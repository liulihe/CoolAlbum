package com.kkkitsch.coolalbum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatcherController {

	@RequestMapping("/member_home.html")
	public String dispatcher() {
		return "member_home";
	}
}