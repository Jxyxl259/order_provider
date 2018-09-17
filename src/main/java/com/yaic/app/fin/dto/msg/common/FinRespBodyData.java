package com.yaic.app.fin.dto.msg.common;

import java.util.List;

import com.yaic.app.fin.dto.msg.FinRespBizData;

/**
 * Body响应部分
 * <p>User: wangwf
 * <p>Date: 2017-7-12
 * <p>Version: 1.0
 */
public class FinRespBodyData {
	
	private List<FinRespBizData> resBizData;

	public List<FinRespBizData> getResBizData() {
		return resBizData;
	}

	public void setResBizData(List<FinRespBizData> resBizData) {
		this.resBizData = resBizData;
	}
	
}
