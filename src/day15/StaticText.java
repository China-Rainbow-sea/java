package day15;

/**
 * static 关键字的使用
 * 1. static 静态的
 * 2. static 可以用来修饰: 属性，方法，代码块，内部类
 * 一: 用 static 修饰属性： 按是否使用 static 修饰,又分为：静态属性  VS 非静态属性(实例变量)
 * 实例变量: 我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性.
 * 非静态变量对应不用的 new 对象的改变，不会影响到其他的 new 对象当中的非静态变量的属性。
 * 静态属性: 我们创建了类的多个对象，多个对象共享同一个静态变量，当通过某一个对象修改静态变量时，会
 * 导致其他对象调用此静态变量时，是最后修改过的。
 * 3. static 修饰属性的其他说明:
 *    1. 静态变量随着类的加载而加载
 *    2. 静态变量的加载要早于 new 对象的加载创建，因为 new 对象，要先加载类，再调用类中的构造方法创建对应的对象
 *    3.静态变量可以通过 "类名.静态变量名"的方式进行调用
 *    4. 由于类只会加载一次，则静态变量再内存当中也只会存在一份，存在方法去的静态域中。
 *    5.静态变量不可以使用 “ this. / super. new 对象的引用的方式调用，因为静态方法比对象先加载到内存当中的
 *    this./super 表示的是对象的引用，比类后，
 *    6.  类变量            实例变量
 *    类    yes               no
 *    对象  yes               yes
 *    7.静态属性举例: System.out; Math, PI;
 *
 *
 *   二: 使用 static 修饰方法： 静态方法
 *    1. 随着类的加载而加载，可以通过 "类.静态方法"的方式进行调用
 *    2.                 静态方法     非静态方法
 *           类           yes            no
 *           对象         yes            yes
 *     静态方法: 只能调用静态的方法或属性
 *     非静态方法可以调用非静态方法或属性，也可以调用静态方法或属性
 *    static 注意点：
 *    在静态的方法内: 不能使用this关键字 以及 super关键字
 *
 *    开发中：如何确定一个属性是否声明为 static 的？
 *        > 属性可以被多个对象共享的，不会随着对象的不同而不同的
 *    开发中: 如何确定一个方法是否要声明为 static 的 ?
 *        > 操作静态属性的方法，通常设置为 static的
 *        > 工具类中的方法，习惯上声明为static 的，比如: Math,Arrays Collections
 *
 *
 */
public class StaticText {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        c1.age = 18;
        c1.name = "姚明";
        c1.nation = "CHN";

        Chinese c2 = new Chinese();
        c2.age = 19;
        c2.name = "马龙";
        c2.nation = "CHINA";

        Chinese.nation = "中国";

        System.out.println(c1.nation);
        System.out.println(c2.nation);

        System.out.println("************************");

        c2.eat();

        Chinese.show();
    }
}


class Chinese {
    String name;
    int age;
    static String nation;


    public static void show() {
        System.out.println("我是 static 方法");
//        eat();  // 静态方法无法调用非静态方法,因为加载的先后顺序不同
//        name = "uji";   // 同样的无法调用非静态的属性/变量
    }


    public void eat() {
        System.out.println("中国人吃中餐");
//        show();  // 非静态方法可以调用静态方法,
    }


}