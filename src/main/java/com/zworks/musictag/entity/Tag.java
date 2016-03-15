/**
 * 
 */
package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年3月3日下午11:30:16
 *
 */
@Entity
@Table(name = "tag")
public class Tag extends IdEntity {
	private String name;
	private String createTime;
	private User creator;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@ManyToOne
	@JoinColumn(name = "creator")
	@JsonIgnore
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
}
