/*
 * Created By lujicong (2016-05-25 17:42:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.dao;

import java.util.List;
import java.util.Map;

import com.yaic.app.order.dto.domain.OrderItemAcciLstDto;
import com.yaic.app.order.dto.domain.ShopOrderGoodsDto;
import com.yaic.fa.dao.BaseDao;

public interface OrderItemAcciLstDao extends BaseDao<OrderItemAcciLstDto> {

	/**
     *  被保人保单信息查询（意健险）
     * <p>User: MASK
     * <p>Date: 2017年5月24日
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
	public List<ShopOrderGoodsDto> orderInfoQuery(Map<String,Object> paramMap);
	
}
