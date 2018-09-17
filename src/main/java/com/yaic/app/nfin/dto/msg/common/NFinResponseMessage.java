package com.yaic.app.nfin.dto.msg.common;

import java.math.BigDecimal;

/**
 * @ClassName: ResponseMessage
 * @Description: (接口响应消息)
 */
public class NFinResponseMessage {
    
	/**暂收款编号*/
	private String poaSerialNo;
	
	/**暂收款可用余额*/
	private BigDecimal enabledAmount;
	
	/**最低余额标准*/
	private BigDecimal miniBalance;
	
	/**核算单位*/
	private String centerCode;
	
	/**有效标识 0-无效，1-有效*/
	private String validInd;
	
	/**返回代码*/
	private String returnCode;
	
	/**返回信息*/
	private String returnMsg;
	
	/**持有人名称*/
	private String ownerName;
	
	/**持有人代码*/
	private String ownerCode;

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

	public BigDecimal getMiniBalance() {
		return miniBalance;
	}

	public void setMiniBalance(BigDecimal miniBalance) {
		this.miniBalance = miniBalance;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getValidInd() {
		return validInd;
	}

	public void setValidInd(String validInd) {
		this.validInd = validInd;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
}
