package blogs.blog13;


import day33.java.Employee;
import day33.java.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamAPITest {
    public static void main(String[] args) {
        // 迭代:
        //public static<T> Stream<T> inerate(final T seed,final UnaryOperator<T> f)
        // 遍历前 10 个偶数
        Stream.iterate(0,t->t+2).forEach(System.out::println);

        // 生成:
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }


    public static void main3(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        System.out.println(stream);
    }



    public static void main2(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};

        // 调用 Arrays 类中的 static<T> stream(T[] array)返回一个对象
        IntStream stream = Arrays.stream(arr);
        System.out.println(stream);

    }

    public static void main1(String[] args) {
        List<Employee> employeeList = EmployeeData.getEmployees();
        //default Stream<E> stream(): 返回一个顺序流
        Stream<Employee> stream = employeeList.stream();
        System.out.println(stream);

        // default Stream<E> parallelStream : 返回一个并行流
        Stream<Employee> employeeStream = employeeList.parallelStream();
        System.out.println(employeeStream);
    }
}
