package com.hhz.jdk8_newFeature.Lambda;

/**
 * Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。在上面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 *
 * @Author Rem
 * @Date 2019-08-30
 * @Version 1.0
 */

public class Demo3 {

    final static String salutation = "hello";

    //接口1
    interface GreetingService {
        void sayMessage(String message);
    }


    //接口2
    interface Converter<T1, T2> {
        void convent(int i);
    }


    public static void main(String[] args) {

        //lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
        int num = 1;

        //此lambda表达式相当于实现接口1的方法
        GreetingService service = (message) -> {
            System.out.println(message + salutation);
        };

        //调用方法
        service.sayMessage("abc  ");

        //在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
        //String param = a;
        Converter<String, Object> c = (param) -> System.out.println(param + num);

        //Error:(41, 77) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
        // num = 4;
        c.convent(2);


    }
}
