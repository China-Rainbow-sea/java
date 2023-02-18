package day29;

import org.junit.Test;

import java.util.Date;

public class ReflectTest {

    @Test
    public void test() {
        /*
    Class.forName()
     1. 静态方法
     2. 方法的参数是一个字符串
     3. 字符串需要的是一个完整类名
     4. 完整类名必须带有包名，：java.lang 包也不能省略
     */

        Class c1 = null;
        Class c2 = null;
        try {
            c1 = Class.forName("java.lang.String"); // c1 代表String.class 文件，或者说c1代表String类型
            c2 = Class.forName("java.util.Date");  // c2代表Date 类型
            Class c3 = Class.forName("java.lang.Integer"); // c3代表Integer类型
            Class c4 = Class.forName("java.lang.System");  //
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Java 中任何一个对象都有一个方法: getClass()
        String s = "abc";
        Class x = s.getClass();  // x 代表String.class 字节码文件，x代表String 类型

        System.out.println(c1 == x); // true == 判断的是对象的内存地址。
        // 类仅仅只会加载到一次到内存当中。 所以对象共用

        Date time = new Date();
        Class y = time.getClass();
        System.out.println(y == c2); // true
        // true (c2 和 y 两个变量中保存的内存地址都是一样的，都指向方法区中的字节码)

        Class z = String.class;  // z 代表 String.class 类型
        Class k = Date.class;   // k 代表Date.class 类型
        Class f = int.class;    // f 代表int 类型
        Class e = double.class;  // e 代表double 类型

        System.out.println(x == z);

    }



}
