/*
 * Created By lujicong (2017-03-23 14:12:08)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.syn.dto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.yaic.fa.dto.BaseDto;

/**
 * SynPolicyCfg
 */
@Table(name = "t_syn_policy_cfg")
public class SynPolicyCfgDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = SynPolicyCfgDto.class.getName().hashCode();

    /** 取数类型 */
    @Id
    private String dealType;

    /** 取数描述 */
    private String description;

    /** 失败重试次数 */
    private Integer failRetryCount;

    /** 处理多少天前数据 */
    private Integer dealBeforeDate;

    /** 一次获取处理条数 */
    private Integer limitCount;

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


    /**
     * 获取属性取数类型的值
     */
    public String getDealType() {
        return this.dealType;
    }

    /**
     * 设置属性取数类型的值
     */
    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    /**
     * 获取属性取数描述的值
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 设置属性取数描述的值
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取属性失败重试次数的值
     */
    public Integer getFailRetryCount() {
        return this.failRetryCount;
    }

    /**
     * 设置属性失败重试次数的值
     */
    public void setFailRetryCount(Integer failRetryCount) {
        this.failRetryCount = failRetryCount;
    }

    /**
     * 获取属性处理多少天前数据的值
     */
    public Integer getDealBeforeDate() {
        return this.dealBeforeDate;
    }

    /**
     * 设置属性处理多少天前数据的值
     */
    public void setDealBeforeDate(Integer dealBeforeDate) {
        this.dealBeforeDate = dealBeforeDate;
    }

    /**
     * 获取属性一次获取处理条数的值
     */
    public Integer getLimitCount() {
        return this.limitCount;
    }

    /**
     * 设置属性一次获取处理条数的值
     */
    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
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