package com.imec.central.components.admin.mapper;

import java.util.List;
import java.util.Map;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.admin.pojo.Privilege;
import com.imec.central.components.admin.pojo.Role;

@BaseMapper
public abstract interface RoleMapper extends EntityMapper<Role> {
	/**
	 * 获取权限的信息
	 * 
	 * @return
	 */
	public abstract List<Privilege> queryPrivilegeList();

	/**
	 * 根据角色编号查询对应的权限
	 */
	public abstract List<Integer> queryPrivilegeByRoleId(int role_id);

	/**
	 * 获取新增角色的编号
	 */
	public abstract int getMaxRoleId();

	/**
	 * 插入中间表数据
	 */
	public abstract void insertPrivilegeRole(Map<String, Integer> map);

	/**
	 * 根据角色id删除中间表数据
	 */
	public abstract void deletePrivilegeRole(int role_id);

	/**
	 * 根据角色id,查找用户角色表上对应的用户编号，从而删除拥有该角色的所有用户
	 */
	public abstract void deleteAccountByRoleId(int role_id);

	/**
	 * 删除t_account_role表中对应的记录
	 */
	public abstract void deleteAccountRoleByRoleId(int role_id);

	/**
	 * 删除t_role表的对应记录
	 */
	public abstract void deleteRoleById(int id);

	/**
	 * 判断是否有用户拥有该角色
	 */
	public abstract int hasAccount(int role_id);

	/**
	 * 更新角色
	 */
	public abstract void updateRole(Role role);
	
	public abstract List<Role> loadRolesByUser(int accountId);
}
