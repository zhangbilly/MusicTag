package com.zworks.musictag.web.controller.tag;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody JsonResponse searchTag(@RequestParam String tagName) {
		JsonResponse json = new JsonResponse();
		if (StringUtils.isBlank(tagName)) {
			return json.failedWithReturn("标签名为空");
		}
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		Tag tag = tagService.save(tagName, new User(user.id));
		json.successWithData("tag", tag);
		return json;
	}
}
