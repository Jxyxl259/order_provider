/*
 * Created By lujicong (2017-07-24 19:48:58)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.yaic.fa.dto.BaseDto;

@Table(name = "t_shop_order_info")
public class ShopOrderInfoDto extends BaseDto implements Serializable {
    
	private static final long serialVersionUID = ShopOrderInfoDto.class.getName().hashCode();
	
	/** 订单编号 */ 
	@Id
	private java.math.BigInteger orderCode;
	
	/** 用户id */ 
	private java.math.BigInteger userId;
	
	/** 订单的状态;0-未确认,1-已确认,2-已完成,3-失败,4-取消 */ 
	private java.lang.String orderStatus;
	
	/** 是否索取发票:0-不需要,1-需要 */ 
	private java.lang.Integer invFlag;
	
	/** 发票类型,用户页面选择,取值ecs_shop_config的code字段的值invoice_type的value */ 
	private java.lang.String invType;
	
	/** 发票抬头,用户页面填写 */ 
	private java.lang.String invPayee;
	
	/** 发票内容,用户页面选择,取值ecs_shop_config的code字段的值 为invoice_content的value */ 
	private java.lang.String invContent;
	
	/** 商品的总金额 */ 
	private java.math.BigDecimal goodsAmount;
	
	/** 应付款金额 */ 
	private java.math.BigDecimal orderAmount;
	
	/** 订单的来源页面 */ 
	private java.lang.String referer;
	
	/** 订单生成时间 */ 
	private java.util.Date addTime;
	
	/** 订单确认时间 */ 
	private java.util.Date confirmTime;
	
	/** 折扣金额 */ 
	private java.math.BigDecimal discount;
	
	/** 创建人 */ 
	private java.lang.String createdUser;
	
	/** 创建时间 */ 
	private java.util.Date createdDate;
	
	/** 更新人 */ 
	private java.lang.String updatedUser;
	
	/** 更新时间 */ 
	private java.util.Date updatedDate;
	
	/** 是否有效:0正常,1作废值 */ 
	private java.lang.Integer invalidFlag;
	
	/** 推荐人 */ 
	private java.lang.String recommendedCode;
	
	/** APP_ID */ 
	private java.lang.String appId;
	
	/** 同步保单状态:0-已同步 */ 
	private java.lang.String synPolicyStatus;
	
	/** 邮寄地址 */ 
	private java.lang.String address;
	
	/** 联系电话 */ 
	private java.lang.String phoneNo;
	
	/** 邮政编码 */ 
	private java.lang.String postCode;
	
	// 保单号
	@Transient
	private String policyNo;
	
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
	 * 设置属性用户id的值
	 */ 
	public void setUserId(java.math.BigInteger userId) {
	    this.userId = userId;
	}
	
	/**
	 * 获取属性用户id的值
	 */ 
	public java.math.BigInteger getUserId() {
	    return this.userId;
	}
	
	/**
	 * 设置属性订单的状态;0-未确认,1-已确认,2-已完成,3-失败,4-取消的值
	 */ 
	public void setOrderStatus(java.lang.String orderStatus) {
	    this.orderStatus = orderStatus;
	}
	
	/**
	 * 获取属性订单的状态;0-未确认,1-已确认,2-已完成,3-失败,4-取消的值
	 */ 
	public java.lang.String getOrderStatus() {
	    return this.orderStatus;
	}
	
	/**
	 * 设置属性是否索取发票:0-不需要,1-需要的值
	 */ 
	public void setInvFlag(java.lang.Integer invFlag) {
	    this.invFlag = invFlag;
	}
	
	/**
	 * 获取属性是否索取发票:0-不需要,1-需要的值
	 */ 
	public java.lang.Integer getInvFlag() {
	    return this.invFlag;
	}
	
	/**
	 * 设置属性发票类型,用户页面选择,取值ecs_shop_config的code字段的值invoice_type的value的值
	 */ 
	public void setInvType(java.lang.String invType) {
	    this.invType = invType;
	}
	
	/**
	 * 获取属性发票类型,用户页面选择,取值ecs_shop_config的code字段的值invoice_type的value的值
	 */ 
	public java.lang.String getInvType() {
	    return this.invType;
	}
	
	/**
	 * 设置属性发票抬头,用户页面填写的值
	 */ 
	public void setInvPayee(java.lang.String invPayee) {
	    this.invPayee = invPayee;
	}
	
	/**
	 * 获取属性发票抬头,用户页面填写的值
	 */ 
	public java.lang.String getInvPayee() {
	    return this.invPayee;
	}
	
	/**
	 * 设置属性发票内容,用户页面选择,取值ecs_shop_config的code字段的值 为invoice_content的value的值
	 */ 
	public void setInvContent(java.lang.String invContent) {
	    this.invContent = invContent;
	}
	
	/**
	 * 获取属性发票内容,用户页面选择,取值ecs_shop_config的code字段的值 为invoice_content的value的值
	 */ 
	public java.lang.String getInvContent() {
	    return this.invContent;
	}
	
	/**
	 * 设置属性商品的总金额的值
	 */ 
	public void setGoodsAmount(java.math.BigDecimal goodsAmount) {
	    this.goodsAmount = goodsAmount;
	}
	
	/**
	 * 获取属性商品的总金额的值
	 */ 
	public java.math.BigDecimal getGoodsAmount() {
	    return this.goodsAmount;
	}
	
	/**
	 * 设置属性应付款金额的值
	 */ 
	public void setOrderAmount(java.math.BigDecimal orderAmount) {
	    this.orderAmount = orderAmount;
	}
	
	/**
	 * 获取属性应付款金额的值
	 */ 
	public java.math.BigDecimal getOrderAmount() {
	    return this.orderAmount;
	}
	
	/**
	 * 设置属性订单的来源页面的值
	 */ 
	public void setReferer(java.lang.String referer) {
	    this.referer = referer;
	}
	
	/**
	 * 获取属性订单的来源页面的值
	 */ 
	public java.lang.String getReferer() {
	    return this.referer;
	}
	
	/**
	 * 设置属性订单生成时间的值
	 */ 
	public void setAddTime(java.util.Date addTime) {
	    this.addTime = addTime;
	}
	
	/**
	 * 获取属性订单生成时间的值
	 */ 
	public java.util.Date getAddTime() {
	    return this.addTime;
	}
	
	/**
	 * 设置属性订单确认时间的值
	 */ 
	public void setConfirmTime(java.util.Date confirmTime) {
	    this.confirmTime = confirmTime;
	}
	
	/**
	 * 获取属性订单确认时间的值
	 */ 
	public java.util.Date getConfirmTime() {
	    return this.confirmTime;
	}
	
	/**
	 * 设置属性折扣金额的值
	 */ 
	public void setDiscount(java.math.BigDecimal discount) {
	    this.discount = discount;
	}
	
	/**
	 * 获取属性折扣金额的值
	 */ 
	public java.math.BigDecimal getDiscount() {
	    return this.discount;
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
	 * 设置属性推荐人的值
	 */ 
	public void setRecommendedCode(java.lang.String recommendedCode) {
	    this.recommendedCode = recommendedCode;
	}
	
	/**
	 * 获取属性推荐人的值
	 */ 
	public java.lang.String getRecommendedCode() {
	    return this.recommendedCode;
	}
	
	/**
	 * 设置属性APP_ID的值
	 */ 
	public void setAppId(java.lang.String appId) {
	    this.appId = appId;
	}
	
	/**
	 * 获取属性APP_ID的值
	 */ 
	public java.lang.String getAppId() {
	    return this.appId;
	}
	
	/**
	 * 设置属性同步保单状态:0-已同步的值
	 */ 
	public void setSynPolicyStatus(java.lang.String synPolicyStatus) {
	    this.synPolicyStatus = synPolicyStatus;
	}
	
	/**
	 * 获取属性同步保单状态:0-已同步的值
	 */ 
	public java.lang.String getSynPolicyStatus() {
	    return this.synPolicyStatus;
	}
	
	/**
	 * 获取属性邮寄地址的值
	 */
	public java.lang.String getAddress() {
		return address;
	}
	
	/**
	 * 设置属性邮寄地址的值
	 */ 
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	/**
	 * 获取属性联系电话的值
	 */
	public java.lang.String getPhoneNo() {
		return phoneNo;
	}
	
	/**
	 * 设置属性联系电话的值
	 */ 
	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	/**
	 * 获取属性邮政编码的值
	 */
	public java.lang.String getPostCode() {
		return postCode;
	}
	
	/**
	 * 设置属性邮政编码的值
	 */ 
	public void setPostCode(java.lang.String postCode) {
		this.postCode = postCode;
	}
	
	public String getPolicyNo() {
	    return policyNo;
	}
	
	public void setPolicyNo(String policyNo) {
	    this.policyNo = policyNo;
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