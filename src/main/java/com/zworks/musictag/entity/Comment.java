package com.zworks.musictag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.zworks.musictag.entity.enumerate.CommentType;

/**
 * @date 2016年5月11日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Entity
@Table(name = "comments")
public class Comment extends IdEntity {

	private User user;

	private Long time;

	private Long likedCount;

	private String content;

	private Comment beReplied;

	private CommentType type;

	private String resourceId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(updatable = false)
	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getLikedCount() {
		return likedCount;
	}

	public void setLikedCount(Long likedCount) {
		this.likedCount = likedCount;
	}

	@NotBlank
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "be_replied")
	public Comment getBeReplied() {
		return beReplied;
	}

	public void setBeReplied(Comment beReplied) {
		this.beReplied = beReplied;
	}

	@Enumerated(EnumType.STRING)
	public CommentType getType() {
		return type;
	}

	public void setType(CommentType type) {
		this.type = type;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

}
