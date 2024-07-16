package day35.com.rainbowsea.javase.stearmApi;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class StreamAPITest17 {
    public static void main(String[] args) {
        // 需求:获得元素的个数
        long count = StudentService.getStudent().stream().count();
        System.out.println("学生的总数: " + count);

        // 也可以使用 collect
        Long count2 = StudentService.getStudent().stream().collect(Collectors.counting());
        System.out.println("学生总数: " + count2);

        // 需求:获得学生的平均年龄
        Double avgAge = StudentService.getStudent().stream().collect(Collectors.averagingDouble(Student::getAge));
        System.out.println("学生的平均年龄: " + avgAge);

        // 需求: 获得最大年龄的学生
        Student student = StudentService.getStudent().stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge())).get();
        System.out.println("学生最大年龄的学生 : "+ student);

        // 需求:获得所有学生年龄之和:
        Integer ageSum = StudentService.getStudent().stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println("所有学生年龄之和: " + ageSum);

        // 需求:获得年龄的所有的信息
        DoubleSummaryStatistics collect = StudentService.getStudent().stream().collect(Collectors.summarizingDouble(Student::getAge));
        System.out.println("学生年龄的所有信息: " + collect);

        System.out.println(collect.getCount());



    }
}
