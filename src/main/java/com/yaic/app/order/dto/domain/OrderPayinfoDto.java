/*
 * Created By lujicong (2015-12-21 16:02:17)
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

@Table(name = "t_order_payinfo")
public class OrderPayinfoDto implements Serializable {
    
    private static final long serialVersionUID = OrderPayinfoDto.class.getName().hashCode();
    
    /** 用户id */ 
    @Transient
    private BigInteger userId;
    
    /** 支付信息表id */ 
    @Id
    private java.lang.Integer payId;
    
    /** 订单主表id */ 
    private BigInteger orderMainId;
    
    /** 订单编号 */ 
    private BigInteger orderCode;
    
    /** 交易流水号 */ 
    private java.lang.String payNo;
    
    /** 支付方式 */ 
    private java.lang.String payWay;
    
    /** 支付金额 */ 
    private BigDecimal payAmount;
    
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
    private Integer invalidFlag;
    
    /** 开户人 */
    private java.lang.String accountHolder;
    
    /** 开户银行 */
    private java.lang.String bankDeposit;
    
    /** 银行账号 */ 
    private java.lang.String bankAccount;
    
    /** 退保账户银行 */ 
    private String surrenderAccountBank;
    
    /** 退保账户名称 */ 
    private String surrenderAccountName;
    
    /** 退保账户号码 */ 
    private String surrenderAccountNo;
    
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
     * 设置属性支付信息表id的值
     */ 
    public void setPayId(java.lang.Integer payId) {
        this.payId = payId;
    }
    
    /**
     * 获取属性支付信息表id的值
     */ 
    public java.lang.Integer getPayId() {
        return this.payId;
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
     * 设置属性支付状态：0-未支付，1-支付成功，2-支付失败的值
     */ 
    public void setPayStatus(java.lang.String payStatus) {
        this.payStatus = payStatus;
    }
    
    /**
     * 获取属性支付状态：0-未支付，1-支付成功，2-支付失败的值
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
     * 获取属性开户人的值
     */ 
    public java.lang.String getAccountHolder() {
		return accountHolder;
	}

    /**
     * 设置属性开户人的值
     */ 
	public void setAccountHolder(java.lang.String accountHolder) {
		this.accountHolder = accountHolder;
	}

	/**
     * 获取属性开户银行的值
     */ 
	public java.lang.String getBankDeposit() {
		return bankDeposit;
	}

	/**
     * 设置属性开户银行的值
     */ 
	public void setBankDeposit(java.lang.String bankDeposit) {
		this.bankDeposit = bankDeposit;
	}

	/**
     * 获取属性银行账号的值
     */ 
	public java.lang.String getBankAccount() {
		return bankAccount;
	}

	/**
     * 设置属性银行账号的值
     */ 
	public void setBankAccount(java.lang.String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	/**
     * 获取属性退保账户银行的值
     */ 
	public String getSurrenderAccountBank() {
        return surrenderAccountBank;
    }

	/**
     * 设置属性退保账户银行的值
     */ 
    public void setSurrenderAccountBank(String surrenderAccountBank) {
        this.surrenderAccountBank = surrenderAccountBank;
    }

    /**
     * 获取属性退保账户名称的值
     */ 
    public String getSurrenderAccountName() {
        return surrenderAccountName;
    }

    /**
     * 设置属性退保账户名称的值
     */ 
    public void setSurrenderAccountName(String surrenderAccountName) {
        this.surrenderAccountName = surrenderAccountName;
    }

    /**
     * 获取属性退保账户号码的值
     */ 
    public String getSurrenderAccountNo() {
        return surrenderAccountNo;
    }

    /**
     * 设置属性退保账户号码的值
     */ 
    public void setSurrenderAccountNo(String surrenderAccountNo) {
        this.surrenderAccountNo = surrenderAccountNo;
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