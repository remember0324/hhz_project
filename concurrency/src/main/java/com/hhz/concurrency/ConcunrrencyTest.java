package com.hhz.concurrency;

import com.hhz.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author Rem
 * @Date 2019-09-09
 * @Version 1.0
 */

@Slf4j
@NotThreadSafe
public class ConcunrrencyTest {

    //请求总数
    public static int clientTotal = 5000;

    //线程总数
    public static int threadTotal = 200;

    //统计
    public static int count = 0;


    private static void add() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //开始线程
                    semaphore.acquire();
                    add();
                    //释放线程
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception", e);
                    e.printStackTrace();
                }
                //每执行一次使用一次闭锁
                countDownLatch.countDown();
            });
        }
        //让当前线程处于阻塞状态，直到锁存器计数为零 以便统计
        countDownLatch.await();
        executorService.shutdown();
        //关闭线程池
        executorService.shutdown();
        log.info("count:{}", count);

    }


}
