package com.fan.service;

import com.fan.domain.Course;

import java.util.List;
import java.util.Map;

public interface UserCourseService {
    Integer insert(Long userId,Long courseId,String yl1);
    Map selectOne(Long userId,Long courseId);
    List selectAll();
    List selectAllOfDeleteFlag();
    Integer update(Long userId,Long courseId,Integer deleteFlag,String yl1);
}
