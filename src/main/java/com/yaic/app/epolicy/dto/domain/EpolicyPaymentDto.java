package com.yaic.app.epolicy.dto.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyPaymentDto {

	/** 交易流水号 */
	@XStreamAlias("PAYNO")
	private String payNo;
	
	/** 支付日期 */
	@XStreamAlias("PAYDATE")
	private String payDate;
	
	/** 支付金额 */
	@XStreamAlias("PAYFEE")
	private String payFee;

	/** 交易流水号 */
	public String getPayNo() {
		return payNo;
	}

	/** 交易流水号 */
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	/** 支付日期 */
	public String getPayDate() {
		return payDate;
	}

	/** 支付日期 */
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	/** 支付金额 */
	public String getPayFee() {
		return payFee;
	}

	/** 支付金额 */
	public void setPayFee(String payFee) {
		this.payFee = payFee;
	}

}
