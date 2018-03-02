package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @RequestMapping("login")
    public String login(String account, String pwd) {

        if (account.equals("qq")) {
            return "1";
        } else {
            return "0";
        }
    }
}
