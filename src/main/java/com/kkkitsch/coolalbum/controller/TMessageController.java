package com.kkkitsch.coolalbum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kkkitsch.coolalbum.common.MyAcctAndId;
import com.kkkitsch.coolalbum.entity.TMessage;
import com.kkkitsch.coolalbum.entity.TMessageReply;
import com.kkkitsch.coolalbum.service.TMessageService;
import com.kkkitsch.coolalbum.util.MyMsg;

@RestController
@RequestMapping("message")
public class TMessageController {

	@Autowired
	TMessageService messageService;

	@RequestMapping("givenmessage")
	public MyMsg<TMessage> givenMessage(HttpSession session, String friendId, String message) {
		return messageService.putMessage(MyAcctAndId.getMyAcct(session), Integer.parseInt(friendId), message);
	}

	@RequestMapping("getmymessage")
	public MyMsg<List<TMessage>> getMyMessage(HttpSession session) {
		return messageService.getMyMessage(MyAcctAndId.getMyId(session));
	}

	@RequestMapping("deletemessage")
	public MyMsg<String> messageDelete(String mId) {
		return messageService.messageDelete(mId);
	}

	@RequestMapping("messagereply")
	public MyMsg<TMessageReply> messageReply(HttpSession session, String replyMessage, String mSponsor, String mId) {
		return messageService.replyMessage(mSponsor, MyAcctAndId.getMyAcct(session), replyMessage, mId);
	}

	@RequestMapping("getreplymessage")
	public MyMsg<List<TMessageReply>> getReplyMessage(String mId) {
		return messageService.getReplyMessage(mId);
	}

	@RequestMapping("getmyreplymessage")
	public MyMsg<List<TMessageReply>> getMyReplyMessage(HttpSession session) {
		return messageService.getMyReplyMessage(MyAcctAndId.getMyAcct(session));
	}
}
