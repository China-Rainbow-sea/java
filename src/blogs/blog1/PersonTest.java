package blogs.blog1;


public class PersonTest{
    public static void main(String[] args) {
        Person p1 = new Student();    // 向上转型，多态

        if(p1 instanceof Student) { // 判断 p1 是否是 Student 的实例/子类,是true，强制向下转换
            Student s1 = (Student)p1;
            System.out.println(s1.studentId);   // 子类特有的属性
            s1.ncee();                          // 子类特有的方法
        }
        System.out.println("*******************");

        if(p1 instanceof Teacher) { // 判断 p1 是否是 Teacher 的实例/子类，是true,强制向下转换
            Teacher t1 = (Teacher)p1;
            System.out.println(t1.teacherId);   // 子类特有的属性
            t1.teach();                         // 子类特有的方法
        }

        System.out.println("*******************");
        if(p1 instanceof Person) {  // 判断p1 是否是 Person 的实例/子类，是true,强制向下转换
            Person person = (Person)p1;
            person.show();
        }
    }

    public static void main11(String[] args) {
        Person p1 = new Student();
        Person p2 = new Teacher();

        System.out.println("p1 instanceof Student: "+ (p1 instanceof Student));
        System.out.println("p1 instanceof Person: "+(p1 instanceof Person));
        System.out.println("p1 instanceof Teacher: "+(p1 instanceof Teacher));

        System.out.println("***************************");

        System.out.println("p2 instanceof Teacher: "+(p2 instanceof Teacher));
        System.out.println("p2 instanceof Person: "+(p2 instanceof Person));
        System.out.println("p2 instanceof Student: "+(p2 instanceof Student));


    }

    public static void main10(String[] args) {
        Person p1 = new Student();
        Student s1 = (Student)p1;
        s1.ncee();

        Person p2 = new Teacher();
        Teacher t1 = (Teacher)p2;
        t1.teach();

//        Student s1 = new Teacher();
    }

    public static void main9(String[] args) {
        Person p1 = new Teacher();
        Student s1 = (Student)p1;  // 编译可以通过，但是运行时会出现异常：ClassCastException
    }

    public static void main8(String[] args) {
        Person p1 = new Student();
        Teacher t1 = (Teacher)p1;  // 编译可以通过，但是运行时会出现异常:ClassCastException
    }

    public static void main7(String[] args) {
        Person p1 = new Student();
        //p1.ncee(); // 直接编译的是父类类型，是无法调用子类中特有的属性/方法的，编译报错

        // 可以使用强制向下转型为对应 子类类型来调用其中的特有的属性/方法
        Student s1 = (Student)p1;
        System.out.println(s1.name);  // 可以调用子类中特有的属性/方法
        s1.ncee();    // 可以调用子类特有的方法


        Person p2 = new Teacher();
        Teacher t1 = (Teacher)p2;
        System.out.println(t1.name);
        t1.teach();    // 调用子类中特有的方法

    }

    public static void main6(String[] args) {
        Person p1 = new Student();
        System.out.println(p1.name);  // 对于编译看左边，调用的是 Person中定义的 name的变量值

        Person p2 = new Teacher();
        System.out.println(p2.name); // 同理的，调用的是左边编译 Person 中定义的 name的变量值

    }

    public static void main5(String[] args) {
        Person p1 = new Student();  // 多态
        p1.show();  // 调用的是 Student子类中重写的方法

        Person p2 = new Teacher();  // 多态
        p2.show();  // 调用的是 Teacher()子类重写的方法
    }

    public static void main4(String[] args) {
        Person p1 = new Student();  // 多态：父类的引用指向子类的对象
        // System.out.println(p1.studentId);// 调用子类特有的属性，编译无法通过
        // p1.ncee(); // 调用子类特有的方法，编译无法通过
        // 因为我们左边编译赋值的是 Person 父类类型，该父类中没有子类特有的属性和方法，编译自然无法通过了。
        // 编译都无法通过，更无法调用运行了。


    }

    public static void main3(String[] args) {
        Person p1 = new Student();
        System.out.println(p1.name);  // 调用的是 父类 Person中的 name

        Person p2 = new Teacher();
        System.out.println(p2.name);  // 同样调用的还是，父类 Person 中的 name 方法
    }



    public static void main2(String[] args) {
        Person person = new Person();
        person.show();

        Student student = new Student();
        student.show();

        Teacher teacher = new Teacher();
        teacher.show();
    }


    public static void main1(String[] args) {
        Person p1 = new Student();   // 多态: 父类的引用执行子类对象
        p1.show();    // 执行的是 Student()子类重写的方法,

        Person p2 = new Teacher();  // 多态：编译看左边，运行看右边
        p2.show();    // 实际执行的是 Teacher() 子类重写的方法
    }

}

class Person {   // 父类
    String name = "Person";
    int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {

    }

    public void show() {
        System.out.println("我是 Person");
    }



}

class Student extends Person{   // 子类
    int studentId;
    String name = "Student";

    @Override
    public void show() {
        System.out.println("我是 Student");
    }

    public void ncee() {
        System.out.println("高考");
    }

}


class Teacher extends  Person{  // 子类
    int teacherId;
    String name = "Teacher";

    @Override
    public void show() {
        System.out.println("我是 Teacher");
    }


    public void teach() {
        System.out.println("教书育人");
    }
}