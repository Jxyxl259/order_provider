package com.yaic.app.order.dto.msg;

import java.util.List;

import com.yaic.app.order.dto.custom.ProdToPolicyInfo;

/**
 * 查询产品保单列表信息
 * <p>User: lpengfei
 * <p>Date: 2017年12月16日
 * <p>Version: 1.0
 */
public class QueryProdToPolicyListResp {
	
	/** 产品保单信息 **/
	List<ProdToPolicyInfo> prodToPolicyList = null;
	
	
	/** 产品保单息 **/
	public List<ProdToPolicyInfo> getProdToPolicyList() {
		return prodToPolicyList;
	}
	
	/** 产品保单信息 **/
	public void setProdToPolicyList(List<ProdToPolicyInfo> prodToPolicyList) {
		this.prodToPolicyList = prodToPolicyList;
	}

}
