package day33;


import day33.java.Employee;
import day33.java.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java8 中有两大最为重要的改变，第一个是 Lambda 表达式，另一个则是Stream API
 * 1. Stream API （java.util.stream） 把真正的函数式编程风格引入到Java中。这是目前为止
 * 对Java类库最好的补充，因为 Stream API 可以极大提供 Java程序员的生产力，让程序员写出高效效率，干净
 * 简洁的代码。
 * 2.Stream 是Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行
 * 非常复杂的查找，过滤和映射数据等操作。使用 Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库
 * 查询。也可以使用 Stream API 来并行执行操作，简而言之， Stream API 提供了一种高效且易于
 * 使用的处理数据的方式，
 *
 *  为什么要使用 Stream API
 *   1. 实际开发中，项目中多数据源都来自于 Mysql,Oracle 等，但现在数据源可以更多了，
 *   有 MongDB, Redis 等，而这些 NoSQL 的数据就需要Java层面去处理。
 *
 *   2. Stream 和 Collection 集合的区别： Collection 是一种静态的内存数据结构，而 Stream 是有关
 *   计算的，前者是主要面向内存，存储在内存中，后者主要是面向 CPU,通过 CPU 实现计算。
 *
 *   什么是 Stream
 *   是数据渠道，用于操作数据源(集合，数组等) 所生成的元素序列，“集合讲的是数据，Stream 讲的是计算！”
 *
 *   注意:
 *   1.Stream 自己不会存储元素
 *   2.Stream 不会改变源对象，相反，他们会返回一个持有结果的新 Stream
 *   3.Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 *   Stream 的操作三个步骤：
 *   1. 创建 Stream
 *   一个数据源(如: 集合，数组) 获取一个流
 *   2. 中间操作
 *   一个中间操作链，对数据源的数据进行处理。
 *   3. 终止操作(终端操作)
 *   一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用(也不可再被使用，
 *   就像集合中的Iterator 迭代器一样，)
 *
 *   创建 Stream 四种方式:
 */
public class SteamAPITest {


    /**
     * 创建Stream 方式一，通过集合
     */
    @Test
    public void test() {
        List<Employee> employee = EmployeeData.getEmployees();

        // default Stream<E> stream() ： 返回一个顺序流
        Stream<Employee> stream = employee.stream();

        // default Stream<E> parallelStream: 返回一个并行流
        Stream<Employee> employeeStream = employee.parallelStream();

    }


    /**
     * 创建 Stream 方式二：通过数组
     */
    @Test
    public void test2() {
        int[] arr = new int[]{1,2,3,4,5,6};
        // 调用 Arrays 类的 static <T> Stream<T> stream (T[] array) 返回一个类
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};

        // <Employee> 泛型
        Stream<Employee>stream1 = Arrays.stream(arr1);

    }

    /**
     * 创建 Stream 的方式三: 通过 Stream 的 of()
     */
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
    }


    /**
     * 创建 Stream 方式四: 创建无限流
     */
    @Test
    public void test4() {
        // 迭代:
        //public static<T> Stream<T> inerate(final T seed,final UnaryOperator<T> f)
        // 遍历前 10 个偶数
        Stream.iterate(0,t->t+2).forEach(System.out::println);

        // 生成:
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}
