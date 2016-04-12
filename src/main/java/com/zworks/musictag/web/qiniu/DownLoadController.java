package com.zworks.musictag.web.qiniu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiniu.util.Auth;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年4月12日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
public class DownLoadController {
	private static final String ACCESS_KEY = "ACCESS_KEY";
	private static final String SECRET_KEY = "SECRET_KEY";

	@RequestMapping(value = "downloadurl", method = RequestMethod.POST)
	public @ResponseBody JsonResponse getDownToken(String key, String domain) {
		// 密钥配置
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String url = domain + "/" + key;
		String downloadUrl = auth.privateDownloadUrl(url);
		JsonResponse json = new JsonResponse();
		json.successWithData("url", downloadUrl);
		return json;
	}
}
