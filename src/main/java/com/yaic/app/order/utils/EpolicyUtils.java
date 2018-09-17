package com.yaic.app.order.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.yaic.servicelayer.charset.StandardCharset;
import com.yaic.servicelayer.http.HttpTransceiver;
import com.yaic.servicelayer.http.wrapper.HttpPostRawWrapper;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;

public class EpolicyUtils {
	/**
	 * 汉语中数字大写
	 */
	private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
	/**
	 * 汉语中货币单位大写，这样的设计类似于占位符
	 */
	private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾",
			"佰", "仟", "兆", "拾", "佰", "仟" };
	/**
	 * 特殊字符：整
	 */
	private static final String CN_FULL = "整";
	/**
	 * 特殊字符：负
	 */
	private static final String CN_NEGATIVE = "负";
	/**
	 * 金额的精度，默认值为2
	 */
	private static final int MONEY_PRECISION = 2;
	/**
	 * 特殊字符：零元整
	 */
	private static final String CN_ZEOR_FULL = "零元" + CN_FULL;

	public static final int DATAERROR_CODE = 9999;
	public static final int SUCCESS_CODE = 0000;
	private static final String APPLICATION_JSON = "application/json";
	private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

	public static HttpResponseWrapper doPostTran(final String hostUrl, final String xmlStr) {
		final HttpPostRawWrapper httpPostWrapper = new HttpPostRawWrapper();
		httpPostWrapper.setServerUrl(hostUrl);
		httpPostWrapper.setCharset(StandardCharset.UTF_8.name());
		httpPostWrapper.setUrlEncodeEnabled(true);
		httpPostWrapper.setUrlDecodeEnabled(true);
		httpPostWrapper.setContentEncoding(APPLICATION_JSON);
		httpPostWrapper.setMimeType(CONTENT_TYPE_TEXT_JSON);
		httpPostWrapper.setRawBody(xmlStr);
		return HttpTransceiver.doPost(httpPostWrapper);
	}

	/**
	 * 金额格式化
	 * <p>
	 * User: admin
	 * <p>
	 * Date: 2016年12月7日
	 * <p>
	 * Version: 1.0
	 * 
	 * @param d
	 * @return
	 */
	public static String formatNumber(Double d) {
		/* 金额的格式化 */
		if (d.doubleValue() > 0) {
			DecimalFormat df = new DecimalFormat("###,###,###,###,##0.00");
			String temp = df.format(d);
			return temp;
		} else {
			return "";
		}
	}

	/**
	 * 把输入的金额转换为汉语中人民币的大写
	 * 
	 * @param numberOfMoney
	 *            输入的金额
	 * @return 对应的汉语大写
	 */
	public static String numberCNMontrayUnit(BigDecimal numberOfMoney) {
		StringBuffer sb = new StringBuffer();
		// -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
		// positive.
		int signum = numberOfMoney.signum();
		// 零元整的情况
		if (signum == 0) {
			return CN_ZEOR_FULL;
		}
		// 这里会进行金额的四舍五入
		long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();
		// 得到小数点后两位值
		long scale = number % 100;
		int numUnit = 0;
		int numIndex = 0;
		boolean getZero = false;
		// 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
		if (!(scale > 0)) {
			numIndex = 2;
			number = number / 100;
			getZero = true;
		}
		if ((scale > 0) && (!(scale % 10 > 0))) {
			numIndex = 1;
			number = number / 10;
			getZero = true;
		}
		int zeroSize = 0;
		while (true) {
			if (number <= 0) {
				break;
			}
			// 每次获取到最后一个数
			numUnit = (int) (number % 10);
			if (numUnit > 0) {
				if ((numIndex == 9) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
				}
				if ((numIndex == 13) && (zeroSize >= 3)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
				}
				sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				getZero = false;
				zeroSize = 0;
			} else {
				++zeroSize;
				if (!(getZero)) {
					sb.insert(0, CN_UPPER_NUMBER[numUnit]);
				}
				if (numIndex == 2) {
					if (number > 0) {
						sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
					}
				} else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
					sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
				}
				getZero = true;
			}
			// 让number每次都去掉最后一个数
			number = number / 10;
			++numIndex;
		}
		// 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
		if (signum == -1) {
			sb.insert(0, CN_NEGATIVE);
		}
		// 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
		if (!(scale > 0)) {
			sb.append(CN_FULL);
		}
		return sb.toString();
	}

	/**
	 * 获取相差天数 秒相等时不加1天
	 * <p>
	 * User: admin
	 * <p>
	 * Date: 2016年9月23日
	 * <p>
	 * Version: 1.0
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDayInterval(Date startDate, Date endDate) {
		org.joda.time.DateTime sDate = new org.joda.time.DateTime(startDate);
		org.joda.time.DateTime eDate = new org.joda.time.DateTime(endDate);
		int day = Days.daysBetween(new LocalDate(startDate), new LocalDate(endDate)).getDays();
		if (eDate.getHourOfDay() > sDate.getHourOfDay()) {
			day++;
		} else if (eDate.getHourOfDay() == sDate.getHourOfDay() && eDate.getMinuteOfHour() > sDate.getMinuteOfHour()) {
			day++;
		} else if (eDate.getHourOfDay() == sDate.getHourOfDay() && eDate.getMinuteOfHour() == sDate.getMinuteOfHour()
				&& eDate.getSecondOfMinute() > sDate.getSecondOfMinute()) {
			day++;
		}
		return day;
	}
	
	/**
	 * @MethodName : getFields
	 * @Description : 获取类中所有属性及属性值,去除null值,存为map形式
	 * @param model
	 *            操作对象
	 * @return
	 */
	public static Map<String, Object> getFields(Object model) throws Exception {
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		for (Field field : model.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.get(model) != null) {
				fieldMap.put(field.getName().toUpperCase(), field.get(model));
			}
		}
		return fieldMap;
	}
	
}