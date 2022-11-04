package day12;


/**
 * 面向对象的特征之二: 继承性
 * 1. 继承性的好处:
 *  1. 减少了代码的冗余，提高了代码的复用性
 *  2. 便于代码功能后续的扩展
 *  3. 为了之后多态性的使用，提供了前提
 *
 * 二： 继承的格式：class A extend B {}
 * A: 子类，派生类，subclass
 * B: 父类，超类，基类 superclass
 * 体现: 一旦子类A继承了父类的B，以后，子类A中获取了父类B中声明的所有结构，属性，方法
 * 就是是父类中private 私有的依然是被子类继承了的,只是因为封装性的影响,使得子类不能直接调用父类的private私有的方法/属性
 * 子类和父类的关系，不同于子集和集合的关系，子类是父类的扩展,所以子类可以调用父类的，但是父类不可以调用子类中的方法
 * extends 延展,扩展
 *
 * 三: Java中关于继承性的规定
 * 1.一个类可以被多个子类继承
 * 2.但是Java中的类是单继承的，一个类只能继承一个父类，而c++可以多继承
 * 3. 子父类是相对的概念
 * 4. 子类直接继承的父类，称为直接父类，间接继承的父类称为：间接父类
 * 5. 子类继承父类以后，就获取了直接父类以及间接父类中的属性和方法 A->B->C IDE 查看继承关系的快捷建 Ctrl + H
 *
 * 四:
 * 1. 如果没有显式的声明一个类的父类的话，则此类继承于 java.lang.Object类
 * Class Object
 * java.lang.Object
 * public class ObjectClass Object是类Object结构的根。 每个班都有Object作为超类。 所有对象（包括数组）都实现了这个类的方法。
 * 2.所有的Java类(除了java.lang.Object类之外) 都直接或间接的继承了java.Object类
 * 3.意味着，所有的java类具有java.lang.Object类声明的功能.
 *
 */
public class Student extends Person{
//    String name;
//    int age;
    String major;

    public Student() {
        // 无参构造器,实例化对象
    }


/*    public Student(String name,int age,String major) {
        this.name = name;
        this.age = age;

        this.major = major;
    }*/

/*    public void eat() {
        System.out.println("吃饭");
    }


    public void sleep() {
        System.out.println("睡觉");
    }

 */
}
