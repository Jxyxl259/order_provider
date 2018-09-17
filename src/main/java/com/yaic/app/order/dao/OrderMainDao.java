/*
 * Created By lujicong (2015-12-21 16:02:16)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dao;

import java.util.List;
import java.util.Map;

import com.yaic.app.order.dto.custom.PolicyInfo;
import com.yaic.app.order.dto.custom.ProdToPolicyInfo;
import com.yaic.app.order.dto.domain.OrderMainDto;
import com.yaic.fa.dao.BaseDao;

public interface OrderMainDao extends BaseDao<OrderMainDto> {

	/**
	 * 新增记录
	 * <p>Version: 1.0
	 * @param orderMainDto
	 */
	public void addOrderMain(OrderMainDto orderMainDto);
	
	/**
	 * 查询记录列表
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public List<PolicyInfo> queryPolicyList(Map<String,Object> paramMap);
	
	/**
	 * 查询记录数
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public int queryPolicyCount(Map<String,Object> paramMap);
	
	/**
	 * 查询记录列表union all
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public List<PolicyInfo> queryPolicyUnionAllList(Map<String,Object> paramMap);
	
	/**
	 * 查询记录数union all
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public int queryPolicyUnionAllCount(Map<String,Object> paramMap);
	
	/**
	 * 查询记录列表union all (非分页)
	 * <p>User: lujicong
	 * <p>Date: 2015-12-24
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public List<PolicyInfo> queryPolicyUnionAllListNoPage(Map<String,Object> paramMap);
	
	/**
	 * 根据docNo和docType查询记录列表
	 * <p>User: 曲地怀
	 * <p>Date: 2017-12-08
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return 
	 */
	public List<PolicyInfo> queryPoliciesByDocNoAndType(Map<String, Object> paramMap);
	
	/**
	 * 查询产品保单列表信息
	 * <p>User: lpengfei
	 * <p>Date: 2017年12月16日
	 * <p>Version: 1.0
	 */
	public List<ProdToPolicyInfo> queryProdToPolicyList(Map<String, Object> paramMap);
}
