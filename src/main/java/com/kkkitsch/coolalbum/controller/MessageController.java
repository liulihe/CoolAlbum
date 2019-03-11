package com.kkkitsch.coolalbum.controller;

import static com.kkkitsch.coolalbum.common.MyConstant.CUR_MEMBER;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kkkitsch.coolalbum.entity.TMember;
import com.kkkitsch.coolalbum.entity.TMessage;
import com.kkkitsch.coolalbum.service.TMessageService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Controller
@RequestMapping("message")
public class MessageController {

	@Autowired
	TMessageService messageService;

	@RequestMapping("givenmessage")
	@ResponseBody
	public MyMsg<TMessage> givenMessage(HttpSession session, String friendId, String message) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		String accountname = member.getmAccountname();
		return messageService.putMessage(accountname, Integer.parseInt(friendId), message);
	}

	@RequestMapping("getmymessage")
	@ResponseBody
	public MyMsg<List<TMessage>> getMyMessage(HttpSession session) {
		TMember member = (TMember) session.getAttribute(CUR_MEMBER);
		Integer curMemId = member.getmId();
		return messageService.getMyMessage(curMemId);
	}

	@RequestMapping("deletemessage")
	@ResponseBody
	public MyMsg<String> messageDelete(String mId) {
		return messageService.messageDelete(mId);
	}

}
