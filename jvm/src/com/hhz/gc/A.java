package com.hhz.gc;

/**
 * @Author hehongzhi
 * @Date 2019-08-29
 * @Version 1.0
 */

public class A {

    public static int a = 1;

    static {
        System.out.println("A类静态块调用");
    }

    public A() {
        System.out.println("A类的无参构造!");
    }

    public void a() {
        System.out.println("a方法");
    }
}
