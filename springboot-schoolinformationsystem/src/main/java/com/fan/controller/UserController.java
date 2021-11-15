package com.fan.controller;

import com.fan.domain.User;
import com.fan.service.UserRoleService;
import com.fan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理类",description = "对用户进行新增，修改，删除，查询等操作")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @ApiOperation("这用户新增方法，同时会根据参数角色id，在用户和角色的关联表新增数据")
    @PostMapping("/insert")
    public Integer addUser(User user,Long roleId){
        if(roleId!=null){
            userRoleService.insert(user.getUserId(),roleId,null);
        }
        Integer result = userService.insertUser(user);
        return result;
    }
    @ApiOperation("这是用户查询方法，根据用户id查询相应用户")
    @GetMapping("/selectOne/{userId}")
    public User selectOneUser(@PathVariable("userId") Long userId){
        User result=userService.selectOne(userId);
        return result;
    }
    @ApiOperation("这是管理员查询所有用户的方法")
    @GetMapping("/selectAllor")
    public List<User> selectOneUserOfRoot(){
        List<User> result=userService.selectAll();
        return result;
    }
    @ApiOperation("这是普通角色查询所有用户的方法")
    @GetMapping("/selectAll")
    public List<User> selectOneUser(){
        List<User> result=userService.selectAllOfDeleteFlag();
        return result;
    }
    @ApiOperation("这是删除用户的方法")
    @DeleteMapping("/delete/{userId}")
    public Integer deleteUser(@PathVariable("userId") Long userId){
        Integer result=userService.delete(userId);
        return result;
    }
    @ApiOperation("这是修改用户的方法")
    @PutMapping("/Update")
    public Integer updateUser(User user){
        Integer result=userService.update(user);
        return result;
    }
}
