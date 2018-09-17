/*
 * Created By lujicong (2017-03-20 14:44:31)
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
 * SynPolicy
 */
@Table(name = "t_syn_epolicy")
public class SynEpolicyDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = SynEpolicyDto.class.getName().hashCode();

    /** 订单号 */
    @Id
    private java.math.BigInteger orderCode;

    /** 同步保单处理状态 0-未处理,1-处理中,2-处理成功(所有成功),3-处理失败*/
    private String dealStatus;
    
    /** 处理次数 */
    private Integer dealCount;

    /** 是否有效:0正常,1作废值 */
    private Integer invalidFlag;

    /** 创建人 */
    private String createdUser;

    /** 创建时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdDate;

    /** 更新人 */
    private String updatedUser;

    /** 更新时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedDate;

    @Transient
    private String orderCodeStr;
    @Transient
    private java.lang.Integer dealBeforeDate;
    @Transient
    private java.lang.Integer limitCount;
    @Transient
    private String sortType;
    @Transient
    private String policyNo;
    @Transient
    private Date nowTime;
    
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
     * 获取属性同步保单处理状态 0-未处理,1-处理中,2-处理成功(所有成功),3-处理失败的值
     */
    public String getDealStatus() {
        return this.dealStatus;
    }

    /**
     * 设置属性同步保单处理状态  0-未处理,1-处理中,2-处理成功(所有成功),3-处理失败的值
     */
    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * 获取属性处理次数的值
     */
    public Integer getDealCount() {
        return dealCount;
    }

    /**
     * 设置属性处理次数的值
     */
    public void setDealCount(Integer dealCount) {
        this.dealCount = dealCount;
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

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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