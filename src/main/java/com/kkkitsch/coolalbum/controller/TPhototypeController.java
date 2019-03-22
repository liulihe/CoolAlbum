package com.kkkitsch.coolalbum.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kkkitsch.coolalbum.common.MyAcctAndId;
import com.kkkitsch.coolalbum.entity.TPhototype;
import com.kkkitsch.coolalbum.service.TPhototypeService;
import com.kkkitsch.coolalbum.util.MyMsg;

@RestController
@RequestMapping("/phototype")
public class TPhototypeController {

	@Autowired
	TPhototypeService phototypeServiceImpl;

	@RequestMapping("/addtype")
	public MyMsg<TPhototype> addPhototype(TPhototype phototype, HttpSession session, String addOrUpdate,
			String forUpdate) {
		if (phototype != null) {
			boolean flag = phototypeServiceImpl.addPhototype(phototype, MyAcctAndId.getMyId(session), addOrUpdate,
					forUpdate);
			if (flag) {
				return MyMsg.success("添加类型成功", null, null);
			} else {
				return MyMsg.fail("添加类型失败，数据库中已经有此类型名称", null, null);
			}
		} else {
			return MyMsg.fail("添加类型失败，不能为空", null, null);
		}
	}

	/**
	 * 获取所有图片类型，包装后返回
	 */
	@RequestMapping("/gettype")
	public MyMsg<List<TPhototype>> getPhotoType(HttpSession session) {
		// 查询当前member的图片类型
		List<TPhototype> phototypeList = phototypeServiceImpl.getPhototype(MyAcctAndId.getMyId(session));
		if (phototypeList != null) {
			return MyMsg.success("查询成功", phototypeList, null);
		} else {
			return MyMsg.fail("查询失败", null, null);
		}
	}

	@RequestMapping("/deletephototype")
	public MyMsg<TPhototype> deletePhototype(@RequestParam(value = "pId", defaultValue = "") Integer photoTypeId) {
		if (photoTypeId == null) {
			return MyMsg.fail("删除失败", null, null);
		} else {
			boolean flag = phototypeServiceImpl.deletePhototypeById(photoTypeId);
			if (flag) {
				return MyMsg.success("删除成功", null, null);
			} else {
				return MyMsg.fail("会删除此类型下的所有图片，确定吗", null, null);
			}
		}
	}
}
