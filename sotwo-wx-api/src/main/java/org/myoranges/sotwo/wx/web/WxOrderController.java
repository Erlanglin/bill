package org.myoranges.sotwo.wx.web;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.service.WxPayService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.myoranges.sotwo.core.util.JacksonUtil;
import org.myoranges.sotwo.core.util.ResponseUtil;
import org.myoranges.sotwo.db.domain.*;
import org.myoranges.sotwo.db.service.*;
import org.myoranges.sotwo.db.util.OrderHandleOption;
import org.myoranges.sotwo.db.util.OrderUtil;
import org.myoranges.sotwo.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 订单设计
 *
 * 订单状态：
 * 101 订单生成，未支付；102，下单后未支付用户取消；103，下单后未支付超时系统自动取消
 * 201 支付完成，商家未发货；202，订单生产，已付款未发货，但是退款取消；
 * 301 商家发货，用户未确认；
 * 401 用户确认收货，订单结束； 402 用户没有确认收货，但是快递反馈已收获后，超过一定时间，系统自动确认收货，订单结束。
 *
 * 当101用户未付款时，此时用户可以进行的操作是取消订单，或者付款操作
 * 当201支付完成而商家未发货时，此时用户可以取消订单并申请退款
 * 当301商家已发货时，此时用户可以有确认收货的操作
 * 当401用户确认收货以后，此时用户可以进行的操作是删除订单，评价商品，或者再次购买
 * 当402系统自动确认收货以后，此时用户可以删除订单，评价商品，或者再次购买
 *
 * 目前不支持订单退货和售后服务
 *
 */
@RestController
@RequestMapping("/wx/order")
public class WxOrderController {
    private final Log logger = LogFactory.getLog(WxOrderController.class);

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private SotwoUserService userService;
    @Autowired
    private SotwoOrderService orderService;
    @Autowired
    private SotwoOrderGoodsService orderGoodsService;
    @Autowired
    private SotwoAddressService addressService;
    @Autowired
    private SotwoCartService cartService;
    @Autowired
    private SotwoRegionService regionService;
    @Autowired
    private SotwoProductService productService;

    @Autowired
    private WxPayService wxPayService;

    public WxOrderController() {
    }

    private String detailedAddress(SotwoAddress SotwoAddress) {
        Integer provinceId = SotwoAddress.getProvinceId();
        Integer cityId = SotwoAddress.getCityId();
        Integer areaId = SotwoAddress.getAreaId();
        String provinceName = regionService.findById(provinceId).getName();
        String cityName = regionService.findById(cityId).getName();
        String areaName = regionService.findById(areaId).getName();
        String fullRegion = provinceName + " " + cityName + " " + areaName;
        return fullRegion + " " + SotwoAddress.getAddress();
    }

    /**
     * 订单列表
     *
     * @param userId   用户ID
     * @param showType 订单信息
     *                 0， 全部订单
     *                 1，待付款
     *                 2，待发货
     *                 3，待收货
     *                 4，待评价
     * @param page     分页页数
     * @param size     分页大小
     * @return 订单操作结果
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * data: xxx ,
     * count: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @RequestMapping("list")
    public Object list(@LoginUser Integer userId, Integer showType,
                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (userId == null) {
            return ResponseUtil.fail401();
        }
        if (showType == null) {
            showType = 0;
        }

        List<Short> orderStatus = OrderUtil.orderStatus(showType);
        List<SotwoOrder> orderList = orderService.queryByOrderStatus(userId, orderStatus);
        int count = orderService.countByOrderStatus(userId, orderStatus);

        List<Map<String, Object>> orderVoList = new ArrayList<>(orderList.size());
        for (SotwoOrder order : orderList) {
            Map<String, Object> orderVo = new HashMap<>();
            orderVo.put("id", order.getId());
            orderVo.put("orderSn", order.getOrderSn());
            orderVo.put("actualPrice", order.getActualPrice());
            orderVo.put("orderStatusText", OrderUtil.orderStatusText(order));
            orderVo.put("handleOption", OrderUtil.build(order));

            List<SotwoOrderGoods> orderGoodsList = orderGoodsService.queryByOid(order.getId());
            List<Map<String, Object>> orderGoodsVoList = new ArrayList<>(orderGoodsList.size());
            for (SotwoOrderGoods orderGoods : orderGoodsList) {
                Map<String, Object> orderGoodsVo = new HashMap<>();
                orderGoodsVo.put("id", orderGoods.getId());
                orderGoodsVo.put("goodsName", orderGoods.getGoodsName());
                orderGoodsVo.put("number", orderGoods.getNumber());
                orderGoodsVo.put("picUrl", orderGoods.getPicUrl());
                orderGoodsVoList.add(orderGoodsVo);
            }
            orderVo.put("goodsList", orderGoodsVoList);

            orderVoList.add(orderVo);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("count", count);
        result.put("data", orderVoList);

        return ResponseUtil.ok(result);
    }

    /**
     * 订单详情
     *
     * @param userId  用户ID
     * @param orderId 订单信息
     * @return 订单操作结果
     * 成功则
     * {
     * errno: 0,
     * errmsg: '成功',
     * data:
     * {
     * orderInfo: xxx ,
     * orderGoods: xxx
     * }
     * }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("detail")
    public Object detail(@LoginUser Integer userId, Integer orderId) {
        if (userId == null) {
            return ResponseUtil.fail401();
        }
        if (orderId == null) {
            return ResponseUtil.fail402();
        }

        // 订单信息
        SotwoOrder order = orderService.findById(orderId);
        if (null == order) {
            return ResponseUtil.fail(403, "订单不存在");
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.fail(403, "不是当前用户的订单");
        }
        Map<String, Object> orderVo = new HashMap<String, Object>();
        orderVo.put("id", order.getId());
        orderVo.put("orderSn", order.getOrderSn());
        orderVo.put("addTime", LocalDate.now());
        orderVo.put("consignee", order.getConsignee());
        orderVo.put("mobile", order.getMobile());
        orderVo.put("address", order.getAddress());
        orderVo.put("goodsPrice", order.getGoodsPrice());
        orderVo.put("freightPrice", order.getFreightPrice());
        orderVo.put("actualPrice", order.getActualPrice());
        orderVo.put("orderStatusText", OrderUtil.orderStatusText(order));
        orderVo.put("handleOption", OrderUtil.build(order));

        List<SotwoOrderGoods> orderGoodsList = orderGoodsService.queryByOid(order.getId());
        List<Map<String, Object>> orderGoodsVoList = new ArrayList<>(orderGoodsList.size());
        for (SotwoOrderGoods orderGoods : orderGoodsList) {
            Map<String, Object> orderGoodsVo = new HashMap<>();
            orderGoodsVo.put("id", orderGoods.getId());
            orderGoodsVo.put("orderId", orderGoods.getOrderId());
            orderGoodsVo.put("goodsId", orderGoods.getGoodsId());
            orderGoodsVo.put("goodsName", orderGoods.getGoodsName());
            orderGoodsVo.put("number", orderGoods.getNumber());
            orderGoodsVo.put("retailPrice", orderGoods.getRetailPrice());
            orderGoodsVo.put("picUrl", orderGoods.getPicUrl());
            orderGoodsVo.put("goodsSpecificationValues", orderGoods.getGoodsSpecificationValues());
            orderGoodsVoList.add(orderGoodsVo);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("orderInfo", orderVo);
        result.put("orderGoods", orderGoodsVoList);
        return ResponseUtil.ok(result);

    }

    /**
     * 提交订单
     * 1. 根据购物车ID、地址ID、优惠券ID，创建订单表项
     * 2. 购物车清空
     * 3. TODO 优惠券设置已用
     * 4. 商品货品数量减少
     *
     * @param userId 用户ID
     * @param body   订单信息，{ cartId：xxx, addressId: xxx, couponId: xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功', data: { orderId: xxx } }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("submit")
    public Object submit(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (body == null) {
            return ResponseUtil.badArgument();
        }
        Integer cartId = JacksonUtil.parseInteger(body, "cartId");
        Integer addressId = JacksonUtil.parseInteger(body, "addressId");
        Integer couponId = JacksonUtil.parseInteger(body, "couponId");
        if (cartId == null || addressId == null || couponId == null) {
            return ResponseUtil.badArgument();
        }

        // 收货地址
        SotwoAddress checkedAddress = addressService.findById(addressId);

        // 获取可用的优惠券信息
        // 使用优惠券减免的金额
        BigDecimal couponPrice = new BigDecimal(0.00);

        // 货品价格
        List<SotwoCart> checkedGoodsList = null;
        if (cartId.equals(0)) {
            checkedGoodsList = cartService.queryByUidAndChecked(userId);
        } else {
            SotwoCart cart = cartService.findById(cartId);
            checkedGoodsList = new ArrayList<>(1);
            checkedGoodsList.add(cart);
        }
        if (checkedGoodsList.size() == 0) {
            return ResponseUtil.badArgumentValue();
        }
        BigDecimal checkedGoodsPrice = new BigDecimal(0.00);
        for (SotwoCart checkGoods : checkedGoodsList) {
            checkedGoodsPrice = checkedGoodsPrice.add(checkGoods.getRetailPrice().multiply(new BigDecimal(checkGoods.getNumber())));
        }

        // 根据订单商品总价计算运费，满88则免运费，否则8元；
        BigDecimal freightPrice = new BigDecimal(0.00);
        if (checkedGoodsPrice.compareTo(new BigDecimal(88.00)) < 0) {
            freightPrice = new BigDecimal(8.00);
        }

        // 可以使用的其他钱，例如用户积分
        BigDecimal integralPrice = new BigDecimal(0.00);


        // 订单费用
        BigDecimal orderTotalPrice = checkedGoodsPrice.add(freightPrice).subtract(couponPrice);
        BigDecimal actualPrice = orderTotalPrice.subtract(integralPrice);

        // 开启事务管理
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        Integer orderId = null;
        SotwoOrder order = null;
        try {
            // 订单
            order = new SotwoOrder();
            order.setUserId(userId);
            order.setOrderSn(orderService.generateOrderSn(userId));
            order.setAddTime(LocalDateTime.now());
            order.setOrderStatus(OrderUtil.STATUS_CREATE);
            order.setConsignee(checkedAddress.getName());
            order.setMobile(checkedAddress.getMobile());
            String detailedAddress = detailedAddress(checkedAddress);
            order.setAddress(detailedAddress);
            order.setGoodsPrice(checkedGoodsPrice);
            order.setFreightPrice(freightPrice);
            order.setCouponPrice(couponPrice);
            order.setIntegralPrice(integralPrice);
            order.setOrderPrice(orderTotalPrice);
            order.setActualPrice(actualPrice);
            // 添加订单表项
            orderService.add(order);
            orderId = order.getId();

            for (SotwoCart cartGoods : checkedGoodsList) {
                // 订单商品
                SotwoOrderGoods orderGoods = new SotwoOrderGoods();
                orderGoods.setOrderId(order.getId());
                orderGoods.setGoodsId(cartGoods.getGoodsId());
                orderGoods.setGoodsSn(cartGoods.getGoodsSn());
                orderGoods.setProductId(cartGoods.getProductId());
                orderGoods.setGoodsName(cartGoods.getGoodsName());
                orderGoods.setPicUrl(cartGoods.getPicUrl());
                orderGoods.setRetailPrice(cartGoods.getRetailPrice());
                orderGoods.setNumber(cartGoods.getNumber());
                orderGoods.setGoodsSpecificationIds(cartGoods.getGoodsSpecificationIds());
                orderGoods.setGoodsSpecificationValues(cartGoods.getGoodsSpecificationValues());

                // 添加订单商品表项
                orderGoodsService.add(orderGoods);
            }

            // 删除购物车里面的商品信息
            cartService.clearGoods(userId);

            // 商品货品数量减少
            for (SotwoCart checkGoods : checkedGoodsList) {
                Integer productId = checkGoods.getProductId();
                SotwoProduct product = productService.findById(productId);

                Integer remainNumber = product.getGoodsNumber() - checkGoods.getNumber();
                if (remainNumber < 0) {
                    throw new RuntimeException("下单的商品货品数量大于库存量");
                }
                product.setGoodsNumber(remainNumber);
                productService.updateById(product);
            }
        } catch (Exception ex) {
            txManager.rollback(status);
            logger.error("系统内部错误", ex);
            return ResponseUtil.fail(403, "下单失败");
        }
        txManager.commit(status);

        Map<String, Object> data = new HashMap<>();
        data.put("orderId", orderId);
        return ResponseUtil.ok(data);
    }

    /**
     * 取消订单
     * 1. 检测当前订单是否能够取消
     * 2. 设置订单取消状态
     * 3. 商品货品数量增加
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("cancel")
    public Object cancel(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return ResponseUtil.badArgument();
        }

        SotwoOrder order = orderService.findById(orderId);
        if (order == null) {
            return ResponseUtil.badArgumentValue();
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.badArgumentValue();
        }

        // 检测是否能够取消
        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isCancel()) {
            return ResponseUtil.fail(403, "订单不能取消");
        }

        // 开启事务管理
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        try {
            // 设置订单已取消状态
            order.setOrderStatus(OrderUtil.STATUS_CANCEL);
            order.setEndTime(LocalDateTime.now());
            orderService.update(order);

            // 商品货品数量增加
            List<SotwoOrderGoods> orderGoodsList = orderGoodsService.queryByOid(orderId);
            for (SotwoOrderGoods orderGoods : orderGoodsList) {
                Integer productId = orderGoods.getProductId();
                SotwoProduct product = productService.findById(productId);
                Integer number = product.getGoodsNumber() + orderGoods.getNumber();
                product.setGoodsNumber(number);
                productService.updateById(product);
            }
        } catch (Exception ex) {
            txManager.rollback(status);
            logger.error("系统内部错误", ex);
            return ResponseUtil.fail(403, "订单取消失败");
        }
        txManager.commit(status);

        return ResponseUtil.ok();
    }

    /**
     * 付款订单的预支付会话标识
     *
     * 1. 检测当前订单是否能够付款
     * 2. 微信支付平台返回支付订单ID
     * 3. 设置订单付款状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '模拟付款支付成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("prepay")
    public Object prepay(@LoginUser Integer userId, @RequestBody String body) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return ResponseUtil.badArgument();
        }

        SotwoOrder order = orderService.findById(orderId);
        if (order == null) {
            return ResponseUtil.badArgumentValue();
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.badArgumentValue();
        }

        // 检测是否能够取消
        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isPay()) {
            return ResponseUtil.fail(403, "订单不能支付");
        }

        SotwoUser user = userService.findById(userId);
        String openid = user.getWeixinOpenid();
        if(openid == null){
            return ResponseUtil.fail(403, "订单不能支付");
        }
        WxPayMpOrderResult result = null;
        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setOutTradeNo(order.getOrderSn());
            orderRequest.setOpenid(openid);
            // TODO 更有意义的显示名称
            orderRequest.setBody("Sotwo小商场-订单测试支付");
            // 元转成分
            // 这里仅支付1分
            // TODO 这里1分钱需要改成实际订单金额
            orderRequest.setTotalFee(1);
            // TODO 用户IP地址
            orderRequest.setSpbillCreateIp("123.12.12.123");

            result = wxPayService.createOrder(orderRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.fail(403, "订单不能支付");
        }

        orderService.updateById(order);
        return ResponseUtil.ok(result);
    }

    /**
     * 付款成功回调接口
     * 1. 检测当前订单是否是付款状态
     * 2. 设置订单付款成功状态相关信息
     * 3. 响应微信支付平台
     *
     * @param request
     * @param response
     * @return 订单操作结果
     * 成功则 WxPayNotifyResponse.success的XML内容
     * 失败则 WxPayNotifyResponse.fail的XML内容
     *
     * 注意，这里pay-notify是示例地址，开发者应该设立一个隐蔽的回调地址
     */
    @PostMapping("pay-notify")
    public Object payNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
            String xmlResult = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
            WxPayOrderNotifyResult result = wxPayService.parseOrderNotifyResult(xmlResult);

            String orderSn = result.getOutTradeNo();
            String payId = result.getTransactionId();
            // 分转化成元
            String totalFee = BaseWxPayResult.feeToYuan(result.getTotalFee());

            SotwoOrder order = orderService.findBySn(orderSn);
            if(order == null){
                throw new Exception("订单不存在 sn=" + orderSn);
            }

            // 检查这个订单是否已经处理过
            if(OrderUtil.isPayStatus(order) && order.getPayId() != null){
                return WxPayNotifyResponse.success("处理成功!");
            }

            // 检查支付订单金额
            // TODO 这里1分钱需要改成实际订单金额
            if(!totalFee.equals("0.01")){
                throw new Exception("支付金额不符合 totalFee=" + totalFee);
            }

            order.setPayId(payId);
            order.setPayTime(LocalDateTime.now());
            order.setOrderStatus(OrderUtil.STATUS_PAY);
            orderService.updateById(order);

            return WxPayNotifyResponse.success("处理成功!");
        } catch (Exception e) {
            logger.error("微信回调结果异常,异常原因 " + e.getMessage());
            return WxPayNotifyResponse.fail(e.getMessage());
        }
    }


    /**
     * 退款取消订单
     * 1. 检测当前订单是否能够退款取消
     * 2. 设置订单退款取消状态
     * 3. TODO 退款
     * 4. 商品货品数量增加
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("refund")
    public Object refund(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return ResponseUtil.badArgument();
        }

        SotwoOrder order = orderService.findById(orderId);
        if (order == null) {
            return ResponseUtil.badArgument();
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.badArgumentValue();
        }

        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isRefund()) {
            return ResponseUtil.fail(403, "订单不能取消");
        }

        // 开启事务管理
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        try {
            // 设置订单取消状态
            order.setOrderStatus(OrderUtil.STATUS_REFUND);
            orderService.update(order);

            // 退款操作

            // 商品货品数量增加
            List<SotwoOrderGoods> orderGoodsList = orderGoodsService.queryByOid(orderId);
            for (SotwoOrderGoods orderGoods : orderGoodsList) {
                Integer productId = orderGoods.getProductId();
                SotwoProduct product = productService.findById(productId);
                Integer number = product.getGoodsNumber() + orderGoods.getNumber();
                product.setGoodsNumber(number);
                productService.updateById(product);
            }
        } catch (Exception ex) {
            txManager.rollback(status);
            logger.error("系统内部错误", ex);
            return ResponseUtil.fail(403, "订单退款失败");
        }
        txManager.commit(status);

        return ResponseUtil.ok();
    }

    /**
     * 发货
     * 1. 检测当前订单是否能够发货
     * 2. 设置订单发货状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx, shipSn: xxx, shipChannel: xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("ship")
    public Object ship(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        String shipSn = JacksonUtil.parseString(body, "shipSn");
        String shipChannel = JacksonUtil.parseString(body, "shipChannel");
        if (orderId == null || shipSn == null || shipChannel == null) {
            return ResponseUtil.badArgument();
        }

        SotwoOrder order = orderService.findById(orderId);
        if (order == null) {
            return ResponseUtil.badArgument();
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.badArgumentValue();
        }

        // 如果订单不是已付款状态，则不能发货
        if (!order.getOrderStatus().equals(OrderUtil.STATUS_PAY)) {
            return ResponseUtil.fail(403, "订单不能确认收货");
        }

        order.setOrderStatus(OrderUtil.STATUS_SHIP);
        order.setShipSn(shipSn);
        order.setShipChannel(shipChannel);
        order.setShipStartTime(LocalDateTime.now());
        orderService.update(order);

        return ResponseUtil.ok();
    }

    /**
     * 确认收货
     * 1. 检测当前订单是否能够确认订单
     * 2. 设置订单确认状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("confirm")
    public Object confirm(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return ResponseUtil.badArgument();
        }

        SotwoOrder order = orderService.findById(orderId);
        if (order == null) {
            return ResponseUtil.badArgument();
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.badArgumentValue();
        }

        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isConfirm()) {
            return ResponseUtil.fail(403, "订单不能确认收货");
        }

        order.setOrderStatus(OrderUtil.STATUS_CONFIRM);
        order.setConfirmTime(LocalDateTime.now());
        orderService.update(order);
        return ResponseUtil.ok();
    }

    /**
     * 删除订单
     * 1. 检测当前订单是否删除
     * 2. 设置订单删除状态
     *
     * @param userId 用户ID
     * @param body   订单信息，{ orderId：xxx }
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功' }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("delete")
    public Object delete(@LoginUser Integer userId, @RequestBody String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        Integer orderId = JacksonUtil.parseInteger(body, "orderId");
        if (orderId == null) {
            return ResponseUtil.badArgument();
        }

        SotwoOrder order = orderService.findById(orderId);
        if (order == null) {
            return ResponseUtil.badArgument();
        }
        if (!order.getUserId().equals(userId)) {
            return ResponseUtil.badArgumentValue();
        }

        OrderHandleOption handleOption = OrderUtil.build(order);
        if (!handleOption.isDelete()) {
            return ResponseUtil.fail(403, "订单不能删除");
        }

        // 订单order_status没有字段用于标识删除
        // 而是存在专门的delete字段表示是否删除
        orderService.deleteById(orderId);

        return ResponseUtil.ok();
    }

    /**
     * 可以评价的订单商品信息
     *
     * @param userId  用户ID
     * @param orderId 订单ID
     * @param goodsId 商品ID
     * @return 订单操作结果
     * 成功则 { errno: 0, errmsg: '成功', data: xxx }
     * 失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("comment")
    public Object comment(@LoginUser Integer userId, Integer orderId, Integer goodsId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (orderId == null) {
            return ResponseUtil.badArgument();
        }

        List<SotwoOrderGoods> orderGoodsList = orderGoodsService.findByOidAndGid(orderId, goodsId);
        int size = orderGoodsList.size();

        Assert.state(size < 2, "存在多个符合条件的订单商品");

        if (size == 0) {
            return ResponseUtil.badArgumentValue();
        }

        SotwoOrderGoods orderGoods = orderGoodsList.get(0);
        return ResponseUtil.ok(orderGoods);
    }

    /**
     * 自动取消订单
     *
     * 定时检查订单未付款情况，如果超时半个小时则自动取消订单
     * 定时时间是每次相隔半个小时。
     *
     * 注意，因为是相隔半小时检查，因此导致有订单是超时一个小时以后才设置取消状态。
     * TODO
     * 这里可以进一步地配合用户订单查询时订单未付款检查，如果订单超时半小时则取消。
     */
    @Scheduled(fixedDelay = 30*60*1000)
    public void checkOrderUnpaid() {
        logger.debug(LocalDateTime.now());

        List<SotwoOrder> orderList = orderService.queryUnpaid();
        for(SotwoOrder order : orderList){
            LocalDateTime add = order.getAddTime();
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime expired = add.plusMinutes(30);
            if(expired.isAfter(now)){
                continue;
            }

            // 开启事务管理
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
            TransactionStatus status = txManager.getTransaction(def);
            try {
                // 设置订单已取消状态
                order.setOrderStatus(OrderUtil.STATUS_AUTO_CANCEL);
                order.setEndTime(LocalDateTime.now());
                orderService.updateById(order);

                // 商品货品数量增加
                Integer orderId = order.getId();
                List<SotwoOrderGoods> orderGoodsList = orderGoodsService.queryByOid(orderId);
                for (SotwoOrderGoods orderGoods : orderGoodsList) {
                    Integer productId = orderGoods.getProductId();
                    SotwoProduct product = productService.findById(productId);
                    Integer number = product.getGoodsNumber() + orderGoods.getNumber();
                    product.setGoodsNumber(number);
                    productService.updateById(product);
                }
            } catch (Exception ex) {
                txManager.rollback(status);
                logger.error("系统内部错误", ex);
            }
            txManager.commit(status);
        }
    }

    /**
     * 自动确认订单
     *
     * 定时检查订单未确认情况，如果超时七天则自动确认订单
     * 定时时间是每天凌晨3点。
     *
     * 注意，因为是相隔一天检查，因此导致有订单是超时八天以后才设置自动确认。
     * 这里可以进一步地配合用户订单查询时订单未确认检查，如果订单超时7天则自动确认。
     * 但是，这里可能不是非常必要。相比订单未付款检查中存在商品资源有限所以应该
     * 早点清理未付款情况，这里八天再确认是可以的。
     *
     * TODO
     * 目前自动确认是基于管理后台管理员所设置的商品快递到达时间，见orderService.queryUnconfirm。
     * 那么在实际业务上有可能存在商品寄出以后商品因为一些原因快递最终没有到达，
     * 也就是商品快递失败而shipEndTime一直是空的情况，因此这里业务可能需要扩展，以防止订单一直
     * 处于发货状态。
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public void checkOrderUnconfirm() {
        logger.debug(LocalDateTime.now());

        List<SotwoOrder> orderList = orderService.queryUnconfirm();
        for(SotwoOrder order : orderList){
            LocalDateTime shipEnd = order.getShipEndTime();
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime expired = shipEnd.plusDays(7);
            if(expired.isAfter(now)){
                continue;
            }
            // 设置订单已取消状态
            order.setOrderStatus(OrderUtil.STATUS_AUTO_CONFIRM);
            order.setConfirmTime(now);
            orderService.updateById(order);
        }
    }

}