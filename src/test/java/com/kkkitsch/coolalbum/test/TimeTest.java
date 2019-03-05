package com.kkkitsch.coolalbum.test;

import java.util.Calendar;
import org.junit.Test;

public class TimeTest {

	@Test
	public void test1() {

		Calendar c = Calendar.getInstance();

		System.out.println("分钟：" + c.get(Calendar.MINUTE));

		System.out.println("秒：" + c.get(Calendar.SECOND));

		System.out.println("毫秒：" + c.get(Calendar.MILLISECOND));

		System.out.println("12小时制时间：" + c.get(Calendar.HOUR));

		System.out.println("24小时制时间：" + c.get(Calendar.HOUR_OF_DAY));

		System.out.println("指示当前年中的天数，如果今天星期二，那么返回3：" + c.get(Calendar.DAY_OF_WEEK));

		System.out.println("指示一个星期中的某天：" + c.get(Calendar.DAY_OF_WEEK_IN_MONTH));

		System.out.println("指示一个月中的某天：" + c.get(Calendar.DATE));

		System.out.println("指示一个月中的某天，这个相对而言会比较准确：" + c.get(Calendar.DAY_OF_MONTH));

		System.out.println("月份获取需要 +1，那么，赋值时需要 -1：" + c.get(Calendar.MONTH));

		System.out.println("指示当前年中的天数：" + c.get(Calendar.DAY_OF_YEAR));

		c.set(2018, 9, 13);
		System.out.println("指示一个月中的某天：" + c.get(Calendar.DATE));

	}

}
