package com.test.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

public class MyTime {

    /**
     * jdk1.8 时间计算
     */
    public static void show() {
        LocalDate now = LocalDate.now();
        //三天前
        LocalDate before = now.minusDays(3);
        //三天后
        LocalDate after = now.plusDays(3);
        //生日
        MonthDay birthday = MonthDay.of(12, 4);
        //今天
        MonthDay today = MonthDay.from(now);
        if (birthday.equals(today)) {
            System.out.println("生日快乐");
        }
        DayOfWeek dayOfWeek = DayOfWeek.from(now);
        System.out.println(dayOfWeek.getValue());

        LocalTime time = LocalTime.now();
        System.out.println(time);

    }

    public static void main(String[] args) {
        show();
    }
}
