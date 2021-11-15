package com.fan.service.impl;

import com.fan.mapper.UserRoleMapper;
import com.fan.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public Integer insert(Long userId, Long roleId, String yl1) {
        Integer result;
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("roleId",roleId);
        map.put("yl1",yl1);
        if(selectOne(userId,roleId)!=null){
            map.put("deleteFlag",0);
            result=userRoleMapper.update(map);
        }else {
            result=userRoleMapper.insert(map);
        }
        return result;
    }

    @Override
    public Map selectOne(Long userId, Long roleId) {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("roleId",roleId);
        return userRoleMapper.selectOne(map);
    }

    @Override
    public List selectAll() {
        return userRoleMapper.selectAll();
    }

    @Override
    public List selectAllOfDeleteFlag() {
        return userRoleMapper.selectAllOfDeleteFlag();
    }

    @Override
    public Integer delete(Long userId, Long roleId) {
        return userRoleMapper.delete(userId,roleId);
    }

    @Override
    public Integer update(Long userId, Long roleId, Integer deleteFlag, String yl1) {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("roleId",roleId);
        map.put("deleteFlag",deleteFlag);
        map.put("yl1",yl1);
        return userRoleMapper.update(map);
    }
}
