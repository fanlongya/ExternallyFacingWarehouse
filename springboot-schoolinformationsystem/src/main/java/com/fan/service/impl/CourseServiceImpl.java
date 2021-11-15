package com.fan.service.impl;

import com.fan.domain.Classed;
import com.fan.domain.Course;
import com.fan.mapper.CourseMapper;
import com.fan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public List selectSemesterAndFaculty(String semester,String faculty) {
        Course course=new Course();
        course.setSemester(semester);
        course.setFaculty(faculty);
        return courseMapper.selectSemesterAndFaculty(course);
    }

    @Override
    public List<Course> selectOfClassId(Long classId) {
        return courseMapper.selectOfClassId(classId);
    }

    @Override
    public List<Course> selectOfUserId(Long userId) {
        return courseMapper.selectOfUserId(userId);
    }
}
