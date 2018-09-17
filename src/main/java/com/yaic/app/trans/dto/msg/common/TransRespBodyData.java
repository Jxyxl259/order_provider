package com.yaic.app.trans.dto.msg.common;

import com.yaic.app.order.dto.msg.TransTrandNoToPayResp;
import com.yaic.app.trans.dto.msg.TransActivationCardLogoutResp;
import com.yaic.app.trans.dto.msg.TransCancelInsuranceResp;
import com.yaic.app.trans.dto.msg.TransEndorResp;
import com.yaic.app.trans.dto.msg.TransLiabilitySwitchResp;
import com.yaic.app.trans.dto.msg.TransOrderToBusinessNoResp;
import com.yaic.app.trans.dto.msg.TransOrderToPolicyResp;
import com.yaic.app.trans.dto.msg.TransOrderToProposalResp;
import com.yaic.app.trans.dto.msg.TransProposalToPolicyResp;
import com.yaic.app.trans.dto.msg.TransQueryActivationCardInfoResp;
import com.yaic.app.trans.dto.msg.TransSynPolicyResp;

/**
 * 请求Body部分
 * 
 * @Author lujicong
 * @Date: 2015-12-28
 * @Version: 1.0
 */
public class TransRespBodyData {

    /** 订单转投保单 **/
    private TransOrderToProposalResp orderToProposalResp;

    /** 投保单转保单 **/
    private TransProposalToPolicyResp proposalToPolicyResp;

    /** 全单退保 **/
    private TransCancelInsuranceResp cancelInsuranceResp;

    /** 订单转保单 **/
    private TransOrderToPolicyResp orderToPolicyResp;

    /** 订单获取流水号 **/
    private TransOrderToBusinessNoResp orderToBusinessNoResp;
    
    /** 到账确认  */
    private TransTrandNoToPayResp trandNoToPayResp;
    
    /** 批改  */
    private TransEndorResp transEndorResp;
    
    /** 激活卡查询验真接口  */
    private TransQueryActivationCardInfoResp queryActivationCardInfoResp;
    
    /** 激活卡 激活/核销  */
    private TransActivationCardLogoutResp activationCardLogoutResp;
    
    /** 保险责任切换接口  */
    private TransLiabilitySwitchResp liabilitySwitchResp;
    
    /** 任务同步保单  */
    private TransSynPolicyResp synPolicyResp;
    
    public TransOrderToProposalResp getOrderToProposalResp() {
        return orderToProposalResp;
    }

    public void setOrderToProposalResp(TransOrderToProposalResp orderToProposalResp) {
        this.orderToProposalResp = orderToProposalResp;
    }

    public TransProposalToPolicyResp getProposalToPolicyResp() {
        return proposalToPolicyResp;
    }

    public void setProposalToPolicyResp(TransProposalToPolicyResp proposalToPolicyResp) {
        this.proposalToPolicyResp = proposalToPolicyResp;
    }

    public TransCancelInsuranceResp getCancelInsuranceResp() {
        return cancelInsuranceResp;
    }

    public void setCancelInsuranceResp(TransCancelInsuranceResp cancelInsuranceResp) {
        this.cancelInsuranceResp = cancelInsuranceResp;
    }

    public TransOrderToPolicyResp getOrderToPolicyResp() {
        return orderToPolicyResp;
    }

    public void setOrderToPolicyResp(TransOrderToPolicyResp orderToPolicyResp) {
        this.orderToPolicyResp = orderToPolicyResp;
    }
    
    /** 订单获取流水号 **/
	public TransOrderToBusinessNoResp getOrderToBusinessNoResp() {
		return orderToBusinessNoResp;
	}

	/** 订单获取流水号 **/
	public void setOrderToBusinessNoResp(TransOrderToBusinessNoResp orderToBusinessNoResp) {
		this.orderToBusinessNoResp = orderToBusinessNoResp;
	}

	/** 到账确认  */
	public TransTrandNoToPayResp getTrandNoToPayResp() {
		return trandNoToPayResp;
	}

	/** 到账确认  */
	public void setTrandNoToPayResp(TransTrandNoToPayResp trandNoToPayResp) {
		this.trandNoToPayResp = trandNoToPayResp;
	}

	public TransEndorResp getTransEndorResp() {
		return transEndorResp;
	}

	public void setTransEndorResp(TransEndorResp transEndorResp) {
		this.transEndorResp = transEndorResp;
	}
	
	/** 激活卡查询验真接口  */
    public TransQueryActivationCardInfoResp getQueryActivationCardInfoResp() {
        return queryActivationCardInfoResp;
    }

    /** 激活卡查询验真接口  */
    public void setQueryActivationCardInfoResp(TransQueryActivationCardInfoResp queryActivationCardInfoResp) {
        this.queryActivationCardInfoResp = queryActivationCardInfoResp;
    }
    
    /** 激活卡 激活/核销  */
    public TransActivationCardLogoutResp getActivationCardLogoutResp() {
        return activationCardLogoutResp;
    }

    /** 激活卡 激活/核销  */
    public void setActivationCardLogoutResp(TransActivationCardLogoutResp activationCardLogoutResp) {
        this.activationCardLogoutResp = activationCardLogoutResp;
    }

	public TransLiabilitySwitchResp getLiabilitySwitchResp() {
		return liabilitySwitchResp;
	}

	public void setLiabilitySwitchResp(
			TransLiabilitySwitchResp liabilitySwitchResp) {
		this.liabilitySwitchResp = liabilitySwitchResp;
	}
	
	/** 任务同步保单  */
    public TransSynPolicyResp getSynPolicyResp() {
        return synPolicyResp;
    }

    /** 任务同步保单  */
    public void setSynPolicyResp(TransSynPolicyResp synPolicyResp) {
        this.synPolicyResp = synPolicyResp;
    }
}
