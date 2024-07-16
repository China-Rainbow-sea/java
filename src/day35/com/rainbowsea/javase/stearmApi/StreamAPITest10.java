package day35.com.rainbowsea.javase.stearmApi;


import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream 终止操作之 match
 */
public class StreamAPITest10 {
    public static void main(String[] args) {
        // 匹配集合元素是否都是 3
        boolean b = Stream.of(1, 2, 3).allMatch(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.equals(3);
            }
        });
        System.out.println(b);


        boolean b1 = Stream.of(3, 3, 3).allMatch(value -> value.equals(3));
        System.out.println(b1);

        // 匹配集合中元素是否包含 3
        boolean b2 = Stream.of(1, 2, 3).anyMatch(value -> value.equals(3));
        System.out.println(b2);

        // 匹配集合中元素有没有3
        boolean b3 = Stream.of(1, 2, 3, 4).noneMatch(value -> value.equals(3));
        System.out.println(b3);
        boolean b4 = Stream.of(1, 2, 3, 4).noneMatch(value -> value.equals(100));
        System.out.println(b4);


        // 获取流中的第一个元素
        Optional<Integer> first = Stream.of(1, 2, 3, 4).findFirst();
        System.out.println(first.get());

        System.out.println(Stream.of(1, 2, 3, 4, 5).findFirst().get());


        // 需求匹配学生名字是否都为“zhangsan”
        boolean zhangsan = StudentService.getStudent().stream().allMatch(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getName().equals("zhangsan");
            }
        });
        System.out.println(zhangsan);

        // Lambda表达式
        System.out.println(StudentService.getStudent().stream().allMatch(student -> student.getName().equals("张三")));

        // 需求：匹配学生名字是否至少有一个为：张三
        System.out.println(StudentService.getStudent().stream().anyMatch(student -> student.getName().equals("张三")));

        // 需求: 匹配学生名字中是否全部都没有 : 李四
        System.out.println(StudentService.getStudent().stream().noneMatch(student -> student.getName().equals("李四")));

        // 需求:获得第一个学生
        Student student = StudentService.getStudent().stream().findFirst().get();
        System.out.println(student);

        // 优化:
        Optional<Student> optionalStudent = StudentService.getStudent().stream().findFirst();
        if (optionalStudent != null) {
            Student student1 = optionalStudent.get();
            System.out.println(student1);
        }

        // 再优化
        optionalStudent.ifPresent(System.out::println);

        // 需求: 获得第四个学生
        // 思路：跳过前面3个学生，然后再获得第一个元素
        Student student1 = StudentService.getStudent().stream().skip(3).findFirst().get();
        System.out.println(student1);
    }
}
