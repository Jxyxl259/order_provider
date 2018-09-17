package com.yaic.app.order.dto.custom;

import java.math.BigDecimal;
import java.util.Date;

public class PolicyInfo implements java.io.Serializable,Comparable<PolicyInfo> {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String orderCode;
    private String orderMainId;
    private String agrtCode;
    private String policyNo;
    private String riskCode;
    private String riskName;
    private Date startDate;
    private Date endDate;
    private String invalidFlag;
    private Date addTime;
    private BigDecimal goodsAmount;
    private String referer;
    /** 订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，
     *  4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中*/
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderMainId() {
        return orderMainId;
    }

    public void setOrderMainId(String orderMainId) {
        this.orderMainId = orderMainId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getInvalidFlag() {
        return invalidFlag;
    }

    public void setInvalidFlag(String invalidFlag) {
        this.invalidFlag = invalidFlag;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public int compareTo(PolicyInfo info) {
		return -this.addTime.compareTo(info.getAddTime());
	}

	public String getAgrtCode() {
		return agrtCode;
	}

	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}
	
}