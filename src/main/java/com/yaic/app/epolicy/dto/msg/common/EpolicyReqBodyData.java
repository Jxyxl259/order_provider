package com.yaic.app.epolicy.dto.msg.common;

import com.yaic.app.epolicy.dto.msg.PrintEpolicyReq;

public class EpolicyReqBodyData {
	
	/** 打印电子保单 */
	private PrintEpolicyReq reqBizData;

	public PrintEpolicyReq getReqBizData() {
		return reqBizData;
	}

	public void setReqBizData(PrintEpolicyReq reqBizData) {
		this.reqBizData = reqBizData;
	}
	
}
