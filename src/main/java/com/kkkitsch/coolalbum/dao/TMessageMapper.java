package com.kkkitsch.coolalbum.dao;

import com.kkkitsch.coolalbum.entity.TMessage;
import com.kkkitsch.coolalbum.entity.TMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageMapper {
    long countByExample(TMessageExample example);

    int deleteByExample(TMessageExample example);

    int deleteByPrimaryKey(String mId);

    int insert(TMessage record);

    int insertSelective(TMessage record);

    List<TMessage> selectByExample(TMessageExample example);

    TMessage selectByPrimaryKey(String mId);

    int updateByExampleSelective(@Param("record") TMessage record, @Param("example") TMessageExample example);

    int updateByExample(@Param("record") TMessage record, @Param("example") TMessageExample example);

    int updateByPrimaryKeySelective(TMessage record);

    int updateByPrimaryKey(TMessage record);
}