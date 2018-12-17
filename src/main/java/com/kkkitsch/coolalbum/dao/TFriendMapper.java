package com.kkkitsch.coolalbum.dao;

import com.kkkitsch.coolalbum.entity.TFriend;
import com.kkkitsch.coolalbum.entity.TFriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFriendMapper {
    long countByExample(TFriendExample example);

    int deleteByExample(TFriendExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(TFriend record);

    int insertSelective(TFriend record);

    List<TFriend> selectByExample(TFriendExample example);

    TFriend selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") TFriend record, @Param("example") TFriendExample example);

    int updateByExample(@Param("record") TFriend record, @Param("example") TFriendExample example);

    int updateByPrimaryKeySelective(TFriend record);

    int updateByPrimaryKey(TFriend record);
}