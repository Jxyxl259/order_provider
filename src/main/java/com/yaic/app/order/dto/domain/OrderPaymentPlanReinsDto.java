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

@Table(name = "t_order_payment_plan_Reins")
public class OrderPaymentPlanReinsDto implements Serializable {

	private static final long serialVersionUID = OrderPaymentPlanReinsDto.class.getName().hashCode();
	/** 用户id */
	@Transient
	private BigInteger userId;
	/** 费用计划ID */
	@Id
	private java.lang.Integer paymentPlanReinsId;

	/** 订单主表id */
	private BigInteger orderMainId;

	/** 订单编号 */
	private BigInteger orderCode;

	/** 订单编号 */
	private java.lang.String kindCode;
	
	/** 标的序号*/
	private java.lang.Integer itemNo;
	
	/** 缴费期次*/
	private java.lang.Integer payNo;
	
	/** 计划交费截止日期 */
	private java.util.Date planDate;
	
	/** 币别*/
	private java.lang.String currency;
	
	/** 费用金额 */
	private java.math.BigDecimal planFee;

	/** 是否有效 0 有效 1无效 */
	private java.lang.Integer invalidFlag;
	
	/** 备注 */
	private java.lang.String remark;
	
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

	public java.lang.Integer getPaymentPlanReinsId() {
		return paymentPlanReinsId;
	}

	public void setPaymentPlanReinsId(java.lang.Integer paymentPlanReinsId) {
		this.paymentPlanReinsId = paymentPlanReinsId;
	}

	public BigInteger getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(BigInteger orderMainId) {
		this.orderMainId = orderMainId;
	}

	public BigInteger getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(BigInteger orderCode) {
		this.orderCode = orderCode;
	}

	public java.lang.String getKindCode() {
		return kindCode;
	}

	public void setKindCode(java.lang.String kindCode) {
		this.kindCode = kindCode;
	}

	public java.lang.Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(java.lang.Integer itemNo) {
		this.itemNo = itemNo;
	}

	public java.lang.Integer getPayNo() {
		return payNo;
	}

	public void setPayNo(java.lang.Integer payNo) {
		this.payNo = payNo;
	}

	public java.util.Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(java.util.Date planDate) {
		this.planDate = planDate;
	}

	public java.lang.String getCurrency() {
		return currency;
	}

	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}

	public java.math.BigDecimal getPlanFee() {
		return planFee;
	}

	public void setPlanFee(java.math.BigDecimal planFee) {
		this.planFee = planFee;
	}

	public java.lang.Integer getInvalidFlag() {
		return invalidFlag;
	}

	public void setInvalidFlag(java.lang.Integer invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(java.lang.String createdUser) {
		this.createdUser = createdUser;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.lang.String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(java.lang.String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public java.util.Date getUpdatedDate() {
		return updatedDate;
	}

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
