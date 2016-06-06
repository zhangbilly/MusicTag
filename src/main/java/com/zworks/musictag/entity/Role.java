package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @date 2016年3月10日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/

@Entity
@Table(name = "role")
public class Role {
	@Id
	private String id;
	private String roleCode;
	private String roleName;
	private String description;

	public static final String ROLECODE = "roleCode";
	public static final String ROLENAME = "roleName";
	public static final String DESCRIPTION = "description";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
