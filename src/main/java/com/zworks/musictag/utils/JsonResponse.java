package com.zworks.musictag.utils;

import java.util.HashMap;

/**
 * @date 2016年3月8日
 *
 * @author zhangqiang6
 *
 * @Description: JSON返回格式
 *
 **/
public class JsonResponse extends HashMap<String, Object> {
	private static final long serialVersionUID = -3957696416833580484L;
	public static final int SUCCESS = 1;
	public static final int FAILED = 0;
	public static final int NOTFINISHED = 2;
	public static final String STATUS = "status";
	public static final String MESSAGE = "msg";

	public JsonResponse() {
		super();
	}

	public JsonResponse(int flag, String msg) {
		super();
		put(STATUS, flag);
		put(MESSAGE, msg);
	}

	public void failed(String msg) {
		put(STATUS, FAILED);
		put(MESSAGE, msg);
	}

	public JsonResponse failedWithReturn(String msg) {
		put(STATUS, FAILED);
		put(MESSAGE, msg);
		return this;
	}

	public void success() {
		put(STATUS, SUCCESS);
	}

	public void success(String msg) {
		put(STATUS, SUCCESS);
		put(MESSAGE, msg);
	}

	public void successWithData(String key, Object value) {
		put(STATUS, SUCCESS);
		put(key, value);
	}

	public void setStatus(int status) {
		put(STATUS, status);
	}

	public void setMessage(String msg) {
		put(MESSAGE, msg);
	}

	public boolean isfailed() {
		return get(STATUS) != null && (Integer) get(STATUS) == FAILED;
	}
}
