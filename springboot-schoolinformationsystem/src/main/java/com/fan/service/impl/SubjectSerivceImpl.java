package com.fan.service.impl;

import com.fan.domain.Subject;
import com.fan.mapper.SubjectMapper;
import com.fan.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectSerivceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;
    @Override
    public Subject selectOne(Long subjectId) {
        return subjectMapper.selectOne(subjectId);
    }
}
