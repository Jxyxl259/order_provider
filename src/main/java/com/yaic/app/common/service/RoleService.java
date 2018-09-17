/************************************************************************
 * 描述 ：数据库表CMS_ROLE对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-02 16:26:50
 *
 ************************************************************************/

package com.yaic.app.common.service;

import java.util.List;
import java.util.Map;

import com.yaic.app.common.dto.TreeNode;
import com.yaic.app.common.dto.domain.RoleDto;
import com.yaic.fa.service.IBaseService;

public interface RoleService extends IBaseService<RoleDto> {

    /**
     * 查找所有的角色
     * @return
     */
    public List<RoleDto> findAllRoles();

    /**
     * 查找角色关联的资源
     * @param paraMap
     * @return
     */
    public List<TreeNode> findAllResourceByRole(Map<String, String> paraMap);

    /**
     * 保存角色资源
     * @param reqMap
     */
    public void saveRoleResource(Map<String, Object> reqMap);

    /**
     * 保存角色
     * @param roleDto
     */
    public void saveRole(RoleDto roleDto);

    /**
     * 修改角色
     * @param roleDto
     */
    public void updateRole(RoleDto roleDto);

    /**
     * 删除角色
     * @param roleId
     */
    public void delRole(String roleId);

    /**
     * 禁用角色
     * @param roleIds
     */
    public void updateRoleState(List<String> roleIds);

    /**
     * 查询列表
     * @param paraMap
     * @return
     */
    public List<RoleDto> getRecordsByConditions(Map<String, String> paraMap);

}
