/*
 * Created By lujicong (2016-05-25 17:42:32)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.order.dao.OrderItemAcciLstDao;
import com.yaic.app.order.dto.domain.OrderItemAcciLstDto;
import com.yaic.app.order.dto.domain.ShopOrderGoodsDto;
import com.yaic.app.order.service.OrderItemAcciLstService;
import com.yaic.fa.service.BaseService;

@Service("orderItemAcciLstService")
public class OrderItemAcciLstServiceImpl extends BaseService<OrderItemAcciLstDto> implements OrderItemAcciLstService {
	@Autowired
	private OrderItemAcciLstDao orderItemAcciLstDao;
	
	/**
     * 被保人保单信息查询（意健险）
     * <p>User: admin
     * <p>Date: 2017年5月24日
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    public List<ShopOrderGoodsDto> orderInfoQuery(Map<String, Object> paramMap) {
        return orderItemAcciLstDao.orderInfoQuery(paramMap);
    }
}
