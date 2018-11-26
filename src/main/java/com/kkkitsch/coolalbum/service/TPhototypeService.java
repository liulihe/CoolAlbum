package com.kkkitsch.coolalbum.service;

import java.util.List;

import com.kkkitsch.coolalbum.entity.TPhototype;

public interface TPhototypeService {

	public List<TPhototype> getPhototype(Integer mId);
	
	public boolean addPhototype(TPhototype phototype,Integer mId,String addOrUpdate,String forUpdate);

	public boolean deletePhototypeById(Integer photoTypeId);
	
}
