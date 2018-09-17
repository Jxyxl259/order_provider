package com.yaic.app.order.dto.msg;

import java.math.BigInteger;

import com.alibaba.fastjson.JSONObject;

public class SurrenderCallBackReq {
	/**保单号**/
	private String policyNo;
    /**appId **/
    private String appId;
    /**业务单号 **/
    private BigInteger businessNo;
    /**处理类型：11 退保 ,21 人工核保回调**/
    private String dealType;
    /**回调内容 **/
    private JSONObject content;
    /**投保单号**/
    private String proposalNo;
    
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public BigInteger getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(BigInteger businessNo) {
		this.businessNo = businessNo;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public JSONObject getContent() {
		return content;
	}
	public void setContent(JSONObject content) {
		this.content = content;
	}
	public String getProposalNo() {
		return proposalNo;
	}
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
    
}
