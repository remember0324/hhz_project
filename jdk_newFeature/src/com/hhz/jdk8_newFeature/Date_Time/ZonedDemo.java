package com.hhz.jdk8_newFeature.Date_Time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Author Rem
 * @Date 2019-09-04
 * @Version 1.0
 */

public class ZonedDemo {

    public static void main(String[] args) {

        testZonedDateTime();

    }

    private static void testZonedDateTime() {
        //获取当前时间
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("当前时间:" + zonedDateTime);

        ZoneId zoneId = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId:" + zoneId);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当前时区: " + currentZone);
    }
}
