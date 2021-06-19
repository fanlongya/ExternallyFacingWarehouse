package com.fan.mapper1;

import com.fan.model.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GuestMapper1 {
    @Select("select id,name,role from guest")
    List<Guest> selectList();
}
