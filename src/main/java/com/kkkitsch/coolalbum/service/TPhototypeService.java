package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TPhototype;
import com.kkkitsch.coolalbum.util.MyMsg;

public interface TPhototypeService {

	public MyMsg<List<TPhototype>> getPhototype(Integer mId);
	
	public MyMsg<TPhototype> addPhototype(TPhototype phototype,Integer mId,String addOrUpdate,String forUpdate);

	public MyMsg<TPhototype> deletePhototypeById(Integer photoTypeId);
	
}
