/************************************************************************
 * 描述 ：数据库表CMS_MAPPING对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-20 10:30:00
 *
 ************************************************************************/

package com.yaic.app.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yaic.app.common.dao.MappingDao;
import com.yaic.app.common.dto.domain.MappingDto;
import com.yaic.app.common.service.MappingService;
import com.yaic.fa.service.BaseService;

@Service("mappingService")
public class MappingServiceImpl extends BaseService<MappingDto> implements MappingService {

    private MappingDao getMappingDao() {
        return (MappingDao) this.getBaseDao();
    }

    /**
     * 代码转换名称模糊查询
     * 
     * @param mappingName
     * @return
     */
    public List<MappingDto> findByMappingName(Map<String, String> paraMap) {
        return getMappingDao().findByMappingName(paraMap);
    }
}
