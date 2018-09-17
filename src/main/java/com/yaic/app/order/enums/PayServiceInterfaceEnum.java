package com.yaic.app.order.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>User: Qu Dihuai
 * <p>Date: Apr 4, 2018
 */
public enum PayServiceInterfaceEnum implements InterfaceEnumerable
{
	/**
	 * 5.2.16 第三方支付回调
	 */
	CALL_BACK_THIRD_PAY("CallBackThirdPay", "callBackThirdPay"),
	/**
	 * 5.2.17 发起订单支付
	 */
	INIT_ORDER_PAY("InitOrderPay", "initOrderPay"),
	/**
	 * 5.2.22 获取微信签名
	 */
	GET_WX_SIGN("GetWxSign", "getWxSign");

	private String interfaceCode;
	private String methodName;

	public static Map<String, PayServiceInterfaceEnum> cache;
	static
	{
		final PayServiceInterfaceEnum[] enums = PayServiceInterfaceEnum.values();
		final Map<String, PayServiceInterfaceEnum> map = new HashMap<>(enums.length);
		for (final PayServiceInterfaceEnum e : enums)
		{
			map.put(e.interfaceCode, e);
		}
		cache = Collections.unmodifiableMap(map);
	}

	/**
	 * @param interfaceCode
	 * @param methodName
	 */
	private PayServiceInterfaceEnum(final String interfaceCode, final String methodName)
	{
		this.interfaceCode = interfaceCode;
		this.methodName = methodName;
	}

	/**
	 * @return the interfaceCode
	 */
	@Override
	public String interfaceCode()
	{
		return interfaceCode;
	}

	/**
	 * @return the methodName
	 */
	@Override
	public String methodName()
	{
		return methodName;
	}

	/**
	 * @param interfaceCode
	 * @return the InterfaceCodeEnum
	 */
	public static PayServiceInterfaceEnum fromCode(final String interfaceCode)
	{
		return cache.get(interfaceCode);
	}
}
