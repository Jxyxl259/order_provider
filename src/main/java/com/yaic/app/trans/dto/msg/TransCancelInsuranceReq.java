package com.yaic.app.trans.dto.msg;

import java.util.Date;
import java.util.List;

import com.yaic.app.order.dto.domain.OrderItemkindDto;

public class TransCancelInsuranceReq {
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

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getEndorDate() {
		return endorDate;
	}

	public void setEndorDate(Date endorDate) {
		this.endorDate = endorDate;
	}

	public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
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

}
