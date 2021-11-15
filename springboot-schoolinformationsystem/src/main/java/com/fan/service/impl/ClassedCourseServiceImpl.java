package com.fan.service.impl;

import com.fan.mapper.ClassedCourseMapper;
import com.fan.service.ClassedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassedCourseServiceImpl implements ClassedCourseService {
    @Autowired
    private ClassedCourseMapper classedCourseMapper;

    @Override
    public Map selectOne(Long classId, Long courseId) {
        Map<String,Object> map=new HashMap();
        map.put("classId",classId);
        map.put("courseId",courseId);
        return classedCourseMapper.selectOne(map);
    }

    @Override
    public List selectAll() {
        return classedCourseMapper.selectAll();
    }

    @Override
    public List selectAllOfDeleteFlag() {
        return classedCourseMapper.selectAllOfDeleteFlag();
    }


    @Override
    public Integer insert(Long classId, Long courseId) {
        Map<String,Object> map=new HashMap();
        map.put("classId",classId);
        map.put("courseId",courseId);
        Integer result;
        if(classedCourseMapper.selectOneOfNoDeleteFlag(map)!=null){
            Map map1=classedCourseMapper.selectOneOfNoDeleteFlag(map);
            map1.put("deleteFlag",0);
            result=classedCourseMapper.update(map1);
        }else {
            result=classedCourseMapper.insert(map);
        }
        return result;
    }

    @Override
    public Integer delete(Long classId, Long courseId) {
        Map<String,Object> map=new HashMap();
        map.put("classId",classId);
        map.put("courseId",courseId);
        return classedCourseMapper.delete(map);
    }

    @Override
    public Integer update(Long classId, Long courseId, Integer deleteFlag, String yl1) {
        Map<String,Object> map=new HashMap();
        map.put("classId",classId);
        map.put("courseId",courseId);
        map.put("deleteFlag",deleteFlag);
        map.put("yl1",yl1);
        return classedCourseMapper.update(map);
    }
}
