package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TMessage;
import com.kkkitsch.coolalbum.entity.TMessageReply;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TMessageService {

	MyMsg<TMessage> putMessage(String accountname, int parseInt, String message);

	MyMsg<List<TMessage>> getMyMessage(Integer curMemId);

	MyMsg<String> messageDelete(String mId);

	MyMsg<TMessageReply> replyMessage(String mSponsor, String accountname, String replyMessage,String mId);


}
