package com.fan.controller;

import com.fan.domain.Classed;
import com.fan.service.ClassedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classed")
@Api(tags = "班级管理控制类",description = "这是一个管理班级的新增，删除，修改，查询")
public class ClassedController {
    @Autowired
    private ClassedService classedService;
    @PostMapping("/insertClassed")
    @ApiOperation("这是新增班级方法")
    public String addClassed(Classed classed){
        return classedService.insert(classed).toString();
    }
    @GetMapping("/selectClassed/{classId}")
    @ApiOperation("这是根据班级ID查看班级方法")
    public Classed selectClassed(@PathVariable("classId") Long classId){
        return classedService.selectOne(classId);
    }
    @GetMapping("/selectClassesor")
    @ApiOperation("这是管理员查看全部班级方法")
    public List selectClassedesOfRoot(){
        return classedService.selectAll();
    }
    @GetMapping("/selectClasses")
    @ApiOperation("这是普通用户查看全部班级方法")
    public List selectClassedes(){
        return classedService.selectAllOfDeleteFlag();
    }
    @DeleteMapping("/deleteClassed/{classId}")
    @ApiOperation("这是删除班级方法")
    public Integer deleteClassed(@PathVariable("classId") Long classId){
        return classedService.delete(classId);
    }
    @PutMapping("/updateClassed")
    @ApiOperation("这是修改班级方法")
    public Integer updateClassedes(Classed classed){
        return classedService.update(classed);
    }
}
