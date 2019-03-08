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

	@Override
	public List<TPhoto> getSelectPhoto(Integer mId, String ptid) {
		TPhotoExample example = new TPhotoExample();
		Criteria criteria = example.createCriteria();
		criteria.andPMemberIdEqualTo(mId);
		criteria.andPTypeIdEqualTo(Integer.parseInt(ptid));
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
	public boolean updateClickNum(TPhoto photo, Integer mId) {

		// 更新前先查出来
		TPhoto tPhoto = photoMapper.selectByPrimaryKey(photo.getpId());

		// 查询不为空
		if (tPhoto != null) {
			// 获取点赞数量和点赞人的id
			Integer likenum = tPhoto.getpLikenum();
			String clicklikeMemberids = tPhoto.getpClicklikeMemberid();
			System.out.println("点赞人id=" + clicklikeMemberids);

			// 如果已经有点赞的人
			if (clicklikeMemberids != null) {
				boolean contains = clicklikeMemberids.contains(mId.toString());
				// 如果本人已经点过赞了
				if (contains) {
					return false;
				} else {
					// 点赞
					photo.setpLikenum(++likenum);
					photo.setpClicklikeMemberid(clicklikeMemberids + mId + ",");
					System.out.println("要更新了哈哈哈：" + photo);
					photoMapper.updateByPrimaryKeySelective(photo);
					return true;
				}
			} else {
				// 没有点赞的直接开始点赞
				photo.setpLikenum(++likenum);
				photo.setpClicklikeMemberid(mId + ",");
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

	@Override
	public TPhoto getDelicatedPhoto(String pId) {
		return photoMapper.selectByPrimaryKey(Integer.parseInt(pId));
	}

}
