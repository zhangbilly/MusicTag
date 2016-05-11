package com.zworks.musictag.utils;

import org.apache.shiro.SecurityUtils;

import com.zworks.musictag.service.ShiroDbRealm.ShiroUser;

/**
 * @date 2016年5月11日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public class ShiroUtils {
	public static Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}
