/**
 * 
 */
package com.zworks.musictag.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import com.zworks.musictag.entity.SongAndList;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年5月21日下午12:37:04
 *
 */
public interface SongAndListDao extends CrudRepository<SongAndList, Long>, JpaSpecificationExecutor<SongAndList>{

}
