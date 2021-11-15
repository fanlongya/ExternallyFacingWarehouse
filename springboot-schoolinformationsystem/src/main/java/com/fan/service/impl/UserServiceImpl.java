package com.fan.service.impl;

import com.fan.domain.User;
import com.fan.mapper.UserMapper;
import com.fan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertUser(User user) {
        Integer result;
        if(selectOne(user.getUserId())!=null){
            user.setDeleteFlag(0);
            result=update(user);
        }else{
            result=userMapper.insert(user);
        }
        return result;
    }

    @Override
    public User selectOne(Long userId) {
        return userMapper.selectOne(userId);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectAllOfDeleteFlag() {
        return userMapper.selectAllOfDeleteFlag();
    }

    @Override
    public Integer delete(Long userId) {
        return userMapper.delete(userId);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }
}
