package com.kkkitsch.coolalbum.test;

import java.util.UUID;

import org.junit.Test;

public class UUIDTest {

	@Test
	public void test1() {
		String[] split = UUID.randomUUID().toString().split("-");
		String str = "";
		for (String string : split) {
			str = str + string;
		}
		System.out.println(str);
	}

}
