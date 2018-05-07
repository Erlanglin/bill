package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.sotwoTopic;
import org.myoranges.sotwo.db.domain.sotwoTopicExample;

public interface SotwoTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    long countByExample(sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByExample(sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insert(sotwoTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insertSelective(sotwoTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    List<sotwoTopic> selectByExampleWithBLOBs(sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    List<sotwoTopic> selectByExample(sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<sotwoTopic> selectByExampleSelective(@Param("example") sotwoTopicExample example, @Param("selective") sotwoTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    sotwoTopic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") sotwoTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExampleSelective(@Param("record") sotwoTopic record, @Param("example") sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") sotwoTopic record, @Param("example") sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExample(@Param("record") sotwoTopic record, @Param("example") sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKeySelective(sotwoTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(sotwoTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKey(sotwoTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoTopic selectOneByExample(sotwoTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoTopic selectOneByExampleSelective(@Param("example") sotwoTopicExample example, @Param("selective") sotwoTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_topic
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoTopic selectOneByExampleWithBLOBs(sotwoTopicExample example);
}