package com.yaic.app.nfin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.nfin.dto.msg.common.NFinRequestMessage;
import com.yaic.app.nfin.dto.msg.common.NFinResponseMessage;
import com.yaic.app.nfin.service.NFinService;
import com.yaic.app.order.service.OrderHttpTransService;
import com.yaic.app.provider.StatusCodeProvider;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.StringUtil;


@Service("nfinService")
public class NFinServiceImpl implements NFinService {

    @Value("${remote.nfin.url}")
    private String serUrl;
    private final static String NET_ERROR = "与后台通讯异常";    
    private final static String FAIL_CODE = "9999";
    private final static String SUCCESS_CODE = "0000";
    
	@Override
	public NFinResponseMessage checkPoa(NFinRequestMessage requestMessage)
			throws Exception {
		requestMessage.setRequestTime(new Date());
		requestMessage.setRequestSource("order");
		return this.doFinTrans(requestMessage);
	}
	
    private NFinResponseMessage doFinTrans(NFinRequestMessage requestMessage) {
		NFinResponseMessage responseMessage = new NFinResponseMessage();
		HttpResponseWrapper httpResponseWrapper = new OrderHttpTransService().doTran(serUrl, requestMessage);
		if (httpResponseWrapper.getStatus()) {
			responseMessage = JSON.parseObject((String)httpResponseWrapper.getContent(), NFinResponseMessage.class);
			if(StringUtil.isEmpty(responseMessage.getReturnCode())){
				if(SUCCESS_CODE.equals(responseMessage.getReturnCode())) {
					return responseMessage;
				}
				responseMessage.setReturnMsg(StatusCodeProvider.SYSTEMNO_INTERFACE_FIN + responseMessage.getReturnCode());
			}
		} else {
			String statusCode = StatusCodeProvider.getCode(httpResponseWrapper, FAIL_CODE);
			responseMessage.setReturnCode(statusCode);
			responseMessage.setReturnMsg(NET_ERROR);
		}
		return responseMessage;
    }
}
