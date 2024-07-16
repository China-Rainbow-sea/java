package day35.com.rainbowsea.javase.stearmApi;


import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream中间操作之：filter 筛选
 */
public class StreamAPITest04 {
    public static void main(String[] args) {
        // 筛选出年龄大于 20 的学生对象
        // filter 属于中间操作，过滤
        // forEach 属于终止操作，遍历
        // filter和forEach 都是 Steam接口中的方法
        // 由于 Steam支持格式调用，所以可以一直“.”
        // 匿名内部类的方式
        StudentService.getStudent().stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAge() > 20;
            }
        }).forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });

// Lambda表达式
        StudentService.getStudent().stream().filter(student -> student.getAge() > 20).forEach(System.out::println);

        // 筛选出字符串长度大于3的元素
        Stream<String> stringStream = Stream.of("zhangsan", "lish", "lihua").filter(s -> s.length() > 3);
        stringStream.forEach(System.out::println);

        System.out.println("++++++++++++++++++++");

        // 筛选出学生名字长度大于4的学生
        StudentService.getStudent().stream().filter(student -> student.getName().length() > 4)
                .forEach(System.out::println);



    }
}
