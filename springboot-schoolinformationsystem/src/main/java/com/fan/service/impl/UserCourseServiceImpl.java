package com.fan.service.impl;

import com.fan.domain.Course;
import com.fan.mapper.UserCourseMapper;
import com.fan.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    @Autowired
    private UserCourseMapper userCourseMapper;
    @Override
    public Integer insert(Long userId, Long courseId,String yl1) {
        Integer result;
        Map map=new HashMap();
        map.put("userId",userId);
        map.put("courseId",courseId);
        map.put("yl1",yl1);
//        System.out.println(selectOne(userId,courseId).toString());
        if(userCourseMapper.selectOneOfNoDeleteFlag(map)!=null){
            System.out.println("1");
            result=update(userId,courseId,0,yl1);
        }else{
            result=userCourseMapper.insert(map);
        }
        return result;
    }

    @Override
    public Map selectOne(Long userId, Long courseId) {
        Map<String ,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("courseId",courseId);
        return userCourseMapper.selectOne(map);
    }

    @Override
    public List selectAll() {
        return userCourseMapper.selectAll();
    }

    @Override
    public List selectAllOfDeleteFlag() {
        return userCourseMapper.selectAllOfDeleteFlag();
    }

    @Override
    public Integer update(Long userId,Long courseId,Integer deleteFlag,String yl1) {
        Map<String ,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("courseId",courseId);
        map.put("deleteFlag",deleteFlag);
        map.put("yl1",yl1);
        return userCourseMapper.update(map);
    }
}
