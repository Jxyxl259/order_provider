package com.yaic.app.fin.dto.msg;

import java.math.BigDecimal;

public class FinRespBizData {
	/**暂收款编号*/
	private String poaSerialNo;
	
	/**暂收款可用余额*/
	private BigDecimal enabledAmount;
	
	public String getPoaSerialNo() {
		return poaSerialNo;
	}
	public void setPoaSerialNo(String poaSerialNo) {
		this.poaSerialNo = poaSerialNo;
	}
	public BigDecimal getEnabledAmount() {
		return enabledAmount;
	}
	public void setEnabledAmount(BigDecimal enabledAmount) {
		this.enabledAmount = enabledAmount;
	}

}
