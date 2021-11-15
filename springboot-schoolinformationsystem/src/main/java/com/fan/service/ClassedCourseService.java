package com.fan.service;

import java.util.List;
import java.util.Map;

public interface ClassedCourseService {
    Map selectOne(Long classId,Long courseId);
    List selectAll();
    List selectAllOfDeleteFlag();
    Integer insert(Long classId,Long courseId);
    Integer delete(Long classId,Long courseId);
    Integer update(Long classId,Long courseId,Integer deleteFlag,String yl1);
}
