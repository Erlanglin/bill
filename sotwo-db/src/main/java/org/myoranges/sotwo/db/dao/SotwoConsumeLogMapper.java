package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.SotwoConsumeLog;
import org.myoranges.sotwo.db.domain.SotwoConsumeLogExample;

public interface SotwoConsumeLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    long countByExample(SotwoConsumeLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int deleteByExample(SotwoConsumeLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int insert(SotwoConsumeLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int insertSelective(SotwoConsumeLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    List<SotwoConsumeLog> selectByExample(SotwoConsumeLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SotwoConsumeLog> selectByExampleSelective(@Param("example") SotwoConsumeLogExample example, @Param("selective") SotwoConsumeLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    SotwoConsumeLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoConsumeLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SotwoConsumeLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByExampleSelective(@Param("record") SotwoConsumeLog record, @Param("example") SotwoConsumeLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByExample(@Param("record") SotwoConsumeLog record, @Param("example") SotwoConsumeLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByPrimaryKeySelective(SotwoConsumeLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByPrimaryKey(SotwoConsumeLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoConsumeLog selectOneByExample(SotwoConsumeLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_consume_log
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoConsumeLog selectOneByExampleSelective(@Param("example") SotwoConsumeLogExample example, @Param("selective") SotwoConsumeLog.Column ... selective);
}