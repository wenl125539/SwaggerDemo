package com.wenl.swagger.controller;

import com.wenl.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
