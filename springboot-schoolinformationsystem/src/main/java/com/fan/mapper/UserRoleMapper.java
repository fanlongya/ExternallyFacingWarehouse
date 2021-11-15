package com.fan.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserRoleMapper {
    //delete from user_role where user_id=#{userId} and role_id=#{roleId}
    @Update("update user_role set delete_flag=1 where user_id=#{userId} and role_id=#{roleId}")
    Integer delete(@Param("userId") Long userId,@Param("roleId") Long roleId);
    @Update("update user_role set delete_flag=#{deleteFlag},yl1=#{yl1} where user_id=#{userId} and role_id=#{roleId}")
    Integer update(Map map);
    @Select("select user_id userId,role_id roleId from user_role where user_id=#{userId} and role_id=#{roleId} and delete_flag=0")
    Map selectOne(Map map);
    @Select("select user_id userId,role_id roleId from user_role")
    List selectAll();
    @Select("select user_id userId,role_id roleId from user_role where delete_flag=0")
    List selectAllOfDeleteFlag();
    @Insert("insert into user_role value(#{userId},#{roleId},0,now(),#{yl1})")
    Integer insert(Map map);
}
