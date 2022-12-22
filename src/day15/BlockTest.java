package day15;


/**
 * 类的成员之前: 代码块(或初始化块)
 * 1. 代码块的作用: 用来初始化类，对象
 * 2. 代码块如果有修饰的话：只能使用 static
 * 3. 分类: 静态代码块  VS  非静态代码块
 * 4. 静态代码块:
 *       > 内部可以有输出语句
 *       > 随着类加载而执行,并且只会执行一次.
 *       > 作用: 初始化类的信息
 *       > 如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 *       > 静态代码块内只能调用静态的属性,静态的方法,不能调用非静态的结构
 *
 *
 *
 * 5. 非静态代码块:
 *       > 内部可以有输出语句
 *       > 随着对象的创建而执行
 *       > 每创建一个对象，就执行一次非静态代码块
 *       > 作用: 可以在创建对象时，对对象的属性等运行初始化
 *       > 非静态代码块内可以调用静态的属性,静态的方法,或非静态的方法/属性
 *
 *
 * 6. 对属性可以赋值的位置：
 *     1. 默认初始化
 *     2. 显式初始化
 *     3. 构造器中初始化
 *     4. 有了对象以后，可以通过 “对象”，属性，或对象，方法的方式，进行赋值
 *     5，在代码块中赋值
 *
 *
 */
public class BlockTest {
    public static void main(String[] args) {
//        String desc = Person.desc;  // 静态代码块随着类加载而加载并执行。这时调用的是静态的属性，
        // 非静态的代码块是不会执行的。

        Person person = new Person(); // 随着对象的创建而执行(其中包含了类的加载,所以有静态代码的执行)
        Person person2 = new Person();
    }
}


class Person{
    static String name;
    static int age;
    static String desc = "我是一个人";

    public Person() {

    }

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭");
    }

    // static 静态代码块
    static {
        System.out.println("hello static block 1");
        desc = "我是一个爱学习的人";
        info();
//        eat();// 静态的无法调用非静态的，除非实例化对象 new
//        name // 变量也是同理
    }
    static {
        System.out.println("hello static block 2");

    }


    // 非静态 static 的代码块

    {
        System.out.println("hello block 2");
    }
    {
        System.out.println("hello block 1 ");
        age = 1;
    }


    public static void info(){
        System.out.println("我是一个快乐的人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
