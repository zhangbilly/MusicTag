/**
 * 
 */
package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年5月21日上午10:45:51
 *
 */
@Entity
@Table(name = "songandlist")
public class SongAndList extends IdEntity{
	
	private SongList songList;

	private Song song;

	private Integer position;
	
	private Long addTime;
	
	@ManyToOne
	@JoinColumn(name="songlist_id")
	public SongList getSongList() {
		return songList;
	}
	public void setSongList(SongList songList) {
		this.songList = songList;
	}
	@ManyToOne
	@JoinColumn(name="song_id")
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}

	@NotNull
	public Long getAddTime() {
		return addTime;
	}
	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
}
