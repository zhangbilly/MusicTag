package com.zworks.musictag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zworks.musictag.entity.Song;
import com.zworks.musictag.repository.SongDao;

/**
 * @date 2016年3月21日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Service
public class SongService {
	@Autowired
	private SongDao songDao;

	public Song save(Song song) {
		return songDao.save(song);
	}
}
