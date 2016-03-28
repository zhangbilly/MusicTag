package com.zworks.musictag.web.controller.song;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.persistence.SearchFilter.Operator;

import com.zworks.musictag.entity.MusicTag;
import com.zworks.musictag.entity.Song;
import com.zworks.musictag.entity.Tag;
import com.zworks.musictag.service.AlbumService;
import com.zworks.musictag.service.MusicTagService;
import com.zworks.musictag.service.SingerService;
import com.zworks.musictag.service.SongService;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年3月21日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
public class SongController {
	@Autowired
	private SongService songService;
	@Autowired
	private SingerService singerService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private MusicTagService musicTagService;

	@RequestMapping(value = "song", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createSong(@RequestBody Song song, BindingResult result) {
		JsonResponse json = new JsonResponse();
		if (song.getSinger().getId() == null) {
			singerService.save(song.getSinger());
		}
		if (song.getAlbum().getId() == null) {
			song.getAlbum().setSinger(song.getSinger());
			albumService.save(song.getAlbum());
		}
		songService.save(song);
		json.successWithData("song", song);
		return json;
	}

	@RequestMapping(value = "songlistbytag", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getSongListByTag(@RequestParam(value = "pn", defaultValue = "1") int pageNumber,
			@RequestParam(value = "ps", defaultValue = "20") int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			HttpServletRequest request) {
		JsonResponse json = new JsonResponse();
		Map<String, Object> searchParams = new HashMap<String, Object>();
		String tagId = request.getParameter(Tag.TAGID);
		if (StringUtils.isNotBlank(tagId)) {
			searchParams.put(Operator.EQ + "_" + "song.id", tagId);
		}
		Page<MusicTag> songList = musicTagService.getSongsByTag(searchParams, pageNumber, pageSize, sortType);
		json.successWithData("songs", songList);
		return json;
	}

	@RequestMapping(value = "songlist", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getSongListBuyName(@RequestParam(value = "pn", defaultValue = "1") int pageNumber,
			@RequestParam(value = "ps", defaultValue = "20") int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			HttpServletRequest request) {
		JsonResponse json = new JsonResponse();
		Map<String, Object> searchParams = new HashMap<String, Object>();
		String songName = request.getParameter(Song.SONGNAME);
		if (StringUtils.isNotBlank(songName)) {
			searchParams.put(Operator.LIKE + "_" + Song.SONGNAME, songName);
		}
		Page<Song> songList = songService.getSongs(searchParams, pageNumber, pageSize, sortType);
		json.successWithData("songs", songList);
		return json;
	}
}
