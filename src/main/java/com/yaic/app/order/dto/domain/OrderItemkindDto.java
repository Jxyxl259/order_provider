/*
 * Created By lujicong (2015-12-21 16:02:16)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_itemkind")
public class OrderItemkindDto implements Serializable {
    
	private static final long serialVersionUID = OrderItemkindDto.class.getName().hashCode();
	
	/** 用户id */ 
	@Transient
	private BigInteger userId;
	
	/** 主键id */ 
	@Id
	private java.lang.Integer itemkindId;
	
	/** 订单主表id */ 
	private BigInteger orderMainId;
	
	/** 订单编号 */ 
	private BigInteger orderCode;
	
	/**标的序号*/
	private java.lang.Integer itemNo;
	
	/** 序号 */ 
	private java.lang.Integer serialNo;
	
	/** 险别代码 */ 
	private java.lang.String kindCode;
	
	/** 险别名称 */ 
	private java.lang.String kindName;
	
	/** 保额 */ 
	private BigDecimal amount;
	
	/** 保费 */ 
	private BigDecimal premium;
	
	/** 是否计入总保额标志:0-否,1-是 */ 
	private java.lang.String calculateInd;
	
	/** 投保不计免赔标志 */ 
	private java.lang.String deductibleFlag;
	
	/** 创建人 */ 
	private java.lang.String createdUser;
	
	/** 创建时间 */ 
	private java.util.Date createdDate;
	
	/** 更新人 */ 
	private java.lang.String updatedUser;
	
	/** 更新时间 */ 
	private java.util.Date updatedDate;
	
	/** 是否有效:0正常,1作废值 */ 
	private Integer invalidFlag;
	
	/** 主险、附加险标志 */ 
	private java.lang.String kindInd;
	
	/** 费率 */ 
	private BigDecimal rate;
	
	/** 每人保费 */
	@Transient
	private BigDecimal unitPremium;
	
	/** 年保费 */
	@Transient
	private BigDecimal yearPremium;
	
	/** 再保保费 */
	private BigDecimal reinsPremium;
	
	/**-----------------批改意健险信息参数 START----------------**/
	/** 每人保额 */
	@Transient
	private BigDecimal unitInsured;
	
	/** 批改标识：I-新增，D-删除，U-修改 */ 
	@Transient
	private java.lang.String flag;
	
	/** 限额信息列表 */
	@Transient
	private List<OrderLimitDto> limitList;
	
	/** 免赔信息列表 */
	@Transient
	private List<OrderDeductibleDto> deductibleList;
	
	/** 再保费率 */
	@Transient
	private BigDecimal reinsRate;
	/**-----------------批改意健险信息参数 END----------------**/
	
	public java.lang.Integer getItemNo() {
		return itemNo;
	}
	
	public void setItemNo(java.lang.Integer itemNo) {
		this.itemNo = itemNo;
	}
	
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
	 * 设置属性主键id的值
	 */ 
	public void setItemkindId(java.lang.Integer itemkindId) {
	    this.itemkindId = itemkindId;
	}
	
	/**
	 * 获取属性主键id的值
	 */ 
	public java.lang.Integer getItemkindId() {
	    return this.itemkindId;
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
	 * 设置属性险别代码的值
	 */ 
	public void setKindCode(java.lang.String kindCode) {
	    this.kindCode = kindCode;
	}
	
	/**
	 * 获取属性险别代码的值
	 */ 
	public java.lang.String getKindCode() {
	    return this.kindCode;
	}
	
	/**
	 * 设置属性险别名称的值
	 */ 
	public void setKindName(java.lang.String kindName) {
	    this.kindName = kindName;
	}
	
	/**
	 * 获取属性险别名称的值
	 */ 
	public java.lang.String getKindName() {
	    return this.kindName;
	}
	
	/**
	 * 设置属性保额的值
	 */ 
	public void setAmount(BigDecimal amount) {
	    this.amount = amount;
	}
	
	/**
	 * 获取属性保额的值
	 */ 
	public BigDecimal getAmount() {
	    return this.amount;
	}
	
	/**
	 * 设置属性保费的值
	 */ 
	public void setPremium(BigDecimal premium) {
	    this.premium = premium;
	}
	
	/**
	 * 获取属性保费的值
	 */ 
	public BigDecimal getPremium() {
	    return this.premium;
	}
	
	public java.lang.String getCalculateInd() {
		return calculateInd;
	}
	
	public void setCalculateInd(java.lang.String calculateInd) {
		this.calculateInd = calculateInd;
	}
	
	/**
	 * 设置属性投保不计免赔标志的值
	 */ 
	public void setDeductibleFlag(java.lang.String deductibleFlag) {
	    this.deductibleFlag = deductibleFlag;
	}
	
	/**
	 * 获取属性投保不计免赔标志的值
	 */ 
	public java.lang.String getDeductibleFlag() {
	    return this.deductibleFlag;
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
	public void setInvalidFlag(Integer invalidFlag) {
	    this.invalidFlag = invalidFlag;
	}
	
	/**
	 * 获取属性是否有效:0正常,1作废值的值
	 */ 
	public Integer getInvalidFlag() {
	    return this.invalidFlag;
	}
	
	public java.lang.String getKindInd() {
	    return kindInd;
	}
	
	public void setKindInd(java.lang.String kindInd) {
	    this.kindInd = kindInd;
	}
	
	public BigDecimal getRate() {
	    return rate;
	}
	
	public void setRate(BigDecimal rate) {
	    this.rate = rate;
	}
	
	/**每人保费**/
	public BigDecimal getUnitPremium() {
		return unitPremium;
	}
	
	/**每人保费**/
	public void setUnitPremium(BigDecimal unitPremium) {
		this.unitPremium = unitPremium;
	}
	
	/** 年保费 */
	public BigDecimal getYearPremium() {
		return yearPremium;
	}
	
	/** 年保费 */
	public void setYearPremium(BigDecimal yearPremium) {
		this.yearPremium = yearPremium;
	}

	/**再保保费**/
	public BigDecimal getReinsPremium() {
		return reinsPremium;
	}
	
	/**再保保费**/
	public void setReinsPremium(BigDecimal reinsPremium) {
		this.reinsPremium = reinsPremium;
	}
	
	/** 每人保额 */
	public BigDecimal getUnitInsured() {
		return unitInsured;
	}
	
	/** 每人保额 */
	public void setUnitInsured(BigDecimal unitInsured) {
		this.unitInsured = unitInsured;
	}
	
	/** 批改标识：I-新增，D-删除，U-修改 */ 
	public java.lang.String getFlag() {
		return flag;
	}
	
	/** 批改标识：I-新增，D-删除，U-修改 */ 
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}
	
	/** 限额信息列表 */
	public List<OrderLimitDto> getLimitList() {
		return limitList;
	}
	
	/** 限额信息列表 */
	public void setLimitList(List<OrderLimitDto> limitList) {
		this.limitList = limitList;
	}
	
	/** 免赔信息列表 */
	public List<OrderDeductibleDto> getDeductibleList() {
		return deductibleList;
	}
	
	/** 免赔信息列表 */
	public void setDeductibleList(List<OrderDeductibleDto> deductibleList) {
		this.deductibleList = deductibleList;
	}
	
	/** 再保费率 */
	public BigDecimal getReinsRate() {
		return reinsRate;
	}

	/** 再保费率 */
	public void setReinsRate(BigDecimal reinsRate) {
		this.reinsRate = reinsRate;
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