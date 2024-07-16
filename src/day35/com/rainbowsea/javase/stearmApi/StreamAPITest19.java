package day35.com.rainbowsea.javase.stearmApi;

import java.util.stream.Collectors;

public class StreamAPITest19 {
    public static void main(String[] args) {
        // 需求:将所有学生的姓名连接成一个字符串,每个名字之间以","连接
        String s = StudentService.getStudent().stream().map(Student::getName)
                .collect(Collectors.joining(","));
        System.out.println(s);
    }
}
