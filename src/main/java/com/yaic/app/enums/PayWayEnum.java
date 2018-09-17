package com.yaic.app.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * User: Qu Dihuai
 * <p>
 * Date: Apr 8, 2018
 */
public enum PayWayEnum
{
	/**
	 * 工行支付
	 **/
	ICBC_PAY("01", "icbcepay.ePayQuery.url"),
	/**
	 * 工行移动支付
	 **/
	ICBC_APP_PAY("02", "icbcepay.ePayQuery.url"),
	/**
	 * 支付宝即时到账
	 **/
	ALI_PAY("03", "alipay.ePayQuery.url"),
	/**
	 * 支付宝扫码支付
	 **/
	ALI_NATIVE_PAY("04", "alipay.native.ePayQuery.url"),
	/**
	 * 支付宝移动支付
	 **/
	ALI_APP_PAY("05", "alipay.app.ePayQuery.url"),
	/**
	 * 微信支付
	 **/
	WX_PAY("06", "weixinpay.ePayQuery.url"),
	/**
	 * 快钱支付
	 **/
	KUAIQIAN_PAY("07", "kuaiqianpay.ePayQuery.url"),
	/**
	 * 支付宝手机网站支付
	 **/
	ALI_WAP_PAY("08", "alipay.wap.ePayQuery.url"),
	/**
	 * 微信H5支付
	 **/
	WX_H5_PAY("09", "weixinpay.ePayQuery.url"),
	/**
	 * 银联支付
	 **/
	UNION_PAY("10", "unionpay.ePayQuery.url"),
	/**
	 * 务通支付
	 **/
	WU_TONG("11", "wutongpay.ePayQuery.url");

	private String code;
	private String urlKey;

	private static Map<String, PayWayEnum> cache;
	static
	{
		final Map<String, PayWayEnum> map = new HashMap<>(PayWayEnum.values().length);
		for (final PayWayEnum e : PayWayEnum.values())
		{
			map.put(e.code(), e);
		}
		cache = Collections.unmodifiableMap(map);
	}

	private PayWayEnum(final String code, final String urlKey)
	{
		this.code = code;
		this.urlKey = urlKey;
	}

	/**
	 * @return the code
	 */
	public String code()
	{
		return code;
	}

	/**
	 * @return the urlKey
	 */
	public String urlKey()
	{
		return urlKey;
	}

	/**
	 * @param code
	 * @return PayWayEnum
	 */
	public static PayWayEnum fromCode(final String code)
	{
		return cache.get(code);
	}
}
