package com.fan.service;

//import com.fan.dao.GuestDao;

import com.fan.domain.Guest;
import com.fan.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiseImpl implements GuestService {
    //    private GuestDao dao;dao.selectList();
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> selectAllGuest() {
        return guestRepository.findAll();
    }
//    public void update(Guest guest){
//        dao.update(guest);
//    }
//    public void delete(Long id){
//        dao.delete(id);
//    }
//    public Guest getGuest(Long id){
//        return dao.getGuest(id);
//    }
//    public void add(Guest guest){
//        dao.add(guest);
//    }
}
