/*
 * Created By lujicong (2015-12-23 10:04:01)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dao;

import java.util.List;
import java.util.Map;

import com.yaic.app.order.dto.domain.OrderCustomerDto;
import com.yaic.app.order.dto.domain.ShopOrderGoodsDto;
import com.yaic.fa.dao.BaseDao;

public interface OrderCustomerDao extends BaseDao<OrderCustomerDto> {
  
	/**
     * 查询userid、ordercode
     * <p>User: lishuang
     * <p>Date: 2015-12-24
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
	public List<ShopOrderGoodsDto> orderInfoQuery(Map<String,Object> paramMap);
	
}
