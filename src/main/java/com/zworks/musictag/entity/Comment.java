package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class Comment {
	@Id
	private String id;

	private String userId;

	private Long time;

	private Long likedCount;

	private String content;

	private String beReplied;

	private CommentType type;

	private String resourceId;

	public static final String USER = "user";
	public static final String TIME = "time";
	public static final String LIKEDCOUNT = "likedCount";
	public static final String CONTENT = "content";
	public static final String BEREPLIED = "beReplied";
	public static final String TYPE = "type";
	public static final String RESOURCEID = "resourceId";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setBeReplied(String beReplied) {
		this.beReplied = beReplied;
	}

	public String getBeReplied() {
		return beReplied;
	}

}
