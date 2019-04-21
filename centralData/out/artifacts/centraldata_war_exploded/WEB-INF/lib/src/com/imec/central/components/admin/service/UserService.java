package com.imec.central.components.admin.service;

import java.util.List;

import com.imec.central.components.admin.pojo.Privilege;
import com.imec.central.components.admin.pojo.User;

public abstract interface UserService {
	/**
	 * 查询所有用户信息
	 */
	public abstract List<User> selectEntity();

	/**
	 * 增加用户
	 */
	public abstract void addUser(User user);

	/**
	 * 删除用户
	 */
	public abstract void deleteUser(int id);

	/**
	 * 修改密码
	 */
	public abstract void updatePassWord(User user);

	/**
	 * 修改用户信息
	 */
	public abstract void updateUser(User user);

	/**
	 * 判断用户是否登录
	 */
	public abstract User getLogin(String name, String pass);

	/**
	 * 加载全部权限信息
	 */
	public abstract List<Privilege> loadAllPrivilege();

	/**
	 * 加载当前登录用户所拥有的权限
	 */
	public abstract List<Privilege> loadLoginPrivilege(int userId);
}
