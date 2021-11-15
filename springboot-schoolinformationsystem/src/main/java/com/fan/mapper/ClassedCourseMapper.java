package com.fan.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ClassedCourseMapper {
    @Select("select class_id classId,course_id courseId,delete_flag deleteFlag,create_time createTime,yl1 from class_course where class_id=#{classId} and course_id=#{courseId} and delete_flag=0")
    Map selectOne(Map map);
    @Select("select class_id classId,course_id courseId,delete_flag deleteFlag,create_time createTime,yl1 from class_course where class_id=#{classId} and course_id=#{courseId}")
    Map selectOneOfNoDeleteFlag(Map map);
    @Select("select class_id classId,course_id courseId,delete_flag deleteFlag,create_time createTime,yl1 from class_course")
    List selectAll();
    @Select("select class_id classId,course_id courseId,delete_flag deleteFlag,create_time createTime,yl1 from class_course where delete_flag=0")
    List selectAllOfDeleteFlag();
    @Insert("insert into class_course value(#{classId},#{courseId},0,now(),#{yl1})")
    Integer insert(Map map);
    @Update("update class_course set delete_flag=1 where class_id=#{classId} and course_id=#{courseId}")
    Integer delete(Map map);
    @Update("update class_course set delete_flag=#{deleteFlag},yl1=#{yl1} where class_id=#{classId} and course_id=#{courseId}")
    Integer update(Map map);
}
