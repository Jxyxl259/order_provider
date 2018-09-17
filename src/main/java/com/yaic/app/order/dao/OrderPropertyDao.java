/*
 * Created By lujicong (2015-12-21 16:02:18)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dao;

import com.yaic.app.order.dto.custom.PropertyPolicyDto;
import com.yaic.app.order.dto.domain.OrderPropertyDto;
import com.yaic.fa.dao.BaseDao;

public interface OrderPropertyDao extends BaseDao<OrderPropertyDto> {
    
    public int queryPropertyPolicyCount(PropertyPolicyDto propertyPolicyDto);
    
}
