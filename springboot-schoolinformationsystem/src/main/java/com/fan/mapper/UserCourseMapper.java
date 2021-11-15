package com.fan.mapper;

import com.fan.domain.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserCourseMapper {
    @Insert("insert into user_course value(#{userId},#{courseId},0,now(),#{yl1})")
    Integer insert(Map map);
    @Select("select user_id userId,course_id courseId,create_time createTime,yl1 from user_course where user_id=#{userId} and course_id=#{courseId} and delete_flag=0")
    Map selectOne(Map map);
    @Select("select user_id userId,course_id courseId,create_time createTime,yl1 from user_course where user_id=#{userId} and course_id=#{courseId}")
    Map selectOneOfNoDeleteFlag(Map map);
    @Select("select user_id userId,course_id courseId,delete_flag deleteFlag,create_time createTime,yl1 from user_course")
    List selectAll();
    @Select("select user_id userId,course_id courseId,delete_flag deleteFlag,create_time createTime,yl1 from user_course where delete_flag=0")
    List selectAllOfDeleteFlag();
    @Update("update user_course set delete_flag=#{deleteFlag},yl1=#{yl1} where user_id=#{userId} and course_id=#{courseId}")
    Integer update(Map map);
}
