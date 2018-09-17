package com.yaic.app.epolicy.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.epolicy.dto.msg.common.EpolicyRequestMessage;
import com.yaic.app.epolicy.dto.msg.common.EpolicyResponseMessage;
import com.yaic.app.epolicy.service.IEpolicyService;
import com.yaic.app.order.service.OrderHttpTransService;
import com.yaic.app.provider.StatusCodeProvider;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;

@Service("epolicyService")
public class EpolicyServiceImpl implements IEpolicyService {

    @Value("${remote.epolicy.url}")
    private String serUrl;
    private final static String NET_ERROR = "与后台通讯异常";
    private final static String FAIL_CODE = "9999";
    
    private EpolicyResponseMessage doEpolicyCenterTrans(EpolicyRequestMessage requestMessage) {
    	EpolicyResponseMessage responseMessage = new EpolicyResponseMessage();
		HttpResponseWrapper httpResponseWrapper = new OrderHttpTransService().doTran(serUrl, requestMessage);
		if (httpResponseWrapper.getStatus()) {
			responseMessage = JSON.parseObject((String)httpResponseWrapper.getContent(), EpolicyResponseMessage.class);
		} else {
			String statusCode = StatusCodeProvider.getCode(httpResponseWrapper, FAIL_CODE);
			responseMessage.setCode(statusCode);
			responseMessage.setMessage(NET_ERROR);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + statusCode);
		}
		return responseMessage;
    }

	@Override
	public EpolicyResponseMessage printEpolicy(EpolicyRequestMessage requestMessage) {
		requestMessage.setInterfaceCode("printEpolicyByOuterMsg");
		requestMessage.setRequestTime(new Date());
		return doEpolicyCenterTrans(requestMessage);
	}
    
}
