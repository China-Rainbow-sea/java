package day14;

public class InstanceTest {
    public static void main(String[] args) {
        InstanceTest instanceTest = new InstanceTest(); // 静态方法访问非静态方法,实例化对象

        instanceTest.method(new Person());
        System.out.println("*******************");
        instanceTest.method(new Student());
        System.out.println("**********************");
        instanceTest.method(new Graduate());

    }



    public void method(Person p) {
        if(p instanceof Person) {  // 判断如果 p 是否是 Person的实例对象/子类
            Person person = (Person)p;  // 强制向下转型,
            System.out.println("p Person");
        }


        if(p instanceof Student) {  // 判断如果 p 是否是 Student的实例对象/子类
            Student student = (Student)p;   // 强制向下转型
            System.out.println("p Student");
        }


        if(p instanceof Graduate) {  // 判断如果 p 是否是 Graduate 的实例对象/子类
            Graduate graduate = (Graduate)p;  // 强制向下转型
            System.out.println("p Graduate");
        }

    }
}
