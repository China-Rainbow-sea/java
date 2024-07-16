package day35.com.rainbowsea.javase.stearmApi;


import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Stream中间操作之: sorted
 * 排序
 */
public class StreamAPITest07 {
    public static void main(String[] args) {
        // 需求: 对元素执行“升序”排序
        Stream.of(1,2,3,5,100,0).sorted().forEach(System.out::println);
        Stream.of("aaa","ddd","ccc").sorted().forEach(System.out::println);

        // 需求：按照学生的年龄执行“升序”排序（排序后输出学生对象）
        // 排序，需要POJO 类对象 实现 Comparable 接口
        StudentService.getStudent().stream().sorted().forEach(System.out::println);

        // 或者
        StudentService.getStudent().stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        }).forEach(System.out::println);

        // Lambda表达式的方式
        StudentService.getStudent().stream().sorted((o1,o2)->o1.getAge() - o2.getAge()).forEach(System.out::println);

        // 需求: 对元素执行“升序” 排序
        Stream.of(10,20,30,1,0).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 升序 前 - 后
                //return o1 - o2;
                return o1.compareTo(o2);
            }
        }).forEach(System.out::println);

        Stream.of(10,20,30,1,0).sorted(Integer::compareTo).forEach(System.out::println);

        // 需求：按照学生的年龄执行“升序”排序，（排序后输出学生年龄）
        // 先映射，后排序
        StudentService.getStudent().stream().map(Student::getAge).sorted().forEach(System.out::println);
        StudentService.getStudent().stream().map(Student::getAge).sorted(Integer::compareTo)
                .forEach(System.out::println);
    }

}
