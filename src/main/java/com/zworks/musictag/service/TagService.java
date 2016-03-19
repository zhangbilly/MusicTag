package com.zworks.musictag.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;

import com.google.common.collect.Maps;
import com.zworks.musictag.entity.Tag;
import com.zworks.musictag.entity.User;
import com.zworks.musictag.repository.TagDao;
import com.zworks.musictag.utils.DataUtils;

/**
 * @date 2016年3月15日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Service
public class TagService {
	@Autowired
	private TagDao tagDao;

	public Tag save(String tagName, User user) {
		Tag tag = createTag(tagName, user);
		return tagDao.save(tag);
	}

	private Tag createTag(String tagName, User user) {
		Tag tag = new Tag();
		tag.setName(tagName);
		tag.setCreator(user);
		tag.setCreateTime(DataUtils.getCurrectTime());
		return tag;
	}
	public List<Tag> getTags(int pageNumber, int pageSize, String sortType){
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<Tag> spec = buildSpecification();
		return tagDao.findAll(spec, pageRequest).getContent();
	}
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.ASC, Tag.NAME);
		} else if (Tag.CREATETIME.equals(sortType)) {
			sort = new Sort(Direction.DESC, Tag.CREATETIME);
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}
	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Tag> buildSpecification() {
		Map<String, SearchFilter> filters =  Maps.newHashMap();
		Specification<Tag> spec = DynamicSpecifications.bySearchFilter(filters.values(), Tag.class);
		return spec;
	}
}
