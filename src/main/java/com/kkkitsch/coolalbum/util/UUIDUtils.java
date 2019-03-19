package com.kkkitsch.coolalbum.util;

import java.util.UUID;

public class UUIDUtils {

	public static String getUUID() {
		String[] split = UUID.randomUUID().toString().split("-");
		String str = "";
		for (String string : split) {
			str = str + string;
		}
		return str;
	}

}
