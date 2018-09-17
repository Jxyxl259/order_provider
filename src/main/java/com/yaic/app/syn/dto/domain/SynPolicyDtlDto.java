/*
 * Created By lujicong (2017-03-20 14:44:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.yaic.fa.dto.BaseDto;

/**
 * SynPolicyDtl
 */
@Table(name = "t_syn_policy_dtl")
public class SynPolicyDtlDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = SynPolicyDtlDto.class.getName().hashCode();

    /** 订单主表id */
    @Id
    private java.math.BigInteger orderMainId;

    /** 订单号 */
    private java.math.BigInteger orderCode;
    
    /** 保单号 */
    private String policyNo;
    
    /** 协议号 */ 
    private String agrtCode;

    /** 同步保单处理状态 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 */
    private String dealStatus;

    /** 是否有效:0正常,1作废值 */
    private Integer invalidFlag;

    /** 创建人 */
    private String createdUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdDate;

    /** 更新人 */
    private String updatedUser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedDate;

    @Transient
    private String orderMainIdStr;
    @Transient
    private String orderCodeStr;
    @Transient
    private java.lang.Integer dealBeforeDate;
    @Transient
    private java.lang.Integer limitCount;
    @Transient
    private Date nowTime;
    

    /**
     * 获取属性订单主表id的值
     */
    public java.math.BigInteger getOrderMainId() {
        return this.orderMainId;
    }

    /**
     * 设置属性订单主表id的值
     */
    public void setOrderMainId(java.math.BigInteger orderMainId) {
        this.orderMainIdStr = String.valueOf(orderMainId);
        this.orderMainId = orderMainId;
    }

    /**
     * 获取属性订单号的值
     */
    public java.math.BigInteger getOrderCode() {
        return this.orderCode;
    }

    /**
     * 设置属性订单号的值
     */
    public void setOrderCode(java.math.BigInteger orderCode) {
        this.orderCodeStr = String.valueOf(orderCode);
        this.orderCode = orderCode;
    }

    /**
     * 获取属性保单号的值
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 设置属性保单号的值
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 获取属性协议号的值
     */
    public String getAgrtCode() {
        return agrtCode;
    }

    /**
     * 设置属性协议号的值
     */
    public void setAgrtCode(String agrtCode) {
        this.agrtCode = agrtCode;
    }

    /**
     * 获取属性同步保单处理状态 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败的值
     */
    public String getDealStatus() {
        return this.dealStatus;
    }

    /**
     * 设置属性同步保单处理状态 0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败的值
     */
    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * 获取属性是否有效:0正常,1作废值的值
     */
    public Integer getInvalidFlag() {
        return this.invalidFlag;
    }

    /**
     * 设置属性是否有效:0正常,1作废值的值
     */
    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }

    /**
     * 获取属性创建人的值
     */
    public String getCreatedUser() {
        return this.createdUser;
    }

    /**
     * 设置属性创建人的值
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * 获取属性创建时间的值
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * 设置属性创建时间的值
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取属性更新人的值
     */
    public String getUpdatedUser() {
        return this.updatedUser;
    }

    /**
     * 设置属性更新人的值
     */
    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    /**
     * 获取属性更新时间的值
     */
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    /**
     * 设置属性更新时间的值
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getOrderMainIdStr() {
        return orderMainIdStr;
    }

    public void setOrderMainIdStr(String orderMainIdStr) {
        this.orderMainIdStr = orderMainIdStr;
    }

    public String getOrderCodeStr() {
        return orderCodeStr;
    }

    public void setOrderCodeStr(String orderCodeStr) {
        this.orderCodeStr = orderCodeStr;
    }

    public java.lang.Integer getDealBeforeDate() {
        return dealBeforeDate;
    }

    public void setDealBeforeDate(java.lang.Integer dealBeforeDate) {
        this.dealBeforeDate = dealBeforeDate;
    }

    public java.lang.Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(java.lang.Integer limitCount) {
        this.limitCount = limitCount;
    }

    public Date getNowTime() {
        return nowTime;
    }

    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}