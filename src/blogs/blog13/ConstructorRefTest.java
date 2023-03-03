package blogs.blog13;


import day33.java.Employee;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {
    /**
     *BiFunction中的R apply(T t,U u)
     */
    public static void main(String[] args) {
        // 匿名实现接口的方式
        BiFunction<Integer,String,Employee> biFunction = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer,s);
            }
        };
        Employee employee = biFunction.apply(100, "Tom"); // 调用 BiFunction 接口中的 apply()抽象方法
        System.out.println(employee);

        // Lambda 表达式
        BiFunction<Integer,String,Employee> biFunction2 = (id,name)->new Employee(id,name);
        Employee employee2 = biFunction2.apply(100, "Tom"); // 调用 BiFunction 接口中的 apply()抽象方法
        System.out.println(employee2);

        // 构造器引用
        BiFunction<Integer,String,Employee> biFunction3 = Employee::new;
        Employee employee3 = biFunction3.apply(100, "Tom"); // 调用 BiFunction 接口中的 apply()抽象方法
        System.out.println(employee3);

    }


    /**
     *
     * Function中的R apply(T t)
     */
    public static void main3(String[] args) {
        // 匿名实现接口的方式
        Function<Integer,Employee> function = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer integer) {
                return new Employee(integer);
            }
        };
        Employee apply = function.apply(100);  // 调用function接口中重写的apply()抽象方法
        System.out.println(apply);

        // Lambda  表达式
        Function<Integer,Employee> function2 = id->new Employee(id);
        Employee apply2 = function2.apply(100);  // 调用function接口中重写的apply()抽象方法
        System.out.println(apply2);

        // 构造器引用
        Function<Integer,Employee> function3 = Employee::new;
        Employee apply3 = function3.apply(100);  // 调用function接口中重写的apply()抽象方法
        System.out.println(apply3);

    }



    /**
     *
     * Supplier中的 T get()
     */
    public static void main2(String[] args) {
        // 匿名实现接口
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        Employee employee = supplier.get();  // 调用 Supplier 接口中重写 get()的抽象方法
        System.out.println(employee);

        // Lambda 表达式
        Supplier<Employee> supplier2 = ()->new Employee();
        Employee employee2 = supplier2.get();  // 调用 Supplier 接口中重写 get()的抽象方法
        System.out.println(employee2);

        // 构造器引用
        Supplier<Employee> supplier3 = Employee::new;
        Employee employee3 = supplier3.get();  // 调用 Supplier 接口中重写 get()的抽象方法
        System.out.println(employee3);
    }
}
