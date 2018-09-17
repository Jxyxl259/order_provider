/*
 * Created By lujicong (2015-12-21 16:02:18)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
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

@Table(name = "t_order_property")
public class OrderPropertyDto implements Serializable {
    
    private static final long serialVersionUID = OrderPropertyDto.class.getName().hashCode();
   
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 财产险标的信息表id */ 
    @Id
    private java.lang.Integer propertyId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 省份代码 */ 
    private java.lang.String itemProvinceCode;
    
    /** 省份名称 */ 
    private java.lang.String itemProvinceCname;
    
    /** 城市代码 */ 
    private java.lang.String itemCityCode;
    
    /** 城市名称 */ 
    private java.lang.String itemCityCname;
    
    /** 区县代码 */ 
    private java.lang.String itemDistrictCode;
    
    /** 区县名称 */ 
    private java.lang.String itemDistrictCname;
    
    /** 保险住所 */ 
    private java.lang.String situation;
    
    /** 是否有效:0正常,1作废值 */ 
    private Integer invalidFlag;
    
    /** 创建人 */ 
    private java.lang.String createdUser;
    
    /** 创建时间 */ 
    private java.util.Date createdDate;
    
    /** 更新人 */ 
    private java.lang.String updatedUser;
    
    /** 更新时间 */ 
    private java.util.Date updatedDate;
    
    /** 定额类型 */ 
    private java.lang.String rationType;
    
    /**
     * 设置属性用户id的值
     */ 
    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
    
    /**
     * 获取属性用户id的值
     */ 
    public BigInteger getUserId() {
        return this.userId;
    }
    
    /**
     * 设置属性财产险标的信息表id的值
     */ 
    public void setPropertyId(java.lang.Integer propertyId) {
        this.propertyId = propertyId;
    }
    
    /**
     * 获取属性财产险标的信息表id的值
     */ 
    public java.lang.Integer getPropertyId() {
        return this.propertyId;
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
     * 设置属性省份代码的值
     */ 
    public void setItemProvinceCode(java.lang.String itemProvinceCode) {
        this.itemProvinceCode = itemProvinceCode;
    }
    
    /**
     * 获取属性省份代码的值
     */ 
    public java.lang.String getItemProvinceCode() {
        return this.itemProvinceCode;
    }
    
    /**
     * 设置属性省份名称的值
     */ 
    public void setItemProvinceCname(java.lang.String itemProvinceCname) {
        this.itemProvinceCname = itemProvinceCname;
    }
    
    /**
     * 获取属性省份名称的值
     */ 
    public java.lang.String getItemProvinceCname() {
        return this.itemProvinceCname;
    }
    
    /**
     * 设置属性城市代码的值
     */ 
    public void setItemCityCode(java.lang.String itemCityCode) {
        this.itemCityCode = itemCityCode;
    }
    
    /**
     * 获取属性城市代码的值
     */ 
    public java.lang.String getItemCityCode() {
        return this.itemCityCode;
    }
    
    /**
     * 设置属性城市名称的值
     */ 
    public void setItemCityCname(java.lang.String itemCityCname) {
        this.itemCityCname = itemCityCname;
    }
    
    /**
     * 获取属性城市名称的值
     */ 
    public java.lang.String getItemCityCname() {
        return this.itemCityCname;
    }
    
    /**
     * 设置属性区县代码的值
     */ 
    public void setItemDistrictCode(java.lang.String itemDistrictCode) {
        this.itemDistrictCode = itemDistrictCode;
    }
    
    /**
     * 获取属性区县代码的值
     */ 
    public java.lang.String getItemDistrictCode() {
        return this.itemDistrictCode;
    }
    
    /**
     * 设置属性区县名称的值
     */ 
    public void setItemDistrictCname(java.lang.String itemDistrictCname) {
        this.itemDistrictCname = itemDistrictCname;
    }
    
    /**
     * 获取属性区县名称的值
     */ 
    public java.lang.String getItemDistrictCname() {
        return this.itemDistrictCname;
    }
    
    /**
     * 设置属性保险住所的值
     */ 
    public void setSituation(java.lang.String situation) {
        this.situation = situation;
    }
    
    /**
     * 获取属性保险住所的值
     */ 
    public java.lang.String getSituation() {
        return this.situation;
    }
    
    /**
     * 设置属性是否有效:0正常,1作废值的值
     */ 
    public void setInvalidFlag(Integer invalidFlag) {
        this.invalidFlag = invalidFlag;
    }
    
    /**
     * 获取属性是否有效:0正常,1作废值的值
     */ 
    public Integer getInvalidFlag() {
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
    
    public java.lang.String getRationType() {
        return rationType;
    }

    public void setRationType(java.lang.String rationType) {
        this.rationType = rationType;
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