package com.hhz.jdk8_newFeature.defaultMethod;

/**
 * Java 8 新增了接口的默认方法。
 * 简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
 * 我们只需在方法名前面加个 default 关键字即可实现默认方法。
 *
 * @Author Rem
 * @Date 2019-09-03
 * @Version 1.0
 */
public interface Demo {

    interface Vehicle {
        default void print() {
            System.out.println("我是一辆四轮车");

        }

        default void horn() {
            System.out.println("四轮车按喇叭");

        }

        static void vehicle() {
            System.out.println("四轮车的静态方法");
        }

    }


    interface FourWheeler {
        default void print() {
            System.out.println("我是一辆摩托车");

        }
    }

    class Car implements Vehicle, FourWheeler {

        public void print() {
            Vehicle.super.print();
            FourWheeler.super.print();
            Vehicle.super.horn();
            Vehicle.vehicle();
            System.out.println("我是一辆汽车");
        }
    }

    static void main(String[] args) {
        new Car().print();
    }

}
