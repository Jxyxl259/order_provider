/*
 * Created By lujicong (2015-12-21 16:02:20)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.order.dao.ShopOrderPayinfoDao;
import com.yaic.app.order.dto.domain.ShopOrderPayinfoDto;
import com.yaic.app.order.service.ShopOrderPayinfoService;
import com.yaic.fa.service.BaseService;

@Service("shopOrderPayinfoService")
public class ShopOrderPayinfoServiceImpl extends BaseService<ShopOrderPayinfoDto> implements ShopOrderPayinfoService {
    
    @Autowired
    private ShopOrderPayinfoDao shopOrderPayinfoDao;
    
    public ShopOrderPayinfoDto forUpdateShopOrderPayInfoByPk(ShopOrderPayinfoDto shopOrderPayinfoDto) {
        return shopOrderPayinfoDao.forUpdateShopOrderPayInfoByPk(shopOrderPayinfoDto);
    }

}
