/*
 * Created By lujicong (2016-05-30 14:58:07)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.dao;

import java.util.List;
import java.util.Map;

import com.yaic.app.order.dto.domain.VorderDynamicDto;
import com.yaic.fa.dao.BaseDao;

public interface VorderDynamicDao extends BaseDao<VorderDynamicDto> {
	
	/**
	 * 重复投保查询列表
	 * <p>User: lipengfei
	 * <p>Date: 2016年5月30日
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public List<VorderDynamicDto> queryOrderRepeated(Map<String,Object> paramMap);
	
	/**
	 * 查询重复投保数
	 * <p>User: lipengfei
	 * <p>Date: 2016年5月30日
	 * <p>Version: 1.0
	 * @param paramMap
	 * @return
	 */
	public int queryOrderRepeatCount(Map<String,Object> paramMap);
}
