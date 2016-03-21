package com.zworks.musictag.web.controller.singer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zworks.musictag.entity.Singer;
import com.zworks.musictag.service.SingerService;
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
@RequestMapping(value = "singer")
public class SingerController {
	@Autowired
	private SingerService singerService;

	@RequestMapping(value = "singers", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getSingerList(@RequestParam(value = "pagenum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "pagesize", defaultValue = "5") int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			HttpServletRequest request) {
		JsonResponse json = new JsonResponse();
		String singerName = request.getParameter(Singer.SINGERNAME);
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<Singer> tasks = singerService.getSingers(singerName, searchParams, pageNumber, pageSize, sortType);
		json.successWithData("singers", tasks.getContent());
		return json;

	}
}
