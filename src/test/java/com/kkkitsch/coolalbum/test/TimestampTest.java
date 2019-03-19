package com.kkkitsch.coolalbum.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class TimestampTest {

	@Test
	public void test() {
		Timestamp time = new Timestamp(new Date().getTime());
		System.out.println(time);
	}

}
