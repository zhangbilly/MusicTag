package com.zworks.musictag.web.controller.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.entity.Song;
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

	@RequestMapping(value = "song", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createSong(@RequestBody Song song, BindingResult result) {
		JsonResponse json = new JsonResponse();
		songService.save(song);
		json.successWithData("song", song);
		return json;
	}
}
