package com.fan.mapper;

import com.fan.model.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface GuestMapper {
    @Select("select id,name,role from guest")
    List<Guest> selectList();
}
