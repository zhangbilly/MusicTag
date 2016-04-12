package com.zworks.musictag.web.controller.songlist;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.entity.SongList;
import com.zworks.musictag.service.SongListService;
import com.zworks.musictag.utils.DataUtils;
import com.zworks.musictag.utils.JsonResponse;
import com.zworks.musictag.utils.QiniuUtils;

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
	public @ResponseBody JsonResponse createSongList(SongList songList, BindingResult result) {
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
		songList.setCoverImg(QiniuUtils.getDownloadUrl(songList.getCoverImg()));
		json.successWithData("songList", songList);
		return json;
	}

	@RequestMapping(value = "songlists", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getSongLists(@RequestParam(value = "pn", defaultValue = "1") int pageNumber,
			@RequestParam(value = "ps", defaultValue = "20") int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			HttpServletRequest request) {
		JsonResponse json = new JsonResponse();
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<SongList> songList = songListService.getSongLists(searchParams, pageNumber, pageSize, sortType);
		for (SongList sl : songList.getContent()) {
			sl.setCoverImg(QiniuUtils.getDownloadUrl(sl.getCoverImg()));
		}
		json.successWithData("songlists", songList);
		return json;
	}

	@RequestMapping(value = "songlist/{songlistid}", method = RequestMethod.PUT)
	public @ResponseBody JsonResponse updateSongList(@PathVariable(value = "songlistid") Long songListId,
			@RequestBody SongList songList) {
		JsonResponse json = new JsonResponse();
		SongList dbSongList = songListService.getSongListById(songListId);
		// 更新歌单
		dbSongList.setName(songList.getName());
		dbSongList.setDescription(songList.getDescription());
		dbSongList.setUpdateTime(DataUtils.getCurrectTime());
		songListService.save(dbSongList);
		json.successWithData("songlist", dbSongList);
		return json;

	}

	@RequestMapping(value = "songlist/cover/{songlistid}", method = RequestMethod.PUT)
	public @ResponseBody JsonResponse updateSongListCover(@PathVariable(value = "songlistid") Long songListId,
			@RequestBody SongList songList) {
		JsonResponse json = new JsonResponse();
		SongList dbSongList = songListService.getSongListById(songListId);
		// 更新歌单封面
		dbSongList.setCoverImg(songList.getCoverImg());
		dbSongList.setUpdateTime(DataUtils.getCurrectTime());
		songListService.save(dbSongList);
		json.successWithData("songlist", dbSongList);
		return json;

	}
}
