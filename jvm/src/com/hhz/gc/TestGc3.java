package com.hhz.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * CMS全称 Concurrent Mark Sweep，是一款并发的、使用标记-清除算法的垃圾回收器，
 * 该回收器是针对老年代垃圾回收的，通过参数-XX:+UseConcMarkSweepGC进行设置。
 * :‐XX:+UseConcMarkSweepGC ‐XX:+PrintGCDetails ‐Xms16m ‐Xmx16m
 *
 *
 * @Author hehongzhi
 * @Date 2019-08-25
 * @Version 1.0
 */

public class TestGc3 {

    public static void main(String[] args) throws Exception {

        //实现:不断的产生新的数据(对象),随机的的废弃对象(垃圾)
        List<Object> list = new ArrayList<>();

        while (true) {
            int sleep = new Random().nextInt(100);
            if (System.currentTimeMillis() % 2 == 0) {
                list.clear();
            } else {
                //向list添加10000个对象并且设置最大内存为16M
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key__" + i, "value_" + System.currentTimeMillis());
                    list.add(properties);
                }
            }
            Thread.sleep(sleep);
        }

    }
}
