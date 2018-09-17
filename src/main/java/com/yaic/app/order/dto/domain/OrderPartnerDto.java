/*
 * Created By lujicong (2017-09-24 15:26:34)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2017
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

import com.yaic.fa.dto.BaseDto;

@Table(name = "t_order_partner")
public class OrderPartnerDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = OrderPartnerDto.class.getName().hashCode();
	
	/** 用户id */ 
	@Transient
	private BigInteger userId;
	
	/** 主键ID */ 
	@Id
	private java.lang.Integer partnerId;
	
	/** 订单编号 */ 
	private java.math.BigInteger orderCode;
	
	/** 订单主表id */ 
	private java.math.BigInteger orderMainId;
	
	/** 序号 */ 
	private java.lang.Integer serialNo;
	
	/** 协议代码 */ 
	private java.lang.String agreementNo;
	
	/** 合作方类型:1-个人代理，2-公司代理，3-经纪公司，4-其它中介人，5-网络平台 */ 
	private java.lang.String partnerType;
	
	/** 合作方标识:0-辅合作方，1-主合作方 */ 
	private java.lang.String partnerFlag;
	
	/** 合作方代码 */ 
	private java.lang.String partnerCode;
	
	/** 合作方名称 */ 
	private java.lang.String partnerName;
	
	/** 合作方别名 */ 
	private java.lang.String partnerAlias;
	
	/** 失效标志：0-有效，1-失效 */ 
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
	 * 设置属性主键ID的值
	 */ 
	public void setPartnerId(java.lang.Integer partnerId) {
	    this.partnerId = partnerId;
	}
	
	/**
	 * 获取属性主键ID的值
	 */ 
	public java.lang.Integer getPartnerId() {
	    return this.partnerId;
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
	 * 设置属性协议代码的值
	 */ 
	public void setAgreementNo(java.lang.String agreementNo) {
	    this.agreementNo = agreementNo;
	}
	
	/**
	 * 获取属性协议代码的值
	 */ 
	public java.lang.String getAgreementNo() {
	    return this.agreementNo;
	}
	
	/**
	 * 设置属性合作方类型:1-个人代理，2-公司代理，3-经纪公司，4-其它中介人，5-网络平台的值
	 */ 
	public void setPartnerType(java.lang.String partnerType) {
	    this.partnerType = partnerType;
	}
	
	/**
	 * 获取属性合作方类型:1-个人代理，2-公司代理，3-经纪公司，4-其它中介人，5-网络平台的值
	 */ 
	public java.lang.String getPartnerType() {
	    return this.partnerType;
	}
	
	/**
	 * 设置属性合作方标识:0-辅合作方，1-主合作方的值
	 */ 
	public void setPartnerFlag(java.lang.String partnerFlag) {
	    this.partnerFlag = partnerFlag;
	}
	
	/**
	 * 获取属性合作方标识:0-辅合作方，1-主合作方的值
	 */ 
	public java.lang.String getPartnerFlag() {
	    return this.partnerFlag;
	}
	
	/**
	 * 设置属性合作方代码的值
	 */ 
	public void setPartnerCode(java.lang.String partnerCode) {
	    this.partnerCode = partnerCode;
	}
	
	/**
	 * 获取属性合作方代码的值
	 */ 
	public java.lang.String getPartnerCode() {
	    return this.partnerCode;
	}
	
	/**
	 * 设置属性合作方名称的值
	 */ 
	public void setPartnerName(java.lang.String partnerName) {
	    this.partnerName = partnerName;
	}
	
	/**
	 * 获取属性合作方名称的值
	 */ 
	public java.lang.String getPartnerName() {
	    return this.partnerName;
	}
	
	/**
	 * 设置属性合作方别名的值
	 */ 
	public void setPartnerAlias(java.lang.String partnerAlias) {
	    this.partnerAlias = partnerAlias;
	}
	
	/**
	 * 获取属性合作方别名的值
	 */ 
	public java.lang.String getPartnerAlias() {
	    return this.partnerAlias;
	}
	
	/**
	 * 设置属性失效标志：0-有效，1-失效的值
	 */ 
	public void setInvalidFlag(java.lang.Integer invalidFlag) {
	    this.invalidFlag = invalidFlag;
	}
	
	/**
	 * 获取属性失效标志：0-有效，1-失效的值
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