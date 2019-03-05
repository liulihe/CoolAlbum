package com.kkkitsch.coolalbum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kkkitsch.coolalbum.service.HistoryTodayService;

@Controller
public class HistoryTodayController {

	@Autowired
	HistoryTodayService historyTodayServiceImpl;

	@RequestMapping("/historytoday")
	@ResponseBody
	public String getHistoryToday() {
		return historyTodayServiceImpl.getHistoryToday();
	}

}
