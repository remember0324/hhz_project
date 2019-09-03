package com.hhz.jdk8_newFeature.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用通过方法的名字来指向一个方法
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码
 * 方法引用使用一对冒号 ::
 *
 * @Author Rem
 * @Date 2019-08-31
 * @Version 1.0
 */

public interface Demo<T> {

    // 方法引用 :: 是Lambda表达式的另一种简写方式
    //类名::静态方法
    //对象::实例方法
    //类名::实例方法

    class Car {
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }


        //静态方法引用：它的语法是Class::static_method，实例如下
        public static void main(String[] args) {
            //lambda表示
            final Car car1 = Car.create(() -> new Car());


            //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
            final Car car = Car.create(Car::new);
            final List<Car> cars = Arrays.asList(car);

            //普通表示
            for (Car car2 : cars) {
                System.out.println(car2);
            }
            //lambda表示
            cars.forEach(car2 -> System.out.println(car2));
            //lambda+方法引用表示
            cars.forEach(System.out::println);
            //静态方法引用：它的语法是Class::static_method，实例如下：
            cars.forEach(Car::collide);
            //特定类的任意对象的方法引用：它的语法是Class::method实例如下：
            cars.forEach(Car::repair);
            //特定对象的方法引用：它的语法是instance::method实例如下：
            final Car police = Car.create(Car::new);
            cars.forEach(police::follow);

        }
    }
}
