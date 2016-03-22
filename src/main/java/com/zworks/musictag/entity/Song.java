/**
 * 
 */
package com.zworks.musictag.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年3月3日下午11:25:56
 *
 */
@Entity
@Table(name = "song")
public class Song extends IdEntity {
	private String songName;
	private Singer singer;
	private Album album;
	private String duration;

	public static final String SONGNAME = "songName";
	public static final String SINGER = "singer";
	public static final String ALBUM = "album";
	public static final String DURATION = "duration";

	@NotBlank
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	@ManyToOne
	@JoinColumn(name = "singer_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	@ManyToOne
	@JoinColumn(name = "album_id")
	@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

}
