package com.zworks.musictag.web.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date 2016年3月10日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
public class PubController {
	@RequestMapping(method = RequestMethod.GET, value = "index")
	public String getIndexPage() {
		return "index";
	}
}
