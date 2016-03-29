package com.zworks.musictag.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

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

	public Page<Song> getSongs(Map<String, Object> searchParams, int pageNumber, int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Song> spec = buildSpecification(searchParams);
		return songDao.findAll(spec, pageRequest);
	}

	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = new Sort(Direction.ASC, Song.SONGNAME);
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Song> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<Song> spec = DynamicSpecifications.bySearchFilter(filters.values(), Song.class);
		return spec;
	}

	public Song getSong(Map<String, Object> searchParams) {
		Specification<Song> spec = buildSpecification(searchParams);
		Song song = songDao.findOne(spec);
		return song;
	}
}
