package com.zworks.musictag.web.controller.musictag;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.persistence.SearchFilter.Operator;

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

	/**
	 * 添加音乐标签
	 * 
	 * @param musicTag
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "musictag", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createMusicTag(@RequestBody MusicTag musicTag, BindingResult result) {
		JsonResponse json = new JsonResponse();
		// 查询是否已经存在
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put(Operator.EQ + "_" + MusicTag.tagId, String.valueOf(musicTag.getTag().getId()));
		searchParams.put(Operator.EQ + "_" + MusicTag.songId, String.valueOf(musicTag.getSong().getId()));
		if (musicTagService.isMusicTagExist(searchParams)) {
			json.setStatus(2);
			return json;
		}
		musicTagService.save(musicTag);
		json.successWithData("song", musicTag);
		return json;
	}
}
