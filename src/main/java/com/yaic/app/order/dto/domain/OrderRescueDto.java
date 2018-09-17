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

@Table(name = "t_order_rescue")
public class OrderRescueDto implements Serializable {
    
	private static final long serialVersionUID = OrderRescueDto.class.getName().hashCode();
	/** 用户id */ 
    @Transient
    private BigInteger userId;
    
	/** 救援信息表id */ 
	@Id
	private java.lang.Integer rescueId;
	
	/** 订单主表id */ 
	private BigInteger orderMainId;
	
	/** 订单编号 */ 
	private BigInteger orderCode;
	
	/** 序号 */ 
    private java.lang.Integer serialNo;
	
	/** 救援公司*/ 
	private java.lang.String rescueCompany;
	
	/** 救援方案 */ 
	private java.lang.String rescueProgram;
	
	/** 保障计划 */ 
	private java.lang.String rescuePlan;
	
	/** 备注 */ 
	private java.lang.String remark;
	
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
	 * 获取属性用户id的值
	 */
	public BigInteger getUserId() {
		return userId;
	}

	/**
     * 设置属性用户id的值
     */
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	
	/**
     * 获取属性救援信息表id的值
     */
	public java.lang.Integer getRescueId() {
		return rescueId;
	}

	/**
	 * 设置属性救援信息表id的值
	 */
	public void setRescueId(java.lang.Integer rescueId) {
		this.rescueId = rescueId;
	}

	/**
     * 获取属性订单主表id的值
     */
	public BigInteger getOrderMainId() {
		return orderMainId;
	}

	/**
	 * 设置属性订单主表id的值
	 */
	public void setOrderMainId(BigInteger orderMainId) {
		this.orderMainId = orderMainId;
	}
	
	/**
     * 获取属性订单编号的值
     */
	public BigInteger getOrderCode() {
		return orderCode;
	}

	/**
     * 设置属性订单编号的值
     */
	public void setOrderCode(BigInteger orderCode) {
		this.orderCode = orderCode;
	}
	
	/**
     * 获取属性序号的值
     */
	public java.lang.Integer getSerialNo() {
		return serialNo;
	}

	/**
     * 设置属性序号的值
     */
	public void setSerialNo(java.lang.Integer serialNo) {
		this.serialNo = serialNo;
	}

	/**
     * 获取属性救援公司的值
     */
	public java.lang.String getRescueCompany() {
		return rescueCompany;
	}

	/**
     * 设置属性救援公司的值
     */
	public void setRescueCompany(java.lang.String rescueCompany) {
		this.rescueCompany = rescueCompany;
	}

	/**
     * 获取属性救援方案的值
     */
	public java.lang.String getRescueProgram() {
		return rescueProgram;
	}

	/**
     * 设置属性救援方案的值
     */
	public void setRescueProgram(java.lang.String rescueProgram) {
		this.rescueProgram = rescueProgram;
	}

	/**
     * 获取属性保障计划的值
     */
	public java.lang.String getRescuePlan() {
		return rescuePlan;
	}

	/**
     * 设置属性保障计划的值
     */
	public void setRescuePlan(java.lang.String rescuePlan) {
		this.rescuePlan = rescuePlan;
	}

	/**
     * 获取属性备注的值
     */
	public java.lang.String getRemark() {
		return remark;
	}

	/**
     * 设置属性备注的值
     */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
     * 获取属性是否有效:0正常,1作废值的值
     */
	public java.lang.Integer getInvalidFlag() {
		return invalidFlag;
	}

	/**
     * 设置属性是否有效:0正常,1作废值的值
     */
	public void setInvalidFlag(java.lang.Integer invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	/**
     * 获取属性创建人的值
     */
	public java.lang.String getCreatedUser() {
		return createdUser;
	}

	/**
     * 设置属性创建人的值
     */
	public void setCreatedUser(java.lang.String createdUser) {
		this.createdUser = createdUser;
	}

	/**
     * 获取属性创建时间的值
     */
	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	/**
     * 设置属性创建时间的值
     */
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
     * 获取属性更新人的值
     */
	public java.lang.String getUpdatedUser() {
		return updatedUser;
	}

	/**
     * 设置属性更新人的值
     */
	public void setUpdatedUser(java.lang.String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
     * 获取属性更新时间的值
     */
	public java.util.Date getUpdatedDate() {
		return updatedDate;
	}

	/**
     * 设置属性更新时间的值
     */
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
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