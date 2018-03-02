package com.test.time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 执行简单任务
 */
public class MyTask {
    static int x = 0;
    public  static  void start() {

        //计时器
        Timer a = new Timer();
        //任务,1s后开始，每隔3s执行一次
        a.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务" + x++);
            }
        }, 1000, 3000);

    }

    public static void main(String[] args) {
        start();
    }
}
