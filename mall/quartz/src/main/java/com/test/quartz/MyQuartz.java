package com.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyQuartz {
    static Scheduler scheduler;
    static JobDetail detail;
    static {
        try {
             scheduler = StdSchedulerFactory.getDefaultScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        //包装成一个task
        detail = JobBuilder.newJob(FirstJob.class).build();
    }

    //执行规则:每月4日的上午10点, 每隔5秒执行一次
    public static CronScheduleBuilder cron() {
        return CronScheduleBuilder.cronSchedule("0/5 * 10 4 * ?");
    }

    public static void main(String[] args) {
        //触发器
        CronTrigger trigger = TriggerBuilder.newTrigger().startNow().withSchedule(cron()).build();

        try {
            scheduler.scheduleJob(detail,trigger);
            //开始执行任务
            scheduler.start();
            //scheduler.pauseJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
