/*
 * Created By lujicong (2017-09-24 15:26:35)
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

@Table(name = "t_order_salesman")
public class OrderSalesmanDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = OrderSalesmanDto.class.getName().hashCode();
	
	/** 用户id */ 
	@Transient
	private BigInteger userId;
	
	/** 业务员id */ 
	@Id
	private java.lang.Integer salesmanId;
	
	/** 订单编号 */ 
	private java.math.BigInteger orderCode;
	
	/** 订单主表id */ 
	private java.math.BigInteger orderMainId;
	
	/** 序号 */ 
	private java.lang.Integer serialNo;
	
	/** 协议代码 */ 
	private java.lang.String agreementNo;
	
	/** 子协议代码 */ 
	private java.lang.String agreementSubNo;
	
	/** 业务员标识 */ 
	private java.lang.String salesmanFlag;
	
	/** 业务员代码 */ 
	private java.lang.String salesmanCode;
	
	/** 业务员名称 */ 
	private java.lang.String salesmanName;
	
	/** 团队代码 */ 
	private java.lang.String teamCode;
	
	/** 团队名称 */ 
	private java.lang.String teamName;
	
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
	 * 设置属性业务员id的值
	 */ 
	public void setSalesmanId(java.lang.Integer salesmanId) {
	    this.salesmanId = salesmanId;
	}
	
	/**
	 * 获取属性业务员id的值
	 */ 
	public java.lang.Integer getSalesmanId() {
	    return this.salesmanId;
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
	 * 设置属性子协议代码的值
	 */ 
	public void setAgreementSubNo(java.lang.String agreementSubNo) {
	    this.agreementSubNo = agreementSubNo;
	}
	
	/**
	 * 获取属性子协议代码的值
	 */ 
	public java.lang.String getAgreementSubNo() {
	    return this.agreementSubNo;
	}
	
	/**
	 * 设置属性业务员标识的值
	 */ 
	public void setSalesmanFlag(java.lang.String salesmanFlag) {
	    this.salesmanFlag = salesmanFlag;
	}
	
	/**
	 * 获取属性业务员标识的值
	 */ 
	public java.lang.String getSalesmanFlag() {
	    return this.salesmanFlag;
	}
	
	/**
	 * 设置属性业务员代码的值
	 */ 
	public void setSalesmanCode(java.lang.String salesmanCode) {
	    this.salesmanCode = salesmanCode;
	}
	
	/**
	 * 获取属性业务员代码的值
	 */ 
	public java.lang.String getSalesmanCode() {
	    return this.salesmanCode;
	}
	
	/**
	 * 设置属性业务员名称的值
	 */ 
	public void setSalesmanName(java.lang.String salesmanName) {
	    this.salesmanName = salesmanName;
	}
	
	/**
	 * 获取属性业务员名称的值
	 */ 
	public java.lang.String getSalesmanName() {
	    return this.salesmanName;
	}
	
	/**
	 * 设置属性团队代码的值
	 */ 
	public void setTeamCode(java.lang.String teamCode) {
	    this.teamCode = teamCode;
	}
	
	/**
	 * 获取属性团队代码的值
	 */ 
	public java.lang.String getTeamCode() {
	    return this.teamCode;
	}
	
	/**
	 * 设置属性团队名称的值
	 */ 
	public void setTeamName(java.lang.String teamName) {
	    this.teamName = teamName;
	}
	
	/**
	 * 获取属性团队名称的值
	 */ 
	public java.lang.String getTeamName() {
	    return this.teamName;
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