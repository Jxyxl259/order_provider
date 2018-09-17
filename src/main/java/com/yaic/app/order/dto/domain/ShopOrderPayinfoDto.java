/*
 * Created By lujicong (2015-12-21 16:02:20)
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

@Table(name = "t_shop_order_payinfo")
public class ShopOrderPayinfoDto implements Serializable {
    
    private static final long serialVersionUID = ShopOrderPayinfoDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 支付信息id */ 
    @Id
    private java.lang.Integer payinfoId;
    
    /** 电商订单号 */ 
    private java.math.BigInteger orderCode;
    
    /** 交易流水号 */ 
    private java.lang.String payNo;
    
    /** 支付方式 */ 
    private java.lang.String payWay;
    
    /** 支付金额 */ 
    private java.math.BigDecimal payAmount;
    
    /** 支付状态:0-未支付，1-支付成功，2-支付失败 */ 
    private java.lang.String payStatus;
    
    /** 支付时间 */ 
    private java.util.Date payDate;
    
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
    
    /** 支付数据来源 */ 
    private java.lang.String dataSource;
    
    /** 支付人 */ 
    private java.lang.String payeeName;
    
    /** 支付银行 */ 
    private java.lang.String bankName;
    
    /** 支付银行代码 */
    private java.lang.String bankCode;
    
    /** 支付账号 */ 
    private java.lang.String bankAccount;
    
    /** 银行预留手机号 */
    private java.lang.String phoneNo;
    
    /** 支付人证件类型 */
    private java.lang.String docType;
    
    /** 支付人证件 */
    private java.lang.String docNo;
    
    /** 计划缴费截止日期 */ 
    @Transient
    private java.util.Date planDate;
    
    /** 支付平台订单号 */ 
    private java.lang.String payOrderId;
    
    /** 保险公司于支付宝对账用单号 */ 
    private java.lang.String checkPayNo;
    
    /** 激活卡卡号 */ 
    private java.lang.String activationCardNo;
    
    /** 单证类型代码 */ 
    private java.lang.String docVerCode;
    
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
     * 设置属性支付信息id的值
     */ 
    public void setPayinfoId(java.lang.Integer payinfoId) {
        this.payinfoId = payinfoId;
    }
    
    /**
     * 获取属性支付信息id的值
     */ 
    public java.lang.Integer getPayinfoId() {
        return this.payinfoId;
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
     * 设置属性交易流水号的值
     */ 
    public void setPayNo(java.lang.String payNo) {
        this.payNo = payNo;
    }
    
    /**
     * 获取属性交易流水号的值
     */ 
    public java.lang.String getPayNo() {
        return this.payNo;
    }
    
    /**
     * 设置属性支付方式的值
     */ 
    public void setPayWay(java.lang.String payWay) {
        this.payWay = payWay;
    }
    
    /**
     * 获取属性支付方式的值
     */ 
    public java.lang.String getPayWay() {
        return this.payWay;
    }
    
    /**
     * 设置属性支付金额的值
     */ 
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
    
    /**
     * 获取属性支付金额的值
     */ 
    public BigDecimal getPayAmount() {
        return this.payAmount;
    }
    
    /**
     * 设置属性支付状态:0-未支付，1-支付成功，2-支付失败的值
     */ 
    public void setPayStatus(java.lang.String payStatus) {
        this.payStatus = payStatus;
    }
    
    /**
     * 获取属性支付状态:0-未支付，1-支付成功，2-支付失败的值
     */ 
    public java.lang.String getPayStatus() {
        return this.payStatus;
    }
    
    /**
     * 设置属性支付时间的值
     */ 
    public void setPayDate(java.util.Date payDate) {
        this.payDate = payDate;
    }
    
    /**
     * 获取属性支付时间的值
     */ 
    public java.util.Date getPayDate() {
        return this.payDate;
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
    
    /**
     * 设置属性支付数据来源
     */ 
    public java.lang.String getDataSource() {
        return dataSource;
    }

    /**
     * 获取属性支付数据来源
     */ 
    public void setDataSource(java.lang.String dataSource) {
        this.dataSource = dataSource;
    }
    
    /**
     * 设置属性支付人的值
     */ 
    public void setPayeeName(java.lang.String payeeName) {
        this.payeeName = payeeName;
    }
    
    /**
     * 获取属性支付人的值
     */ 
    public java.lang.String getPayeeName() {
        return this.payeeName;
    }
    
    public java.lang.String getBankCode() {
		return bankCode;
	}

	public void setBankCode(java.lang.String bankCode) {
		this.bankCode = bankCode;
	}

	public java.lang.String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public java.lang.String getDocType() {
		return docType;
	}

	public void setDocType(java.lang.String docType) {
		this.docType = docType;
	}

	public java.lang.String getDocNo() {
		return docNo;
	}

	public void setDocNo(java.lang.String docNo) {
		this.docNo = docNo;
	}

	/**
     * 设置属性支付银行的值
     */ 
    public void setBankName(java.lang.String bankName) {
        this.bankName = bankName;
    }
    
    /**
     * 获取属性支付银行的值
     */ 
    public java.lang.String getBankName() {
        return this.bankName;
    }
    
    /**
     * 设置属性支付账号的值
     */ 
    public void setBankAccount(java.lang.String bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    /**
     * 获取属性支付账号的值
     */ 
    public java.lang.String getBankAccount() {
        return this.bankAccount;
    }
    
    /**
     * 设置属性计划缴费截止日期的值
     */ 
    public void setPlanDate(java.util.Date planDate) {
        this.planDate = planDate;
    }
    
    /**
     * 获取属性计划缴费截止日期的值
     */ 
    public java.util.Date getPlanDate() {
        return this.planDate;
    }
    
    /**
     * 设置属性支付平台订单号的值
     */ 
    public void setPayOrderId(java.lang.String payOrderId) {
        this.payOrderId = payOrderId;
    }
    
    /**
     * 获取属性支付平台订单号的值
     */ 
    public java.lang.String getPayOrderId() {
        return this.payOrderId;
    }
    
    /**
     * 设置属性保险公司于支付宝对账用单号的值
     */ 
    public void setCheckPayNo(java.lang.String checkPayNo) {
        this.checkPayNo = checkPayNo;
    }
    
    /**
     * 获取属性保险公司于支付宝对账用单号的值
     */ 
    public java.lang.String getCheckPayNo() {
        return this.checkPayNo;
    }
    
    /**
     * 获取属性激活卡卡号的值
     */ 
    public java.lang.String getActivationCardNo() {
        return activationCardNo;
    }

    /**
     * 设置属性激活卡卡号的值
     */ 
    public void setActivationCardNo(java.lang.String activationCardNo) {
        this.activationCardNo = activationCardNo;
    }

    /**
     * 获取属性单证类型代码的值
     */ 
    public java.lang.String getDocVerCode() {
        return docVerCode;
    }

    /**
     * 设置属性单证类型代码的值
     */
    public void setDocVerCode(java.lang.String docVerCode) {
        this.docVerCode = docVerCode;
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