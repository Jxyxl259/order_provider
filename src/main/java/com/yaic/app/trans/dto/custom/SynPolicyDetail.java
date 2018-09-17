package com.yaic.app.trans.dto.custom;

import java.math.BigInteger;

public class SynPolicyDetail {
    /** 子订单号 **/
    private BigInteger orderMainId;
    /** 同步保单处理状态  0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，4-转保单失败 */
    private String synDealStatus;
    /** 返回信息 **/
    private String message;
    /** 交易流水号 **/
    private String trandNo;
    /** 投保单号 **/
    private String proposalNo;
    /** 投保单号 **/
    private String policyNo;
    
    public BigInteger getOrderMainId() {
        return orderMainId;
    }
    public void setOrderMainId(BigInteger orderMainId) {
        this.orderMainId = orderMainId;
    }
    public String getSynDealStatus() {
        return synDealStatus;
    }
    public void setSynDealStatus(String synDealStatus) {
        this.synDealStatus = synDealStatus;
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
    public String getPolicyNo() {
        return policyNo;
    }
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}
