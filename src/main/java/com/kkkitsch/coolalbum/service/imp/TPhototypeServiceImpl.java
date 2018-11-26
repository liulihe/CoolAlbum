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
	public List<TPhototype> getPhototype(Integer mId) {
		// 封装查询条件
		TPhototypeExample example = new TPhototypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andPMemberIdEqualTo(mId);
		return phototypeMapper.selectByExample(example);
	}

	@Override
	public boolean addPhototype(TPhototype phototype, Integer mId, String addOrUpdate, String forUpdate) {

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
				return affectNum == 1 ? true : false;
			} else {
				return false;
			}
		} else if ("update".equals(addOrUpdate)) {
			// 封装查询条件
			criteria.andPTypenameEqualTo(forUpdate);
			List<TPhototype> list = phototypeMapper.selectByExample(example);
			if (!list.isEmpty()) {
				phototype.setpMemberId(mId);
				phototype.setpId(list.get(0).getpId());
				System.out.println("开始更新：" + phototype);

				int affectNum = phototypeMapper.updateByPrimaryKeySelective(phototype);
				return affectNum == 1 ? true : false;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean deletePhototypeById(Integer photoTypeId) {
		int affectNum = -1;
		try {
			// 先删除此类型关联的图片
			TPhotoExample example = new TPhotoExample();
			com.kkkitsch.coolalbum.entity.TPhotoExample.Criteria criteria = example.createCriteria();
			criteria.andPTypeIdEqualTo(photoTypeId);
			photoMapper.deleteByExample(example);
			// 删除类型
			affectNum = phototypeMapper.deleteByPrimaryKey(photoTypeId);
		} catch (Exception e) {
			System.out.println("删除失败了");
			e.printStackTrace();
		}
		return affectNum == 1 ? true : false;
	}
}
