package com.fan.service;

import com.fan.mapper.GuestMapper;
import com.fan.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestMapper mapper;

    @Override
    public List<Guest> selectList() {
        return mapper.selectList(null);
    }
}
