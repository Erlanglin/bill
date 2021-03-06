package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.SotwoAddress;
import org.myoranges.sotwo.db.domain.SotwoAddressExample;

public interface SotwoAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    long countByExample(SotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int deleteByExample(SotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int insert(SotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int insertSelective(SotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    List<SotwoAddress> selectByExample(SotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<SotwoAddress> selectByExampleSelective(@Param("example") SotwoAddressExample example, @Param("selective") SotwoAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    SotwoAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") SotwoAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByExampleSelective(@Param("record") SotwoAddress record, @Param("example") SotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByExample(@Param("record") SotwoAddress record, @Param("example") SotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByPrimaryKeySelective(SotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat May 12 10:41:29 CST 2018
     */
    int updateByPrimaryKey(SotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoAddress selectOneByExample(SotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    SotwoAddress selectOneByExampleSelective(@Param("example") SotwoAddressExample example, @Param("selective") SotwoAddress.Column ... selective);
}