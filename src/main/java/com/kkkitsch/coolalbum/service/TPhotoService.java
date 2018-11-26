package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TPhotoService {

	MyMsg<TPhoto> uploadFile(TPhoto photo);

	List<TPhoto> getAllPhoto(Integer mId);

	boolean updateClickNum(TPhoto photo);

	boolean singleDelete(String pId);
	
}
