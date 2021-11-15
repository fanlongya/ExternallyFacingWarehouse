package com.fan.mapper;

import com.fan.domain.Classed;
import com.fan.domain.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    @Select("select course_id courseId,subject_id subjectId,teacher_id teacherId,semester,faculty,start_time startTime,end_time endTime,delete_flag deleteFlag,yl1 from course where semester=#{semester} and faculty=#{faculty} and start_time<=now() and end_time>=now() and delete_flag=0")
    List<Course> selectSemesterAndFaculty(Course course);
    @Select("select co.course_id courseId,co.subject_id subjectId,co.teacher_id teacherId,co.semester,co.faculty,co.start_time startTime,co.end_time endTime,co.delete_flag deleteFlag,co.yl1 from class_course cc inner join course co on cc.course_id=co.course_id where class_id=#{classId} and cc.delete_flag=0")
    List<Course> selectOfClassId(Long classId);
    @Select("select co.course_id courseId,co.subject_id subjectId,co.teacher_id teacherId,co.semester,co.faculty,co.start_time startTime,co.end_time endTime,co.delete_flag deleteFlag,co.yl1 from user_course uc inner join course co on uc.course_id=co.course_id where user_id=#{userId} and uc.delete_flag=0")
    List<Course> selectOfUserId(Long userId);
//    @Select("select class_id classId,course_id courseId from class_course where class_id=#{classId}")
//    @Results(id="selectofclassId",value = {
//            @Result(property = "classId",column = "classId",id=true),
//            @Result(property ="courseList",javaType = List.class,column = "courseId",many= @Many(select = "selectOfCourseId",fetchType = FetchType.LAZY))
//    })
//    Classed selectOfClassId(Long classId);
//    @Select("select course_id courseId,subject_id subjectId,teacher_id teacherId,semester,faculty,start_time startTime,end_time endTime,delete_flag deleteFlag,yl1 from course where course_id=#{courseId}")
//    Course selectOfCourseId(Long courseId);
}
