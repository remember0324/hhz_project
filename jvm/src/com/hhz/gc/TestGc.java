package com.hhz.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * 分别使用串行:-XX:+UseSerialGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 *        并行:-XX:+UseParNewGC -XX:+PrintGCDetails -Xms16m -Xmx16m
 * 垃圾回收
 * @Author hehongzhi
 * @Date 2019-08-24
 * @Version 1.0
 */

public class TestGc {

    public static void main(String[] args) throws Exception {

        //实现:不断的产生新的数据(对象),生育户的废弃对象(垃圾)
        List<Object> list = new ArrayList<>();

        while (true) {
            int sleep = new Random().nextInt(100);
            if (System.currentTimeMillis() % 2 == 0) {
                list.clear();
            } else {
                //向list添加10000个对象并且设置最大内存为16M
                for (int i = 0; i < 10000; i++) {
                    Properties properties = new Properties();
                    properties.put("key_" + i, "value_" + System.currentTimeMillis());
                    list.add(properties);
                }
            }
            Thread.sleep(sleep);
        }

    }
}
