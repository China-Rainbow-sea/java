package day15;

/**
 * 单例设计模式
 * 1. 设计模式是在大量的实践中总结和理论化之后优选的代码结构,编译风格，以及解决问题的思考方式，设计模式免去
 * 我们自己再思考和摸索式，就像是经典的棋谱，不同的棋局，我们用不同的棋谱，“套路”，以及就像公式一样的
 * 2. 所谓的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，
 * 并且该类只能提供一个取得其对象实例的方法，如果我们要让类在一个虚拟机中只能生产一个对象，我们首先必须将
 * 类的构造器的访问权限设置为 private，这样，就不能用 new 操作符在类的外部产生类的对象了，但在类内部仍可以
 * 产生该类的对象，因为在类的外部开始还无法得到类的对象，只能调用该类的某个静态方法以返回类内部创建的对象，静态方法
 * 只能访问类中的静态成员变量，所以，指向类内部产生的该类对象的变量也必须定义成静态的。
 *
 *  1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例.
 *  2. 如何实现 ?
 *      饿汉式  VS 懒汉式
 *
 *
 *  3. 区分饿汉式 和 懒汉式
 *     饿汉式:
 *     坏处: 对象加载时间过长。
 *     好处: 饿汉式是线程安全的
 *     例如: Runtime  典型的饿汉式
 *
 *     懒汉式:
 *     坏处: 目前的写法坏处，线程不安全。---> 到多线程内容时，再修改
 *     好处: 延迟对象的创建
 *
 */

/*
  网站的计数器，一般也是单例模式实现，否则难以同步，
  应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为
  只能有一个实例去操作，否则内容不好追加。
  数据库连接池: 设计一般也是采用单例模式，因为数据库连接是一种数据库资源。。
  项目中，读取配置文件的类，一般也只有一个对象，没有必要每次使用配置文件数据，都生成一个对象去读取。
  Application 也是单例的典型应用
  Windows的 Task Manager(任务管理器)就是很典型的单例模式
  Windows的 Recycle Bin(回收站) 也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
 */


public class SingletonTest {



    // 单例设计：懒汉式:
    public static void main2(String[] args) {
        Bank2 bank1 = Bank2.getInstance();
        Bank2 bank2 = Bank2.getInstance();

        System.out.println(bank1 == bank2);   // 同理一样是，相等的
    }


    // 单例设计：饿汉式
    public static void main1(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);  // 比较的是引用类，的地址是否相等
        // 因为都是从单例设计模式中的饿汉式,从其中的 static 静态方式中 new 出来的，
        // static 静态的在方法区中，所有对象共用，在内存当中也仅仅只是加载一次而已.


    }


    // 饿汉式的另外一种方式
    public static void main(String[] args) {
        Bank3 bank3 = Bank3.instance;
        Bank3 bank32 = Bank3.instance;


        //bank3.instance = null;   // 可能会被恶意修改,使用final 防止被恶意修改

        System.out.println(bank3 == bank32);
    }

}


// 方式一: 饿汉式:
class Bank{
    // 1.私有化类的构造器
    private Bank() {

    }

    // 2.内部创建类的对象,注意是 static 的修饰的对象属性，所有对象共用仅仅只是加载一次
    // 要求此对象也必须声明为静态的 static
    private static Bank Instance = new Bank();


    // 3.提供公共的方法，返回类的对象,注意:static 静态的属性对应的着 static 的方法
    public static Bank getInstance() {
        return Instance;
    }

}


// 单例模式: 懒汉式
class Bank2 {
    // 1. 私有化类的构造器
    private Bank2() {

    }

    // 2. 声明当前类对象，没有初始化
    // 4. 此对象也必须声明为 static 的
    private static Bank2 instance = null;

    // 3. 声明public static 的返回当前类对象的方法
    public static Bank2 getInstance() {
        if(instance == null) {   // 当 instance 为 null 的时候，就创建新的不是空就不创建新的对象
            instance = new Bank2();
        }
        return instance;

    }



}


// 新的一种饿汉式
class Bank3{
    private Bank3() {

    }

    // 可能会被恶意修改
//    public static Bank3 instance = new Bank3();

    // 改进,使用 final 用于防止恶意修改
    public static final Bank3 instance = new Bank3();

}