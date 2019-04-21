package com.imec.central.components.auth.security.authentication;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.common.collect.Sets;
import com.imec.central.components.auth.security.mapper.LoginUserMapper;
import com.imec.central.components.auth.security.pojo.LoginUser;
import com.imec.central.components.admin.mapper.RoleMapper;
import com.imec.central.components.admin.pojo.Role;

/**
 * spring security安全机制－用于从数据库加载用户
 * 
 * @author mulan
 * 
 */
public class BasicUserDetailsServiceImpl implements UserDetailsService {

	private final static String ROLE_PROFIX = "ROLE_";
	
	/**
	 * 登录用户访问接口
	 */
	@Autowired
	private LoginUserMapper loginUserMapper;

	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 从数据库获取登录用户信息
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		LoginUser loginUser = null;
		try {
			// 从数据库获取用户
			loginUser = loginUserMapper.loadUserByUsername(username);
			// 用户不存在
			if (loginUser == null) {
				throw new UsernameNotFoundException("用户" + username + " 不存在!");
			}
			Integer userId = loginUser.getId();
			//设置登陆用户的角色
			List<Role> roles = roleMapper.loadRolesByUser(userId);
			if(roles==null||roles.size() == 0){
				throw new UsernameNotFoundException("用户" + username + " 不存在!");
			}
			loginUser.setRoles(roles);
			// 设置登录用户的权限
			Set<GrantedAuthority> authorities = Sets.newHashSet();
			for(Role role: roles){
				authorities.add(new SimpleGrantedAuthority(ROLE_PROFIX+role.getName()));
			}
			loginUser.setAuthorities(authorities);
			
			//设置用户登陆成功后打开页面
			loginUser.setDefaultUrl(roles.get(0).getIndexUrl());
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		// 返回登录用户
		return loginUser;
	}

	/*
	 * Getter and Setter
	 */
	public LoginUserMapper getLoginUserMapper() {
		return loginUserMapper;
	}

	public void setLoginUserMapper(LoginUserMapper loginUserMapper) {
		this.loginUserMapper = loginUserMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	
}

