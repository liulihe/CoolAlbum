package com.kkkitsch.coolalbum.dao;

import com.kkkitsch.coolalbum.entity.TPhototype;
import com.kkkitsch.coolalbum.entity.TPhototypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPhototypeMapper {
    long countByExample(TPhototypeExample example);

    int deleteByExample(TPhototypeExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(TPhototype record);

    int insertSelective(TPhototype record);

    List<TPhototype> selectByExample(TPhototypeExample example);

    TPhototype selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(@Param("record") TPhototype record, @Param("example") TPhototypeExample example);

    int updateByExample(@Param("record") TPhototype record, @Param("example") TPhototypeExample example);

    int updateByPrimaryKeySelective(TPhototype record);

    int updateByPrimaryKey(TPhototype record);
}