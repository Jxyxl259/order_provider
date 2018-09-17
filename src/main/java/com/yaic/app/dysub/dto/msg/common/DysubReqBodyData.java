package com.yaic.app.dysub.dto.msg.common;

import com.yaic.app.dysub.dto.msg.OrderCallBackDysubReq;
import com.yaic.app.dysub.dto.msg.PolicyNoToRedisReq;
import com.yaic.app.order.dto.msg.FtpCallBackReq;
import com.yaic.app.order.dto.msg.common.ShopOrderDto;

public class DysubReqBodyData {
	
	/** 商品订单信息 **/
    private ShopOrderDto cancelInsuranceCallBackReq;

    /** 保单信息添加缓存 **/
    private PolicyNoToRedisReq policyNoToRedisReq;
    
    /** 退保回调信息 **/
    private FtpCallBackReq ftpCallBackReq;
    
    /** ORDER回调DYSUB **/
    private OrderCallBackDysubReq orderCallBackDysubReq;
    
	public ShopOrderDto getCancelInsuranceCallBackReq() {
		return cancelInsuranceCallBackReq;
	}

	public void setCancelInsuranceCallBackReq(
			ShopOrderDto cancelInsuranceCallBackReq) {
		this.cancelInsuranceCallBackReq = cancelInsuranceCallBackReq;
	}

	public PolicyNoToRedisReq getPolicyNoToRedisReq() {
		return policyNoToRedisReq;
	}

	public void setPolicyNoToRedisReq(PolicyNoToRedisReq policyNoToRedisReq) {
		this.policyNoToRedisReq = policyNoToRedisReq;
	}
	
	public FtpCallBackReq getFtpCallBackReq() {
		return ftpCallBackReq;
	}

	public void setFtpCallBackReq(FtpCallBackReq ftpCallBackReq) {
		this.ftpCallBackReq = ftpCallBackReq;
	}

	public OrderCallBackDysubReq getOrderCallBackDysubReq() {
		return orderCallBackDysubReq;
	}

	public void setOrderCallBackDysubReq(OrderCallBackDysubReq orderCallBackDysubReq) {
		this.orderCallBackDysubReq = orderCallBackDysubReq;
	}
    
}
