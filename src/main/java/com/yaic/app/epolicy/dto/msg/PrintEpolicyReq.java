package com.yaic.app.epolicy.dto.msg;

public class PrintEpolicyReq {
	
	/** 保单号 */
	private String policyNo;
	
	/** 批改序列号 */
	private String endorSeqno;
	
	/** 险种代码 */
	private String riskCode;
	
	/** 单证类型(AE:保单,DC:批单,VC:凭证)*/
	private String doctypeCode;
	
	/** 业务数据(xml格式)*/
	private String businessData;

	/** 保单号 */
	public String getPolicyNo() {
		return policyNo;
	}

	/** 保单号 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/** 批改序列号 */
	public String getEndorSeqno() {
		return endorSeqno;
	}

	/** 批改序列号 */
	public void setEndorSeqno(String endorSeqno) {
		this.endorSeqno = endorSeqno;
	}

	/** 险种代码 */
	public String getRiskCode() {
		return riskCode;
	}

	/** 险种代码 */
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	/** 单证类型(AE:保单,DC:批单,VC:凭证)*/
	public String getDoctypeCode() {
		return doctypeCode;
	}

	/** 单证类型(AE:保单,DC:批单,VC:凭证)*/
	public void setDoctypeCode(String doctypeCode) {
		this.doctypeCode = doctypeCode;
	}

	/** 业务数据(xml格式)*/
	public String getBusinessData() {
		return businessData;
	}

	/** 业务数据(xml格式)*/
	public void setBusinessData(String businessData) {
		this.businessData = businessData;
	}
	
}
