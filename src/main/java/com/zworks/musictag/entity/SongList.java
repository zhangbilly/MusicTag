package com.zworks.musictag.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	
	private String createTime;

	private String updateTime;
	private int trackCount;
	private String coverImg;
	
	
	private List<SongAndList> songs;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String CREATOR = "creator";
	public static final String CREATETIME = "createTime";
	public static final String UPDATETIME = "updateTime";
	public static final String TRACKCOUNT = "trackCount";
	public static final String COVERIMG = "coverImg";

	/**
	 * 
	 */
	public SongList() {
		// TODO Auto-generated constructor stub
	}
	public SongList(Long id){
		this.id=id;
	}
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
	@Column(updatable = false)
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

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	@OneToMany(mappedBy="songList")
	public List<SongAndList> getSongs() {
		return songs;
	}

	public void setSongs(List<SongAndList> songs) {
		this.songs = songs;
	}

	public int getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}
}
