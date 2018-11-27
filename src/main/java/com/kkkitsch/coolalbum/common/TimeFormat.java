package com.kkkitsch.coolalbum.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormat {

	/**
	 * @param date
	 * @return 格式化的时间对象
	 */
	public static String timeFormat(Date date) {
		// 时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
		return sdf.format(date);
	}
}
