package com.yaic.app.epolicy.service;

import com.yaic.app.epolicy.dto.msg.common.EpolicyRequestMessage;
import com.yaic.app.epolicy.dto.msg.common.EpolicyResponseMessage;


public interface IEpolicyService {

	/**
	 * 打印电子保单接口
	 * <p>User: glizhen
	 * <p>Date: 2018-6-27
	 * <p>Version: 1.0
	 * @param printEpolicyReq
	 * @return
	 */
	public EpolicyResponseMessage printEpolicy(EpolicyRequestMessage requestMessage);
	
}
