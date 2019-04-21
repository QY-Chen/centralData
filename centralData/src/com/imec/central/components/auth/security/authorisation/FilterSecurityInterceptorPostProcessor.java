package com.imec.central.components.auth.security.authorisation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.util.Assert;

public class FilterSecurityInterceptorPostProcessor implements
		BeanPostProcessor, InitializingBean {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	public Object postProcessAfterInitialization(Object bean, String name) {

		
		/**
		 * FilterSecurityInterceptor是Spring Security的授权节点
		 */
		if (bean instanceof FilterSecurityInterceptor) {
			((FilterSecurityInterceptor) bean)
					.setSecurityMetadataSource(securityMetadataSource);
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String name) {
		return bean;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(securityMetadataSource,
				"securityMetadataSource cannot be null");
	}
}
