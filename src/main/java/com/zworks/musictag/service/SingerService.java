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

import com.zworks.musictag.entity.Singer;
import com.zworks.musictag.repository.SingerDao;

/**
 * @date 2016年3月21日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Service
public class SingerService {
	@Autowired
	private SingerDao singerDao;

	public Page<Singer> getSingers(String singerName, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Singer> spec = buildSpecification(singerName, searchParams);

		return singerDao.findAll(spec, pageRequest);
	}

	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = new Sort(Direction.ASC, Singer.SINGERNAME);
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Singer> buildSpecification(String singerName, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		if (StringUtils.isNotBlank(singerName))
			filters.put(Singer.SINGERNAME, new SearchFilter(Singer.SINGERNAME, Operator.EQ, singerName));
		Specification<Singer> spec = DynamicSpecifications.bySearchFilter(filters.values(), Singer.class);
		return spec;
	}

	public Singer save(Singer singer) {
		return singerDao.save(singer);
	}
}
