package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.sotwoKeyword;
import org.myoranges.sotwo.db.domain.sotwoKeywordExample;

public interface SotwoKeywordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    long countByExample(sotwoKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByExample(sotwoKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insert(sotwoKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insertSelective(sotwoKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    List<sotwoKeyword> selectByExample(sotwoKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<sotwoKeyword> selectByExampleSelective(@Param("example") sotwoKeywordExample example, @Param("selective") sotwoKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    sotwoKeyword selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoKeyword selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") sotwoKeyword.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExampleSelective(@Param("record") sotwoKeyword record, @Param("example") sotwoKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExample(@Param("record") sotwoKeyword record, @Param("example") sotwoKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKeySelective(sotwoKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKey(sotwoKeyword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoKeyword selectOneByExample(sotwoKeywordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_keyword
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoKeyword selectOneByExampleSelective(@Param("example") sotwoKeywordExample example, @Param("selective") sotwoKeyword.Column ... selective);
}