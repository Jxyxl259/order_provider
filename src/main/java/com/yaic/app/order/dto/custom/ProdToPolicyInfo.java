package com.yaic.app.order.dto.custom;

import java.io.Serializable;
import java.util.Date;

public class ProdToPolicyInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 订单编号 **/
	private String orderCode;
	
	/** 关联单号 **/
	private String associatedNo;
	
	/** 保单号  **/
	private String policyNo;
	
	/** 第三方保单号 **/
	private String othPolicyNo;
	
	/** 保险起期 **/
	private Date startDate;
	
	/** 保险止期 **/
	private Date endDate;
	
	/** 销售方案代码  **/
	private String agrtCode;
	
	/** 产品代码  **/
	private String projectCode;
	
	/** 渠道来源  **/
	private String dataSource;
	
	/** 产品名称 **/
	private String productName;
	
	/** 订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，
	 *  4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中*/
	private String status;
	
	
	/** 订单编号 **/
	public String getOrderCode() {
		return orderCode;
	}
	
	/** 订单编号 **/
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	/** 关联单号 **/
	public String getAssociatedNo() {
		return associatedNo;
	}
	
	/** 关联单号 **/
	public void setAssociatedNo(String associatedNo) {
		this.associatedNo = associatedNo;
	}
	
	/** 保单号  **/
	public String getPolicyNo() {
		return policyNo;
	}
	
	/** 保单号  **/
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	/** 第三方保单号 **/
	public String getOthPolicyNo() {
		return othPolicyNo;
	}
	
	/** 第三方保单号 **/
	public void setOthPolicyNo(String othPolicyNo) {
		this.othPolicyNo = othPolicyNo;
	}
	
	/** 保险起期 **/
	public Date getStartDate() {
		return startDate;
	}
	
	/** 保险起期 **/
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/** 保险止期 **/
	public Date getEndDate() {
		return endDate;
	}
	
	/** 保险止期 **/
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/** 销售方案代码  **/
	public String getAgrtCode() {
		return agrtCode;
	}
	
	/** 销售方案代码  **/
	public void setAgrtCode(String agrtCode) {
		this.agrtCode = agrtCode;
	}
	
	/** 产品代码  **/
	public String getProjectCode() {
		return projectCode;
	}
	
	/** 产品代码  **/
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	/** 渠道来源  **/
	public String getDataSource() {
		return dataSource;
	}
	
	/** 渠道来源  **/
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	
	/** 产品名称 **/
	public String getProductName() {
		return productName;
	}
	
	/** 产品名称 **/
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/** 订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，
	 *  4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中*/
	public String getStatus() {
		return status;
	}
	
	/** 订单有效状态：0-初始状态，1-转投保成功，2-转投保失败，3-转保单成功，
	 *  4-转保单失败 ，5-全单批退成功，6-批改成功，7-批改中*/
	public void setStatus(String status) {
		this.status = status;
	}

}