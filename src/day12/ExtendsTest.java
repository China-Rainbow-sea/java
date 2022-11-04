package day12;

public class ExtendsTest {
    public static void main(String[] args) {
        Person person = new Person(); // 调用构造器,实例化对象

        person.age = 19;
        person.eat();

        Student student = new Student();
//        student.name = "Tom";  父类中的 name private私有化了,子类继承了但是无法访问
        student.eat();
        student.sleep();

    }
}
