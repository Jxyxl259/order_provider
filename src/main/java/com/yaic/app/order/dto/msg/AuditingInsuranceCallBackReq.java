package com.yaic.app.order.dto.msg;

public class AuditingInsuranceCallBackReq {
	/*订单号*/
	private String orderCode;
	
	/*投保单号*/
	private String proposalNo;
	
	/*审核状态 0-审核通过,1-审核未通过*/
	private String auditingStatus;
	
	/*审核原因*/
	private String auditingMsg;

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
