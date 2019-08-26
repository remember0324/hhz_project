package com.hhz.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * G1垃圾收集器相对比其他收集器而言，最大的区别在于它取消了年轻代、老年代的物理
 * 划分，取而代之的是将堆划分为若干个区域（Region），这些区域中包含了有逻辑上的
 * 年轻代、老年代区域。
 * -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:+PrintGCDetails -Xmx256m
 *
 *
 * @Author hehongzhi
 * @Date 2019-08-25
 * @Version 1.0
 */

public class TestGc4 {

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
