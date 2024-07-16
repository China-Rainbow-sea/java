package day35.com.rainbowsea.javase.stearmApi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamAPITest05 {

    public static void main(String[] args) {
        // 把字符串中的字母全部转化为大写
        // 匿名内部类的方式
        Stream.of("abc","def","xyz").map(new Function<String, String>() {

            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out::println);

        // Lambda表达式
        Stream.of("abc","def","xyz").map(String::toUpperCase).forEach(System.out::println);

        // 获的集合中所有学生的名字
        StudentService.getStudent().stream().map(Student::getName).forEach(System.out::println);

        // 需求: 获得集合中性别为男的学生名字
        //思路: 先筛选，后映射
        // 先 filter，然后 map
        StudentService.getStudent().stream().filter(student -> student.getGender().equals("男"))
                .map(Student::getName).forEach(System.out::println);


        System.out.println("+++++++++");
        // 将多个集合中的数据合并到一个流 Stream 中
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);


        // 匿名内部类的方式
        Stream<List<Integer>> towListStream = Stream.of(list, list2);
        towListStream.flatMap(new Function<List<Integer>, Stream<?>>() {
            @Override
            public Stream<?> apply(List<Integer> integers) {
                return integers.stream();
            }
        }).forEach(System.out::println);

        Stream<List<Integer>> towListStream2 = Stream.of(list, list2);
        // Lambda表达式方式
        towListStream2.flatMap(List<Integer>::stream).forEach(System.out::println);
    }
}
