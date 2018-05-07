package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.sotwoOrderGoods;
import org.myoranges.sotwo.db.domain.sotwoOrderGoodsExample;

public interface SotwoOrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    long countByExample(sotwoOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByExample(sotwoOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insert(sotwoOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insertSelective(sotwoOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    List<sotwoOrderGoods> selectByExample(sotwoOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<sotwoOrderGoods> selectByExampleSelective(@Param("example") sotwoOrderGoodsExample example, @Param("selective") sotwoOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    sotwoOrderGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") sotwoOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExampleSelective(@Param("record") sotwoOrderGoods record, @Param("example") sotwoOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExample(@Param("record") sotwoOrderGoods record, @Param("example") sotwoOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKeySelective(sotwoOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKey(sotwoOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoOrderGoods selectOneByExample(sotwoOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_order_goods
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoOrderGoods selectOneByExampleSelective(@Param("example") sotwoOrderGoodsExample example, @Param("selective") sotwoOrderGoods.Column ... selective);
}