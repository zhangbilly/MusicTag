package com.zworks.musictag.utils;

import com.qiniu.util.Auth;

/**
 * @date 2016年4月12日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public class QiniuUtils {
	private static final String ACCESS_KEY = "ACCESS_KEY";
	private static final String SECRET_KEY = "SECRET_KEY";

	public static String getDownloadUrl(String url) {
		if (url == null || url.indexOf("_") < 0) {
			return null;
		}
		String[] keys = url.split("_");
		String key = keys[0];
		String domain = keys[1];
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		url = domain + "/" + key;
		String downloadUrl = auth.privateDownloadUrl(url);
		return downloadUrl;
	}
}
