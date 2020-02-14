package com.wenl.swagger.controller;

import com.wenl.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Hello控制类")
@RestController
public class HelloController {


    @RequestMapping(value = "/hello",method = {RequestMethod.POST})
    public String hello(){
        return "hello";
    }

    @ApiOperation("getUser方法接口描述")
    @PostMapping("/getUser")
    public User getUser(){
        return new User();
    }

    @ApiOperation("getUser2方法接口描述")
    @PostMapping("/getUser2")
    public User getUser2(@ApiParam("用户名") String username){
        return new User();
    }

    @ApiOperation("getUser3Post方法接口描述")
    @PostMapping("/getUser3")
    public User getUser3(@ApiParam("用户") User user){
        return user;
    }
}
