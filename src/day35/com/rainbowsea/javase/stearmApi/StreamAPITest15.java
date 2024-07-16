package day35.com.rainbowsea.javase.stearmApi;


import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 获得年龄大于 20岁的女同学,然后返回按照年龄进行"升序"排序后的 List 集合
 *
 */
public class StreamAPITest15 {
    public static void main(String[] args) {
        ArrayList<Student> students = StudentService.getStudent().stream()
                .filter(student -> student.getGender().equals("女"))
                .filter(student -> student.getAge() >= 20)
                .sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(students);
    }
}
