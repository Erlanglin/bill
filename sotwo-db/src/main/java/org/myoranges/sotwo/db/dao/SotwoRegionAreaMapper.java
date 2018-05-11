package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.SotwoRegionArea;
import org.myoranges.sotwo.db.domain.SotwoRegionAreaExample;

public interface SotwoRegionAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    long countByExample(SotwoRegionAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int deleteByExample(SotwoRegionAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int insert(SotwoRegionArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int insertSelective(SotwoRegionArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    List<SotwoRegionArea> selectByExample(SotwoRegionAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SotwoRegionArea> selectByExampleSelective(@Param("example") SotwoRegionAreaExample example, @Param("selective") SotwoRegionArea.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByExampleSelective(@Param("record") SotwoRegionArea record, @Param("example") SotwoRegionAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated Fri May 11 22:05:05 CST 2018
     */
    int updateByExample(@Param("record") SotwoRegionArea record, @Param("example") SotwoRegionAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoRegionArea selectOneByExample(SotwoRegionAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoRegionArea selectOneByExampleSelective(@Param("example") SotwoRegionAreaExample example, @Param("selective") SotwoRegionArea.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_region_area
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoRegionArea selectByPrimaryKeySelective(@Param("selective") SotwoRegionArea.Column ... selective);
}