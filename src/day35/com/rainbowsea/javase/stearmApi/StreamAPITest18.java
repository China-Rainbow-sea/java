package day35.com.rainbowsea.javase.stearmApi;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stream 终止操作之: 收集 collect
 * 分组: groupingBy
 */
public class StreamAPITest18 {
    public static void main(String[] args) {
        // 按照性别分组
        //StudentService.getStudent().stream().collect(Collectors.groupingBy(以什么进行分组))
        Map<String, List<Student>> map = StudentService.getStudent().stream().collect(Collectors.groupingBy(Student::getGender));

        map.forEach((k,v)->System.out.println(k + "==>" + v));
    }
}
