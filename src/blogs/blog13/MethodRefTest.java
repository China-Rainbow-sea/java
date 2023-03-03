package blogs.blog13;

import day33.java.Employee;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodRefTest {



    public static void main2(String[] args) {
        // 匿名实现接口的方式：
        Employee emp = new Employee(1001,"Tom",23,5600);
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return emp.getName();
            }
        };
        String regStr1 = supplier1.get();  // 调用其 Supplier 重写的get()抽象方法
        System.out.println(regStr1);

        // Lambda 表达式
        Supplier<String> supplier2 = ()->emp.getName();
        String regStr2 = supplier2.get();  // 调用其 Supplier 重写的get()抽象方法
        System.out.println(regStr2);


        // 方法引用
        Supplier<String> supplier3 = emp::getName;
        String regStr3 = supplier3.get();  // 调用其 Supplier 重写的get()抽象方法
        System.out.println(regStr3);
    }



    public static void main1(String[] args) {
        // 匿名实现接口的方式：
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("匿名实现接口的方式: " + s);
            }
        };

        consumer1.accept("Hello World");

        // Lambda 表达式
        Consumer<String> consumer2 = s-> System.out.println("Lambda 表达式: " + s);
        consumer2.accept("Hello World");

        // 方法引用
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello World");

    }
}
