package com.yaic.app.pubs.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.order.service.OrderHttpTransService;
import com.yaic.app.provider.StatusCodeProvider;
import com.yaic.app.pubs.dto.msg.MailRequestDto;
import com.yaic.app.pubs.dto.msg.MailResponseDto;
import com.yaic.app.pubs.service.MailService;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Value("${remote.mls.url}")
    private String serUrl;
    private final static String NET_ERROR = "与后台通讯异常";
    private final static String FAIL_CODE = "9999";
    
    @Override
	public MailResponseDto sendEmail(MailRequestDto requestMessage){
		return this.doMlsTrans(requestMessage);
	}
	
    private MailResponseDto doMlsTrans(MailRequestDto requestMessage) {
		MailResponseDto responseMessage = new MailResponseDto();
		HttpResponseWrapper httpResponseWrapper = new OrderHttpTransService().doTran(serUrl, requestMessage);
		if (httpResponseWrapper.getStatus()) {
			responseMessage = JSON.parseObject((String)httpResponseWrapper.getContent(), MailResponseDto.class);
		} else {
			String statusCode = StatusCodeProvider.getCode(httpResponseWrapper, FAIL_CODE);
			responseMessage.setCode(statusCode);
			responseMessage.setMessage(NET_ERROR);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + statusCode);
		}
		return responseMessage;
    }
}
