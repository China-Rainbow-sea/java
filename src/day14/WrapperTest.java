package day14;

/*
包装类:
    基本数据类型      包装类
           byte --> Byte
          short --> Short
          int   --> Integer
          long  --> Long                ---> 父类 Number
          float --> Float
          double --> Double
          boolean --> Boolean
          char   --> Character
 针对八种基本数据类型 定义相应的引用类型-- 包装类(封装类)
 有了类的特点，就可以调用类中的方法,java 才是真正的面向对象.

 */

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.FormatFlagsConversionMismatchException;

// 基本数据类型 --> 包装类
public class WrapperTest {
    @Test
    public void test1() {
        int num1 = 10;
       // num1.toString; // 因为 num1 是基本数据类型,无法继承Object 类中的方法.

        Integer in1 = new Integer(num1);  // 转换为对应 int 类型的包装类
        System.out.println(in1.toString());  // 包装类是类，可以调用Object 类中的方法

        Integer in2 = new Integer("123");  // 参数可以是字符串
        System.out.println(in2.toString());


        /*Integer in3 = new Integer("123abc");  // 报异常其中含有 字符无法转换
        System.out.println(in3.toString())*/;

        Float f1 = new Float(12.3f);  // 数值可以
        Float f2 = new Float("12.3");    // 字符串可以

        System.out.println(f1.toString());
        System.out.println(f2.toString());


        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("**************************");

        Boolean b3 = new Boolean("123true");  // 注意Boolean 不是合适的true 返回的就是 false
        System.out.println(b3);
        /*
        public Boolean(String s) {
        this(parseBoolean(s));
        }
        public static boolean parseBoolean(String s) {
        return ((s != null) && s.equalsIgnoreCase("true"));
        }
         */

    }


    /**
     * 包装类  ---> 基本数据类型, 调用包装类中的 xxxValue()的方法即可
     */
    @Test
    public void test2() {
        Integer in1 = new Integer(12);
        int intValue = in1.intValue();
        System.out.println(intValue + 1);

        float floatValue = in1.floatValue();
        System.out.println(floatValue +2);


        System.out.println(new Integer(99) + 1);

    }


    /**
     * JDK 5.0 新特性: 自动装箱,与自动拆箱
     */
    @Test
    public void test3() {
        int num1 = 10;
        Integer in1 = num1;   // 自动装箱
        System.out.println(in1 + 1);
        System.out.println(in1.toString());
        int num3 = in1;      // 自动拆箱
        System.out.println(num3);

        boolean b1 = true;
        Boolean b2 = b1;     // 自动装箱
        System.out.println(b2);

    }


    /**
     * 基本数据类型  --->  String类型
     * 1. 使用 + "" 拼接上一个字符串，自动提升转换.
     * 2. 调用String重载的valueOf()的方法，需要注意的是这是:在字符串的类型的方法
     */
    @Test
    public void test4() {
        int num1 = 10;
        String str1 = num1 + "";
        System.out.println(str1);

        String str2 = String.valueOf(num1);
        System.out.println(str2);

        boolean b = true;
        String str3 = String.valueOf(b);
        System.out.println(str3);

        float f = 12.3f;
        String str4 = String.valueOf(f);
        System.out.println(str4);

        Double d = new Double(99.9);
        String str5 = String.valueOf(d);
        System.out.println(str5);
    }


    /**
     * String 类型转换 --->  基本数据类型，包装类
     * 使用，包装类的parseXxx()的方法
     */
    @Test
    public void Test5() {
        String str1 = "123";
        // 错误情况
        // int num1 = (int)str1;   // 将String强制转换为int类型是不行的
        // Integer in1 = (Integer)str1;  // 将String 强制转换为 Integer类型也不可以


        // 正确情况: 使用 parseXxx()的方法
        int in1 = Integer.parseInt(str1);
        System.out.println(in1 + 1);

        Double d2 = Double.parseDouble(str1);
        System.out.println(d2);

        String str2 = "true";
        boolean b = Boolean.parseBoolean(str2);
        System.out.println(b);

        String str3 = "false2";
        Boolean b2 = Boolean.parseBoolean(str3);
        System.out.println(b2);  // 当 Boolean 返回的的值不是对应的 true,或者false,一律返回false;


    }


}
