/************************************************************************
 * 描述 ：数据库表CMS_USER对应的Service，代码生成。
 * 作者 ：HZHIHUI
 * 日期 ：2015-11-02 16:26:50
 *
 ************************************************************************/

package com.yaic.app.common.service;

import java.util.List;
import java.util.Map;

import com.yaic.app.common.dto.domain.RoleResourceDto;
import com.yaic.app.common.dto.domain.UserDto;
import com.yaic.app.common.form.UserRoleForm;
import com.yaic.fa.service.IBaseService;

public interface UMUserService extends IBaseService<UserDto> {

    /**
     * 
     * @param userDto
     * @return
     */
    public List<UserDto> selectList(UserDto userDto);

    /**
     * 删除用户列表
     * @param userDto
     * @return
     */
    public int deleteList(List<UserDto> userDtoList);

    /**
     *  查找用户角色
     * @param username
     * @return
     */
    public List<UserRoleForm> findUserRoles(String userCode);

    /**
     * 查找用户权限
     * @param userCode
     * @return
     */
    public List<RoleResourceDto> findUserResources(String userCode);

    /**
     * 根据用户代码修改用户密码
     * @param paraMap
     */
    public void updatePassword(Map<String, String> paraMap);
}
