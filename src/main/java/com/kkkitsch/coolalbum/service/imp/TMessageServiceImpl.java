package com.kkkitsch.coolalbum.service.imp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.dao.TMessageMapper;
import com.kkkitsch.coolalbum.entity.TMessage;
import com.kkkitsch.coolalbum.entity.TMessageExample;
import com.kkkitsch.coolalbum.entity.TMessageExample.Criteria;
import com.kkkitsch.coolalbum.service.TMessageService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Service
public class TMessageServiceImpl implements TMessageService {

	@Autowired
	TMessageMapper messageMapper;

	@Override
	public MyMsg<TMessage> putMessage(String accountname, int friendId, String message) {
		if (message == null || message.trim().equals("")) {
			return MyMsg.fail("留言不能为空", null, null);
		} else {
			TMessage record = new TMessage();
			record.setmId(UUID.randomUUID().toString().substring(0,12));
			record.setmSponsor(accountname);
			record.setmMessageReceiverId(friendId);
			record.setmContent(message);
			record.setmCreatetime(new Date());
			int affectNum = messageMapper.insertSelective(record);
			System.out.println("留言后的message:" + record);
			return affectNum == 1 ? MyMsg.success("留言成功", record, null) : MyMsg.fail("留言失败", null, null);
		}
	}

	@Override
	public MyMsg<List<TMessage>> getMyMessage(Integer curMemId) {
		TMessageExample example = new TMessageExample();
		Criteria criteria = example.createCriteria();
		criteria.andMMessageReceiverIdEqualTo(curMemId);
		List<TMessage> messageList = messageMapper.selectByExample(example);
		if (messageList.isEmpty()) {
			return MyMsg.fail("没有任何留言", null, null);
		} else {
			return MyMsg.success("查询成功", messageList, null);
		}
	}

	@Override
	public MyMsg<String> messageDelete(String mId) {
		int affectNum = messageMapper.deleteByPrimaryKey(mId);
		return affectNum==1?MyMsg.success("删除成功", null, null):MyMsg.fail("删除失败", null, null);
	}

}
