package day33;

import day33.java.Employee;
import day33.java.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试 Stream 的终止操作
 */
public class StreamAPITest03 {

    // 1. 匹配与查找
    /**
     * allMatch(Predicate p) 检查是否匹配所有元素。
     * 练习:是否所有的员工的年龄都大于 18
     */
    @Test
    public void test() {
        List<Employee> list = EmployeeData.getEmployees();

        boolean b = list.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);
    }

    /**
     * anyMath(Predicate p) 检查是否至少匹配一个元素：
     * 练习: 是否存在元素的工资大于 10000
     */
    @Test
    public void test2() {
        List<Employee> list = EmployeeData.getEmployees();

        boolean b = list.stream().anyMatch(e -> e.getSalary() > 1000);
        System.out.println(b);
    }


    /**
     * noneMatch(Predicate p) 检查是否没有匹配的元素。
     * 练习: 是否存在员工姓 "雷"
     */
    @Test
    public void test3() {
        List<Employee> list = EmployeeData.getEmployees();

        boolean b = list.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b);
    }

    /**
     * findFirst 返回第一个元素
     */
    @Test
    public void test4() {
        List<Employee> list = EmployeeData.getEmployees();

        Optional<Employee> first = list.stream().findFirst();
        System.out.println(first);
    }


    /**
     * findAny 返回当前流中的任意元素
     */
    @Test
    public void test5() {
        List<Employee> list = EmployeeData.getEmployees();
        Optional<Employee> any = list.stream().findAny();
        System.out.println(any);
    }


    /**
     * count 返回流中元素的总个数
     */
    @Test
    public void test6() {
        List<Employee> list = EmployeeData.getEmployees();
        long count = list.stream().count();
        System.out.println(count);

        long count1 = list.stream().filter(s -> s.getSalary() > 5000).count();
        System.out.println(count1);
    }

    /**
     * max(Comparator c) 返回流中最大值
     * 练习返回最高的工资。
     */
    @Test
    public void test7() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Double> doubleStream = list.stream().map(e -> e.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);  // 方法引用 Double 中的 compare方法
        System.out.println(max);
    }


    /**
     * min(Comparator c) 返回流中最小值、
     * 练习: 返回值最低工资的员工
     */
    @Test
    public void test8() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Double> doubleStream = list.stream().map(e -> e.getSalary());
        Optional<Double> min = doubleStream.min(Double::compareTo);
        System.out.println(min);


    }

    /**
     * forEach(Consumer c) 内部迭代
     */
    @Test
    public void test9() {
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().forEach(System.out::println);

        System.out.println("****************************");
        // 集合的遍历操作
        list.forEach(System.out::println);
    }


    // 归约

    /**
     * reduce(T identity, BinaryOperator ) 可以将流中元素反复结合起来，得到一个值。返回
     * 练习: 计算 1-10 的自然数的和
     */
    @Test
    public void test10() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    /**
     * reduce(BinaryOperator) 可以将流中元素反复的结合起来，得到一个值，返回Optional<T>
     * 练习: 计算公司所有员工的工资的总和
     */
    @Test
    public void test11() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Double> doubleStream = list.stream().map(Employee::getSalary);
        //Optional<Double> reduce = doubleStream.reduce(Double::sum);
        // 或者
        Optional<Double> reduce = doubleStream.reduce((d1, d2) -> d1 + d2);

        System.out.println(reduce);
    }


    // 收集:
    /**
     * collect(Collector c) 将流转换为其他形式，接收一个Collector 接口的实现，
     * 用于给 Stream 中
     * 练习1 查找工资大于 6000 的员工，结果返回为一个 List 或 set
     */
    @Test
    public void test12() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = list.stream().filter(e -> e.getSalary() > 6000);
        List<Employee> collect = employeeStream.collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
