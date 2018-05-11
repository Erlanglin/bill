package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.SotwoRegionStreet;
import org.myoranges.sotwo.db.domain.SotwoRegionStreetExample;

public interface SotwoRegionStreetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    long countByExample(SotwoRegionStreetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int deleteByExample(SotwoRegionStreetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int insert(SotwoRegionStreet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int insertSelective(SotwoRegionStreet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    List<SotwoRegionStreet> selectByExample(SotwoRegionStreetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SotwoRegionStreet> selectByExampleSelective(@Param("example") SotwoRegionStreetExample example, @Param("selective") SotwoRegionStreet.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByExampleSelective(@Param("record") SotwoRegionStreet record, @Param("example") SotwoRegionStreetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByExample(@Param("record") SotwoRegionStreet record, @Param("example") SotwoRegionStreetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoRegionStreet selectOneByExample(SotwoRegionStreetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoRegionStreet selectOneByExampleSelective(@Param("example") SotwoRegionStreetExample example, @Param("selective") SotwoRegionStreet.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_street
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoRegionStreet selectByPrimaryKeySelective(@Param("selective") SotwoRegionStreet.Column ... selective);
}