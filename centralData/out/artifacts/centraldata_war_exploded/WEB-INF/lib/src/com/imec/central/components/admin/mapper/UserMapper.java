package com.imec.central.components.admin.mapper;

import java.util.List;
import java.util.Map;

import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.admin.pojo.Privilege;
import com.imec.central.components.admin.pojo.User;
import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.CentralMapper;


/**
 * UserMapper(dao操作)映射器接口，生成的映射器默认是小写类名
 */
@BaseMapper
public abstract interface UserMapper extends EntityMapper<User> {
	/**
	 * 获取新增用户的编号
	 */
	public abstract int getMaxId();

	/**
	 * 添加新用户的角色
	 */
	public abstract void addAccount_Role(Map<String, Integer> map);

	/**
	 * 根据id删除用户
	 */
	public abstract void deleteUserById(int id);

	/**
	 * 删除该用户所拥有的角色
	 */
	public abstract void deleteUserJoinRole(int id);

	/**
	 * 更新用户密码
	 */
	public abstract void updatePassWord(User user);

	/**
	 * 更新用户的描述和角色编号
	 */
	public abstract void updateRemark(User user);

	public abstract void updateRoleId(User user);

	/**
	 * 获取登录用户
	 */
	public abstract User getLoginUser(Map<String, String> map);

	/**
	 * 查询所有的权限信息
	 */
	public abstract List<Privilege> loadAllPrivilege();

	/**
	 * 查询该登录用户的所拥有的所有权限
	 */
	public abstract List<Privilege> loadLoginPrivilege(int account_id);
}
