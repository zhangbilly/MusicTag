/**
 * 
 */
package com.zworks.musictag.web.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zworks.musictag.entity.SongList;
import com.zworks.musictag.service.SongListService;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @Description:
 * @author zhangqiang
 * @date 2016年5月21日上午10:53:45
 *
 */
@RestController
@RequestMapping(value="api/v1/songlist")
public class SongListRestController {
	@Autowired
	private SongListService songListService;
	@RequestMapping(method=RequestMethod.POST)
	public JsonResponse addSongList(@RequestBody SongList songList){
		JsonResponse json = new JsonResponse();
		songList = songListService.addSongList(songList);
		json.successWithData("songList", songList);
		return json;
	}
}
