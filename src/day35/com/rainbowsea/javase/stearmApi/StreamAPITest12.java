package day35.com.rainbowsea.javase.stearmApi;

public class StreamAPITest12 {
    public static void main(String[] args) {
        // 需求: 获得元素的个数
        System.out.println(StudentService.getStudent().stream().count());
        System.out.println(StudentService.getStudent().size());


        // 需求: 获得年龄"最大"的学生
        Student student = StudentService.getStudent().stream().max((s1, s2) -> s1.getAge() - s2.getAge()).get();
        System.out.println(student);

        // 需求: 获得学生的"最大年龄"
        Integer integer = StudentService.getStudent().stream().map(Student::getAge).max(Integer::compareTo).get();
        System.out.println(integer);

        // 需求:获得年龄"最小"的学生
        System.out.println(StudentService.getStudent().stream().min((s1, s2) -> s1.getAge() - s2.getAge()).get());


        // 需求:获得学生的"最小"年龄
        System.out.println(StudentService.getStudent().stream().map(Student::getAge).min(Integer::compareTo).get());
    }
}
