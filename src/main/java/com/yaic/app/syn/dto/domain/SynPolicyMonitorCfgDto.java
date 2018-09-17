/*
 * Created By lujicong (2017-03-31 20:02:28)
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
 * SynPolicyMonitorCfg
 */
@Table(name = "t_syn_policy_monitor_cfg")
public class SynPolicyMonitorCfgDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = SynPolicyMonitorCfgDto.class.getName().hashCode();

    /** 监控类型 */
    @Id
    private String monitorType;

    /** 监控描述 */
    private String description;

    /** 预警阈值数 */
    private Integer threshold;

    /** 预警提示信息 */
    private String warnMsg;

    /** 通知手机号(多个英文分号分割开) */
    private String mobile;

    /** 短信开关:0-开启,1-关闭 */
    private Integer smsSwitch;

    /** 通知邮箱(多个英文分号分割开) */
    private String email;

    /** 邮件开关:0-开启,1-关闭 */
    private Integer emailSwitch;

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
     * 获取属性监控类型的值
     */
    public String getMonitorType() {
        return this.monitorType;
    }

    /**
     * 设置属性监控类型的值
     */
    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    /**
     * 获取属性监控描述的值
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 设置属性监控描述的值
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取属性预警阈值数的值
     */
    public Integer getThreshold() {
        return this.threshold;
    }

    /**
     * 设置属性预警阈值数的值
     */
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    /**
     * 获取属性预警提示信息的值
     */
    public String getWarnMsg() {
        return this.warnMsg;
    }

    /**
     * 设置属性预警提示信息的值
     */
    public void setWarnMsg(String warnMsg) {
        this.warnMsg = warnMsg;
    }

    /**
     * 获取属性通知手机号(多个英文分号分割开)的值
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * 设置属性通知手机号(多个英文分号分割开)的值
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取属性短信开关:0-开启,1-关闭的值
     */
    public Integer getSmsSwitch() {
        return this.smsSwitch;
    }

    /**
     * 设置属性短信开关:0-开启,1-关闭的值
     */
    public void setSmsSwitch(Integer smsSwitch) {
        this.smsSwitch = smsSwitch;
    }

    /**
     * 获取属性通知邮箱(多个英文分号分割开)的值
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 设置属性通知邮箱(多个英文分号分割开)的值
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取属性邮件开关:0-开启,1-关闭的值
     */
    public Integer getEmailSwitch() {
        return this.emailSwitch;
    }

    /**
     * 设置属性邮件开关:0-开启,1-关闭的值
     */
    public void setEmailSwitch(Integer emailSwitch) {
        this.emailSwitch = emailSwitch;
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