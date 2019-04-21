package com.imec.central.components.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imec.central.components.admin.mapper.ResourceMapper;
import com.imec.central.components.admin.pojo.Resource;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> loadAllResources() {

		return resourceMapper.loadAllResources();
	}

	@Override
	public List<Resource> loadAllRoleResources() {

		return resourceMapper.loadAllRoleResources();
	}
	
	/**
	 * 加载菜单对应的所有监测资源
	 * @param privilegeId 菜单ID
	 * @return
	 */
	@Override
	public List<Resource> loadResourceByPrivilege(int privilegeId){
		return resourceMapper.loadResourceByPrivilege(privilegeId);
	}

}
