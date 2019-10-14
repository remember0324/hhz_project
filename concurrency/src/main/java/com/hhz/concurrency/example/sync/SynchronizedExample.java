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
public class SynchronizedExample {

    //修饰一个类
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    //修饰一个静态方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    /**
     * 同一对象分两个线程访问被synchronized修饰的代码块时,先执行完一个线程再执行另外一个线程;
     * 同一对象分两个线程访问被synchronized修饰的普通方法时,先执行完一个线程再执行另外一个线程;
     * 不同对象分两个线程访问被synchronized修饰的代码块时,两个线程交替执行本线程内所有流程,线程之间不会有冲突;
     * 不同对象分两个线程访问被synchronized修饰的普通方法时,两个线程交替执行本线程内所有流程,线程之间不会有冲突;
     *
     * @param args
     */
    public static void main(String[] args) {
        SynchronizedExample example1 = new SynchronizedExample();
        SynchronizedExample example2 = new SynchronizedExample();
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });

        executorService.execute(() -> {
            example2.test2(2);
        });

    }
}
