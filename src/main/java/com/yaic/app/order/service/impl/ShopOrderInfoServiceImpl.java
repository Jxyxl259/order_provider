/*
 * Created By lujicong (2015-12-21 16:02:19)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.order.dao.ShopOrderInfoDao;
import com.yaic.app.order.dto.domain.ShopOrderInfoDto;
import com.yaic.app.order.service.ShopOrderInfoService;
import com.yaic.fa.service.BaseService;

@Service("shopOrderInfoService")
public class ShopOrderInfoServiceImpl extends BaseService<ShopOrderInfoDto> implements ShopOrderInfoService {
    
    @Autowired
    private ShopOrderInfoDao shopOrderInfoDao;

    /**
     * 查询记录列表
     * <p>User: lujicong
     * <p>Date: 2015-12-24
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    public List<ShopOrderInfoDto> queryOrderList(Map<String, Object> paramMap) {
        return shopOrderInfoDao.queryOrderList(paramMap);
    }

    /**
     * 查询记录数
     * <p>User: lujicong
     * <p>Date: 2015-12-24
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    public int queryOrderCount(Map<String, Object> paramMap) {
        return shopOrderInfoDao.queryOrderCount(paramMap);
    }
}
