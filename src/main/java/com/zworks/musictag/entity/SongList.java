package com.zworks.musictag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @date 2016年3月31日
 *
 * @author zhangqiang6
 *
 * @Description: 歌单实体类
 *
 **/
@Entity
@Table(name = "songlist")
public class SongList extends IdEntity {
	private String name;
	private String description;
	private User creator;

	@Column(updatable = false)
	private String createTime;

	private String updateTime;
	private String trackCount;
	private String coverImg;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String CREATOR = "creator";
	public static final String CREATETIME = "createTime";
	public static final String UPDATETIME = "updateTime";
	public static final String TRACKCOUNT = "trackCount";
	public static final String COVERIMG = "coverImg";

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name = "creator", updatable = false)
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(String trackCount) {
		this.trackCount = trackCount;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

}
