package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "user_role")
public class UserRole extends IdEntity {
	private User user;
	private Role role;
	private String grantTime;

	public static final String GRANTTIME = "grantTime";

	@NotBlank
	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@NotBlank
	@OneToOne
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGrantTime() {
		return grantTime;
	}

	public void setGrantTime(String grantTime) {
		this.grantTime = grantTime;
	}

}
