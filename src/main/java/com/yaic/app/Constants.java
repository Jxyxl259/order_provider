package com.yaic.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.yaic.app.provider.StatusCodeProvider;

public class Constants {

    /** 当前用户信息 **/
    public static final String CURRENT_USER = "user";
    /** 当前用户代码 **/
    public static final String LOGIN_USER_ID_KEY = "LOGIN_USER_ID";
    /** Redis缓存有效时间 单位:秒  **/
    public static final int EXPIRE_TIME = 60*60*3;
    /** 支付状态 **/
    public static Map<String,String> paystatusMap;
    static{
    	final Map<String,String> map = new HashMap<>();
        map.put("0","未支付");
        map.put("1","支付失败");
        map.put("2","支付成功");
        map.put("3","订单取消");
        map.put("4","订单关闭");
        map.put("5","退款中");
        map.put("6","退款成功");
        map.put("7","退款失败");
        map.put("8","订单不存在");
        map.put("9","接口异常");
        paystatusMap = Collections.unmodifiableMap(map);
    }

    /** 激活卡处理方式 **/
    public static final String DISPOSE_JHK = "JK";
    
    /* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  begin  */
    /** 保保平台 **//*
    public static final String DATA_SOURCE_BBPT = "O-BBPT";
    
    *//** 爱出门 **//*
    public static final String DATA_SOURCE_ACM = "O-ACM";
    
    *//** 北京无卡付**//*
    public static final String DATA_SOURCE_WKFBJ = "O-WKFBJ";
    
    *//** 上海和付**//*
    public static final String DATA_SOURCE_SHHF = "O-SHHF";

    *//** 广州联保**//*
    public static final String DATA_SOURCE_GZLB = "O-GZLB";*/
    /* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  end  */
    
    /** 趣店 **/
    public static final String DATA_SOURCE_QD = "O-QD";
    
    /** 新网江西趣店 **/
    public static final String DATA_SOURCE_XJQD = "O-XJQD";
    
    /** 乐荐科技 **/
    public static final String DATA_SOURCE_LJKJ = "O-LJKJ";
    
    /** 5.2.37  退保回调对账数据**/
    public static final String CALLBACK_SURRENDER_RECONCILIATION = "CallBackSurrenderReconciliation";
    
    /** 5.2.38  统一回调对账数据**/
	public static final String ORDER_CALLBACK_DYSUB_DATA = "OrderCallbackDysubData";
	
	/** 订单系统响应码前缀 **/
    public static final String STATUSCODE_PREFIX = StatusCodeProvider.SYSTEMNO_INTERFACE_ORDER;
	
    /** 其他险种代码 **/
    public static final String RISK_CODE_9999 = "9999";
    /**处理类型-退保**/
    public static final String DEAL_TYPE = "11";
    /**处理类型-人工审核**/
    public static final String AUDITING_TYPE = "21";
    /** 退保状态 **/
    public static Map<String,String> surrenderStatus = new ConcurrentHashMap<String,String>();
    static{
    	surrenderStatus.put("surrenderStatusSuccess","1");	//成功
    	surrenderStatus.put("surrenderStatusFail","2");	//失败
    }
    
    /* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  begin  */
    /*public static Map<String,String> poaInfoMap = new HashMap<String,String>();
    static{
    	poaInfoMap.put("O-BBPT_FIELD_SEPARATOR_AGRTCODE_BBPT_3405", "{\"channelName\":\"北京万能小哥信息技术有限公司\",\"emailModule\":\"{'businessType':'003','isTime':'1','moduleId':'01','templateId':'02'}\",\"isEmail\":\"1\",\"poaLimit\":300}");
    	poaInfoMap.put("O-ACM_FIELD_SEPARATOR_AGRTCODE_ACM_3409", "{\"channelName\":\"吉林爱出门网络科技有限公司\",\"emailModule\":\"{'businessType':'003','isTime':'1','moduleId':'01','templateId':'02'}\",\"isEmail\":\"1\",\"poaLimit\":1000}");
    	poaInfoMap.put("O-WKFBJ_FIELD_SEPARATOR_AGRTCODE_WKFBJ_2202", "{\"channelName\":\"无卡付（北京）科技有限公司\",\"emailModule\":\"{'businessType':'003','isTime':'1','moduleId':'01','templateId':'02'}\",\"isEmail\":\"1\",\"poaLimit\":1000}");
    	poaInfoMap.put("O-SHHF_FIELD_SEPARATOR_AGRTCODE_SHHF_2202", "{\"channelName\":\"上海和付信息技术有限公司\",\"emailModule\":\"{'businessType':'003','isTime':'1','moduleId':'01','templateId':'02'}\",\"isEmail\":\"1\",\"poaLimit\":1000}");
    	poaInfoMap.put("O-GZLB_FIELD_SEPARATOR_AGRTCODE_GZLB_3412", "{\"channelName\":\"广州花城假期国际旅行社有限公司\",\"emailModule\":\"{'businessType':'003','isTime':'1','moduleId':'01','templateId':'02'}\",\"isEmail\":\"1\",\"poaLimit\":3000}");
    }*/
    /* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  end  */
    
    /** 合同争议解决方式 **/
    public static Map<String, String> argueSolutionMap = new HashMap<String, String>();
    static{
    	argueSolutionMap.put("1", "诉讼");
    	argueSolutionMap.put("2", "仲裁");
    	argueSolutionMap.put("3", "协商");
    }
    
    /** 性别 **/
    public static Map<String, String> sexMap = new HashMap<String, String>();
    static{
    	sexMap.put("01", "男");
    	sexMap.put("02", "女");
    	sexMap.put("03", "未知");
    }
    
    public static final class MutualStatus {
		/**
		 * 成功
		 */
		public static final int OK = 200;
		/**
		 * 异常错误
		 */
		public static final int ERR = 500;
	}
    
	/** 处理类型-投保 **/
	public static final String DEAL_TYPE_INSURE = "INSURE";
	
	/** 处理类型-退保 **/
	public static final String DEAL_TYPE_CANCEL = "CANCEL";
	
	/* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  begin  */
	/** 保保平台-个人意外险 **//*
	public static final String AGRTCODE_BBPT_3405 = "201608000700114502";
	
	*//** 爱出门-航空意外险 **//*
	public static final String AGRTCODE_ACM_3409 = "03409001013000,03409001014000,03409001015000,03409001016000";
	
	*//** 北京无卡付-个人账户资金安全保险 **//*
	public static final String AGRTCODE_WKFBJ_2202 = "02202001010000,02202001011000,02202001012000,02202001013000";

	*//** 上海和付-个人账户资金安全保险 **//*
	public static final String AGRTCODE_SHHF_2202 = "02202001004000,02202001005000,02202001006000,02202001007000";
	
	*//** 广州联保信息技术有限公司 **//*
	public static final String AGRTCODE_GZLB_3412 = "03412005001000";*/
	/* delete by zhaobaoyang 2018/08/14 for RM-6864 新收付暂收款功能需求-中台系统  end  */
}
