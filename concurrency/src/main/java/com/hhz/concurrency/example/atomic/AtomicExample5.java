package com.hhz.concurrency.example.atomic;

import com.hhz.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 基于反射的实用工具，可以对指定类的指定 volatile int 字段进行原子更新。
 * 此类用于原子数据结构，该结构中同一节点的几个字段都独立受原子更新控制。
 * AtomicIntegerFieldUpdater:根据类,对类中字段进行更新
 *
 * @Author Rem
 * @Date 2019-09-09
 * @Version 1.0
 */

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 200)) {
            log.info("update success 1, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 200)) {
            log.info("update success 1, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }
    }
}
