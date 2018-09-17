package com.yaic.app.order.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.yaic.servicelayer.http.HttpTransceiver;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;

public class ClientUtils {
    /**
     * 与其他系统交互功能基类
     * 
     * @param mapData
     *            需要传送给互动平台的参数，Map的形式传输
     * @param serverURL
     *            服务交互地址
     * @return 数组第一位为是否正常影响Y为正常N为不正常
     */
	public HttpResponseWrapper connectServer(final Object inputObject, final String serverURL) {
		final String jsonData = JSON.toJSONString(inputObject);
		return HttpTransceiver.doPostRaw(serverURL, "text/plain", jsonData, true, true);
	}

    /**
     * 与其他系统交互功能基类
     * 
     * @param mapData
     *            需要传送给互动平台的参数，Map的形式传输
     * @param serverURL
     *            服务交互地址
     * @return 数组第一位为是否正常影响Y为正常N为不正常
     */
	public String[] connectServer(final String serverURL, final Object inputObject) {
		final String jsonData = JSON.toJSONString(inputObject);
		final Map<String, String> headers = new HashMap<>(2);
		headers.put("Content-type", "application/json");
		headers.put("Accept", "application/json");

		final HttpResponseWrapper httpResponseWrapper = HttpTransceiver.doPostRaw(headers, serverURL, jsonData, false, false);
		return convertResult(httpResponseWrapper);
	}

	private String[] convertResult(final HttpResponseWrapper httpResponseWrapper) {
		final String[] result = new String[2];
		result[0] = httpResponseWrapper.getStatus() ? "Y" : "N";
		result[1] = httpResponseWrapper.getStatus() ? (String) httpResponseWrapper.getContent() : httpResponseWrapper.getErrorMessage();
		return result;
	}
}
