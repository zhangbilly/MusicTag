package com.zworks.musictag.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
	public static String getCurrectTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		return formatter.format(d);
	}
}
