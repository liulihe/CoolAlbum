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
		return phototypeServiceImpl.addPhototype(phototype, MyAcctAndId.getMyId(session), addOrUpdate, forUpdate);
	}

	/**
	 * 获取所有图片类型，包装后返回
	 */
	@RequestMapping("/gettype")
	public MyMsg<List<TPhototype>> getPhotoType(HttpSession session) {
		return phototypeServiceImpl.getPhototype(MyAcctAndId.getMyId(session));
	}

	@RequestMapping("/deletephototype")
	public MyMsg<TPhototype> deletePhototype(@RequestParam(value = "pId", defaultValue = "") Integer photoTypeId) {
		return phototypeServiceImpl.deletePhototypeById(photoTypeId);
	}
}
