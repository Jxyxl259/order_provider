/*
 * Created By lujicong (2015-12-21 16:02:20)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service;

import com.yaic.app.order.dto.domain.ShopOrderPayinfoDto;
import com.yaic.fa.service.IBaseService;

public interface ShopOrderPayinfoService extends IBaseService<ShopOrderPayinfoDto> {
    
    public ShopOrderPayinfoDto forUpdateShopOrderPayInfoByPk(ShopOrderPayinfoDto shopOrderPayinfoDto);
    
}
