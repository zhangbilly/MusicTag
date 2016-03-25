package com.zworks.musictag.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

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

	public Page<Album> getAlbums(String albumName, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Album> spec = buildSpecification(albumName, searchParams);

		return albumDao.findAll(spec, pageRequest);
	}

	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = new Sort(Direction.ASC, Album.ALBUMNAME);
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Album> buildSpecification(String albumName, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		if (StringUtils.isNotBlank(albumName))
			filters.put(Album.ALBUMNAME, new SearchFilter(Album.ALBUMNAME, Operator.LIKE, albumName));
		Specification<Album> spec = DynamicSpecifications.bySearchFilter(filters.values(), Album.class);
		return spec;
	}
}
