package com.hhz.concurrency.example.atomic;

import com.hhz.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference:对字段进行更新
 * AtomicReference和AtomicInteger非常类似，不同之处就在于AtomicInteger是对整数的封装，
 * 底层采用的是compareAndSwapInt实现CAS，比较的是数值是否相等，而AtomicReference则对应普通的对象引用，
 * 底层使用的是compareAndSwapObject实现CAS，比较的是两个对象的地址是否相等。
 * 也就是它可以保证你在修改对象引用时的线程安全性。
 * <p>
 * 引用类型的赋值是原子的。虽然虚拟机规范中说64位操作可以不是原子性的，
 * 可以分为两个32位的原子操作，但是目前商用的虚拟机几乎都实现了64位原子操作。
 *
 * @Author Rem
 * @Date 2019-09-09
 * @Version 1.0
 */

@Slf4j
@ThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        count.compareAndSet(0, 1); // no
        count.compareAndSet(1, 3); // no
        count.compareAndSet(2, 4); // 4
        count.compareAndSet(3, 5); // no
        log.info("count:{}", count.get());
    }


}
