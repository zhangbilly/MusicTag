package com.zworks.musictag.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.zworks.musictag.entity.Comment;

/**
 * @date 2016年5月11日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public interface CommentDao extends CrudRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {

}
