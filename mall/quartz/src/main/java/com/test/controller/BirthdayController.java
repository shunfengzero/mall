package com.test.controller;

import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BirthdayController {

    @Resource
    private UserService userService;


    @RequestMapping("sendBirthdayMessage")
    public String sendBirthdayMessage() {
        userService.findAllUsers();
        return "1";
    }

}
