package day16;

/**
 * abstract关键字的使用；
 * abstract：抽象的意思
 * 2.abstract可以修饰的结构: 类，方法
 * 3.abstract 修饰类:抽象类
 *     > 抽象类不可以 new 实例化对象
 *     > 抽象类中一定有构造器.因为用于子类继承必须调用父类中的构造方法
 *     > 开发中: 都会提供抽象类的子类,让子类对象实例化，完成相关的操作。
 * 4. abstract 修饰方法: 抽象方法
 *    > 抽象方法只有方法的声明，没有方法体
 *    > 包含抽象方法的类，一定是一个抽象类，反之，抽象类中可以没有抽象方法
 *    > 若子类继承了一个抽象类的方法，该子类要么也是一个抽象类，不然就必须重写所继承的抽象类中所有的抽象方法不然编译报错
 *    > 若子类重写了父类中的所有的抽象方法，此子类方可实例化，不然报错
 *    > 若子类没有重写父类中的所有的抽象方法，则子类也是一个抽象类，需要使用abstract 修饰类
 *
 * 5. abstract 使用上的注意点:
 *    > abstract 不能用来修饰：属性，构造器等结构,属性无法重写，构造器也是无法重写的
 *    > abstract 不能用来修饰私有private方法，私有方法无法重写
 *    > abstract 不能用来修饰静态方法,同理静态方法无法重写，和类一起加载的
 *    > abstract 无法修饰，属性，构造器，private,静态方法，final修饰的方法，因为都无法重写
 *
 *
 */
public class AbstractText {
    public static void main(String[] args) {
        // Person person = new Person(); // 抽象类不可以实例化,实例化报错,除非匿名子类
        Person p1 = new Student(); // 多态:动态绑定: 编译看左边，运行结果看右边
        p1.eat();

        method(new Student());   // 匿名对象

        Student student = new Student();
        method(student);         // 非匿名对象

        // 对抽象类: 创建了匿名子类的对象 ,重写其中的抽象方法
        Person p = new Person(){
            @Override
            public void eat(){
                System.out.println("匿名抽象类的子类对象，重写其中的抽象方法");
            }
        };



    }

    public static void method(Person person) {
        System.out.println("method");
    }
}


abstract class Person{
    String name;
    int age;



    public Person() {

    }

    public Person(String name) {

    }

    // 抽象方法: 没有方法体;
    abstract public void eat();

    // Illegal combination of modifiers: 'abstract' and 'private'
    // abstract private void test();  // abstract 无法修饰 私有方法:因为私有方法无法重写

    // Illegal combination of modifiers: 'abstract' and 'static'
    // abstract static public void test();  // abstract 无法修饰 静态方法:因为静态方法无法被重写
    public void walk(){
        System.out.println("人走路");
    }



}

class Student extends Person{  // 注意abstract 抽象类必须要构造器用于子类的实例化全过程
    @Override
    public void eat() {
        System.out.println("重写抽象类中的抽象方法");
    }

    public Student() {

    }
}