/************************************************************************
 * 描述 ：数据库表CMS_PARAMETER_TYPE对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-17 09:06:38
 *
 ************************************************************************/

package com.yaic.app.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yaic.app.common.dao.ParameterTypeDao;
import com.yaic.app.common.dto.AutoCompleteDto;
import com.yaic.app.common.dto.domain.ParameterTypeDto;
import com.yaic.app.common.service.ParameterTypeService;
import com.yaic.fa.service.BaseService;

@Service("parameterTypeService")
public class ParameterTypeServiceImpl extends BaseService<ParameterTypeDto> implements ParameterTypeService {

    private ParameterTypeDao getParameterTypeDao() {
        return (ParameterTypeDao) this.getBaseDao();
    }

    public List<ParameterTypeDto> getRecordsByType(Map<String, String> paraMap) {
        return getParameterTypeDao().getRecordsByType(paraMap);
    }

    public List<AutoCompleteDto> getAcDataList(Map<String, String> paraMap) {
        return getParameterTypeDao().getAcDataList(paraMap);
    }

}
