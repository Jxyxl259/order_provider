package com.yaic.app.order.dto.msg.common;

import java.util.List;

public class CallBackOrderInfoDto {
    /** 子订单号 **/
    private String orderId;
    /** 子订单号是否转投保成功标志 0:成功,1:失败**/
    private String proposalPassFlag;
    /** 子订单号是否转保单成功标志 0:成功,1:失败 **/
    private String policyPassFlag;
    /** 返回信息 **/
    private String message;
    /** 交易流水号 **/
    private String trandNo;
    /** 投保单号 **/
    private String proposalNo;
    /** 订单号 **/
    private String orderCode;
    /** 子投保单号列表 **/
    private List<String> subProposalNoList;
    /** 保单号 **/
    private String policyNo;
    /** 子保单号列表 **/
    private List<String> subPolicyNoList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProposalPassFlag() {
        return proposalPassFlag;
    }

    public void setProposalPassFlag(String proposalPassFlag) {
        this.proposalPassFlag = proposalPassFlag;
    }

    public String getPolicyPassFlag() {
        return policyPassFlag;
    }

    public void setPolicyPassFlag(String policyPassFlag) {
        this.policyPassFlag = policyPassFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrandNo() {
        return trandNo;
    }

    public void setTrandNo(String trandNo) {
        this.trandNo = trandNo;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
    public List<String> getSubProposalNoList() {
        return subProposalNoList;
    }

    public void setSubProposalNoList(List<String> subProposalNoList) {
        this.subProposalNoList = subProposalNoList;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public List<String> getSubPolicyNoList() {
        return subPolicyNoList;
    }

    public void setSubPolicyNoList(List<String> subPolicyNoList) {
        this.subPolicyNoList = subPolicyNoList;
    }

}
