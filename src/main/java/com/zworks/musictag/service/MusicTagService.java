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

import com.zworks.musictag.entity.MusicTag;
import com.zworks.musictag.repository.MusicTagDao;

/**
 * @date 2016年3月22日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Service
public class MusicTagService {
	@Autowired
	private MusicTagDao musicTagDao;

	public Page<MusicTag> getSongsByTag(Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<MusicTag> spec = buildSpecification(searchParams);
		Page<MusicTag> musicTagList = musicTagDao.findAll(spec, pageRequest);

		return musicTagList;
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<MusicTag> buildSpecification(Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<MusicTag> spec = DynamicSpecifications.bySearchFilter(filters.values(), MusicTag.class);
		return spec;
	}

	public void save(MusicTag musicTag) {
		musicTagDao.save(musicTag);

	}
}
