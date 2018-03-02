package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/27.
 */
@Controller
public class RootController {
    @RequestMapping("/")
    public String toRool(){
        return "index";
    }
}
