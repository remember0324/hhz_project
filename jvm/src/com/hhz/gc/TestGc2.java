package com.hhz.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * ParallelGC:
 * -XX:+UseParallelGC
 * 年轻代使用ParallelGC垃圾回收器，老年代使用串行回收器。
 * -XX:+UseParallelOldGC
 * 年轻代使用ParallelGC垃圾回收器，老年代使用ParallelOldGC垃圾回收器。
 * -XX:MaxGCPauseMillis
 * 设置最大的垃圾收集时的停顿时间，单位为毫秒
 * 需要注意的时，ParallelGC为了达到设置的停顿时间，可能会调整堆大小或其他
 * 的参数，如果堆的大小设置的较小，就会导致GC工作变得很频繁，反而可能会
 * 影响到性能。
 * 该参数使用需谨慎。
 * -XX:GCTimeRatio
 * 设置垃圾回收时间占程序运行时间的百分比，公式为1/(1+n)。
 * 它的值为0~100之间的数字，默认值为99，也就是垃圾回收时间不能超过1%
 * -XX:UseAdaptiveSizePolicy
 * 自适应GC模式，垃圾回收器将自动调整年轻代、老年代等参数，达到吞吐量、
 * 堆大小、停顿时间之间的平衡。
 * 一般用于，手动调整参数比较困难的场景，让收集器自动进行调整。
 *
 * @Author hehongzhi
 * @Date 2019-08-24
 * @Version 1.0
 */

public class TestGc2 {

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
