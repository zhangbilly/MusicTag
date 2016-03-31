package com.zworks.musictag.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zworks.musictag.entity.SongList;

/**
 * @date 2016年3月31日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public interface SongListDao extends PagingAndSortingRepository<SongList, Long>, JpaSpecificationExecutor<SongList> {

}
