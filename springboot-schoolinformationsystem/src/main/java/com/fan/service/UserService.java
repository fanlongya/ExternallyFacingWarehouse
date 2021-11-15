package com.fan.service;

import com.fan.domain.User;

import java.util.List;

public interface UserService {
    Integer insertUser(User user);
    User selectOne(Long userId);
    List<User> selectAll();
    List<User> selectAllOfDeleteFlag();
    Integer delete(Long userId);
    Integer update(User user);
}
