/*
 * Created By lujicong (2015-12-21 16:02:13)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.app.Constants;
import com.yaic.app.order.service.OrderHttpTransService;
import com.yaic.app.order.service.OrderSolutionProdService;
import com.yaic.app.pdms.dto.msg.common.PdmsRequestMessage;
import com.yaic.app.pdms.dto.msg.common.PdmsResponseMessage;
import com.yaic.app.provider.StatusCodeProvider;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.StringUtil;

@Service("orderSolutionProdService")
public class OrderSolutionProdServiceImpl implements OrderSolutionProdService {
    @Value("${remote.pdms.url}")
    private String serUrl;
    private final static String NET_ERROR = "与后台通讯异常";
    private final static String FAIL_CODE = "9999";
    private final static String SUCCESS_CODE = "0000";


    private PdmsResponseMessage doPdmsAgrtProjectTrans(PdmsRequestMessage requestMessage) {
		PdmsResponseMessage responseMessage = new PdmsResponseMessage();
		HttpResponseWrapper httpResponseWrapper = new OrderHttpTransService().doPostTran(serUrl, requestMessage);
		if (httpResponseWrapper.getStatus()) {
			responseMessage = JSON.parseObject((String)httpResponseWrapper.getContent(), PdmsResponseMessage.class);
			if(StringUtil.isEmpty(responseMessage.getStatusCode())){
				if(SUCCESS_CODE.equals(responseMessage.getCode())) {
					responseMessage.setStatusCode(responseMessage.getCode());
					return responseMessage;
				}
				responseMessage.setStatusCode(StatusCodeProvider.SYSTEMNO_INTERFACE_PDMS + responseMessage.getCode());
			}
		} else {
			String statusCode = StatusCodeProvider.getCode(httpResponseWrapper, FAIL_CODE);
			responseMessage.setCode(statusCode);
			responseMessage.setMessage(NET_ERROR);
			responseMessage.setStatusCode(Constants.STATUSCODE_PREFIX + statusCode);
		}
		return responseMessage;
    }

    public PdmsResponseMessage getPdmsSolution(PdmsRequestMessage requestMessage) {
        requestMessage.setInterfaceCode("GetPdmsSolution");
        requestMessage.setRequestTime(new Date());
        return this.doPdmsAgrtProjectTrans(requestMessage);
    }

    public PdmsResponseMessage getPdmsProduct(PdmsRequestMessage requestMessage) {
        requestMessage.setInterfaceCode("GetPdmsProduct");
        requestMessage.setRequestTime(new Date());
        return this.doPdmsAgrtProjectTrans(requestMessage);
    }

    public PdmsResponseMessage getPdmsSolutionProd(PdmsRequestMessage requestMessage) {
        requestMessage.setInterfaceCode("GetPdmsSolutionProd");
        requestMessage.setRequestTime(new Date());
        return this.doPdmsAgrtProjectTrans(requestMessage);
    }

}
