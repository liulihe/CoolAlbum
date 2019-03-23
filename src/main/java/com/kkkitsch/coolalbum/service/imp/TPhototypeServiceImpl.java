package com.kkkitsch.coolalbum.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.dao.TPhotoMapper;
import com.kkkitsch.coolalbum.dao.TPhototypeMapper;
import com.kkkitsch.coolalbum.entity.TPhotoExample;
import com.kkkitsch.coolalbum.entity.TPhototype;
import com.kkkitsch.coolalbum.entity.TPhototypeExample;
import com.kkkitsch.coolalbum.entity.TPhototypeExample.Criteria;
import com.kkkitsch.coolalbum.service.TPhototypeService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Service
public class TPhototypeServiceImpl implements TPhototypeService {

	@Autowired
	TPhototypeMapper phototypeMapper;

	@Autowired
	TPhotoMapper photoMapper;

	/**
	 * 获取所有图片类型
	 */
	@Override
	public MyMsg<List<TPhototype>> getPhototype(Integer mId) {
		// 封装查询条件
		TPhototypeExample example = new TPhototypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPMemberIdEqualTo(mId);
		List<TPhototype> phototypeList = phototypeMapper.selectByExample(example);
		if (phototypeList != null) {
			return MyMsg.success("查询成功", phototypeList, null);
		} else {
			return MyMsg.fail("查询失败", null, null);
		}
	}

	@Override
	public MyMsg<TPhototype> addPhototype(TPhototype phototype, Integer mId, String addOrUpdate, String forUpdate) {
		if (phototype == null) {
			return MyMsg.fail("添加类型失败，不能为空", null, null);
		}
		// 封装查询条件
		TPhototypeExample example = new TPhototypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPMemberIdEqualTo(mId);

		if ("add".equals(addOrUpdate)) {
			// 封装查询条件
			criteria.andPTypenameEqualTo(phototype.getpTypename());
			List<TPhototype> list = phototypeMapper.selectByExample(example);
			// 如果查询为空，说明数据库中没有这种图片类型，可以 插入
			if (list.isEmpty()) {
				phototype.setpMemberId(mId);
				System.out.println("开始插入：" + phototype);
				int affectNum = phototypeMapper.insertSelective(phototype);
				return affectNum == 1 ? MyMsg.success("添加成功", phototype, null) : MyMsg.fail("添加失败，请重试", null, null);
			} else {
				return MyMsg.fail("添加失败，已有此类型", null, null);
			}
		} else if ("update".equals(addOrUpdate)) {
			// 封装查询条件
			criteria.andPTypenameEqualTo(forUpdate);
			List<TPhototype> list = phototypeMapper.selectByExample(example);
			if (!list.isEmpty()) {
				phototype.setpMemberId(mId);
				phototype.setpId(list.get(0).getpId());
				int affectNum = phototypeMapper.updateByPrimaryKeySelective(phototype);
				return affectNum == 1 ? MyMsg.success("更新成功", null, null) : MyMsg.fail("更新失败，请重试", null, null);
			} else {
				return MyMsg.fail("更新失败，已有此类型", null, null);
			}
		} else {
			return MyMsg.fail("发生未知错误", null, null);
		}
	}

	@Override
	public MyMsg<TPhototype> deletePhototypeById(Integer photoTypeId) {

		if (photoTypeId == null) {
			return MyMsg.fail("删除失败", null, null);
		}
		try {
			// 先删除此类型关联的图片
			TPhotoExample example = new TPhotoExample();
			com.kkkitsch.coolalbum.entity.TPhotoExample.Criteria criteria = example.createCriteria();
			criteria.andPTypeIdEqualTo(photoTypeId);
			photoMapper.deleteByExample(example);
			// 再删除类型
			phototypeMapper.deleteByPrimaryKey(photoTypeId);
			return MyMsg.success("删除成功", null, null);
		} catch (Exception e) {
			return MyMsg.fail("会删除此类型下的所有图片，确定吗", null, null);
		}
	}
}