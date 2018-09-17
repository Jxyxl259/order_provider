package com.yaic.app.order.dto.msg;

public class QueryPolicyListReq {
    /** 开始位置 **/
    private Integer startIndex;
    /** 每页数量 **/
    private Integer pageSize;
    /** 有效标志 **/
    private String invalidFlag;
    /** 保单号 */
    private String policyNo;
    /** 证件类型 */
    private String docType;
    /** 证件号码 */
    private String docNo;
    /** 姓名 */
    private String docName;
    /** 查询方式标志 不传或1-常规查询 2-客制化查询 */
    private String queryFlag;

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getInvalidFlag() {
        return invalidFlag;
    }

    public void setInvalidFlag(String invalidFlag) {
        this.invalidFlag = invalidFlag;
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

	public String getQueryFlag() {
		return queryFlag;
	}

	public void setQueryFlag(String queryFlag) {
		this.queryFlag = queryFlag;
	}

}
