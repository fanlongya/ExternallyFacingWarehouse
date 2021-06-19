package com.fan.service;

import com.fan.mapper1.GuestMapper1;
import com.fan.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    //    @Autowired
//    private GuestMapper mapper;
    @Autowired
    private GuestMapper1 mapper1;

    @Override
    public List<Guest> selectList() {
        return mapper1.selectList();
    }
}
