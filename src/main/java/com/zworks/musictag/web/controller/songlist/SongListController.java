package com.zworks.musictag.web.controller.songlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.entity.SongList;
import com.zworks.musictag.service.SongListService;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年3月31日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
public class SongListController {
	@Autowired
	private SongListService songListService;

	@RequestMapping(value = "songlist", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createSong(SongList songList, BindingResult result) {
		JsonResponse json = new JsonResponse();
		songListService.save(songList);
		json.successWithData("songList", songList);
		return json;
	}

	@RequestMapping(value = "songlist/{songlistid}", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getSongListById(@PathVariable(value = "songlistid") Long songListId) {
		JsonResponse json = new JsonResponse();
		SongList songList = songListService.getSongListById(songListId);
		if (songList == null) {
			return json.failedWithReturn("歌单不存在");
		}
		json.successWithData("songList", songList);
		return json;
	}
}
