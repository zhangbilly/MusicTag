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
@Table(name = "user_role")
public class UserRole {
	@Id
	private String id;
	private String userId;
	private String roleId;
	private String grantTime;

	public static final String GRANTTIME = "grantTime";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getGrantTime() {
		return grantTime;
	}

	public void setGrantTime(String grantTime) {
		this.grantTime = grantTime;
	}

}
