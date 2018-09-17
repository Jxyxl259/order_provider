package com.yaic.app.fin.dto.msg.common;

import java.util.List;

import com.yaic.app.fin.dto.msg.FinReqBizData;


/**
 * Body请求部分
 * <p>User: wangwf
 * <p>Date: 2017-7-12
 * <p>Version: 1.0
 */
public class FinReqBodyData {
	
	private List<FinReqBizData> reqBizData;

	public List<FinReqBizData> getReqBizData() {
		return reqBizData;
	}

	public void setReqBizData(List<FinReqBizData> reqBizData) {
		this.reqBizData = reqBizData;
	}

	
	
}
