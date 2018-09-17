package com.yaic.app.order.dto.msg;

public class UnderwriterCallBackReq {
	
	/*订单主表Id*/
	private String orderMainId;
	
	/*订单号*/
	private String orderCode;
	
	/*投保单号*/
	private String proposalNo;
	
	/*保单号*/
	private String policyNo;
	
	/*见费标识 Y-见费，N-非见费*/
	private String codInd;	
	
	/* 暂收款号 */ 
	private String poaSerialNo;
	
	/*审核状态 0-审核通过,1-审核未通过*/
	private String auditingStatus;
	
	/*审核原因*/
	private String auditingMsg;
	
	public String getOrderMainId() {
		return orderMainId;
	}

	public void setOrderMainId(String orderMainId) {
		this.orderMainId = orderMainId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getCodInd() {
		return codInd;
	}

	public void setCodInd(String codInd) {
		this.codInd = codInd;
	}

	public String getPoaSerialNo() {
		return poaSerialNo;
	}

	public void setPoaSerialNo(String poaSerialNo) {
		this.poaSerialNo = poaSerialNo;
	}

	public String getAuditingStatus() {
		return auditingStatus;
	}

	public void setAuditingStatus(String auditingStatus) {
		this.auditingStatus = auditingStatus;
	}

	public String getAuditingMsg() {
		return auditingMsg;
	}

	public void setAuditingMsg(String auditingMsg) {
		this.auditingMsg = auditingMsg;
	}
	
}
