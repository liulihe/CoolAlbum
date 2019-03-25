package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TPhotoService {

	MyMsg<TPhoto> uploadFile(TPhoto photo);

	MyMsg<List<TPhoto>> getAllPhoto(Integer mId);
	
	MyMsg<TPhoto> updateClickNum(TPhoto photo,Integer mId);

	MyMsg<TPhoto> singleDelete(String pId);
	
	List<TPhoto> getSelectPhoto(Integer mId,String ptid);

	MyMsg<TPhoto> getDelicatedPhoto(String pId);
	
}
