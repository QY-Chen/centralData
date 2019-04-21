package com.imec.central.components.auth.security.event;

import org.springframework.context.ApplicationEvent;

/**
 * 
 * @author mulan
 *
 */
public class AccessAttributeRefreshEvent extends ApplicationEvent {

	public AccessAttributeRefreshEvent(Object source) {
		super(source);
	}

}