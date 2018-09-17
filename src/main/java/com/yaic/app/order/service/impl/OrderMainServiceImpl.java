/*
 * Created By lujicong (2015-12-21 16:02:16)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.order.dao.OrderMainDao;
import com.yaic.app.order.dto.custom.PolicyInfo;
import com.yaic.app.order.dto.custom.ProdToPolicyInfo;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.app.order.service.OrderMainService;
import com.yaic.fa.service.BaseService;

@Service("orderMainService")
public class OrderMainServiceImpl extends BaseService<OrderMainDto> implements OrderMainService {

	@Autowired
	private OrderMainDao orderMainDao;
	
	public void addOrderMain(OrderMainDto orderMainDto) {
	    orderMainDao.addOrderMain(orderMainDto);
	}
	
	/**
	 * 查询记录列表
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public List<PolicyInfo> queryPolicyList(Map<String,Object> paramMap) {
	    return orderMainDao.queryPolicyList(paramMap);
	}
	
	/**
	 * 查询记录数
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public int queryPolicyCount(Map<String,Object> paramMap) {
	    return orderMainDao.queryPolicyCount(paramMap);
	}
	
	/**
	 * 查询记录列表union all
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public List<PolicyInfo> queryPolicyUnionAllList(Map<String,Object> paramMap) {
	    return orderMainDao.queryPolicyUnionAllList(paramMap);
	}
	
	/**
	 * 查询记录数union all
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public int queryPolicyUnionAllCount(Map<String,Object> paramMap) {
	    return orderMainDao.queryPolicyUnionAllCount(paramMap);
	}
	
	/**
	 * 查询记录列表union all(非分页)
	 * <p>User: lujicong
	 * <p>Date: 2016-02-23
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public List<PolicyInfo> queryPolicyUnionAllListNoPage(Map<String,Object> paramMap) {
	    return orderMainDao.queryPolicyUnionAllListNoPage(paramMap);
	}
	
	/**
	 * 根据docNo和docType查询记录列表(三官专用)
	 * <p>User: Qu Dihuai
	 * <p>Date: 2017-12-08
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return List<PolicyInfo>
	 */
	@Override
	public List<PolicyInfo> queryPoliciesByDocNoAndType(Map<String, Object> paramMap) {
		return orderMainDao.queryPoliciesByDocNoAndType(paramMap);
	}
	
	/**
	 * 查询产品保单列表信息
	 * <p>User: lpengfei
	 * <p>Date: 2017年12月16日
	 * <p>Version: 1.0
	 */
	@Override
	public List<ProdToPolicyInfo> queryProdToPolicyList(Map<String, Object> paramMap) {
		return orderMainDao.queryProdToPolicyList(paramMap);
	}
}
