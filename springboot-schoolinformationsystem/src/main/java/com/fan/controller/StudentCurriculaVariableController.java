package com.fan.controller;

import com.fan.domain.Course;
import com.fan.domain.Subject;
import com.fan.domain.User;
import com.fan.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@Api(tags = "这是学生管理类",description = "为学生提供新增，删除，查找数据的操作")
public class StudentCurriculaVariableController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private UserCourseService userCourseService;
    @Autowired
    private ClassedService classedService;
    @GetMapping("/selectoc/{classId}")
    @ApiOperation("这是根据学生的用户表内的班级id，找到老师为班级选好的课程")
    public List selectOfClassId(@PathVariable("classId") Long classId){
        List<Course> courseList=courseService.selectOfClassId(classId);
        for(Course course:courseList){
            course.setTeacher(userService.selectOne(course.getTeacherId()));
            course.setSubject(subjectService.selectOne(course.getSubjectId()));
        }
        return courseList;
    }
    @ApiOperation("根据参数用户id和课程id，为用户课程表创建数据，参数课程id是一个字符串，由都个课程id中加','组成例：courseId,courseId,courseId...")
    @PostMapping("/insertusco")
    public Integer insertUserCourse(Long userId,String courseIdStr){
        Integer result=0;
        String[] courseIdList=courseIdStr.split(",");
        for (int i=0;i<courseIdList.length;i++){
            Long emp=Long.parseLong(courseIdList[i]);
            if(emp!=null&!emp.equals(0)){
                result+=userCourseService.insert(userId,emp,null);
            }
        }
        return result;
    }
    @ApiOperation("根据参数学生id，查询用户所有信息")
    @GetMapping("/selectUser/{userId}")
    public User selectUserOfUserId(@PathVariable("userId") Long userId){
        User user=userService.selectOne(userId);
        user.setClassed(classedService.selectOne(user.getClassId()));
        return user;
    }
    @ApiOperation("根据参数学生id，查询用户所要得当前学期的课程信息和课程的相关信息科目信息，课程老师信息")
    @GetMapping("/selectCourse/{userId}")
    public List<Course> selectCourseOfUserId(@PathVariable("userId") Long userId){
        List<Course> courseList=courseService.selectOfUserId(userId);
        for(Course course:courseList){
            course.setTeacher(userService.selectOne(course.getTeacherId()));
            course.setSubject(subjectService.selectOne(course.getSubjectId()));
        }
        return courseList;
    }
}
