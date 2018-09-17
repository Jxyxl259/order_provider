package com.yaic.app.order.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yaic.servicelayer.charset.StandardCharset;
import com.yaic.servicelayer.http.HttpTransceiver;
import com.yaic.servicelayer.http.wrapper.HttpPostRawWrapper;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;

@Service
public class OrderHttpTransService {
    public static final int DATAERROR_CODE = 9999;
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

	public HttpResponseWrapper doPostTran(String hostUrl, Object requestObj){
		final HttpPostRawWrapper httpPosDTO = new HttpPostRawWrapper();
		httpPosDTO.setServerUrl(hostUrl);
		httpPosDTO.setMimeType(CONTENT_TYPE_TEXT_JSON);
		httpPosDTO.setUrlEncodeEnabled(true);
		httpPosDTO.setUrlDecodeEnabled(true);
		httpPosDTO.setCharset(StandardCharset.UTF_8.name());
		httpPosDTO.setContentEncoding(APPLICATION_JSON);
		httpPosDTO.setRawBody(JSON.toJSONString(requestObj));

		return HttpTransceiver.doPost(httpPosDTO);
	}

	public HttpResponseWrapper doTran(String hostUrl, Object requestObj){
		final Map<String, String> headers = new HashMap<>(2);
		headers.put("Content-type", APPLICATION_JSON);
		headers.put("Accept", APPLICATION_JSON);

		final String jsonString = JSON.toJSONString(requestObj);
		return HttpTransceiver.doPostRaw(headers, hostUrl, jsonString, false, false);
	}

}
