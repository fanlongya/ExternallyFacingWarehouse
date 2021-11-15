package com.fan.service;

import java.util.List;
import java.util.Map;

public interface UserRoleService {
    Integer insert(Long userId,Long roleId,String yl1);
    Map selectOne(Long userId,Long roleId);
    List selectAll();
    List selectAllOfDeleteFlag();
    Integer delete(Long userId,Long roleId);
    Integer update(Long userId,Long roleId,Integer deleteFlag,String yl1);
}
