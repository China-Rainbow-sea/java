package day35.com.rainbowsea.javase.stearmApi;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public static List<Student> getStudent() {
        List<Student> studentList= new ArrayList<>();
        studentList.add(new Student("李华",18,"男"));
        studentList.add(new Student("小红",18,"女"));
        studentList.add(new Student("张三",21,"男"));
        studentList.add(new Student("小青",20,"女"));
        studentList.add(new Student("wangwu",20,"男"));

        return studentList;

    }
}
