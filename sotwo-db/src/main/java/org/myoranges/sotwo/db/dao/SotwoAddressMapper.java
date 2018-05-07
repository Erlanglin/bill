package org.myoranges.sotwo.db.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.myoranges.sotwo.db.domain.sotwoAddress;
import org.myoranges.sotwo.db.domain.sotwoAddressExample;

public interface SotwoAddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    long countByExample(sotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByExample(sotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insert(sotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int insertSelective(sotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    List<sotwoAddress> selectByExample(sotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<sotwoAddress> selectByExampleSelective(@Param("example") sotwoAddressExample example, @Param("selective") sotwoAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    sotwoAddress selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") sotwoAddress.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExampleSelective(@Param("record") sotwoAddress record, @Param("example") sotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByExample(@Param("record") sotwoAddress record, @Param("example") sotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKeySelective(sotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated Sat Apr 07 10:22:31 CST 2018
     */
    int updateByPrimaryKey(sotwoAddress record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoAddress selectOneByExample(sotwoAddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sotwo_address
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    sotwoAddress selectOneByExampleSelective(@Param("example") sotwoAddressExample example, @Param("selective") sotwoAddress.Column ... selective);
}