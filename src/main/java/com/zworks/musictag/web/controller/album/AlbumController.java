package com.zworks.musictag.web.controller.album;

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

import com.zworks.musictag.entity.Album;
import com.zworks.musictag.service.AlbumService;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年3月25日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	@RequestMapping(value = "albums", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getSingerList(@RequestParam(value = "pagenum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "pagesize", defaultValue = "5") int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			HttpServletRequest request) {
		JsonResponse json = new JsonResponse();
		String albumName = request.getParameter(Album.ALBUMNAME);
		Map<String, Object> searchParams = new HashMap<String, Object>();
		Page<Album> tasks = albumService.getAlbums(albumName, searchParams, pageNumber, pageSize, sortType);
		json.successWithData("albums", tasks.getContent());
		return json;

	}
}
