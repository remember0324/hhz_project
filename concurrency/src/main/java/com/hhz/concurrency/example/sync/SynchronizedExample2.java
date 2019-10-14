package com.hhz.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized:同步关键词
 * 注意:在子类继承父类时,父类有synchronized修饰的方法时,子类使用父类的方法不具有synchronized属性,需要重新写上
 *
 * @Author Rem
 * @Date 2019-09-11
 * @Version 1.0
 */

@Slf4j
public class SynchronizedExample2 {

    //修饰一个类
    public void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    //修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    /**
     * 不同对象分两个线程访问被synchronized修饰的静态方法时,本类的所有对象同一时间只能有一个线程被执行;
     * 不同对象分两个线程访问被synchronized修饰的静态类时,本类的所有对象同一时间只能有一个线程被执行;
     *
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });

        executorService.execute(() -> {
            example2.test1(2);
        });

    }
}
