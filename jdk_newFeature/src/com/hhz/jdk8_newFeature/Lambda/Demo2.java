package com.hhz.jdk8_newFeature.Lambda;

/**
 * 语法格式:
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 *
 * @Author Rem
 * @Date 2019-08-30
 * @Version 1.0
 */

public class Demo2 {
    interface MathOperation {
        int operation(int a, int b);
    }

    interface MathOperation2 {
        default int operation(int a, int b) {
            return a - b;
        }
    }


    interface GreetingService {
        void sayMessage(String message);
    }

    //不做具体实现
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    //具体实现
    private int operate2(int a, int b) {
        MathOperation m = (aa, bb) -> aa - bb;
        return m.operation(a, b);
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        // 类型声明
        MathOperation m1 = (a, b) -> a + b;
        // 不用类型声明
        MathOperation m2 = (int a, int b) -> a - b;
        // 大括号中的返回语句
        MathOperation m3 = (a, b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation m4 = (a, b) -> a / b;

        int aa = demo2.operate(2, 1, (a, b) -> a + b);

        System.out.println(aa);


        System.out.println("10 + 5 = " + demo2.operate(10, 5, m1));
        System.out.println("10 - 5 = " + demo2.operate(10, 5, m2));
        System.out.println("10 x 5 = " + demo2.operate(10, 5, m3));
        System.out.println("10 / 5 = " + demo2.operate(10, 5, m4));


        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

}
