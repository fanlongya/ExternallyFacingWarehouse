package com.fan.mapper;

import com.fan.domain.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestDao {
    private static List<Guest> guests = new ArrayList<>();

    static {
        guests.add(new Guest(000001l, "曾繁龙", "霸道总裁"));
        guests.add(new Guest(000002l, "小江", "技术总监"));
        guests.add(new Guest(000003l, "魏翱", "营销总监"));
        guests.add(new Guest(000004l, "江涛", "策划总监"));
        guests.add(new Guest(000005l, "有杰", "销售总监"));
    }

    public List<Guest> selectList() {
        return guests;
    }

    public void add(Guest guest) {
//        int size=guests.size()+1;
//        guest.setId((long) size);
        guests.add(guest);
    }

    public void update(Guest guest) {
        long id = guest.getId();
        Guest guest1 = null;
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId() == id) {
                guest1 = guests.get(i);
            }
        }
        guest1.setName(guest.getName());
        guest1.setRole(guest.getRole());
    }

    public void delete(Long id) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId() == id) {
                guests.remove(i);
                break;
            }
        }
    }

    public Guest getGuest(Long id) {
        Guest guest = null;
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId() == id) {
                guest = guests.get(i);
            }
        }
        return guest;
    }
}
