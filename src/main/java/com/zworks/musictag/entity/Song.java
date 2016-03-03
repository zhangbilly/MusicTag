/**
 * 
 */
package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年3月3日下午11:25:56
 *
 */
@Entity
@Table(name="song")
public class Song extends IdEntity{
	private String songName;
	private Singer singer;
	private Album album;
	@NotBlank
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	@NotBlank
	@OneToOne
	@JoinColumn(name="pk_singer")
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	@NotBlank
	@OneToOne
	@JoinColumn(name="pk_album")
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	

}
