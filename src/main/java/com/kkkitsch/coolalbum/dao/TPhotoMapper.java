package com.kkkitsch.coolalbum.dao;

import com.kkkitsch.coolalbum.entity.TPhoto;
import com.kkkitsch.coolalbum.entity.TPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPhotoMapper {
    long countByExample(TPhotoExample example);

    int deleteByExample(TPhotoExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(TPhoto record);

    int insertSelective(TPhoto record);

    List<TPhoto> selectByExample(TPhotoExample example);

    TPhoto selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") TPhoto record, @Param("example") TPhotoExample example);

    int updateByExample(@Param("record") TPhoto record, @Param("example") TPhotoExample example);

    int updateByPrimaryKeySelective(TPhoto record);

    int updateByPrimaryKey(TPhoto record);
}