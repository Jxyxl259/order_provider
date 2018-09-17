/************************************************************************
 * 描述 ：数据库表CMS_ROLE对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-02 16:26:50
 *
 ************************************************************************/

package com.yaic.app.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yaic.app.common.dao.RoleDao;
import com.yaic.app.common.dto.TreeNode;
import com.yaic.app.common.dto.domain.RoleDto;
import com.yaic.app.common.service.RoleService;
import com.yaic.fa.service.BaseService;

@Service("roleService")
public class RoleServiceImpl extends BaseService<RoleDto> implements RoleService {

    private RoleDao getRoleDao() {
        return (RoleDao) this.getBaseDao();
    }

    /**
     * 查找所有的角色
     * 
     * @return
     */
    @Override
    public List<RoleDto> findAllRoles() {
        return getRoleDao().findAllRoles();
    }

    /**
     * 查找角色关联的资源
     * 
     * @param paraMap
     * @return
     */
    @Override
    public List<TreeNode> findAllResourceByRole(Map<String, String> paraMap) {
        return getRoleDao().findAllResourceByRole(paraMap);
    }

    /**
     * 保存角色资源
     * 
     * @param reqMap
     */
    @Override
    @SuppressWarnings("unchecked")
    public void saveRoleResource(Map<String, Object> reqMap) {

        // 删除角色资源
        getRoleDao().delRowResource((String) reqMap.get("roleId"));

        // 保存
        if (((List<String>) reqMap.get("resourceIds")).size() > 0) {
            getRoleDao().saveRoleResource(reqMap);
        }

    }

    /**
     * 保存角色
     * 
     * @param roleDto
     */
    @Override
    public void saveRole(RoleDto roleDto) {
        insertNotNull(roleDto);
    }

    /**
     * 修改角色
     * 
     * @param roleDto
     */
    @Override
    public void updateRole(RoleDto roleDto) {
        updateByPrimaryKeyNotNull(roleDto);
    }

    /**
     * 删除角色
     * 
     * @param roleId
     */
    @Override
    public void delRole(String roleId) {

        // 角色
        getRoleDao().delRow(roleId);
        // 角色资源
        getRoleDao().delRowResource(roleId);
    }

    /**
     * 禁用角色
     * 
     * @param roleIds
     */
    @Override
    public void updateRoleState(List<String> roleIds) {

        getRoleDao().updateRoleState(roleIds);
    }

    /**
     * 查询列表
     * 
     * @param paraMap
     * @return
     */
    @Override
    public List<RoleDto> getRecordsByConditions(Map<String, String> paraMap) {
        return getRoleDao().getRecordsByConditions(paraMap);
    }

}
