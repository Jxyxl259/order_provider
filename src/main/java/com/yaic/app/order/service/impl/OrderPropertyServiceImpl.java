/*
 * Created By lujicong (2015-12-21 16:02:18)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.order.dao.OrderPropertyDao;
import com.yaic.app.order.dto.custom.PropertyPolicyDto;
import com.yaic.app.order.dto.domain.OrderPropertyDto;
import com.yaic.app.order.service.OrderPropertyService;
import com.yaic.fa.service.BaseService;

@Service("orderPropertyService")
public class OrderPropertyServiceImpl extends BaseService<OrderPropertyDto> implements OrderPropertyService {

    @Autowired
    private OrderPropertyDao orderPropertyDao;

    public int queryPropertyPolicyCount(PropertyPolicyDto propertyPolicyDto) {
        return orderPropertyDao.queryPropertyPolicyCount(propertyPolicyDto);
    }

}
