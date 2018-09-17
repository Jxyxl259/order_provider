/*
 * Created By lujicong (2015-12-21 16:02:20)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.dao;

import com.yaic.app.order.dto.domain.ShopOrderPayinfoDto;
import com.yaic.fa.dao.BaseDao;

public interface ShopOrderPayinfoDao extends BaseDao<ShopOrderPayinfoDto> {
    
    public ShopOrderPayinfoDto forUpdateShopOrderPayInfoByPk(ShopOrderPayinfoDto shopOrderPayinfoDto);
    
}
