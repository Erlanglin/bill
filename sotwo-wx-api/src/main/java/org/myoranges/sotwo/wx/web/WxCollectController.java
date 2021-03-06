package org.myoranges.sotwo.wx.web;

import org.apache.commons.lang3.ObjectUtils;
import org.myoranges.sotwo.core.util.JacksonUtil;
import org.myoranges.sotwo.core.util.ResponseUtil;
import org.myoranges.sotwo.db.domain.SotwoCollect;
import org.myoranges.sotwo.db.domain.SotwoGoods;
import org.myoranges.sotwo.db.service.SotwoCollectService;
import org.myoranges.sotwo.db.service.SotwoGoodsService;
import org.myoranges.sotwo.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx/collect")
public class WxCollectController {
    @Autowired
    private SotwoCollectService collectService;
    @Autowired
    private SotwoGoodsService goodsService;

    /**
     * 用户收藏列表
     *
     * @param userId 用户ID
     * @param typeId 类型ID
     *    目前没有使用
     * @param page 分页页数
     * @param size 分页大小
     * @return 用户收藏列表
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              collectList: xxx,
     *              totalPages: xxx
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @GetMapping("list")
    public Object list(@LoginUser Integer userId, Integer typeId,
                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        if(typeId == null){
            return ResponseUtil.badArgument();
        }

        List<SotwoCollect> collectList = collectService.queryByType(userId, typeId, page, size);
        int count = collectService.countByType(userId, typeId);
        int totalPages = (int) Math.ceil((double) count / size);

        List<Object> collects = new ArrayList<>(collectList.size());
        for(SotwoCollect collect : collectList){
            Map<String, Object> c = new HashMap();
            c.put("id", collect.getId());
            c.put("typeId", collect.getTypeId());
            c.put("valueId", collect.getValueId());

            SotwoGoods goods = goodsService.findById(collect.getValueId());
            c.put("name", goods.getName());
            c.put("goodsBrief", goods.getGoodsBrief());
            c.put("listPicUrl", goods.getListPicUrl());
            c.put("retailPrice", goods.getRetailPrice());

            collects.add(c);
        }

        Map<String, Object> result = new HashMap();
        result.put("collectList", collects);
        result.put("totalPages", totalPages);
        return ResponseUtil.ok(result);
    }

    /**
     * 用户收藏添加或删除
     *
     * @param userId 用户ID
     * @param body 请求内容
     * @return 操作结果
     *   成功则
     *  {
     *      errno: 0,
     *      errmsg: '成功',
     *      data:
     *          {
     *              type: xxx,
     *          }
     *  }
     *   失败则 { errno: XXX, errmsg: XXX }
     */
    @PostMapping("addordelete")
    public Object addordelete(@LoginUser Integer userId, @RequestBody String body) {
        if(userId == null){
            return ResponseUtil.unlogin();
        }
        if(body == null){
            return ResponseUtil.badArgument();
        }

        Integer typeId = JacksonUtil.parseInteger(body, "typeId");
        Integer valueId = JacksonUtil.parseInteger(body, "valueId");
        if(!ObjectUtils.allNotNull(typeId, valueId)){
            return ResponseUtil.badArgument();
        }

        SotwoCollect collect = collectService.queryByTypeAndValue(userId, typeId, valueId);

        String handleType = null;
        if(collect != null){
            handleType = "delete";
            collectService.deleteById(collect.getId());
        }
        else{
            handleType = "add";
            collect = new SotwoCollect();
            collect.setUserId(userId);
            collect.setValueId(valueId);
            collect.setTypeId(typeId);
            collect.setAddTime(LocalDateTime.now());
            collectService.add(collect);
        }

        Map<String, Object> data = new HashMap();
        data.put("type", handleType);
        return ResponseUtil.ok(data);
    }
}