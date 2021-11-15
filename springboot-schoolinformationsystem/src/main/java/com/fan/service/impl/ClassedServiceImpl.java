package com.fan.service.impl;

import com.fan.domain.Classed;
import com.fan.mapper.ClassedMapper;
import com.fan.service.ClassedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ClassedServiceImpl implements ClassedService {
    @Autowired
    private ClassedMapper classedMapper;
    @Override
    public Integer insert(Classed classed) {
//        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
//        Time time=new Time(System.currentTimeMillis());
//        System.out.println(timestamp.toString()+"::"+time.toString());
//        Classed classed1=new Classed(20210103011l,"软件1班",201604030511l,0,null,null);
        Integer result=classedMapper.insert(classed);
//        System.out.println(result);
//        System.out.println("新增成功！");
        return result;
    }

    @Override
    public Classed selectOne(Long classId) {
        Classed classed=classedMapper.selectOne(classId);
        return classed;
    }

    @Override
    public List<Classed> selectOfTeacherId(Long teacherId) {
        return classedMapper.selectOfTeacherId(teacherId);
    }

    @Override
    public List<Classed> selectAll() {
        List<Classed> classeds=classedMapper.selectAll();
        return classeds;
    }

    @Override
    public List<Classed> selectAllOfDeleteFlag() {
        return classedMapper.selectAllOfDeleteFlag();
    }

    @Override
    public Integer delete(Long classId) {
        return classedMapper.delete(classId);
    }

    @Override
    public Integer update(Classed classed) {
        return classedMapper.update(classed);
    }
}
