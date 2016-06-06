/**
 * 
 */
package com.zworks.musictag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年5月21日上午10:45:51
 *
 */
@Entity
@Table(name = "songandlist")
public class SongAndList {
	@Id
	private String id;

	@Column(name = "songlist_id")
	private String songListId;

	private String songId;

	private Integer position;

	private Long addTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSongListId() {
		return songListId;
	}

	public void setSongListId(String songListId) {
		this.songListId = songListId;
	}

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Long getAddTime() {
		return addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

}
