package com.kkkitsch.coolalbum.test;

import org.junit.Test;

public class RegExpTest {

	@Test

	public void test() {
		// 复杂密码
		System.out.println("kkkitsch996".matches("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,30}"));
	}

}
