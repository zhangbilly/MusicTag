package com.zworks.musictag.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.zworks.musictag.entity.SongAndList;
import com.zworks.musictag.entity.SongList;
import com.zworks.musictag.entity.User;
import com.zworks.musictag.repository.SongAndListDao;
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
	@Autowired
	private SongAndListDao songAndListDao;

	public SongList save(SongList songList) {
		if (songList.getId() == null) {
			songList.setCreateTime(DataUtils.getCurrectTime());
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			songList.setCreator(new User(user.id));
		}
		return songListDao.save(songList);

	}

	public SongList getSongListById(Long songListId) {
		return songListDao.findOne(songListId);
	}

	public Page<SongList> getSongLists(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<SongList> spec = buildSpecification(searchParams);
		return songListDao.findAll(spec, pageRequest);
	}

	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = new Sort(Direction.ASC, SongList.NAME);
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<SongList> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<SongList> spec = DynamicSpecifications.bySearchFilter(filters.values(), SongList.class);
		return spec;
	}

	/**
	 * @param songList
	 * @return
	 */
	@Transactional
	public SongList addSongList(SongList songList) {
		songList.setCreateTime(DataUtils.getCurrectTime());
		if(songList.getSongs()!=null){
			songList.setTrackCount(songList.getSongs().size());
		}
		songListDao.save(songList);
		if(songList.getSongs()!=null){
			for(SongAndList song:songList.getSongs()){
				song.setAddTime(System.currentTimeMillis());
				song.setSongList(new SongList(songList.getId()));
			}
		}
		songAndListDao.save(songList.getSongs());
		return songList;
	}

}
