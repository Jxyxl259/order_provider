package com.yaic.app.order.dto.msg;

public class QueryOrderPayInfoResp {
	/** 保单号 */
	private java.lang.String policyNo;
	
    /** 电商订单号 */ 
    private java.math.BigInteger orderCode;
    
    /** 交易流水号 */ 
    private java.lang.String payNo;
    
    /** 支付方式 */ 
    private java.lang.String payWay;
    
    /** 支付金额 */ 
    private java.math.BigDecimal payAmount;
    
    /** 支付状态:0-未支付，1-支付成功，2-支付失败 */ 
    private java.lang.String payStatus;
    
    /** 是否有效:0正常,1作废值 */ 
    private java.lang.Integer invalidFlag;
    
    /** 支付数据来源 */ 
    private java.lang.String dataSource;
    
    /** 支付人 */ 
    private java.lang.String payeeName;
    
    /** 支付银行 */ 
    private java.lang.String bankName;
    
    /** 支付银行代码 */
    private java.lang.String bankCode;
    
    /** 支付账号 */ 
    private java.lang.String bankAccount;
    
    /** 银行预留手机号 */
    private java.lang.String phoneNo;
    
    /** 支付人证件类型 */
    private java.lang.String docType;
    
    /** 支付人证件 */
    private java.lang.String docNo;
    
    /** 支付平台订单号 */ 
    private java.lang.String payOrderId;
    
    /** 保险公司于支付宝对账用单号 */ 
    private java.lang.String checkPayNo;

	public java.lang.String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(java.lang.String policyNo) {
		this.policyNo = policyNo;
	}

	public java.math.BigInteger getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(java.math.BigInteger orderCode) {
		this.orderCode = orderCode;
	}

	public java.lang.String getPayNo() {
		return payNo;
	}

	public void setPayNo(java.lang.String payNo) {
		this.payNo = payNo;
	}

	public java.lang.String getPayWay() {
		return payWay;
	}

	public void setPayWay(java.lang.String payWay) {
		this.payWay = payWay;
	}

	public java.math.BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(java.math.BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public java.lang.String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(java.lang.String payStatus) {
		this.payStatus = payStatus;
	}

	public java.lang.Integer getInvalidFlag() {
		return invalidFlag;
	}

	public void setInvalidFlag(java.lang.Integer invalidFlag) {
		this.invalidFlag = invalidFlag;
	}

	public java.lang.String getDataSource() {
		return dataSource;
	}

	public void setDataSource(java.lang.String dataSource) {
		this.dataSource = dataSource;
	}

	public java.lang.String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(java.lang.String payeeName) {
		this.payeeName = payeeName;
	}

	public java.lang.String getBankName() {
		return bankName;
	}

	public void setBankName(java.lang.String bankName) {
		this.bankName = bankName;
	}

	public java.lang.String getBankCode() {
		return bankCode;
	}

	public void setBankCode(java.lang.String bankCode) {
		this.bankCode = bankCode;
	}

	public java.lang.String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(java.lang.String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public java.lang.String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public java.lang.String getDocType() {
		return docType;
	}

	public void setDocType(java.lang.String docType) {
		this.docType = docType;
	}

	public java.lang.String getDocNo() {
		return docNo;
	}

	public void setDocNo(java.lang.String docNo) {
		this.docNo = docNo;
	}

	public java.lang.String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(java.lang.String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public java.lang.String getCheckPayNo() {
		return checkPayNo;
	}

	public void setCheckPayNo(java.lang.String checkPayNo) {
		this.checkPayNo = checkPayNo;
	}
    
}
