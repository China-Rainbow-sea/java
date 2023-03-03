package blogs.blog13;

import day33.java.Employee;
import day33.java.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest02 {
    public static void main(String[] args) {
        // sorted(comparator  com ) 定制排序 通过年龄排序，默认是升序的 > 0 返回 1，
        List<Employee> employees = EmployeeData.getEmployees();
        // 创建 Stream 对象
        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted((e1, e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());  // 年龄排序

            if (compare != 0) {
                return compare;
            } else { // 年龄一致，再通过比较器进一步排序，比较薪资排序
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        });
        sorted.forEach(System.out::println);

    }


    public static void main8(String[] args) {
        // sorted -- 自然排序
        // 注意排序：需要实现  Comparable 接口
        // 注意泛型不能放基本数据类型
        List<Integer> list = Arrays.asList(12,56,3,2,1);
        // 创建 Stream 对象
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);
    }


    public static void main7(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        // 创建 stream 对象
        Stream<Employee> stream = employees.stream();
        // 获取到一个关于 Employee 对象中的 有关 name 属性的 Stream 对象
        Stream<String> stringStream = stream.map(e -> e.getName());
        // 获取到该 Stream 对象中 name 长度大于 3 的名字
        Stream<String> stringFilter = stringStream.filter(e -> e.length() > 3);
        stringFilter.forEach(System.out::println);

    }


    // 将字符串的多个字符构造的从集合转换为单个字符串并存储到 List 集合中
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();

        for (Character character : str.toCharArray()) { // toCharArray()将一个字符串拆分为单个字符
            list.add(character);
        }

        return list.stream();
    }

    public static void main6(String[] args) {
        // flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的
        // 数据组成一个数据
        List<String> list = Arrays.asList("aa", "AA", "bb");

        Stream<String> stream = list.stream();
        Stream<Character> characterStream = stream.flatMap(StreamAPITest02::fromStringToStream); // 方法引用
        characterStream.forEach(System.out::println);


    }

    public static void main5(String[] args) {
        List<String> list = Arrays.asList("aa", "bb", "cc");

        // 创建一个 Stream 对象
        Stream<String> stream = list.stream();
        Stream<String> stringStream = stream.map(s -> s.toUpperCase());  // toUpperCase() 将字母转换为大写的
        stringStream.forEach(System.out::println);  // Stream  终止操作
    }


    public static void main4(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        // distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        // 所以对应存储的 Employee 对象需要重写 hashCode() 和  equals()方法
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 20, 8000));

        list.stream().distinct().forEach(System.out::println);


    }


    public static void main3(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        // skip(n) 跳过元素，返回一个扔掉了前 n 个元素的流，若流中元素不足 n 个，则返回一个 空
        // stream 不可二次使用，需要新建
        Stream<Employee> skip = list.stream().skip(3);
        skip.forEach(System.out::println);   // 该操作是终止操作，并运用了方法引用

    }


    public static void main2(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        // 创建一个 Stream 对象
        Stream<Employee> stream = list.stream();

        // limit(n) 截断流: 筛选出 list 集合中存储的前3 个信息
        stream.limit(3).forEach(System.out::println);

    }


    public static void main1(String[] args) {
        List<Employee> list = EmployeeData.getEmployees();
        // 创建一个 Stream 对象
        Stream<Employee> stream = list.stream();
        // 使用 filter 进行一个筛选
        // boolean test(T t)
        // 筛选出：工资大于 7000 的 Employee 对象
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

    /*    System.out.println("*********************");
        stream.limit(3).forEach(System.out::println);*/

    }
}
