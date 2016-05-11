package com.zworks.musictag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zworks.musictag.entity.Comment;
import com.zworks.musictag.entity.User;
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

	public void save(Comment comment) {
		if (comment.getId() == null) {
			comment.setBeReplied(null);
			comment.setTime(System.currentTimeMillis());
			comment.setUser(new User(ShiroUtils.getCurrentUserId()));
		}
		commentDao.save(comment);

	}
}
