package com.situ.crm.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerContact {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.id
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.customer_id
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    private Integer customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.time
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.address
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact.overview
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    private String overview;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.id
     *
     * @return the value of customer_contact.id
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.id
     *
     * @param id the value for customer_contact.id
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.customer_id
     *
     * @return the value of customer_contact.customer_id
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.customer_id
     *
     * @param customerId the value for customer_contact.customer_id
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.time
     *
     * @return the value of customer_contact.time
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.time
     *
     * @param time the value for customer_contact.time
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.address
     *
     * @return the value of customer_contact.address
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.address
     *
     * @param address the value for customer_contact.address
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact.overview
     *
     * @return the value of customer_contact.overview
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public String getOverview() {
        return overview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact.overview
     *
     * @param overview the value for customer_contact.overview
     *
     * @mbggenerated Mon Oct 30 13:58:02 CST 2017
     */
    public void setOverview(String overview) {
        this.overview = overview == null ? null : overview.trim();
    }
}