package com.hhz.gc;

/**
 * @Author hehongzhi
 * @Date 2019-08-29
 * @Version 1.0
 */
public class B extends A {

    public static int b = 2;

    public B() {
        System.out.println("B类的构造被调用");
    }

    static {
        System.out.println("B类静态块调用");
    }


    static class D extends A {

        public static int e = 4;

        static {
            int e = 6;
            System.out.println("D类静态块调用");
        }


        public D() {
            System.out.println("D类的构造被调用");
        }

    }


    static class E extends D {

        public static int e = 5;

        static {
            System.out.println("E类静态块调用");
        }

        public E() {
            System.out.println("E类的构造被调用");
        }

    }


    public static void main(String[] args) {
        System.out.println(E.e);
    }
}
