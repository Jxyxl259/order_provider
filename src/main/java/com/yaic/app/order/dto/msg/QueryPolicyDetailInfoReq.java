package com.yaic.app.order.dto.msg;

public class QueryPolicyDetailInfoReq {
    /** 订单ID **/
    private String orderId;
    /** 保单号 **/
    private String policyNo;
    /** 证件类型 */
    private String docType;
    /** 证件号码 */
    private String docNo;
    /** 姓名*/
    private String docName;
    
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getPolicyNo() {
        return policyNo;
    }
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
    public String getDocType() {
        return docType;
    }
    public void setDocType(String docType) {
        this.docType = docType;
    }
    public String getDocNo() {
        return docNo;
    }
    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
    
}
