package com.yaic.app.order.dto.msg;

public class InitOrderPayReq {
    /**订单号 **/
    private String orderCode;
    /**支付方式 **/
    private String payWay;
    /**数据来源**/
    private String dataSource;
    /**交易类型(WX) **/
    private String tradeType;
    /**用户标识 (jsapi 使用)(WX) **/
    private String openId;
    /**终端IP APP和网页支付提交用户端ip(WX) **/
    private String spBillCreateIp;
    /**启动类型(工行APP) 1：工行iPhone客户端版2：工行Android客户端版21：工行移动生活版（iPhone）22：工行移动生活版（Android）**/
    private String clientType;
    /**支付宝前端跳转url**/
    private String returnUrl;
    
    // union param start
    /**应用ID **/
    private String appCode;
    /**渠道编号 **/
    private String channelNo;
    /**前台通知地址 **/
    private String frontUrl;
    /**手机号 **/
    private String mobile;
    /**模式类型 **/
    private String model;
    /**活动编号 **/
    private String actCode;
    /**流水号 **/
    private String serialNo;
    /**用户名 **/
    private String userName;
    /**商品类型 **/
    private String goodType;
    /** 支付人 */ 
    private String payeeName;
    
    /** 支付银行 */ 
    private String bankName;
    
    /** 支付银行代码 */
    private String bankCode;
    
    /** 支付账号 */ 
    private String bankAccount;
    
    /** 银行预留手机号 */
    private String phoneNo;
    
    /** 支付人证件类型 */
    private String docType;
    
    /** 支付人证件 */
    private String docNo;
	
	// Add by Qu Dihuai for RM-4599 start
	/** 银联支付系统的用户ID(由银联传过来的) */
	private String unionPayUserId;
	// Add by Qu Dihuai for RM-4599 end
	
    // union param end
	
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSpBillCreateIp() {
        return spBillCreateIp;
    }

    public void setSpBillCreateIp(String spBillCreateIp) {
        this.spBillCreateIp = spBillCreateIp;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	// Add by Qu Dihuai for RM-4599 start
	public String getUnionPayUserId() {
		return unionPayUserId;
	}

	public void setUnionPayUserId(String unionPayUserId) {
		this.unionPayUserId = unionPayUserId;
	}
	// Add by Qu Dihuai for RM-4599 end
	
}
