package com.yaic.app.fin.dto.msg.common;

import java.util.Date;

/**
 * @ClassName: RequestMessage
 * @Description: (接口请求消息)
 */
public class FinRequestMessage {

    /** -----------公共消息头---------- */
    /** 接口标识 */
    private String interfaceCode;
    /** 时间戳 */
    private Date requestTime;
    /** 请求来源 */
    private String requestSource;
    
    /** ------------实体部分---------- */
    private FinReqBodyData data = new FinReqBodyData();

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
  
	public FinReqBodyData getData() {
		return data;
	}

	public void setData(FinReqBodyData data) {
		this.data = data;
	}

	public String getRequestSource() {
		return requestSource;
	}

	public void setRequestSource(String requestSource) {
		this.requestSource = requestSource;
	}
}
