package com.yaic.app.epolicy.dto.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class EpolicyPaymentRoot {

	/** 支付信息 */
	@XStreamImplicit(itemFieldName="ROWNUM")
	private List<EpolicyPaymentDto> paymentRownum;

	/** 支付信息 */
	public List<EpolicyPaymentDto> getPaymentRownum() {
		return paymentRownum;
	}

	/** 支付信息 */
	public void setPaymentRownum(List<EpolicyPaymentDto> paymentRownum) {
		this.paymentRownum = paymentRownum;
	}
	
}
