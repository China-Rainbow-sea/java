package day14;

import java.util.Date;

public class PersonTest {


    /**
     * 练习
     * @param args
     */
    public static void main(String[] args) {
        // 问题一: 编译时通过,运行时不通过
        // 举例一:
        /*Person p1 = new Man();
        Woman woman = (Woman)p1; // .ClassCastException:类异常,*/
        // 编译可以通过的原因: 将 p1 为 Person 父类的类型，强制转换 “向下转型为” 了 woman 对应父类中的一个子类
        // 运行无法通过的原因是: 将一个 本身是 Man 类型的强制转换为了一个人 与 Man 不相关的类型了，运行是服务通过的，运行时看左边

        // 举例二:
        Person p3 = new Person();
        //Man m = (Man) p3;   // .ClassCastException 同样报类异常,因为 p3 不是 Man 的实例，也不是Man的子类

        // 问题二: 编译通过,运行时也通过
        Person p1 = new Man();

        if(p1 instanceof Man) {    // instanceof 判断 p1是否是 Man 的实例对象/ 子类
            Man man = (Man)p1;     // 强制向下转型为 Man 的类类型
        }
        // 或者

        Object p2 = new Woman();

        if(p2 instanceof Person) {       // instanceof 判断 p2 是否是 Person 的实例对象/子类，
            Person person = (Person)p2;  // 强制向下转型为 Person 的类类型
        }



        // 问题三: 编译不通过
        // Man man = new Woman();   // 两者之间没有任何的联系

        // 举例二:
        // String str = new Date();

        // 举例三:
        Object object = new Date();

        String str = (String)object; // ClassCastException 类异常,因为 object 不是 String 的实例/不是String 的子类。



    }


    public static void main2(String[] args) {
        Person p1 = new Woman();

        if(p1 instanceof Woman) {   // instanceof 判断 p1 是否是 Woman 的实例，的子类
            Woman woman = (Woman)p1;
            System.out.println("woman");
        }

        if(p1 instanceof Man) {
            Man man = (Man) p1;
            System.out.println("Man");
        }


        if(p1 instanceof Person) {   // instanceof 判断 p1 是否是 Person 的实例/子类
            Person person = (Person)p1;
            System.out.println("Person");
        }


        if(p1 instanceof Object) {  // instanceof 判断 p1 是否是 Object 的实例/子类
            Object object = (Object)p1;
            System.out.println("Object");
        }







    }



    public static void main1(String[] args) {
        // 对象多态(自动向上转型),父类的引用指向子类的对象(对于方法: 编译看右边,运行看左边;而变量则是编译运行都看右边)
        Person p2 = new Man();
        // 多态的使用,当调用父类同名的同参数的方法时，实际执行的是子类重写父类的方法,---虚拟方法调用
        p2.eat();

        // p2.walk(); 无法调用子类中的方法,因为编译无法通过(编译是看右边的)，而右边是Person的父类,
        // 该父类是没有该 walk()方法的.没有从而也就无法编译过去了，编译都过不去,也就无法运行了


        Person p3 = new Woman();

        p3.name = "Tom";

        // 多态(向上转型)不能调用子类所特有的方法，属性:编译的时候是看右边,右边是Person类,没有 walk方法,id的属性
        /*p3.id = 1;
        p2.walk();*/

        // 有了对象的多态性以后,内存当中是会加载子类所特有的“属性”和“方法”的，但是由于变量声明为父类类型，导致了
        // 编译时，只能调用父类中的声明的“属性”和“方法”,子类特有的属性和方法不能调用，使用的。



        // 所以，如何可以使用多态了以后，可以再调用子类中特有的 “属性”和“方法”
        // 可以使用“强制转换”(向下转型)的方式，转换为对应的子类的对象

        Man m1 = (Man)p2;
        System.out.println(((Man) p2).id);

        System.out.println(m1.id);

        // man 所以特有的属性和方法
        m1.eat();
        m1.walk();


        // ClassCastException: 需要注意的是: 使用强制转换()可能存在，ClassCastException:类异常
        // 就是无法所“强制转换的”类，不是它本身实例的对象的类，和它本身的类没有一点关系(),导致强制转换失败
        /*Woman m2 = (Woman)p2;
        m2.walk();*/


        // 如何避 “强制转换”时，所发生的: ClassCastException: 类异常
        // 使用 instanceof 关键字,判断
        // a instanceof A 含义: 判断对象 a 是否是类 A 的实例,如果是,返回 true;如果不是,返回 false;

        System.out.println("*******************************************************");

        if(p2 instanceof Woman) {   // 判断p2是否是 Woman 类的的实例
            Woman woman = (Woman)p2;  // 是, 强制转换(向下转型)为对应的类  Woman
            woman.walk();
        }


        if(p2 instanceof Man) {   // 判断p2 是否是 Man 类的实例
            Man man = (Man)p2;    // 是,强制转换(向下转型)为对应的类 Man
            man.walk();
        }


    }


}
