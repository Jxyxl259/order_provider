package com.yaic.app.trans.dto.msg.common;

import com.yaic.app.order.dto.msg.NcmTrandNoToPayReq;
import com.yaic.app.trans.dto.msg.TransActivationCardLogoutReq;
import com.yaic.app.trans.dto.msg.TransCancelInsuranceReq;
import com.yaic.app.trans.dto.msg.TransEndorReq;
import com.yaic.app.trans.dto.msg.TransLiabilitySwitchReq;
import com.yaic.app.trans.dto.msg.TransOrderToBusinessNoReq;
import com.yaic.app.trans.dto.msg.TransOrderToPolicyReq;
import com.yaic.app.trans.dto.msg.TransOrderToProposalReq;
import com.yaic.app.trans.dto.msg.TransProposalToPolicyReq;
import com.yaic.app.trans.dto.msg.TransQueryActivationCardInfoReq;
import com.yaic.app.trans.dto.msg.TransSynPolicyReq;

/**
 * 请求Body部分
 * <p>
 * User: lujicong
 * <p>
 * Date: 2015-12-28
 * <p>
 * Version: 1.0
 */
public class TransReqBodyData {

    /** 订单转投保单 **/
    private TransOrderToProposalReq orderToProposalReq;

    /** 投保单转保单 **/
    private TransProposalToPolicyReq proposalToPolicyReq;

    /** 全单退保 **/
    private TransCancelInsuranceReq cancelInsuranceReq;

    /** 订单转保单 **/
    private TransOrderToPolicyReq orderToPolicyReq;

    /** 订单获取流水号 **/
    private TransOrderToBusinessNoReq transOrderToBusinessNoReq;
    
    /** 到账确认  */
    private NcmTrandNoToPayReq trandNoToPayReq;
    
    /** 批改  */
    private TransEndorReq transEndorReq;
    
    /** 激活卡查询验真接口 **/
    private TransQueryActivationCardInfoReq queryActivationCardInfoReq;
    
    /** 激活卡 激活/核销 **/
    private TransActivationCardLogoutReq activationCardLogoutReq;
    
    /** 佰盈-随心“易”灵活交通意外险-责任切换接口 **/
    private TransLiabilitySwitchReq  liabilitySwitchReq;
    
    /** 任务同步保单  */
    private TransSynPolicyReq synPolicyReq;
    
    public TransOrderToProposalReq getOrderToProposalReq() {
        return orderToProposalReq;
    }

    public void setOrderToProposalReq(TransOrderToProposalReq orderToProposalReq) {
        this.orderToProposalReq = orderToProposalReq;
    }

    public TransProposalToPolicyReq getProposalToPolicyReq() {
        return proposalToPolicyReq;
    }

    public void setProposalToPolicyReq(TransProposalToPolicyReq proposalToPolicyReq) {
        this.proposalToPolicyReq = proposalToPolicyReq;
    }

    public TransCancelInsuranceReq getCancelInsuranceReq() {
        return cancelInsuranceReq;
    }

    public void setCancelInsuranceReq(TransCancelInsuranceReq cancelInsuranceReq) {
        this.cancelInsuranceReq = cancelInsuranceReq;
    }

    public TransOrderToPolicyReq getOrderToPolicyReq() {
        return orderToPolicyReq;
    }

    public void setOrderToPolicyReq(TransOrderToPolicyReq orderToPolicyReq) {
        this.orderToPolicyReq = orderToPolicyReq;
    }

    /** 订单获取流水号 **/
	public TransOrderToBusinessNoReq getTransOrderToBusinessNoReq() {
		return transOrderToBusinessNoReq;
	}

	/** 订单获取流水号 **/
	public void setTransOrderToBusinessNoReq(TransOrderToBusinessNoReq transOrderToBusinessNoReq) {
		this.transOrderToBusinessNoReq = transOrderToBusinessNoReq;
	}
	
	/** 到账确认  */
	public NcmTrandNoToPayReq getTrandNoToPayReq() {
		return trandNoToPayReq;
	}

	/** 到账确认  */
	public void setTrandNoToPayReq(NcmTrandNoToPayReq trandNoToPayReq) {
		this.trandNoToPayReq = trandNoToPayReq;
	}

	public TransEndorReq getTransEndorReq() {
		return transEndorReq;
	}

	public void setTransEndorReq(TransEndorReq transEndorReq) {
		this.transEndorReq = transEndorReq;
	}
	
	/** 激活卡查询验真接口 **/
    public TransQueryActivationCardInfoReq getQueryActivationCardInfoReq() {
        return queryActivationCardInfoReq;
    }

    /** 激活卡查询验真接口 **/
    public void setQueryActivationCardInfoReq(TransQueryActivationCardInfoReq queryActivationCardInfoReq) {
        this.queryActivationCardInfoReq = queryActivationCardInfoReq;
    }

    /** 激活卡 激活/核销 **/
    public TransActivationCardLogoutReq getActivationCardLogoutReq() {
        return activationCardLogoutReq;
    }

    /** 激活卡 激活/核销 **/
    public void setActivationCardLogoutReq(TransActivationCardLogoutReq activationCardLogoutReq) {
        this.activationCardLogoutReq = activationCardLogoutReq;
    }

	public TransLiabilitySwitchReq getLiabilitySwitchReq() {
		return liabilitySwitchReq;
	}

	public void setLiabilitySwitchReq(
			TransLiabilitySwitchReq liabilitySwitchReq) {
		this.liabilitySwitchReq = liabilitySwitchReq;
	}

	/** 任务同步保单  */
    public TransSynPolicyReq getSynPolicyReq() {
        return synPolicyReq;
    }

    /** 任务同步保单  */
    public void setSynPolicyReq(TransSynPolicyReq synPolicyReq) {
        this.synPolicyReq = synPolicyReq;
    }
}
