/*
 * Created By lujicong (2015-12-21 16:02:19)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2015
 */
package com.yaic.app.order.service;

import java.util.List;
import java.util.Map;

import com.yaic.app.order.dto.domain.ShopOrderInfoDto;
import com.yaic.fa.service.IBaseService;

public interface ShopOrderInfoService extends IBaseService<ShopOrderInfoDto> {

    /**
     * 查询记录列表
     * <p>User: lujicong
     * <p>Date: 2015-12-24
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    public List<ShopOrderInfoDto> queryOrderList(Map<String, Object> paramMap);

    /**
     * 查询记录数
     * <p>User: lujicong
     * <p>Date: 2015-12-24
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    public int queryOrderCount(Map<String, Object> paramMap);

}
