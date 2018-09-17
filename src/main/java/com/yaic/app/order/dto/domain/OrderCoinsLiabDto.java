/*
 * Created By lujicong (2018-01-30 10:57:01)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2018
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_coins_liab")
public class OrderCoinsLiabDto implements Serializable {
    
    private static final long serialVersionUID = OrderCoinsLiabDto.class.getName().hashCode();
    
    /** 自增主键ID */ 
    @Id
    private java.lang.Integer coinsLiabId;
    
    /** 订单主表id */ 
    private java.math.BigInteger orderMainId;
    
    /** 订单编号 */ 
    private java.math.BigInteger orderCode;
    
    /** 共保方代码 */ 
    private java.lang.String coinsCode;
    
    /** 序号 */ 
    private java.lang.Integer serialNo;
    
    /** 责任代码 */ 
    private java.lang.String liabCode;
    
    /** 责任名称 */ 
    private java.lang.String liabName;
    
    /** 保额 */ 
    private java.math.BigDecimal sumInsured;
    
    /** 保费 */ 
    private java.math.BigDecimal grossPremium;
    
    /** 共保份额 */ 
    private java.math.BigDecimal coinsRate;
    
    /** 描述 */ 
    private java.lang.String liabDesc;
    
    /** 备注 */ 
    private java.lang.String remark;
    
    /** 标志 */ 
    private java.lang.String flag;
    
    /** 是否有效:0正常,1作废值 */ 
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
     * 设置属性自增主键ID的值
     */ 
    public void setCoinsLiabId(java.lang.Integer coinsLiabId) {
        this.coinsLiabId = coinsLiabId;
    }
    
    /**
     * 获取属性自增主键ID的值
     */ 
    public java.lang.Integer getCoinsLiabId() {
        return this.coinsLiabId;
    }
    
    /**
     * 设置属性订单主表id的值
     */ 
    public void setOrderMainId(java.math.BigInteger orderMainId) {
        this.orderMainId = orderMainId;
    }
    
    /**
     * 获取属性订单主表id的值
     */ 
    public java.math.BigInteger getOrderMainId() {
        return this.orderMainId;
    }
    
    /**
     * 设置属性订单编号的值
     */ 
    public void setOrderCode(java.math.BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 获取属性订单编号的值
     */ 
    public java.math.BigInteger getOrderCode() {
        return this.orderCode;
    }
    
    /**
     * 设置属性共保方代码的值
     */ 
    public void setCoinsCode(java.lang.String coinsCode) {
        this.coinsCode = coinsCode;
    }
    
    /**
     * 获取属性共保方代码的值
     */ 
    public java.lang.String getCoinsCode() {
        return this.coinsCode;
    }
    
    /**
     * 设置属性序号的值
     */ 
    public void setSerialNo(java.lang.Integer serialNo) {
        this.serialNo = serialNo;
    }
    
    /**
     * 获取属性序号的值
     */ 
    public java.lang.Integer getSerialNo() {
        return this.serialNo;
    }
    
    /**
     * 设置属性责任代码的值
     */ 
    public void setLiabCode(java.lang.String liabCode) {
        this.liabCode = liabCode;
    }
    
    /**
     * 获取属性责任代码的值
     */ 
    public java.lang.String getLiabCode() {
        return this.liabCode;
    }
    
    /**
     * 设置属性责任名称的值
     */ 
    public void setLiabName(java.lang.String liabName) {
        this.liabName = liabName;
    }
    
    /**
     * 获取属性责任名称的值
     */ 
    public java.lang.String getLiabName() {
        return this.liabName;
    }
    
    /**
     * 设置属性保额的值
     */ 
    public void setSumInsured(java.math.BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }
    
    /**
     * 获取属性保额的值
     */ 
    public java.math.BigDecimal getSumInsured() {
        return this.sumInsured;
    }
    
    /**
     * 设置属性保费的值
     */ 
    public void setGrossPremium(java.math.BigDecimal grossPremium) {
        this.grossPremium = grossPremium;
    }
    
    /**
     * 获取属性保费的值
     */ 
    public java.math.BigDecimal getGrossPremium() {
        return this.grossPremium;
    }
    
    /**
     * 设置属性共保份额的值
     */ 
    public void setCoinsRate(java.math.BigDecimal coinsRate) {
        this.coinsRate = coinsRate;
    }
    
    /**
     * 获取属性共保份额的值
     */ 
    public java.math.BigDecimal getCoinsRate() {
        return this.coinsRate;
    }
    
    /**
     * 设置属性描述的值
     */ 
    public void setLiabDesc(java.lang.String liabDesc) {
        this.liabDesc = liabDesc;
    }
    
    /**
     * 获取属性描述的值
     */ 
    public java.lang.String getLiabDesc() {
        return this.liabDesc;
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
     * 设置属性标志的值
     */ 
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }
    
    /**
     * 获取属性标志的值
     */ 
    public java.lang.String getFlag() {
        return this.flag;
    }
    
    /**
     * 设置属性是否有效:0正常,1作废值的值
     */ 
    public void setInvalidFlag(java.lang.Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性是否有效:0正常,1作废值的值
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