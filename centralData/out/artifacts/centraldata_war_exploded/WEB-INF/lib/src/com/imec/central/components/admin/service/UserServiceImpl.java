package com.imec.central.components.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imec.central.components.admin.mapper.UserMapper;
import com.imec.central.components.admin.pojo.Privilege;
import com.imec.central.components.admin.pojo.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectEntity() {
		return userMapper.selectEntity("");
	}

	@Override
	public void addUser(User user) {
		userMapper.addEntity(user);
		int maxId = userMapper.getMaxId();
		for(Integer roleId : user.getAllRoleIds()){
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("account_id", maxId);
			map.put("role_id", roleId);
			userMapper.addAccount_Role(map);
		}
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteUserById(id);
		userMapper.deleteUserJoinRole(id);
	}

	@Override
	public void updatePassWord(User user) {
		userMapper.updatePassWord(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateRemark(user);
		userMapper.updateRoleId(user);
	}

	@Override
	public User getLogin(String name, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("pass", pass);
		return userMapper.getLoginUser(map);
	}

	@Override
	public List<Privilege> loadAllPrivilege() {
		return userMapper.loadAllPrivilege();
	}

	@Override
	public List<Privilege> loadLoginPrivilege(int userId) {
		return userMapper.loadLoginPrivilege(userId);
	}

}
