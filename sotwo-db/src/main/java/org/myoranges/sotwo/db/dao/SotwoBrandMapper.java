package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.SotwoBrand;
import org.myoranges.sotwo.db.domain.SotwoBrandExample;

public interface SotwoBrandMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    long countByExample(SotwoBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int deleteByExample(SotwoBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int insert(SotwoBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int insertSelective(SotwoBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    List<SotwoBrand> selectByExample(SotwoBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SotwoBrand> selectByExampleSelective(@Param("example") SotwoBrandExample example, @Param("selective") SotwoBrand.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    SotwoBrand selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoBrand selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SotwoBrand.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByExampleSelective(@Param("record") SotwoBrand record, @Param("example") SotwoBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByExample(@Param("record") SotwoBrand record, @Param("example") SotwoBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByPrimaryKeySelective(SotwoBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByPrimaryKey(SotwoBrand record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoBrand selectOneByExample(SotwoBrandExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_brand
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoBrand selectOneByExampleSelective(@Param("example") SotwoBrandExample example, @Param("selective") SotwoBrand.Column ... selective);
}