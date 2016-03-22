package com.zworks.musictag.web.controller.musictag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.entity.MusicTag;
import com.zworks.musictag.service.MusicTagService;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年3月22日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
public class MusicTagController {

	@Autowired
	private MusicTagService musicTagService;

	@RequestMapping(value = "musictag", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createMusicTag(@RequestBody MusicTag musicTag, BindingResult result) {
		JsonResponse json = new JsonResponse();
		musicTagService.save(musicTag);
		json.successWithData("song", musicTag);
		return json;
	}
}
