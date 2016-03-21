package com.zworks.musictag.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zworks.musictag.entity.Song;

/**
 * @date 2016年3月21日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public interface SongDao extends PagingAndSortingRepository<Song, Long>, JpaSpecificationExecutor<Song> {

}
