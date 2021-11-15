package com.fan.service;

import com.fan.domain.Classed;
import com.fan.domain.Course;

import java.util.List;

public interface CourseService {
    List selectSemesterAndFaculty(String semester,String faculty);
    List<Course> selectOfClassId(Long classId);
    List<Course> selectOfUserId(Long userId);
}
