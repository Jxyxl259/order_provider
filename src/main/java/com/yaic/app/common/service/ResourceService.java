/************************************************************************
 * 描述 ：数据库表${tableInfo.tableOriginalName}对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-02 16:26:50
 *
 ************************************************************************/

package com.yaic.app.common.service;

import java.util.HashMap;
import java.util.List;

import com.yaic.app.common.dto.TreeNode;
import com.yaic.app.common.dto.domain.ResourceDto;
import com.yaic.fa.service.IBaseService;

public interface ResourceService extends IBaseService<ResourceDto> {

    public String getMenu(String userId);

    public List<ResourceDto> getResource(HashMap<String, String> condition);

    /**
     * save
     */
    public int saveResource(ResourceDto resourceDto);

    /**
     * 查找所有菜单资源
     */
    public List<TreeNode> findAllMenuResource();

    /**
     * 查找所有服务资源
     */
    public List<TreeNode> findAllServiceResource();

    /**
     * 查询最大资源ID
     * @return
     */
    public List<ResourceDto> findMaxResourceId();
}
