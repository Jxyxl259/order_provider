package com.yaic.app.common.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.yaic.servicelayer.http.HttpTransceiver;
import com.yaic.servicelayer.http.wrapper.HttpResponseWrapper;
import com.yaic.servicelayer.util.ConfigUtil;

public class SendSmsUtil {
    private static final String EMAS_SERVER = ConfigUtil.getValue("sms.url");// "http://sms.1an.com/emas/sendSMS/httpjson";

    private static final String EMAS_USER = ConfigUtil.getValue("sms.user");// "core";

    private static final String EMAS_PWD = ConfigUtil.getValue("sms.pwd");// "Ya12@com";

    private static final String PUB_KEY = ConfigUtil.getValue("sms.key");// "EMASKEYS";

    private static final String SMS_SIGN = ConfigUtil.getValue("sms.sign");// "【易安保险】";

    private static final String SMS_CMD = ConfigUtil.getValue("sms.cmd");// "1001";

    /**
     * 短信发送http请求
     * @param inputObject 短信信息参数，以对象形式传输
     * @param serverURL 短信平台地址，如:http://127.0.0.1:80/sendEmas/sendSMS/httpjson
     * @return 数组第一位为是否正常影响Y为正常N为不正常
     */
    public static HttpResponseWrapper sendSms(final Object inputObject, final String serverURL) {
		final Map<String, String> params = new HashMap<>(2);
		params.put("jsondata", JSON.toJSONString(inputObject));
		return HttpTransceiver.doPostKVpair(serverURL, null, params, true);
	}

    public static String getEmasServer() {
        return EMAS_SERVER;
    }

    public static String getEmasUser() {
        return EMAS_USER;
    }

    public static String getEmasPwd() {
        return EMAS_PWD;
    }

    public static String getPubKey() {
        return PUB_KEY;
    }

    public static String getSmsSign() {
        return SMS_SIGN;
    }

    public static String getSmsCmd() {
        return SMS_CMD;
    }
}