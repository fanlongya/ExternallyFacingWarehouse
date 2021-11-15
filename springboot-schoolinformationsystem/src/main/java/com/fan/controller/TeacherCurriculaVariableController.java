package com.fan.controller;

import com.fan.domain.Classed;
import com.fan.domain.Course;
import com.fan.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(tags = "老师选课管理类",description = "为老师提供选课时所需要得一些数据，选课后的一些写入操作")
public class TeacherCurriculaVariableController {
    @Autowired
    private ClassedCourseService classedCourseService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassedService classedService;
    @Autowired
    private UserService userService;
    @Autowired
    private SubjectService subjectService;
    @ApiOperation("根据老师Id找到在相应的班级信息")
    @GetMapping("/selectClassOfTeacherId/{teacherId}")
    public List<Classed> selectClassOfTeacherId(@PathVariable("teacherId") Long teacherId){
        return classedService.selectOfTeacherId(teacherId);
    }
    @ApiOperation("根据老师的院系和学期找到相应的在选课时间内的所有的课程信息和课程的相关信息科目信息，课程老师信息")
    @GetMapping("/selectAllCoOfSeFa")
    public List selectAllCourseOfSemesterFaculty(String semester,String faculty){
        List<Course> courseList=courseService.selectSemesterAndFaculty(semester,faculty);
        for(Course course:courseList){
            course.setTeacher(userService.selectOne(course.getTeacherId()));
            course.setSubject(subjectService.selectOne(course.getSubjectId()));
        }
        return courseList;
    }
    @ApiOperation("根据参数班级id和课程id，为班级课程表创建数据，参数课程id是一个字符串，由都个课程id中加','组成")
    @PostMapping("/insertClassedCourse")
    public Integer insertClassedCourse(Long classId,String courseIdStr){
        Integer result=0;
        String[] courseIdArray=courseIdStr.split(",");
        for(int i=0;i<courseIdArray.length;i++){
            Long a=Long.parseLong(courseIdArray[i]);
            if(a!=null&!a.equals(0)){
                result+=classedCourseService.insert(classId,a);
            }
        }
        return result;
    }
    @ApiOperation("根据班级id找到相应有关联的的所有的课程相关信息")
    @GetMapping("/selectacoci/{classId}")
    public List<Course> selectAllCourseOfClassId(@PathVariable("classId") Long classId){
        List<Course> courseList=courseService.selectOfClassId(classId);
        for(Course course:courseList){
            course.setTeacher(userService.selectOne(course.getTeacherId()));
            course.setSubject(subjectService.selectOne(course.getSubjectId()));
        }
        return courseList;
    }
}
