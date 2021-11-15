package com.fan.service;
import com.fan.mapper.GuestDao;
import com.fan.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServise {
    @Autowired
    private GuestDao dao;

    public List<Guest> selectAllGuest() {
        return dao.selectList();
    }

    public void update(Guest guest) {
        dao.update(guest);
    }

    public void delete(Long id) {
        dao.delete(id);
    }

    public Guest getGuest(Long id) {
        return dao.getGuest(id);
    }

    public void add(Guest guest) {
        dao.add(guest);
    }
}
