package day21;

import org.junit.Test;

/**
 * java.lang.StringBuilder
 * StringBuffer 和 StringBuilder 的区别 ？
 *  StringBuffer 中的方法都有: synchronized 关键字修饰，表示StringBuffer在多线程环境下运行是安全的。
 *  StringBuilder 中的方法都没有: synchronized 关键字修饰，表示StringBuilder在多线程环境下运行是不安全的
 *  StringBuffer 是线程安全的
 *  StringBuilder 是非线程安全的
 */
public class StringBuilderTest2 {

    @Test
    public void test1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(100);
        stringBuilder.append(true);
        stringBuilder.append("hello");
        stringBuilder.append("kitty");
        System.out.println((stringBuilder));
    }


    /**
     * 面试题: String为什么是不可变的
     * 我看过源码，String类中有一个byte[] 数组，这个byte[]数组采用了final修饰
     * 因为数组一旦创建长度不可变，并且被final 修饰的引用一旦指向某个对象之后，不可
     * 再指向其他对象，所以String是不可变的
     *
     * 2.为什么StringBuilder / StringBuffer 是可以变的
     * 我看过源码: StringBuffer/StringBuilder 内部实际上是一个byte[]数组，
     * 这个byte[]数组没有被final修饰，StringBuffer/StringBuilder的初始化容量我们记得应该是 16
     * 当存满了会自动进行扩容，好像是2倍的扩容，底层调用了数组拷贝的方法Arrays.copy()是这样扩容的
     * 所以StringBuffer/StringBuilder适合于使用字符串的频繁拼接操作。
     */
    @Test
    public void test2() {
        // 字符串不可变是什么意思
        // 是说双引号里面的字符串对象一旦创建就不可变了
        String s = "abc";

        // s变量是可以指向其他对象的
        // 字符串是不可变的，不是说以上变量，说的是"abc"这个对象不可变
        s = "xyx";
        System.out.println(s);

    }

    /**
     * 包装类的面试题
     */
    @Test
    public void test3() {
        Integer num1 = 1000;
        Integer num2 = 1000;
        System.out.println(num1 + num2);
        // == 对应引用类型来说，比较的是地址值，而不是内容
        // == 这个运算符不会触发自动拆箱机制，(只有+,-,*,/) 等运算符的时候才会)
        System.out.println(num1 == num2); // == 比较的是地址值 false
    }

    @Test
    public void test4() {
        Integer num = 128;
        Integer num2 = 128;

        System.out.println(num == num2);  // false
        /*
        java中为了提高程序的执行效率，将[-128到127]之间所有的包装对象提前创建好
        放到了一个方法区"整数型常量"当中了，目的是只要用这个区间的数据不需要再 new()对象创建了
        直接从整数型常量池当中取出来。
        原理: num3 变量中保存的对象的内存地址 和 num4 保存的对象的的内存地址都是指向同一个常量池的地址的
        所对应的地址值是一样的
         */

        Integer num3 = 127;
        Integer num4 = 127;

        // == 永远判断的都是两个对象的内存地址是否相同
        System.out.println(num3 == num4);  // true
    }


    /**
     * 进制转换为字符串
     */
    @Test
    public void test5() {
        // static String toBinaryString(int i)
        // 静态的: 将十进制 --> 二进制字符串
        String s2 = Integer.toBinaryString(3);
        System.out.println(s2);   // 二级制，逢2进一

        // static String toHexString(int x)
        // 类方法: 将十进制 ---> 十六进制字符串
        String s16 = Integer.toHexString(16);
        System.out.println(s16);  // 10 十六进制，逢16进一

        // static String toOctalString(int x)
        // 类方法; 将 十进制 --> 八进制字符串
        String s8 = Integer.toOctalString(8);
        System.out.println(s8); // 10 八进制，逢8进一

    }
}
