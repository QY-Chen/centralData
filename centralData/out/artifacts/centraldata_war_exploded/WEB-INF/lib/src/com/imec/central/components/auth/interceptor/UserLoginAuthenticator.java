package com.imec.central.components.auth.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.imec.central.components.auth.security.pojo.LoginUser;
import com.imec.central.components.admin.mapper.UserMapper;
import com.imec.central.components.admin.pojo.Privilege;
import com.imec.central.util.PropertiesUtils;
import com.imec.central.util.SecurityUtils;
import com.imec.central.util.URLUtils;

public class UserLoginAuthenticator implements HandlerInterceptor {

	private List<Privilege> allPrivileges;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {

		HttpSession session = request.getSession();
		String loginUrl = PropertiesUtils.getPropertiesValue("default.login.url", "config");
		if (session != null) {
			Object user = session.getAttribute("User");
			if (user != null) {
//				response.addHeader("Access-Control-Allow-Origin", "*");
				Boolean havePrivilege= requestHavePrivilege(request);
				 if(havePrivilege == null || havePrivilege == true){
					 return true;
				 }else{
					 //如果没有对应权限，则跳转到默认页面
					 LoginUser loginUser = (LoginUser) SecurityUtils.getCurrentUser();
					String redirectUrl = loginUser.getDefaultUrl();
					response.sendRedirect(request.getContextPath() + redirectUrl);
					return false;
				 }
			} else {
				response.sendRedirect(request.getContextPath() + loginUrl);
				return false;
			}
		}
		response.sendRedirect(request.getContextPath() + loginUrl);
		return false;
	}
	
	@Autowired
	private UserMapper userMapper;
	/**
	 * 请求地址权限判断
	 * @param request
	 * @return null(请求地址不在权限判断范围内) true,flase(用户有，无权限)
	 */
	private Boolean requestHavePrivilege(HttpServletRequest request){
		String requestUrl = URLUtils.getUrlNoParamFromRequestUrl(request.getRequestURI());
		/*
		 * 第一步，先判断请求地址是否属于权限地址
		 * 如果请求地址与所有权限地址不匹配，返回null
		 */
		List<Privilege> allPrivileges = getAllPrivileges();
		Boolean isPrivilegeUrl = false;
		for(Privilege p :allPrivileges){
			String privilegeUrl = URLUtils.getUrlNoParamFromRequestUrl(p.getUrl());
			if (requestUrl.equals(privilegeUrl)) {
				isPrivilegeUrl = true;
			}
		}
		
		if(!isPrivilegeUrl){
			return null;
		}
		/*
		 * 第二步：在判断用户是否拥有请求地址的权限
		 */
		Object loginPrivilege = request.getSession().getAttribute("loginPrivilege");
		if(loginPrivilege == null){
			return false;
		}
		List<Privilege> paths = (List<Privilege>)loginPrivilege;
		for (Privilege p : paths) {
			String privilegeUrl = URLUtils.getUrlNoParamFromRequestUrl(p.getUrl());
			if (requestUrl.equals(privilegeUrl)) {
				return true;
			}
		}
		return false;
	}
	
	private List<Privilege> getAllPrivileges(){
		if(allPrivileges == null){
			allPrivileges = userMapper.loadAllPrivilege();
		}
		return allPrivileges;
	}
}
