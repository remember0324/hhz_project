package com.hhz.jdk8_newFeature.Date_Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @Author Rem
 * @Date 2019-09-04
 * @Version 1.0
 */

public class LocalDemo {

    public static void main(String[] args) {
        //获取当前日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间详细:" + currentTime);
        LocalDate localDate = currentTime.toLocalDate();
        System.out.println("当前时间日期:" + localDate);

        int year = currentTime.getYear();
        Month month = currentTime.getMonth();
        int dayOfMonth = currentTime.getDayOfMonth();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        int second = currentTime.getSecond();
        System.out.println("当前时间-年:" + year);
        System.out.println("当前时间-月:" + month);
        System.out.println("当前时间-月中的天:" + dayOfMonth);
        System.out.println("当前时间-时:" + hour);
        System.out.println("当前时间-分:" + minute);
        System.out.println("当前时间-秒:" + second);

        System.out.println("------------分割线-----------");
        LocalDateTime nationalDay = currentTime.withMonth(10).withDayOfMonth(1);
        System.out.println("国庆节:" + nationalDay);

        LocalDate MacaoBack = LocalDate.of(1999, Month.SEPTEMBER, 20);
        System.out.println("澳门回归日期:" + MacaoBack);

        LocalTime parse = LocalTime.parse("13:10");
        System.out.println("String转LocalTime:" + parse);
        System.out.println(parse);

    }

}
