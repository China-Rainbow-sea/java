package day33.java;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *  和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *  抽象方法的返回值类型即为构造器所属的类的类型。
 *
 * 二、数组引用
 * 大家可以把数组看做是一个特殊的类，则写法与构造器引用是一致的，稍微多了一个 String[]::new 方括号。
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){

        // 匿名实现接口重写其中的抽象方法
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        System.out.println(sup.get());

        // Lambda 表达式 无参数，一条语句，一个返回值  {} 可以省略，()不可以省略
        Supplier<Employee> supplier = ()->new Employee();

        System.out.println(supplier.get());

        // 构造器引用
        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier2.get());


    }

	//Function中的R apply(T t)
    @Test
    public void test2(){

        // Lambda 表达式 一个参数，一个返回值，() {} 可以省略
        Function<Integer,Employee> function1 = id->new Employee(id);
        Employee employee = function1.apply(1001);
        System.out.println(employee);

        // 构造器引用
        Function<Integer,Employee> function2 = Employee::new;
        Employee apply = function2.apply(1002);
        System.out.println(apply);

    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        // Lambda 表达式 两个参数，一个返回值
        BiFunction<Integer,String,Employee> function = (id,name)->new Employee(id,name);
        Employee tom = function.apply(1001, "Tom");
        System.out.println(tom);

        // 构造器引用
        BiFunction<Integer,String,Employee> function2 = Employee::new;
        Employee tom2 = function2.apply(1002, "Tom2");
        System.out.println(tom2);

    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        // Lambda 一个参数，一个返回值 () {} 可以省略
        Function<Integer,String[]> function = length->new String[length];
        String[] arr1 = function.apply(5);

        System.out.println(Arrays.toString(arr1));

        // 数组引用:
        Function<Integer,String[]> function2 = String[]::new;
        String[] apply = function2.apply(6);
        System.out.println(Arrays.toString(apply));

    }
}
