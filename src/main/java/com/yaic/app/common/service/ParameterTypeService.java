/************************************************************************
 * 描述 ：数据库表CMS_PARAMETER_TYPE对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-17 09:06:38
 *
 ************************************************************************/

package com.yaic.app.common.service;

import java.util.List;
import java.util.Map;

import com.yaic.app.common.dto.AutoCompleteDto;
import com.yaic.app.common.dto.domain.ParameterTypeDto;
import com.yaic.fa.service.IBaseService;

public interface ParameterTypeService extends IBaseService<ParameterTypeDto> {

    public List<ParameterTypeDto> getRecordsByType(Map<String, String> paraMap);

    public List<AutoCompleteDto> getAcDataList(Map<String, String> paraMap);

}
