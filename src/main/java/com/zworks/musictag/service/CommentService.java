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
import org.springside.modules.persistence.SearchFilter.Operator;

import com.google.common.collect.Maps;
import com.zworks.musictag.entity.Comment;
import com.zworks.musictag.entity.User;
import com.zworks.musictag.entity.enumerate.CommentType;
import com.zworks.musictag.repository.CommentDao;
import com.zworks.musictag.utils.ShiroUtils;

/**
 * @date 2016年5月11日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;

	public Comment save(Comment comment) {
		if (comment.getId() == null) {
			comment.setBeReplied(null);
			comment.setTime(System.currentTimeMillis());
			comment.setUser(new User(ShiroUtils.getCurrentUserId()));
		}
		return commentDao.save(comment);

	}

	public Page<Comment> getLatestComment(int pageNumber, int pageSize, String resourceId, CommentType type) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
		Specification<Comment> spec = buildSpecification(resourceId, type);
		Page<Comment> commentList = commentDao.findAll(spec, pageRequest);
		return commentList;
	}

	private PageRequest buildPageRequest(int pageNumber, int pageSize) {
		Sort sort = new Sort(Direction.DESC, Comment.TIME);
		return new PageRequest(pageNumber - 1, pageSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<Comment> buildSpecification(String resourceId, CommentType type) {
		Map<String, SearchFilter> filters = Maps.newHashMap();
		filters.put(Comment.RESOURCEID, new SearchFilter(Comment.RESOURCEID, Operator.EQ, resourceId));
		filters.put(Comment.TYPE, new SearchFilter(Comment.TYPE, Operator.EQ, type));
		Specification<Comment> spec = DynamicSpecifications.bySearchFilter(filters.values(), Comment.class);
		return spec;
	}
}
