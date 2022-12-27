package day16;


/**
 * 接口的使用
 * 1. 接口使用 interface 关键字定义
 * 2. Java中，接口和类是并列的两个结构
 * 3. 如何定义接口，定义接口中的成员
 *      3.1 jdk7.0及以前，只能定义全局常量和抽象方法
 *      > 全局常量: public static final
 *         在接口中定义  int Min_SPEED = 1;  默认是省略了 public static final 因为可以通过类名.xxx,访问
 *             同样无法通过 类名.xxx,赋值的方式修改 值,因为被 final修饰了。
 *
 *      > 抽象方法: public abstract的抽象方法
 *          在接口中定义的 void stop(); 方法默认省略了: public abstract 抽象修饰
 *
 *
 *
 *      3.2 jdk8. 以后: 除了定义全局常量和抽象方法之外: 还可以定义静态方法，默认方法
 *
 *
 *      4. 接口中不能定义构造器: 因为接口是不需要new 实例化的，同时：接口 与 类的关系是 ：实现不是继承，所以没有子类实例化全过程的调用父类构造器
 *      5. java开发中: 接口通过让类去实现(implements)的方式来使用：
 *      如果对应实现类，必须重写接口中所有的的抽象方法(abstract)默认省略的，不然编译报错。
 *      如果没有重写接口中的抽象方法，则将该类也定义为接口interface才行
 *
 *      6. 接口 与 类的关系是: implements 实现关系:
 *           > 一个接口可以被多个类实现
 *           > 一个类可以实现多个接口
 *      7. 接口 与 接口 的关系是: 多继承关系
 *      8. 接口的具体使用: 体现了多态性,
 *      9. 接口，实际上定义了一种规范
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.Min_SPEED);
        System.out.println(Flyable.MAX_SPEED);
       // Flyable.Min_SPEED = 0;  // 无法修改默认是被 final 修饰的无法被修改
    }
}


interface Flyable{
    // 全局常量
    public static final int MAX_SPEED = 7900;
    int Min_SPEED = 1;   // 默认省略了 public static final

    // 抽象方法
    public abstract void fly();

    // 省略了 public abstract
    void stop();

    // Interface abstract methods cannot have body
    /*public Flyable(){   // 接口是不能有构造器的，因为无法 new 实例化对象,
                        // 接口与类的关系是: 实现关系，不是继承关系: 没有子类实例化全过程:调用父类的构造器方法
    }*/



}


class Plane implements Flyable{
    @Override
    public void fly(){

    }


    @Override
    public void stop(){

    }

}


interface AA {
    void method1();
}

interface BB {
    void method2();
}

// 接口之间可以多继承关系:
interface CC extends AA,BB{

}





