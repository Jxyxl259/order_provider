/*
 * Created By lujicong (2015-12-21 16:02:18)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service;

import com.yaic.app.order.dto.custom.PropertyPolicyDto;
import com.yaic.app.order.dto.domain.OrderPropertyDto;
import com.yaic.fa.service.IBaseService;

public interface OrderPropertyService extends IBaseService<OrderPropertyDto> {

    public int queryPropertyPolicyCount(PropertyPolicyDto propertyPolicyDto);

}
