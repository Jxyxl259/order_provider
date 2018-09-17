package com.yaic.app.order.dto.custom;

import java.util.Date;

public class endorNoInfoDto {
	
    /** 批单序号 **/
    private String endorSeqNo;
    
    /** 批改类型 */
    private String endorType;
    
    /** 批改时间 **/
    private Date validDate;
    
    
    /** 批单序号 **/
	public String getEndorSeqNo() {
		return endorSeqNo;
	}
	
	/** 批单序号 **/
	public void setEndorSeqNo(String endorSeqNo) {
		this.endorSeqNo = endorSeqNo;
	}
	
	/** 批改类型 */
	public String getEndorType() {
		return endorType;
	}
	
	/** 批改类型 */
	public void setEndorType(String endorType) {
		this.endorType = endorType;
	}
	
	/** 批改时间 **/
	public Date getValidDate() {
		return validDate;
	}
	
	/** 批改时间 **/
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
    
}
