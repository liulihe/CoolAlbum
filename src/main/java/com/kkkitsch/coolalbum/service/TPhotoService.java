package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TPhotoService {

	MyMsg<TPhoto> uploadFile(TPhoto photo);

	List<TPhoto> getAllPhoto(Integer mId);
	
	boolean updateClickNum(TPhoto photo,Integer mId);

	boolean singleDelete(String pId);
	
	List<TPhoto> getSelectPhoto(Integer mId,String ptid);

	TPhoto getDelicatedPhoto(String pId);
	
}
