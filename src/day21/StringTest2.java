package day21;

import org.junit.Test;

/**
 * 关于 java jdk 中的内置的一个类: java.lang.String
 * 1.String 表示字符串类型，属于引用数据类型，不属于基本数据类型
 * 2.在Java中随便使用双引号括起来的都是String 对象例如:"abc","def","hello world"
 * 3.java中规定: 双引号括起来的字符串，是不可变的，也就是说"abc"自出生到最终死亡，不能变成"abcd"
 * 4.Jdk 当中双引号括起来的字符串，例如"abc" "def" 都是直接存储在方法区的字符串常量池当中的
 * 为什么SUN公司把字符串存储在一个“字符串常量池”当中呢，因为字符串在实际的开发中是使用太频繁，
 * 所以把字符串放到了方法区的字符串常量池当中。
 * String的构造器
 * 1.String s = "";
 * 2.String s = new String();
 * 3.string s = new String(char[],起始下标，长度);
 * 4.String s = new String(byte[],起始下标，长度);
 *
 */
public class StringTest2 {

    @Test
    public void test1() {
        // 这两行代码表示要创建了3 个字符串对象,都在字符串常量池当中
        String s1 = "abcdef";
        String s2 = "abcdef" + "xy";

        // 分析：这是使用new的方式创建的字符串，这个代码中的"xy" 是从哪里来的
        // 凡是双引号括起来的都在字符串常量池中有一部分.
        // new对象的时候一定在堆内存当中开辟空间，再指向方法区中的字符串常量池
        String s3 = new String("xy");
    }


    @Test
    public void test2() {
        String s1 = "hello";
        // "hello" 是存储在方法区的字符串常量池当中的
        // 字符串常量池中不会存储相同的内容的字符串的，所以这里的 "hello" 是所有对象共用的
        String s2 = "hello";
        // 分析结果是 true 还是false ?
        // == 双等号: 对应引用类型来说，比较的是地址值，不是内容。
        System.out.println(s1 == s2); // true;

        System.out.println("****************************");

        String s3 = new String("xyz");
        String s4 = new String("xyz");

        // 分析是 true 还是 false
        // == 比较的还是地址值，对于引用类型来说。
        // String 类重写了equals方法，以下的equals()对象方法调用的是String重写之后的equals()方法。
        System.out.println(s3 == s4);  // false
        System.out.println(s3.equals(s4));  // true 比较的是内容，不是地址值

        // 为什么 "teste" 这个字符可以后面加"" 呢
        // 因为testSting是一个String字符串对象,只要是对象都能调用方法.
        System.out.println("teste".equals("fadi"));

    }


    @Test
    public void test3() {
        // 分析如下程序: 一共创建了几个对象

        String s1 = new String("hello");
        String s2 = new String("hello");
        /*
        一共创建了 3 个对象:
        堆区中:两个 : s1,s2
        方法区中: 一个“hello” 字符串常量
         */


    }

    @Test
    public void test4() {
        // 创建字符串对象最常用的一种方式:
        String s1 = "hello world";

        // 这里只掌握常用的构造方法
        byte[] bytes = {97,98,99};  // 97 = a,98 = b,99 = c
        String s2 = new String(bytes);  // 通过参数 byte[] 数组创建String对象

        /*
        前面说过: 输出一个引用的时候，会自动调用toString()方法，默认Object的话，会自动输出对象的内存地址
        // 通过输出结果我们得出一个结论: String类已经重写了toString()方法
        // 输出字符串对象的话，输出的不是对象的内存地址，而是字符串本身
         */
        System.out.println(s2);

        // 字节数组，数组元素下标的起始位置，长度
        String s3 = new String(bytes,1,2);
        System.out.println(s3);

        // 将char 数据全部转换成字符串
        char[] chars = {'我','是','中','国','人'};
        // 将char数据的一部分转换成字符串
        String s4 = new String(chars);
        System.out.println(s4);

        // 将char[] 数组中部分转换为 字符串
        String s5 = new String(chars,2,3);  // char[]数组,数组的起始下标,长度
        System.out.println(s5);
    }

}
