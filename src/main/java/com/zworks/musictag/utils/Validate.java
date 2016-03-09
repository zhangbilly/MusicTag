package com.zworks.musictag.utils;

/**
 * @date 2016年3月9日
 *
 * @author zhangqiang6
 *
 * @Description: TODO
 *
 **/
public class Validate {
	/**
	 * 正则表达式：验证用户名
	 */
	public static final String REGEX_LOGINNAME = "^[a-zA-Z][a-zA-Z0-9_]{1,17}$";// 2~18个字符，可使用字母、数字、下划线，需以字母开头
	public static final String REGEX_LOGINNAMEWITHBLANK = "^(\\s*)|([a-zA-Z][a-zA-Z0-9_]{1,17})$";
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";// 6-18位，可使用字母、数字
	public static final String REGEX_PASSWORDWITHBLANK = "^(\\s*)|([a-zA-Z0-9]{6,16})$";
	public static final String REGEX_USERNAME = "^\\S{2,30}$";// 2-30位
	public static final String REGEX_USERNAMEWITHBLANK = "^(\\s*)|(\\S{2,30})$";

}
