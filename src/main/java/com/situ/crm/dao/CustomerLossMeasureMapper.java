package com.situ.crm.dao;

import com.situ.crm.pojo.CustomerLossMeasure;
import com.situ.crm.pojo.CustomerLossMeasureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerLossMeasureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int countByExample(CustomerLossMeasureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int deleteByExample(CustomerLossMeasureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int insert(CustomerLossMeasure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int insertSelective(CustomerLossMeasure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    List<CustomerLossMeasure> selectByExample(CustomerLossMeasureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    CustomerLossMeasure selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int updateByExampleSelective(@Param("record") CustomerLossMeasure record, @Param("example") CustomerLossMeasureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int updateByExample(@Param("record") CustomerLossMeasure record, @Param("example") CustomerLossMeasureExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int updateByPrimaryKeySelective(CustomerLossMeasure record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_loss_measure
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    int updateByPrimaryKey(CustomerLossMeasure record);
}