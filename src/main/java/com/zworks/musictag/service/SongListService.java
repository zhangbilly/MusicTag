package com.zworks.musictag.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zworks.musictag.entity.SongList;
import com.zworks.musictag.entity.User;
import com.zworks.musictag.repository.SongListDao;
import com.zworks.musictag.service.ShiroDbRealm.ShiroUser;
import com.zworks.musictag.utils.DataUtils;

/**
 * @date 2016年3月31日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Service
public class SongListService {
	@Autowired
	private SongListDao songListDao;

	public SongList save(SongList songList) {
		if (songList.getId() == null) {
			songList.setCreateTime(DataUtils.getCurrectTime());
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			songList.setCreator(new User(user.id));
		}
		return songListDao.save(songList);

	}

}
