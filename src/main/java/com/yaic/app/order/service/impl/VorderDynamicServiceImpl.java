/*
 * Created By lujicong (2016-05-30 14:58:07)
 * Homepage https://github.com/lujicong
 * Since 2013 - 2016
 */
package com.yaic.app.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaic.app.order.dao.VorderDynamicDao;
import com.yaic.app.order.dto.domain.VorderDynamicDto;
import com.yaic.app.order.service.VorderDynamicService;
import com.yaic.fa.service.BaseService;

@Service("vorderDynamicService")
public class VorderDynamicServiceImpl extends BaseService<VorderDynamicDto> implements VorderDynamicService {

    @Autowired
    private VorderDynamicDao vorderDynamicDao;

    /**
     * 重复投保查询列表
     * <p>User: lipengfei
     * <p>Date: 2016年5月30日
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    public List<VorderDynamicDto> queryOrderRepeated(Map<String, Object> paramMap) {
        return vorderDynamicDao.queryOrderRepeated(paramMap);
    }

    /**
     * 查询重复投保数
     * <p>User: lipengfei
     * <p>Date: 2016年5月30日
     * <p>Version: 1.0
     * @param paramMap
     * @return
     */
    public int queryOrderRepeatCount(Map<String, Object> paramMap) {
        return vorderDynamicDao.queryOrderRepeatCount(paramMap);
    }

}
