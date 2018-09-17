/*
 * Created By lujicong (2015-12-21 16:02:21)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_shop_order_shipping")
public class ShopOrderShippingDto implements Serializable {
    
    private static final long serialVersionUID = ShopOrderShippingDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 配送信息id */ 
    @Id
    private java.lang.Integer shippingId;
    
    /** 电商订单号 */ 
    private BigInteger orderCode;
    
    /** 下单时间 */ 
    private java.util.Date addTime;
    
    /** 收件人姓名 */ 
    private java.lang.String receiverName;
    
    /** 收件人手机 */ 
    private java.lang.String receiverPhone;
    
    /** 收件省代码 */ 
    private java.lang.String receiverProvinceCode;
    
    /** 收件省名称 */ 
    private java.lang.String receiverProvinceCname;
    
    /** 收件市代码 */ 
    private java.lang.String receiverCityCode;
    
    /** 收件市名称 */ 
    private java.lang.String receiverCityCname;
    
    /** 收件县、区代码 */ 
    private java.lang.String receiverAreaCode;
    
    /** 收件县、区名称 */ 
    private java.lang.String receiverAreaCname;
    
    /** 详细收件街道地址 */ 
    private java.lang.String receiverAddress;
    
    /** 期望收件日期 */ 
    private java.util.Date receiverDate;
    
    /** 配送方式 */ 
    private java.lang.String shippingWay;
    
    /** 配送状态,0-未发货,1-已发货,2-已收货,4-退货 */ 
    private java.lang.String shippingStatus;
    
    /** 配送日期 */ 
    private java.util.Date shippingTime;
    
    /** 订单金额 */ 
    private BigDecimal orderAmount;
    
    /** 配送费用 */ 
    private BigDecimal shippingFee;
    
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
     * 设置属性配送信息id的值
     */ 
    public void setShippingId(java.lang.Integer shippingId) {
        this.shippingId = shippingId;
    }
    
    /**
     * 获取属性配送信息id的值
     */ 
    public java.lang.Integer getShippingId() {
        return this.shippingId;
    }
    
    /**
     * 设置属性电商订单号的值
     */ 
    public void setOrderCode(BigInteger orderCode) {
        this.orderCode = orderCode;
    }
    
    /**
     * 获取属性电商订单号的值
     */ 
    public BigInteger getOrderCode() {
        return this.orderCode;
    }
    
    /**
     * 设置属性下单时间的值
     */ 
    public void setAddTime(java.util.Date addTime) {
        this.addTime = addTime;
    }
    
    /**
     * 获取属性下单时间的值
     */ 
    public java.util.Date getAddTime() {
        return this.addTime;
    }
    
    /**
     * 设置属性收件人姓名的值
     */ 
    public void setReceiverName(java.lang.String receiverName) {
        this.receiverName = receiverName;
    }
    
    /**
     * 获取属性收件人姓名的值
     */ 
    public java.lang.String getReceiverName() {
        return this.receiverName;
    }
    
    /**
     * 设置属性收件人手机的值
     */ 
    public void setReceiverPhone(java.lang.String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    
    /**
     * 获取属性收件人手机的值
     */ 
    public java.lang.String getReceiverPhone() {
        return this.receiverPhone;
    }
    
    /**
     * 设置属性收件省代码的值
     */ 
    public void setReceiverProvinceCode(java.lang.String receiverProvinceCode) {
        this.receiverProvinceCode = receiverProvinceCode;
    }
    
    /**
     * 获取属性收件省代码的值
     */ 
    public java.lang.String getReceiverProvinceCode() {
        return this.receiverProvinceCode;
    }
    
    /**
     * 设置属性收件省名称的值
     */ 
    public void setReceiverProvinceCname(java.lang.String receiverProvinceCname) {
        this.receiverProvinceCname = receiverProvinceCname;
    }
    
    /**
     * 获取属性收件省名称的值
     */ 
    public java.lang.String getReceiverProvinceCname() {
        return this.receiverProvinceCname;
    }
    
    /**
     * 设置属性收件市代码的值
     */ 
    public void setReceiverCityCode(java.lang.String receiverCityCode) {
        this.receiverCityCode = receiverCityCode;
    }
    
    /**
     * 获取属性收件市代码的值
     */ 
    public java.lang.String getReceiverCityCode() {
        return this.receiverCityCode;
    }
    
    /**
     * 设置属性收件市名称的值
     */ 
    public void setReceiverCityCname(java.lang.String receiverCityCname) {
        this.receiverCityCname = receiverCityCname;
    }
    
    /**
     * 获取属性收件市名称的值
     */ 
    public java.lang.String getReceiverCityCname() {
        return this.receiverCityCname;
    }
    
    /**
     * 设置属性收件县、区代码的值
     */ 
    public void setReceiverAreaCode(java.lang.String receiverAreaCode) {
        this.receiverAreaCode = receiverAreaCode;
    }
    
    /**
     * 获取属性收件县、区代码的值
     */ 
    public java.lang.String getReceiverAreaCode() {
        return this.receiverAreaCode;
    }
    
    /**
     * 设置属性收件县、区名称的值
     */ 
    public void setReceiverAreaCname(java.lang.String receiverAreaCname) {
        this.receiverAreaCname = receiverAreaCname;
    }
    
    /**
     * 获取属性收件县、区名称的值
     */ 
    public java.lang.String getReceiverAreaCname() {
        return this.receiverAreaCname;
    }
    
    /**
     * 设置属性详细收件街道地址的值
     */ 
    public void setReceiverAddress(java.lang.String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
    
    /**
     * 获取属性详细收件街道地址的值
     */ 
    public java.lang.String getReceiverAddress() {
        return this.receiverAddress;
    }
    
    /**
     * 设置属性期望收件日期的值
     */ 
    public void setReceiverDate(java.util.Date receiverDate) {
        this.receiverDate = receiverDate;
    }
    
    /**
     * 获取属性期望收件日期的值
     */ 
    public java.util.Date getReceiverDate() {
        return this.receiverDate;
    }
    
    /**
     * 设置属性配送方式的值
     */ 
    public void setShippingWay(java.lang.String shippingWay) {
        this.shippingWay = shippingWay;
    }
    
    /**
     * 获取属性配送方式的值
     */ 
    public java.lang.String getShippingWay() {
        return this.shippingWay;
    }
    
    /**
     * 设置属性配送状态,0-未发货,1-已发货,2-已收货,4-退货的值
     */ 
    public void setShippingStatus(java.lang.String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }
    
    /**
     * 获取属性配送状态,0-未发货,1-已发货,2-已收货,4-退货的值
     */ 
    public java.lang.String getShippingStatus() {
        return this.shippingStatus;
    }
    
    /**
     * 设置属性配送日期的值
     */ 
    public void setShippingTime(java.util.Date shippingTime) {
        this.shippingTime = shippingTime;
    }
    
    /**
     * 获取属性配送日期的值
     */ 
    public java.util.Date getShippingTime() {
        return this.shippingTime;
    }
    
    /**
     * 设置属性订单金额的值
     */ 
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
    
    /**
     * 获取属性订单金额的值
     */ 
    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }
    
    /**
     * 设置属性配送费用的值
     */ 
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }
    
    /**
     * 获取属性配送费用的值
     */ 
    public BigDecimal getShippingFee() {
        return this.shippingFee;
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