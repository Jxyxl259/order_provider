package com.yaic.app.order.dto.msg;

import java.math.BigDecimal;
import java.util.Date;

public class QueryActivationCardInfoResp {
    
    /** 单证类型代码 激活/核销时使用参数之一 */
    private String docVerCode;
    
    /** 单证类型名称 */
    private String docVerName;
    
    /** 印刷流水号 */
    private String businessNo;
    
    /** 激活卡面值 */
    private BigDecimal premium;
    
    /** 卡状态 -1无效数据；0库存流转中；1已付费待激活；9激活卡已激活；当卡状态为1时显示销售信息明细*/
    private String cardStatus;
    
    /** 卡状态描述 */
    private String cardMessage;
    
    /** 激活卡卡号 */
    private String activationCardNo;
    
    /** 激活卡账号 */
    private String activationAccount;
    
    /** 激活卡有效起期 */
    private Date validStartDate;
    
    /** 激活卡有效止期 */
    private Date validEndDate;
    
    /** 激活卡承保方案代码 */
    private String projectCode;
    
    /** 激活卡激活时间 */
    private Date activeTime;
    
    /** 激活卡保单号 */
    private String policyNo;
    
    /** 销售信息 */
    private OrderSalesInfoDto salesInfoDto;

	/** 单证类型代码 */
	public String getDocVerCode() {
		return docVerCode;
	}

	/** 单证类型代码 */
	public void setDocVerCode(String docVerCode) {
		this.docVerCode = docVerCode;
	}

	/** 单证类型名称 */
	public String getDocVerName() {
		return docVerName;
	}

	/** 单证类型名称 */
	public void setDocVerName(String docVerName) {
		this.docVerName = docVerName;
	}

	/** 印刷流水号 */
	public String getBusinessNo() {
		return businessNo;
	}

	/** 印刷流水号 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	/** 激活卡面值 */
	public BigDecimal getPremium() {
		return premium;
	}

	/** 激活卡面值 */
	public void setPremium(BigDecimal premium) {
		this.premium = premium;
	}

	/** 卡状态 -1无效数据；0库存流转中；1已付费待激活；9激活卡已激活；当卡状态为1时显示销售信息明细*/
	public String getCardStatus() {
		return cardStatus;
	}

	/** 卡状态 -1无效数据；0库存流转中；1已付费待激活；9激活卡已激活；当卡状态为1时显示销售信息明细*/
	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	/** 卡状态描述 */
	public String getCardMessage() {
		return cardMessage;
	}

	/** 卡状态描述 */
	public void setCardMessage(String cardMessage) {
		this.cardMessage = cardMessage;
	}
	
	/** 激活卡卡号 */
	public String getActivationCardNo() {
		return activationCardNo;
	}

	/** 激活卡卡号 */
	public void setActivationCardNo(String activationCardNo) {
		this.activationCardNo = activationCardNo;
	}

	/** 激活卡账号 */
	public String getActivationAccount() {
		return activationAccount;
	}

	/** 激活卡账号 */
	public void setActivationAccount(String activationAccount) {
		this.activationAccount = activationAccount;
	}

	/** 激活卡有效起期 */
	public Date getValidStartDate() {
		return validStartDate;
	}

	/** 激活卡有效起期 */
	public void setValidStartDate(Date validStartDate) {
		this.validStartDate = validStartDate;
	}

	/** 激活卡有效止期 */
	public Date getValidEndDate() {
		return validEndDate;
	}

	/** 激活卡有效止期 */
	public void setValidEndDate(Date validEndDate) {
		this.validEndDate = validEndDate;
	}

	/** 激活卡承保方案代码 */
	public String getProjectCode() {
		return projectCode;
	}

	/** 激活卡承保方案代码 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/** 激活卡激活时间 */
	public Date getActiveTime() {
		return activeTime;
	}

	/** 激活卡激活时间 */
	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	/** 激活卡保单号 */
	public String getPolicyNo() {
		return policyNo;
	}

	/** 激活卡保单号 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	/** 销售信息 */
	public OrderSalesInfoDto getSalesInfoDto() {
		return salesInfoDto;
	}

	/** 销售信息 */
	public void setSalesInfoDto(OrderSalesInfoDto salesInfoDto) {
		this.salesInfoDto = salesInfoDto;
	}
    
}