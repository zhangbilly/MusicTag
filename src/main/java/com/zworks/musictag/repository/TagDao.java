package com.zworks.musictag.repository;

import javax.persistence.NonUniqueResultException;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zworks.musictag.entity.Tag;

/**
 * @date 2016年3月15日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public interface TagDao extends PagingAndSortingRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {

	/**
	 * @param tagName
	 * @return
	 */
	public Tag findByName(String tagName) throws NonUniqueResultException;

}
