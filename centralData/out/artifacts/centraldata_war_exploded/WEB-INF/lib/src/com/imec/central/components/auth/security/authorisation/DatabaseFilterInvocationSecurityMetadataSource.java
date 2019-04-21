package com.imec.central.components.auth.security.authorisation;

/**
 * reference
 * @ http://stackoverflow.com/questions/8381776/dynamic-spring-security-using-sql-query
 * @ http://dgparsons.org/spring-security.html
 */
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import com.imec.central.components.auth.security.event.AccessAttributeRefreshEvent;
import com.imec.central.components.admin.mapper.ResourceMapper;
import com.imec.central.components.admin.pojo.Resource;
import com.imec.central.components.admin.service.ResourceService;
import com.imec.central.components.admin.service.UserService;

public class DatabaseFilterInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource,
		ApplicationListener<AccessAttributeRefreshEvent> {

	private final static String ROLE_PROFIX = "ROLE_";

	private ResourceService resourceService;

	private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

	private ReadWriteLock rwlock = new ReentrantReadWriteLock(); // 读写锁

	/**
	 * Keep in mind that getAttributes will be invoked for every request that
	 * Spring Security intercepts so you will most likely want some sort of
	 * caching.
	 */
	public DatabaseFilterInvocationSecurityMetadataSource(
			ResourceService resourceService) {
		this.resourceService = resourceService;
		loadRequestMap();
	}

	/*
	 * 返回当前请求所需要的角色权限 (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#getAttributes
	 * (java.lang.Object)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		System.out.println("get All getAttributes...");
		final HttpServletRequest request = ((FilterInvocation) object)
				.getRequest();
		rwlock.readLock().lock();// 取到读锁
		try {
			// LinkedHashMap 维持插入顺序，即先插入先访问
			for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
					.entrySet()) {
				// 因此，数据库配置中position靠前（1~N)的规则优先起作用
				if (entry.getKey().matches(request)) {
					return entry.getValue();
				}
			}
		} finally {
			rwlock.readLock().unlock();// 释放读锁
		}

		// 如果没有配置规则，即该资源未进行安全保护
		return null;
	}

	/*
	 * 返回所有角色类型 (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#
	 * getAllConfigAttributes()
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

		rwlock.readLock().lock();// 取到读锁

		try {
			for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
					.entrySet()) {

				allAttributes.addAll(entry.getValue());
			}
		} finally {
			rwlock.readLock().unlock();// 释放读锁
		}

		return allAttributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	private void loadRequestMap() {
		// 从数据库获取所有拦截配置
		// 顺序(1~N)，优先匹配低position的，如果成功，返回；意味着低order的规则优先执行
		List<Resource> accessAttributes = resourceService.loadAllRoleResources();
		// 构造FilterInvocationSecurityMetadataSource的规则集合
		// @RequestMatcher: 拦截url的ANT类型表达式，即资源
		// @Collection<ConfigAttribute>: 对应RequestMatcher的可访问角色集合（Role）
		// LinkedHashMap 维持插入顺序，即先插入先访问
		Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

		// MatcherType matcherType = MatcherType.ant; // 当前仅支持ant形式，不支持
		for (Resource accessAttribute : accessAttributes) {
			String path = accessAttribute.getInterceptUrl();
			// 去掉空的配置
			if (!StringUtils.hasText(path)) {
				continue;
			}
			String roleName = accessAttribute.getRoleName();
			if (!StringUtils.hasText(roleName)) {
				continue;
			}
			// 安全配置，角色名称的封装；实现ConfigAttribute接口
			SecurityConfig securityConfig = new SecurityConfig(ROLE_PROFIX+roleName);
			// 根据配置构造相应的RequestMatcher
			RequestMatcher requestMatcher;
			if ("/**".equals(path) || "**".equals(path)) {
				// 匹配任何规则，尽量不在配置中使用
				requestMatcher = AnyRequestMatcher.INSTANCE;
			} else {
				requestMatcher = new AntPathRequestMatcher(path); // 默认
			}
			// 构造相应的可访问角色集合
			Collection<ConfigAttribute> attributes;
			if (requestMap.containsKey(requestMatcher)) {
				// 该path重复，一个资源可多个角色访问
				attributes = requestMap.get(requestMatcher);
				attributes.add(securityConfig);
			} else {
				// 该path首次分析
				attributes = new LinkedList<ConfigAttribute>();
				attributes.add(securityConfig);
				requestMap.put(requestMatcher, attributes);
			}
		}
		// 更新requestMap
		this.setRequestMap(requestMap);
	}

	public void setRequestMap(
			Map<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
		rwlock.writeLock().lock();// 取到写锁
		try {
			this.requestMap = requestMap;
		} finally {
			rwlock.writeLock().unlock();// 释放写锁
		}
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Override
	public void onApplicationEvent(AccessAttributeRefreshEvent event) {
		this.loadRequestMap();
	}

}
