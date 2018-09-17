/*
 * Created By lujicong (2016-12-22 14:16:30)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.dysub.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_dysub_verify_info")
public class DysubVerifyInfoDto implements Serializable {
    
    private static final long serialVersionUID = DysubVerifyInfoDto.class.getName().hashCode();
    
    /** 主键id */ 
    @Id
    private java.lang.Integer verifyId;
    
    /** 校验key值 */ 
    private java.lang.String verifyKey;
    
    /** 保单信息 */ 
    private java.lang.String policyInfo;
    
    /** 保单号 */ 
    private java.lang.String policyNo;
    
    /** 保单状态:1:承保,2:退保 */ 
    private java.lang.String status;
    
    /** 起保日期 */ 
    private java.util.Date startDate;
    
    /** 终保日期 */ 
    private java.util.Date endDate;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 是否有效:0有效，1无效 */ 
    private java.lang.Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建日期 */ 
    private java.util.Date createdDate;
    
    /** 跟新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新日期 */ 
    private java.util.Date updatedDate;
    
    
    /**
     * 设置属性主键id的值
     */ 
    public void setVerifyId(java.lang.Integer verifyId) {
        this.verifyId = verifyId;
    }
    
    /**
     * 获取属性主键id的值
     */ 
    public java.lang.Integer getVerifyId() {
        return this.verifyId;
    }
    
    /**
     * 设置属性校验key值的值
     */ 
    public void setVerifyKey(java.lang.String verifyKey) {
        this.verifyKey = verifyKey;
    }
    
    /**
     * 获取属性校验key值的值
     */ 
    public java.lang.String getVerifyKey() {
        return this.verifyKey;
    }
    
    /**
     * 设置属性保单信息的值
     */ 
    public void setPolicyInfo(java.lang.String policyInfo) {
        this.policyInfo = policyInfo;
    }
    
    /**
     * 获取属性保单信息的值
     */ 
    public java.lang.String getPolicyInfo() {
        return this.policyInfo;
    }
    
    /**
     * 设置属性保单号的值
     */ 
    public void setPolicyNo(java.lang.String policyNo) {
        this.policyNo = policyNo;
    }
    
    /**
     * 获取属性保单号的值
     */ 
    public java.lang.String getPolicyNo() {
        return this.policyNo;
    }
    
    /**
     * 设置属性保单状态:1:承保,2:退保的值
     */ 
    public void setStatus(java.lang.String status) {
        this.status = status;
    }
    
    /**
     * 获取属性保单状态:1:承保,2:退保的值
     */ 
    public java.lang.String getStatus() {
        return this.status;
    }
    
    /**
     * 设置属性起保日期的值
     */ 
    public void setStartDate(java.util.Date startDate) {
        this.startDate = startDate;
    }
    
    /**
     * 获取属性起保日期的值
     */ 
    public java.util.Date getStartDate() {
        return this.startDate;
    }
    
    /**
     * 设置属性终保日期的值
     */ 
    public void setEndDate(java.util.Date endDate) {
        this.endDate = endDate;
    }
    
    /**
     * 获取属性终保日期的值
     */ 
    public java.util.Date getEndDate() {
        return this.endDate;
    }
    
    /**
     * 设置属性备注的值
     */ 
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    
    /**
     * 获取属性备注的值
     */ 
    public java.lang.String getRemark() {
        return this.remark;
    }
    
    /**
     * 设置属性是否有效:0有效，1无效的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性是否有效:0有效，1无效的值
     */ 
    public java.lang.Integer getInvalidFlag() {
        return this.invalidFlag;
    }
    
    /**
     * 设置属性创建人的值
     */ 
    public void setCreatedUser(java.lang.String createdUser) {
        this.createdUser = createdUser;
    }
    
    /**
     * 获取属性创建人的值
     */ 
    public java.lang.String getCreatedUser() {
        return this.createdUser;
    }
    
    /**
     * 设置属性创建日期的值
     */ 
    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }
    
    /**
     * 获取属性创建日期的值
     */ 
    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }
    
    /**
     * 设置属性跟新人的值
     */ 
    public void setUpdatedUser(java.lang.String updatedUser) {
        this.updatedUser = updatedUser;
    }
    
    /**
     * 获取属性跟新人的值
     */ 
    public java.lang.String getUpdatedUser() {
        return this.updatedUser;
    }
    
    /**
     * 设置属性更新日期的值
     */ 
    public void setUpdatedDate(java.util.Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    /**
     * 获取属性更新日期的值
     */ 
    public java.util.Date getUpdatedDate() {
        return this.updatedDate;
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