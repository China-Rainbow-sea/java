package day29;

import org.junit.Test;

/*
研究一下: Class.forName() 发生了什么
  记住：重点:
     如果你只是希望一个类的静态代码块执行，其它代码一律不执行。
     你可以使用:
        Class.forName("全类名路径")
      这个方法的执行会导致类加载，类加载时，静态代码块会执行，并且只会执行一次。
      可以用于 JDBC 中的加载对应数据库驱动.
 */
public class ReflectTest03 {

    @Test
    public void test() {
        // 加载对应的类，类加载器
        try {
            // Class.forName() 这个方法的执行会导致：类加载(类加载了，会执行其中类的静态代码块,
            // 非静态代码块不会执行(实例化对象的时候才会执行)),不需要调用构造器
            Class clazz =  Class.forName("day29.MyClass"); // 全类路径名
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}


class MyClass {
    // 静态代码块:在类加载时执行，并且只会执行一次。
    static {
        System.out.println("MyClass 类的静态代码块执行了 ！");
    }

    {
        System.out.println("非静态代码块");
    }

}
