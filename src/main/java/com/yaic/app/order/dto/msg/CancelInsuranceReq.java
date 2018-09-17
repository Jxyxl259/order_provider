package com.yaic.app.order.dto.msg;

import java.util.Date;

public class CancelInsuranceReq {
    /** 订单号 **/
    private String orderCode;
    /** 子订单ID**/
    private String orderId;
    /** 生效日期 **/
    private Date validDate;
    /** 批改日期 **/
    private Date endorDate;
    /** 保单号 **/
    private String policyNo;
    /** 账户银行 **/
    private String accountBank;
    /** 账户名 **/
    private String accountName;
    /** 账户卡号 **/
    private String accountNumber;
    /** 异步化标识：Y-是,N-否 **/
    private String asynFlag;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getValidDate() {
        return validDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Date getEndorDate() {
		return endorDate;
	}

	public void setEndorDate(Date endorDate) {
		this.endorDate = endorDate;
	}

	public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /** 异步化标识：Y-是,N-否 **/
	public String getAsynFlag() {
		return asynFlag;
	}

	/** 异步化标识：Y-是,N-否 **/
	public void setAsynFlag(String asynFlag) {
		this.asynFlag = asynFlag;
	}
}
