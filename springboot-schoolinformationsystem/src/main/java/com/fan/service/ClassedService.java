package com.fan.service;

import com.fan.domain.Classed;
import com.fan.service.impl.ClassedServiceImpl;

import java.util.List;

public interface ClassedService {
    Integer insert(Classed classed);
    Classed selectOne(Long classId);
    List<Classed> selectOfTeacherId(Long teacherId);
    List<Classed> selectAll();
    List<Classed> selectAllOfDeleteFlag();
    Integer delete(Long classId);
    Integer update(Classed classed);
}
