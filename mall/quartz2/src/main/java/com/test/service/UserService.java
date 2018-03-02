package com.test.service;

import com.test.dao.UserDaop;
import com.test.entity.User1;
import org.quartz.CronTrigger;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDaop userDao1;

    @Resource
    private QuartzService quartzService;
    //private CronTrigger[] tri;
    public void findAllUsers() {
       // tri = new CronTrigger[10];
        int i = 0;
        List<User1> allUsers = userDao1.findAllUsers();
        //for (User1 user : allUsers) {
           // String id = user.getIdentityCard();
            //410-323-19950420-4014
         //   String month = id.substring(10, 12);
          //  String day = id.substring(12, 14);
            //0/5 * 10 4 * ?     0 0 0 day month ?
            String cron = "0 37 17 " + 4 + " " + 12 + " ?";


            //触发器
            CronTrigger  tri = TriggerBuilder.newTrigger().startNow().withSchedule(quartzService.cron(cron)).build();


            try {
                quartzService.scheduler.scheduleJob(quartzService.detail,tri);
                //开始执行任务
               quartzService.scheduler.start();
                //scheduler.pauseJob();
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
            //if
        }



  //  }




}
