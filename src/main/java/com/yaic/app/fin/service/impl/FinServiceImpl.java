package com.yaic.app.fin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.fin.dto.msg.common.FinRequestMessage;
import com.yaic.app.fin.dto.msg.common.FinResponseMessage;
import com.yaic.app.fin.service.FinService;
import com.yaic.app.order.service.OrderHttpTransService;
import com.yaic.app.provider.StatusCodeProvider;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.StringUtil;


@Service("finService")
public class FinServiceImpl implements FinService {

    @Value("${remote.fin.url}")
    private String serUrl;
    private final static String NET_ERROR = "与后台通讯异常";    
    private final static String FAIL_CODE = "9999";
    private final static String SUCCESS_CODE = "0000";
    
	@Override
	public FinResponseMessage checkPoa(FinRequestMessage requestMessage)
			throws Exception {
		requestMessage.setInterfaceCode("findPOA");
		requestMessage.setRequestTime(new Date());
		requestMessage.setRequestSource("order");
		return this.doFinTrans(requestMessage);
	}
	
    private FinResponseMessage doFinTrans(FinRequestMessage requestMessage) {
		FinResponseMessage responseMessage = new FinResponseMessage();
		HttpResponseWrapper httpResponseWrapper = new OrderHttpTransService().doTran(serUrl, requestMessage);
		if (httpResponseWrapper.getStatus()) {
			responseMessage = JSON.parseObject((String)httpResponseWrapper.getContent(), FinResponseMessage.class);
			if(StringUtil.isEmpty(responseMessage.getStatusCode())){
				if(SUCCESS_CODE.equals(responseMessage.getCode())) {
					responseMessage.setStatusCode(responseMessage.getCode());
					return responseMessage;
				}
				responseMessage.setStatusCode(StatusCodeProvider.SYSTEMNO_INTERFACE_FIN + responseMessage.getCode());
			}
		} else {
			String statusCode = StatusCodeProvider.getCode(httpResponseWrapper, FAIL_CODE);
			responseMessage.setCode(statusCode);
			responseMessage.setMessage(NET_ERROR);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + statusCode);
		}
		return responseMessage;
    }
}
