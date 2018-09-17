package com.yaic.app.order.dto.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Table(name = "t_order_item_acci")
public class OrderItemAcciDto implements Serializable {
    
	private static final long serialVersionUID = OrderItemAcciDto.class.getName().hashCode();
	
	/** 用户id */ 
	@Transient
	private BigInteger userId;
	
	/** 意健险标的信息表id */ 
	@Id
	private java.lang.Integer acciId;
	
	/** 订单主表id */ 
	private BigInteger orderMainId;
	
	/** 订单编号 */ 
	private BigInteger orderCode;
	
	/**标的序号*/
	private java.lang.Integer itemNo;
	
	/** 职业 */ 
	private java.lang.String occupation;
	
	/** 人数 */ 
	private java.lang.Integer quantity;
	
	/** 定额类型 */ 
	private java.lang.String rationType;
	
	/** 份数 */ 
	private java.lang.Integer uwCount;
	
	/** 备注 */ 
	private java.lang.String remark;
	
	/** 记名标志 0:不记名；1：记名 */ 
	private java.lang.String nominativeInd;
	
	/** 职业大类 */ 
	private java.lang.String occupationType;
	
	/** 职业大类名称 */ 
	private java.lang.String occupationTypeName;
	
	/** 职业等级 */ 
	private java.lang.String occupationLevel;
	
	/** 职业代码 */ 
	private java.lang.String occupationCode;
	
	/** 人员清单*/
	@Transient
	private List<OrderItemAcciLstDto> acciInsuredList;
	
	/**-----------------批改意健险信息参数 START----------------**/
	/** 批改标识：I-标的信息新增，U-原标的信息批改 */ 
	@Transient
	private java.lang.String flag;
	
	/** 险别信息列表 */
	@Transient
	private List<OrderItemkindDto> itemkindList;
	/**-----------------批改意健险信息参数 END----------------**/
	
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
	
	
	public BigInteger getUserId() {
	    return userId;
	}
	
	public java.lang.Integer getItemNo() {
	    return itemNo;
	}
	
	public void setItemNo(java.lang.Integer itemNo) {
	    this.itemNo = itemNo;
	}
	
	public void setUserId(BigInteger userId) {
	    this.userId = userId;
	}
	
	/**
	 * 设置属性意健险标的信息表id的值
	 */ 
	public void setAcciId(java.lang.Integer acciId) {
	    this.acciId = acciId;
	}
	
	/**
	 * 获取属性意健险标的信息表id的值
	 */ 
	public java.lang.Integer getAcciId() {
	    return this.acciId;
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
	 * 设置属性职业的值
	 */ 
	public void setOccupation(java.lang.String occupation) {
	    this.occupation = occupation;
	}
	
	/**
	 * 获取属性职业的值
	 */ 
	public java.lang.String getOccupation() {
	    return this.occupation;
	}
	
	/**
	 * 设置属性人数的值
	 */ 
	public void setQuantity(java.lang.Integer quantity) {
	    this.quantity = quantity;
	}
	
	/**
	 * 获取属性人数的值
	 */ 
	public java.lang.Integer getQuantity() {
	    return this.quantity;
	}
	
	/**
	 * 设置属性定额类型的值
	 */ 
	public void setRationType(java.lang.String rationType) {
	    this.rationType = rationType;
	}
	
	/**
	 * 获取属性定额类型的值
	 */ 
	public java.lang.String getRationType() {
	    return this.rationType;
	}
	
	/**
	 * 设置属性份数的值
	 */ 
	public void setUwCount(java.lang.Integer uwCount) {
	    this.uwCount = uwCount;
	}
	
	/**
	 * 获取属性份数的值
	 */ 
	public java.lang.Integer getUwCount() {
	    return this.uwCount;
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
	 * 设置属性记名标志 0:不记名；1：记名的值
	 */ 
	public void setNominativeInd(java.lang.String nominativeInd) {
	    this.nominativeInd = nominativeInd;
	}
	
	/**
	 * 获取属性记名标志 0:不记名；1：记名的值
	 */ 
	public java.lang.String getNominativeInd() {
	    return this.nominativeInd;
	}
	
	/**
	 * 设置属性职业大类的值
	 */ 
	public void setOccupationType(java.lang.String occupationType) {
	    this.occupationType = occupationType;
	}
	
	/**
	 * 获取属性职业大类的值
	 */ 
	public java.lang.String getOccupationType() {
	    return this.occupationType;
	}
	
	/**
	 * 设置属性职业大类名称的值
	 */ 
	public void setOccupationTypeName(java.lang.String occupationTypeName) {
	    this.occupationTypeName = occupationTypeName;
	}
	
	/**
	 * 获取属性职业大类名称的值
	 */ 
	public java.lang.String getOccupationTypeName() {
	    return this.occupationTypeName;
	}
	
	/**
	 * 设置属性职业等级的值
	 */ 
	public void setOccupationLevel(java.lang.String occupationLevel) {
	    this.occupationLevel = occupationLevel;
	}
	
	/**
	 * 获取属性职业等级的值
	 */ 
	public java.lang.String getOccupationLevel() {
	    return this.occupationLevel;
	}
	
	/**
	 * 设置属性职业代码的值
	 */ 
	public void setOccupationCode(java.lang.String occupationCode) {
	    this.occupationCode = occupationCode;
	}
	
	/**
	 * 获取属性职业代码的值
	 */ 
	public java.lang.String getOccupationCode() {
	    return this.occupationCode;
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
	
	public List<OrderItemAcciLstDto> getAcciInsuredList() {
	    return acciInsuredList;
	}
	
	public void setAcciInsuredList(List<OrderItemAcciLstDto> acciInsuredList) {
	    this.acciInsuredList = acciInsuredList;
	}
	
	/** 批改标识：I-标的信息新增，U-原标的信息批改 */ 
	public java.lang.String getFlag() {
		return flag;
	}
	
	/** 批改标识：I-标的信息新增，U-原标的信息批改 */ 
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}
	
	public List<OrderItemkindDto> getItemkindList() {
		return itemkindList;
	}
	
	public void setItemkindList(List<OrderItemkindDto> itemkindList) {
		this.itemkindList = itemkindList;
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