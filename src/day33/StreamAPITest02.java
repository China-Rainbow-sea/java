package day33;


import day33.java.Employee;
import day33.java.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 的中间操作
 * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
 * 而在终止操作时一次性全部处理，称为 “惰性求值”
 * filter(Predicate p) 接收 Lambda ，从流中排除某些元素。
 * distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 * limit(long maxSize) 截断流，使其元素不超过给定数量。
 * skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流，若流中元素不足 n 个，则返回
 * 一个空流，与 limit()互补.
 */
public class StreamAPITest02 {


    /**
     * 筛选 与切片
     */
    @Test
    public void test() {
        List<Employee> list = EmployeeData.getEmployees();
        // 创建一个 Stream 对象
        Stream<Employee> stream = list.stream();
        // boolean test(T t); 一个参数，一条语句一个返回值 () {} return 省略
        // 筛选出 Employee 对象中  salary > 7000 的信息
        stream.filter(e->e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("**********************");

        // limit(n) ---截断流，使其元素不超过给定数量
        // 注意: stream 和集合中的迭代器是一样的，不可多次不同结构使用。
        // 再次使用时需要新建一个 stream 对象
        list.stream().limit(3).forEach(System.out::println);


        System.out.println("***************");

        // skip(n) 跳过元素，返回一个扔掉了前 n 个元素的流，若流中元素不足 n 个，则返回一个 空
        // stream 不可二次使用，需要新建
        list.stream().skip(2).forEach(System.out::println);

        System.out.println("*****************************");
        // distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        // 所以对应存储的 Employee 对象需要重写 hashCode() 和  equals()方法
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",20,8000));

        list.stream().distinct().forEach(System.out::println);




    }


    /**
     * 映射
     */
    @Test
    public void test2() {
        // map(Function f) 接收一个函数作为参数；将元素转换成其他形式或提取信息，该函数被
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        // R apply(T t); 一个参数，一个返回值 ，(){} return 可以省略
        /*
        public String toUpperCase() {
        return toUpperCase(Locale.getDefault());
    }
         */
        list.stream().map(str->str.toUpperCase()).forEach(System.out::println);

        // 练习: 获取员工姓名长度大于 3 的员工的姓名:
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stream = employees.stream().map(Employee::getName);
        stream.filter(name->name.length() > 3).forEach(System.out::println);
    }


    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList list2 = new ArrayList();

        list2.add(4);
        list2.add(5);
        list2.add(6);

        /*list.add(list2);
        System.out.println(list);

        System.out.println("**********");*/

        list.addAll(list2);
        System.out.println(list);

    }

    // flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的
    // 数据组成一个数据

    // 将字符串中的多个字符构成的集合转换为对应的 Stream 的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()) {  // str.toCharArray()将字符串转换为字符数组
            list.add(c);
        }

        return list.stream();
    }

    /**
     * 映射
     * // flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的
     *     // 数据组成一个数据
     */
    @Test
    public void test4() {
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest02::fromStringToStream);

        streamStream.forEach(s->{
            s.forEach(System.out::println);
        });
        Stream<Stream<Character>> characterStream = list.stream().map(StreamAPITest02::fromStringToStream);
        characterStream.forEach(System.out::println);

    }


    /**
     * 排序
     */
    @Test
    public void test5() {
        // sorted -- 自然排序
        // 注意排序：需要实现  Comparable 接口或者是 Comparator 定制排序
        List<Integer> list = Arrays.asList(12,65,87,0,-98,7);
        list.stream().sorted().forEach(System.out::println);

        // 抛异常，原因: Employee 没有实现 Comparable 接口
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->{
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);


        System.out.println("**********************");
        // sorted(comparator  com ) 定制排序 通过年龄排序，默认是升序的 > 0 返回 1，
        List<Employee> employees2 = EmployeeData.getEmployees();
        Stream<Employee> sorted = employees2.stream().sorted((e1, e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());

            if (ageValue != 0) {
                return ageValue;
            } else {   // 年龄一致，比较薪资
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });
        sorted.forEach(System.out::println);

    }
}
