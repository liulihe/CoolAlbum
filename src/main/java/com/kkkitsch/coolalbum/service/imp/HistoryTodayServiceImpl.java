package com.kkkitsch.coolalbum.service.imp;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.service.HistoryTodayService;
import com.kkkitsch.coolalbum.util.HttpClientUtil;

@Service
public class HistoryTodayServiceImpl implements HistoryTodayService {

	@Override
	public String getHistoryToday() {
		Calendar instance = Calendar.getInstance();
		int curMonth = instance.get(Calendar.MONTH) + 1;
		int curDay = instance.get(Calendar.DAY_OF_MONTH);
		int type = 1;
		int page = 1;
		int rows = 20;

		Map<String, Integer> urlConfig = new HashMap<String, Integer>();
		urlConfig.put("yue", curMonth);
		urlConfig.put("ri", curDay);
		urlConfig.put("type", type);
		urlConfig.put("page", page);
		urlConfig.put("rows", rows);
		try {
			return HttpClientUtil.invoke(urlConfig);
		} catch (Exception e) {
			System.out.println("接口调用失败");
			return null;
		}
	}
}
