package com.zworks.musictag.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zworks.musictag.entity.MusicTag;

/**
 * @date 2016年3月22日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public interface MusicTagDao extends PagingAndSortingRepository<MusicTag, Long>, JpaSpecificationExecutor<MusicTag> {

}
