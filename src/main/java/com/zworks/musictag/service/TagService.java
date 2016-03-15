package com.zworks.musictag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
