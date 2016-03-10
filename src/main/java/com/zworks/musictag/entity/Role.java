package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

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
public class Role extends IdEntity {
	private String roleCode;
	private String roleName;
	private String description;

	public static final String ROLECODE = "roleCode";
	public static final String ROLENAME = "roleName";
	public static final String DESCRIPTION = "description";

	@NotBlank
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@NotBlank
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
