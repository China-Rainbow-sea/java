package blogs.blog13;

import day33.java.Employee;
import day33.java.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest03 {

    /**
     * collect(Collector c) 将流转换为其他形式，接收一个Collector 接口的实现，
     * 用于给 Stream 中
     * 练习1 查找工资大于 6000 的员工，结果返回为一个 List 或 set
     */
    public static void main(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        // 获取到一个工资大于 6000 的 Stream 流
        Stream<Employee> employeeStream = list.stream().filter(e->e.getSalary() > 6000);
        List<Employee> collect = employeeStream.collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    /**
     * reduce(BinaryOperator) 可以将流中元素反复的结合起来，得到一个值，返回Optional<T>
     * 练习: 计算公司所有员工的工资的总和
     */
    public static void main10(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        // 获取到 Employees 员工工资的 Stream 流对象
        Stream<Double> streamSalary = list.stream().map(e -> e.getSalary());
        Optional<Double> reduce = streamSalary.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce);
    }


    /**
     * reduce(T identity, BinaryOperator ) 可以将流中元素反复结合起来，得到一个值。返回
     * 练习: 计算 1-10 的自然数的和
     */
    public static void main9(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        Integer reduce = stream.reduce(0, Integer::sum);
        System.out.println(reduce);
    }


    public static void main8(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        list.stream().forEach(System.out::println);

        System.out.println("****************************");
        // 集合的遍历操作
        list.forEach(System.out::println);
    }

    /**
     * max(Comparator c) 返回流中最大值
     * 练习返回最高的工资。
     */
    public static void main7(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        // 创建一个有关于 Employee 对象的 属性为salary的 Stream 流
        Stream<Double> doubleSalary = stream.map(e -> e.getSalary());
        Optional<Double> max = doubleSalary.max(Double::compareTo);// 方法引用
        System.out.println(max);
    }

    /**
     * count 返回流中元素的总个数
     */
    public static void main6(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }

    /**
     * findAny 返回当前流中的任意元素
     */
    public static void main5(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        Optional<Employee> any = stream.findAny();
        System.out.println(any);
    }


    /**
     * findFirst 返回第一个元素
     */
    public static void main4(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        Optional<Employee> first = stream.findFirst();
        System.out.println(first);

    }


    /**
     * noneMatch(Predicate p) 检查是否没有匹配的元素。
     * 练习: 是否存在员工姓 "雷"
     */
    public static void main3(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        // String 中的startsWith 表示该字符串中是否含有该字符内容，有返回 true,没有返回 fasle
        boolean b = stream.noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(b);
    }


    /**
     * anyMath(Predicate p) 检查是否至少匹配一个元素：
     * 练习: 是否存在元素的工资大于 10000
     */
    public static void main2(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        boolean b = list.stream().anyMatch(e -> e.getSalary() > 1000);
        System.out.println(b);

    }


    /**
     * allMatch(Predicate p) 检查是否匹配所有元素。
     * 练习:是否所有的员工的年龄都大于 18
     */
    public static void main1(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();

        boolean b = list.stream().anyMatch(e -> e.getAge() > 18);
        System.out.println(b);

    }
}
