/*
 * Created By lujicong (2016-05-22 21:20:24)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_dynamic_config")
public class OrderDynamicConfigDto implements Serializable {
    
    private static final long serialVersionUID = OrderDynamicConfigDto.class.getName().hashCode();
    
    /** 主键id */ 
    @Id
    private java.lang.Integer dynamicConfigId;
    
    /** 动态标的类型 */ 
    private java.lang.String dynamicType;
    
    /** 险种代码 */ 
    private java.lang.String riskCode;
    
    /** 字段名 */ 
    private java.lang.String fieldName;
    
    /** 字段描述 */ 
    private java.lang.String fieldDesc;
    
    /** 失效标志:0正常,1作废值 */ 
    private java.lang.Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;
    
    
    /**
     * 设置属性主键id的值
     */ 
    public void setDynamicConfigId(java.lang.Integer dynamicConfigId) {
        this.dynamicConfigId = dynamicConfigId;
    }
    
    /**
     * 获取属性主键id的值
     */ 
    public java.lang.Integer getDynamicConfigId() {
        return this.dynamicConfigId;
    }
    
    /**
     * 设置属性动态标的类型的值
     */ 
    public void setDynamicType(java.lang.String dynamicType) {
        this.dynamicType = dynamicType;
    }
    
    /**
     * 获取属性动态标的类型的值
     */ 
    public java.lang.String getDynamicType() {
        return this.dynamicType;
    }
    
    /**
     * 设置属性险种代码的值
     */ 
    public void setRiskCode(java.lang.String riskCode) {
        this.riskCode = riskCode;
    }
    
    /**
     * 获取属性险种代码的值
     */ 
    public java.lang.String getRiskCode() {
        return this.riskCode;
    }
    
    /**
     * 设置属性字段名的值
     */ 
    public void setFieldName(java.lang.String fieldName) {
        this.fieldName = fieldName;
    }
    
    /**
     * 获取属性字段名的值
     */ 
    public java.lang.String getFieldName() {
        return this.fieldName;
    }
    
    /**
     * 设置属性字段描述的值
     */ 
    public void setFieldDesc(java.lang.String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }
    
    /**
     * 获取属性字段描述的值
     */ 
    public java.lang.String getFieldDesc() {
        return this.fieldDesc;
    }
    
    /**
     * 设置属性失效标志:0正常,1作废值的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性失效标志:0正常,1作废值的值
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
     * 设置属性创建时间的值
     */ 
    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }
    
    /**
     * 获取属性创建时间的值
     */ 
    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }
    
    /**
     * 设置属性更新人的值
     */ 
    public void setUpdatedUser(java.lang.String updatedUser) {
        this.updatedUser = updatedUser;
    }
    
    /**
     * 获取属性更新人的值
     */ 
    public java.lang.String getUpdatedUser() {
        return this.updatedUser;
    }
    
    /**
     * 设置属性更新时间的值
     */ 
    public void setUpdatedDate(java.util.Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    /**
     * 获取属性更新时间的值
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