package com.zworks.musictag.web.controller.tag;

import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zworks.musictag.entity.Tag;
import com.zworks.musictag.entity.User;
import com.zworks.musictag.service.ShiroDbRealm.ShiroUser;
import com.zworks.musictag.service.TagService;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年3月15日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
@RequestMapping(value = "/tag")
public class TagController {
	@Autowired
	private TagService tagService;
	private static Logger logger = LoggerFactory.getLogger(TagController.class);
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse createTag(@RequestParam String tagName) {
		JsonResponse json = new JsonResponse();
		if (StringUtils.isBlank(tagName)) {
			return json.failedWithReturn("标签名为空");
		}
		Tag tag = null;
		try {
			tag = tagService.getTagByName(tagName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.failed("数据错误");
		}
		if(tag==null){
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			tag = tagService.save(tagName, new User(user.id));
			json.successWithData("tag", tag);
		}else{
			json.put("tag", tag);
			json.setStatus(2);
			json.setMessage("标签已经存在。");
		}
		return json;
	}
	@RequestMapping(value="tags",method = RequestMethod.GET)
	public @ResponseBody JsonResponse GetTags(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = "20") int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		JsonResponse json = new JsonResponse();
		List<Tag> tagList = tagService.getTags(pageNumber,pageSize,sortType);
		json.successWithData("tags", tagList);
		return json;
	}
}