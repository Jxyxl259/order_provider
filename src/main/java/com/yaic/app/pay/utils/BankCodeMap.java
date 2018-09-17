package com.yaic.app.pay.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class BankCodeMap {
	
	private static final Logger LOGGER = Logger.getLogger(BankCodeMap.class);

	private static final Map<String,String> BANK_CODE = new HashMap<String,String>();
	
	static {
		//工商银行
		BANK_CODE.put("102", "ICBC");
		BANK_CODE.put("ICBC", "102");
		//中国银行
		BANK_CODE.put("104", "BOC");
		BANK_CODE.put("BOC", "104");
		//建设银行
		BANK_CODE.put("105", "CCB");
		BANK_CODE.put("CCB", "105");
		//广发银行
		BANK_CODE.put("306", "GDB");
		BANK_CODE.put("GDB", "306");
		//光大银行
		BANK_CODE.put("303", "CEB");
		BANK_CODE.put("CEB", "303");
		//北京银行
		BANK_CODE.put("7007", "BOB");
		BANK_CODE.put("BOB", "7007");
		//民生银行
		BANK_CODE.put("305", "CMBC");
		BANK_CODE.put("CMBC", "305");
		//交通银行
		BANK_CODE.put("301", "BOCOM");
		BANK_CODE.put("BOCOM", "301");
		//华夏银行
		BANK_CODE.put("304", "HXB");
		BANK_CODE.put("HXB", "304");
		//平安银行
		BANK_CODE.put("307", "PAB");
		BANK_CODE.put("PAB", "307");
		//农业银行
		BANK_CODE.put("103", "ABC");
		BANK_CODE.put("ABC", "103");
		//邮储银行
		BANK_CODE.put("403", "PSBC");
		BANK_CODE.put("PSBC", "403");
		//兴业银行
		BANK_CODE.put("309", "CIB");
		BANK_CODE.put("CIB", "309");
		//浦发银行
		BANK_CODE.put("310", "SPDB");
		BANK_CODE.put("SPDB", "310");
		//中信银行
		BANK_CODE.put("302", "CITIC");
		BANK_CODE.put("CITIC", "302");
		//招商银行
		BANK_CODE.put("308", "CMB");
		BANK_CODE.put("CMB", "308");
		//上海银行
		BANK_CODE.put("7006", "BOS");
		BANK_CODE.put("BOS", "7006");
		
	}
	
	public static String trans(String code) throws Exception{
		String bankCode = BANK_CODE.get(code);
		if(bankCode == null){
			LOGGER.warn("不存在的银行代码 bankCode[" + code + "]" );
			throw new Exception("不存在的银行代码");
		}
		return bankCode;
	}
	
}
