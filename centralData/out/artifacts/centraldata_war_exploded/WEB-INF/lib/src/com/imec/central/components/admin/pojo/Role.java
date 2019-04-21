package com.imec.central.components.admin.pojo;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;// 角色编号
	private String name;// 角色名称
	private String remark;// 角色描述
	private String indexUrl;// 首页url
	private String indexRemark;// 首页描述
	private Integer[] ids;

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}

	public String getIndexRemark() {
		return indexRemark;
	}

	public void setIndexRemark(String indexRemark) {
		this.indexRemark = indexRemark;
	}

	public Role() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
