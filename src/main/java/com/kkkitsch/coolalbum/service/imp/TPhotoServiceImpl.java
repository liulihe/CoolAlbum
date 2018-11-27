package com.kkkitsch.coolalbum.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kkkitsch.coolalbum.dao.TPhotoMapper;
import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.entity.TPhotoExample;
import com.kkkitsch.coolalbum.entity.TPhotoExample.Criteria;
import com.kkkitsch.coolalbum.service.TPhotoService;
import com.kkkitsch.coolalbum.util.MyMsg;

@Service
public class TPhotoServiceImpl implements TPhotoService {

	@Autowired
	TPhotoMapper photoMapper;

	@Override
	public MyMsg<TPhoto> uploadFile(TPhoto photo) {
		int affectNum = -1;
		try {
			affectNum = photoMapper.insertSelective(photo);
		} catch (Exception e) {
			e.printStackTrace();
			return MyMsg.fail("上传图片失败", photo, null);
		}
		return affectNum == 1 ? MyMsg.success("上传图片成功", photo, null) : MyMsg.fail("上传图片失败", photo, null);
	}

	@Override
	public List<TPhoto> getAllPhoto(Integer mId) {
		TPhotoExample example = new TPhotoExample();
		Criteria criteria = example.createCriteria();
		criteria.andPMemberIdEqualTo(mId);
		List<TPhoto> photoList = null;
		try {
			// 查询所有图片信息
			photoList = photoMapper.selectByExample(example);
		} catch (Exception e) {
			return null;
		}
		return photoList;
	}

	/**
	 * 更新点赞数
	 */
	@Override
	public boolean updateClickNum(TPhoto photo) {

		// 更新前先查出来
		TPhoto tPhoto = photoMapper.selectByPrimaryKey(photo.getpId());

		boolean contains = false;
		Integer likenum = -1;
		// 不为空
		if (tPhoto != null) {
			// 获取点赞数量和点赞人的id
			likenum = tPhoto.getpLikenum();
			System.out.println("点赞数量：" + likenum);

			// 如果没有人点赞
			if (likenum == 0) {
				likenum = 0;
			}

			String clicklikeMemberid = tPhoto.getpClicklikeMemberid();
			System.out.println("clicklikeMemberid=" + clicklikeMemberid);

			// 如果有点赞的
			if (clicklikeMemberid != null) {
				contains = clicklikeMemberid.contains(photo.getpMemberId().toString());
				// 已经点过赞了
				if (contains) {
					System.out.println("已经点过赞了");
					return false;
				} else {
					// 点赞
					photo.setpLikenum(++likenum);
					photo.setpClicklikeMemberid(photo.getpMemberId() + ",");
					System.out.println("要更新了哈哈哈：" + photo);
					photoMapper.updateByPrimaryKeySelective(photo);
					return true;
				}
			} else {
				// 没有点赞的直接开始点赞
				photo.setpLikenum(++likenum);
				photo.setpClicklikeMemberid(photo.getpMemberId() + ",");
				System.out.println("要更新了：" + photo);
				photoMapper.updateByPrimaryKeySelective(photo);
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean singleDelete(String pId) {

		int affectNum = -1;
		try {
			affectNum = photoMapper.deleteByPrimaryKey(Integer.parseInt(pId));
		} catch (NumberFormatException e) {
			System.out.println("删除失败");
			e.printStackTrace();
		}

		return affectNum == 1 ? true : false;
	}
}
