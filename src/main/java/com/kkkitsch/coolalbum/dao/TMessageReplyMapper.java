package com.kkkitsch.coolalbum.dao;

import com.kkkitsch.coolalbum.entity.TMessageReply;
import com.kkkitsch.coolalbum.entity.TMessageReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageReplyMapper {
    long countByExample(TMessageReplyExample example);

    int deleteByExample(TMessageReplyExample example);

    int deleteByPrimaryKey(String mId);

    int insert(TMessageReply record);

    int insertSelective(TMessageReply record);

    List<TMessageReply> selectByExample(TMessageReplyExample example);

    TMessageReply selectByPrimaryKey(String mId);

    int updateByExampleSelective(@Param("record") TMessageReply record, @Param("example") TMessageReplyExample example);

    int updateByExample(@Param("record") TMessageReply record, @Param("example") TMessageReplyExample example);

    int updateByPrimaryKeySelective(TMessageReply record);

    int updateByPrimaryKey(TMessageReply record);
}