package com.yaic.app.provider;

import com.yaic.servicelayer.app.provider.AppNoProvider;
import com.yaic.servicelayer.constant.AppSystem;
import com.yaic.servicelayer.constant.StatusCodeMap;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;

/**
 * 提供订单管理系统的应用系统编号
 * 
 * @author Qu Dihuai
 *
 */
public class StatusCodeProvider {
	/**
	 * 默认的接口编号
	 */
	private final static String DEFAULT_INTERFACE_NO = "000";
	
	/**
	 * 订单系统
	 */
	public final static String SYSTEMNO_INTERFACE_ORDER = provideAppNo(AppSystem.Midend.ORDER) + DEFAULT_INTERFACE_NO;

	/**
	 * 产品工厂
	 */
	public final static String SYSTEMNO_INTERFACE_PDMS = provideAppNo(AppSystem.Midend.PDMS) + DEFAULT_INTERFACE_NO;
	
	/**
	 * 收付系统
	 */
	public final static String SYSTEMNO_INTERFACE_FIN = provideAppNo(AppSystem.Backend.NFIN) + DEFAULT_INTERFACE_NO;
	
	/**
	 * 提供当前系统的系统编号
	 */
	public static String provideAppNo(String appNo) {
		return AppNoProvider.provide(appNo);
	}

	/**
	 * 如果数据收发器(HttpTransceiver)的statusCode值为0, 返回默认的code值
	 */
	public static String getCode(final HttpResponseWrapper result, final String defaultCode)
	{
		if (result.getStatusCode() == 0)
		{
			return defaultCode;
		}
		return StatusCodeMap.fromStatus(result.getStatusCode());
	}
}
