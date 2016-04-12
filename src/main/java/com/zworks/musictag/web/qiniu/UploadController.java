package com.zworks.musictag.web.qiniu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiniu.util.Auth;
import com.zworks.musictag.utils.JsonResponse;

/**
 * @date 2016年4月11日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
@Controller
public class UploadController {
	private static final String ACCESS_KEY = "ACCESS_KEY";
	private static final String SECRET_KEY = "SECRET_KEY";
	private static final String BUCKET_NAME = "BUCKET_NAME";

	@RequestMapping(value = "uptoken", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getUpToken() {
		// 密钥配置
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String token = auth.uploadToken(BUCKET_NAME);
		JsonResponse json = new JsonResponse();
		json.successWithData("uptoken", token);
		return json;
	}
}
