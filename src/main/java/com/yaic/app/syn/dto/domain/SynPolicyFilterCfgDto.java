/*
 * Created By lujicong (2017-05-11 10:25:33)
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
 * SynPolicyFilterCfg
 */
@Table(name = "t_syn_policy_filter_cfg")
public class SynPolicyFilterCfgDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = SynPolicyFilterCfgDto.class.getName().hashCode();

    /** 过滤配置表ID */
    @Id
    private String filterCfgId;

    /** 协议号 */
    private String agrtCode;

    /** 备注 */
    private String remark;

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
     * 获取属性过滤配置表ID的值
     */
    public String getFilterCfgId() {
        return this.filterCfgId;
    }

    /**
     * 设置属性过滤配置表ID的值
     */
    public void setFilterCfgId(String filterCfgId) {
        this.filterCfgId = filterCfgId;
    }

    /**
     * 获取属性协议号的值
     */
    public String getAgrtCode() {
        return this.agrtCode;
    }

    /**
     * 设置属性协议号的值
     */
    public void setAgrtCode(String agrtCode) {
        this.agrtCode = agrtCode;
    }

    /**
     * 获取属性备注的值
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置属性备注的值
     */
    public void setRemark(String remark) {
        this.remark = remark;
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