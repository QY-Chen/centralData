package com.imec.central.components.admin.mapper;

import java.util.List;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.admin.pojo.Resource;

@BaseMapper
public interface ResourceMapper{
	/**
	 * 加载所有的监测资源
	 * @return
	 */
	public List<Resource> loadAllResources();
	/**
	 * 加载所有角色的所有监测资源
	 * @return
	 */
	public List<Resource> loadAllRoleResources();
	
	/**
	 * 加载菜单对应的所有监测资源
	 * @param privilegeId 菜单ID
	 * @return
	 */
	public List<Resource> loadResourceByPrivilege(int privilegeId);
}
