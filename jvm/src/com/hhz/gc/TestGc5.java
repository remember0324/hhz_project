package com.hhz.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 *可视化测试
 *
 *
 * -XX:+UseG1GC ‐XX:MaxGCPauseMillis=100 ‐Xmx256m ‐XX:+PrintGCDetails ‐
 * XX:+PrintGCTimeStamps ‐XX:+PrintGCDateStamps ‐XX:+PrintHeapAtGC ‐
 * Xloggc:E://test//gc.log
 *
 * @Author hehongzhi
 * @Date 2019-08-25
 * @Version 1.0
 */

public class TestGc5 {

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
