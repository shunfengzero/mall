package com.test.service;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;


@Component
public class QuartzService {

    static Scheduler scheduler;
    static JobDetail detail;
    static {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        //包装成一个task
        detail = JobBuilder.newJob(Send.class).build();
    }

    //执行规则:每月4日的上午10点, 每隔5秒执行一次
    public static CronScheduleBuilder cron(String cron) {

        return CronScheduleBuilder.cronSchedule(cron);
    }
}
