package com.hhz.concurrency.example.atomic;

import com.hhz.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

/**
 * 本实例线程安全
 * 原子性：提供互斥访问，同一时刻只能有一个线程对数据进行操作，（atomic,synchronized）；
 *
 * @Author Rem
 * @Date 2019-09-09
 * @Version 1.0
 */

@Slf4j
@ThreadSafe
public class AtomicExample3 {

    //请求总数
    public static int clientTotal = 5000;

    //线程总数
    public static int threadTotal = 200;

    //统计  --(LongAdder通过分散提高性能,统计并发更新有可能有数据误差)
    //处理高并发优先使用LongAdder而不是使用AtomicLong
    //需要准确数值,全局唯一值还是使用AtomicLong
    public static LongAdder count = new LongAdder();

    private static void add() {
        count.decrement();
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
