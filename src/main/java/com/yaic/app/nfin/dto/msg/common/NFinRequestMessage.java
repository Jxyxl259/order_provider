package com.yaic.app.nfin.dto.msg.common;

import java.util.Date;

/**
 * @ClassName: RequestMessage
 * @Description: (接口请求消息)
 */
public class NFinRequestMessage {

	/** 请求来源 */
    private String requestSource;
    
    /** 时间戳 */
    private Date requestTime;
    
    /**暂收款编号*/
	private String poaSerialNo;

	/** 请求来源 */
	public String getRequestSource() {
		return requestSource;
	}

	/** 请求来源 */
	public void setRequestSource(String requestSource) {
		this.requestSource = requestSource;
	}

	/** 时间戳 */
	public Date getRequestTime() {
		return requestTime;
	}

	/** 时间戳 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	/**暂收款编号*/
	public String getPoaSerialNo() {
		return poaSerialNo;
	}

	/**暂收款编号*/
	public void setPoaSerialNo(String poaSerialNo) {
		this.poaSerialNo = poaSerialNo;
	}
}
