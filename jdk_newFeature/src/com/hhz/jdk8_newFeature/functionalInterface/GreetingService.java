package com.hhz.jdk8_newFeature.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * JDK 1.8 之前已有的函数式接口:
 * java.lang.Runnable
 * java.util.concurrent.Callable
 * java.security.PrivilegedAction
 * java.util.Comparator
 * java.io.FileFilter
 * java.nio.file.PathMatcher
 * java.lang.reflect.InvocationHandler
 * java.beans.PropertyChangeListener
 * java.awt.event.ActionListener
 * javax.swing.event.ChangeListener
 * <p>
 * JDK 1.8 新增加的函数接口：
 * java.util.function
 *
 * @Author Rem
 * @Date 2019-09-02
 * @Version 1.0
 */
public class GreetingService {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

        System.out.println("输出所有数据:");

        // 传递参数 n
        eval(list, n -> true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true

        System.out.println("输出所有偶数:");

        eval(list, n -> n % 2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true

        System.out.println("输出大于 3 的所有数字:");

        eval(list, n -> n > 3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {

        //第一种方式
        //list.stream().filter(predicate).forEach(System.out::println);
        //第二种方式
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}
