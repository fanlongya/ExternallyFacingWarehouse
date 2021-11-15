package com.fan.mapper;

import com.fan.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper {
    @Insert("insert into user value(#{userId},#{name},#{password},#{sex},#{age},#{birthday},#{college},#{faculty},#{profession},#{classId},#{deleteFlag},now(),#{yl1})")
    Integer insert(User user);
    @Select("select user_id userId,name,password,sex,age,birthday,college,faculty,profession,class_id classId,delete_flag deleteFlag,create_time createTime,yl1 from user where user_id=#{userId} and delete_flag=0")
    User selectOne(Long userId);
    @Select("select user_id userId,name,password,sex,age,birthday,college,faculty,profession,class_id classId,delete_flag deleteFlag,create_time createTime,yl1 from user")
    List<User> selectAll();
    @Select("select user_id userId,name,password,sex,age,birthday,college,faculty,profession,class_id classId,delete_flag deleteFlag,create_time createTime,yl1 from user where delete_flag=0")
    List<User> selectAllOfDeleteFlag();
//    @Delete("delete from user where user_id=#{userId}")
    @Update("update user set delete_flag=1 where user_id=#{userId}")
    Integer delete(Long userId);
    @Update("update user set name=#{name},password=#{password},sex=#{sex},age=#{age},birthday=#{birthday},college=#{college},faculty=#{faculty},profession=#{profession},class_id=#{classId},delete_flag=#{deleteFlag},create_time=#{createTime},yl1=#{yl1} where user_id=#{userId}")
    Integer update(User user);
}
