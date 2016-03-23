package com.zworks.musictag.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zworks.musictag.entity.Album;

/**
 * @date 2016年3月23日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public interface AlbumDao extends PagingAndSortingRepository<Album, Long>, JpaSpecificationExecutor<Album> {

}
