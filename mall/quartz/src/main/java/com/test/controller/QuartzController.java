package com.test.controller;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@EnableScheduling //启动调度
public class QuartzController {

    int x = 0;
   // @Scheduled(cron = "0/3 37-41 10 * * ?")
    public void print() {

        int y = 0;
        String c = "abc" + (x++) + "--" + y++;
        System.out.println(c);
    }

}
