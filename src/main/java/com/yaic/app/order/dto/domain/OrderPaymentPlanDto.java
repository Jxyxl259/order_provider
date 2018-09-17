package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_payment_plan")
public class OrderPaymentPlanDto implements Serializable {
    
    private static final long serialVersionUID = OrderPaymentPlanDto.class.getName().hashCode();
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    /** 费用计划ID */ 
    @Id
    private java.lang.Integer paymentPlanId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 计划交费截止日期 */ 
    private java.util.Date planDate;
    
    /** 付款人名称 */ 
    private java.lang.String payeeName;
    
    /** 费用金额 */ 
    private java.math.BigDecimal planFee;
    
    /** 是否有效 0 有效 1无效 */ 
    private java.lang.Integer invalidFlag;
    
    /** 创建人代码 */ 
    private java.lang.String createdUser;
    
    /** 创建日期 */ 
    private java.util.Date createdDate;
    
    /** 修改人代码 */ 
    private java.lang.String updatedUser;
    
    /** 修改人日期 */ 
    private java.util.Date updatedDate;
    
    
    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    /**
     * 设置属性费用计划ID的值
     */
    public void setPaymentPlanId(java.lang.Integer paymentPlanId) {
        this.paymentPlanId = paymentPlanId;
    }
    
    /**
     * 获取属性费用计划ID的值
     */
    public java.lang.Integer getPaymentPlanId() {
        return paymentPlanId;
    }
    
    /**
     * 设置属性订单主表id的值
     */ 
    public void setOrderMainId(BigInteger orderMainId) {
        this.orderMainId = orderMainId;
    }
    
    /**
     * 获取属性订单主表id的值
     */ 
    public BigInteger getOrderMainId() {
        return orderMainId;
    }
    
    /**
     * 设置属性订单编号的值
     */ 
    public BigInteger getOrderCode() {
        return orderCode;
    }
    
    /**
     * 获取属性订单编号的值
     */ 
    public void setOrderCode(BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 设置属性计划交费截止日期的值
     */ 
    public void setPlanDate(java.util.Date planDate) {
        this.planDate = planDate;
    }
    
    /**
     * 获取属性计划交费截止日期的值
     */ 
    public java.util.Date getPlanDate() {
        return this.planDate;
    }
    
    /**
     * 设置属性付款人名称的值
     */ 
    public void setPayeeName(java.lang.String payeeName) {
        this.payeeName = payeeName;
    }
    
    /**
     * 获取属性付款人名称的值
     */ 
    public java.lang.String getPayeeName() {
        return this.payeeName;
    }
    
    /**
     * 设置属性费用金额的值
     */ 
    public void setPlanFee(java.math.BigDecimal planFee) {
        this.planFee = planFee;
    }
    
    /**
     * 获取属性费用金额的值
     */ 
    public java.math.BigDecimal getPlanFee() {
        return this.planFee;
    }
    
    /**
     * 设置属性是否有效 0 有效 1无效的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性是否有效 0 有效 1无效的值
     */ 
    public java.lang.Integer getInvalidFlag() {
        return this.invalidFlag;
    }
    
    /**
     * 设置属性创建人代码的值
     */ 
    public void setCreatedUser(java.lang.String createdUser) {
        this.createdUser = createdUser;
    }
    
    /**
     * 获取属性创建人代码的值
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
     * 设置属性修改人代码的值
     */ 
    public void setUpdatedUser(java.lang.String updatedUser) {
        this.updatedUser = updatedUser;
    }
    
    /**
     * 获取属性修改人代码的值
     */ 
    public java.lang.String getUpdatedUser() {
        return this.updatedUser;
    }
    
    /**
     * 设置属性修改人日期的值
     */ 
    public void setUpdatedDate(java.util.Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    /**
     * 获取属性修改人日期的值
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