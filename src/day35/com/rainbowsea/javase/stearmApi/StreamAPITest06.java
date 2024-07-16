package day35.com.rainbowsea.javase.stearmApi;


import java.util.stream.Stream;

/**
 * Stream 中间操作之：distinct 去除重复记录
 */
public class StreamAPITest06 {

    public static void main(String[] args) {
        // 去除重复的元素
        Stream.of(1,2,3,1,1,1).distinct().forEach(System.out::println);


        // 除去重复的学生(除重后输出学生对象)
        // 注意这时候的 POJO 类就必须重写 equals，和 hashCode()方法才行，不然无法去除重
        StudentService.getStudent().stream().distinct().forEach(System.out::println);


        // 需求； 除去年龄相同的学生(除重后输出学生年龄)
        // 思路: 先映射，后除重
        StudentService.getStudent().stream().map(Student::getAge).distinct().forEach(System.out::println);
    }
}
