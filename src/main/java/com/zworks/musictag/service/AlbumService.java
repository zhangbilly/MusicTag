package com.zworks.musictag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zworks.musictag.entity.Album;
import com.zworks.musictag.repository.AlbumDao;

/**
 * @date 2016年3月23日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Service
public class AlbumService {
	@Autowired
	private AlbumDao albumDao;

	public Album save(Album album) {
		return albumDao.save(album);
	}
}
