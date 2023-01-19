package day21;


import day11.Customer;
import org.junit.Test;

import java.util.Arrays;

/**
 * String常用的方法的使用
 */
public class StringMethod2 {

    /**
     * 1. char CharAt(int index)    获取对应字符串下标的字符
     * 2. public int compareTo(String anotherString)按字典顺序比较两个字符串
     */
    @Test
    public void test() {
        char c = "中国人".charAt(1);  // "中国人"是一个字符串String对象，只要是对象就能.""
        System.out.println(c); // 国

        // 2. 了解
        int result = "abc".compareTo("abc");
        System.out.println(result);

        int result2 = "abc".compareTo("abcd");
        System.out.println(result2);

        int result3 = "abc".compareTo("yxz");
        System.out.println(result3);
    }


    /**
     * // 判断该字符串是否在对应的字符串中存在
     * public boolean contains(CharSequence s)当且仅当此字符串包含指定的 char 值序列时，返回 true。
     */
    @Test
    public void test2() {
        String s = "helloWorld.java";
        // 判断该字符串对象是否包含后面的字符串内容
        boolean b1 = s.contains(".java");   // true
        System.out.println(b1);

        System.out.println("https://java.baidu.com".contains("https://")); // false


    }

    /**
     * :判断该字符串对象是否是以xxx结尾的
     * public boolean endsWith(String suffix)测试此字符串是否以指定的后缀结束。
     */
    @Test
    public void test3() {
        String s = "test.txt";
        boolean b1 = s.endsWith(".txt"); // true
        System.out.println(b1);

        System.out.println("test.txt".endsWith(".java")); // false

        System.out.println("fsdjioajfasoIJFOISAJIOFIOASDFJIOIO".endsWith("IO")); // true
    }



    /**
     * 判断两个字符串是否相等，并同时忽略大小写
     * public boolean equalsIgnoreCase(String anotherString)
     * 将此 String 与另一个 String 比较，不考虑大小写。如果两个字符串的长度相同，并且其中的相应字符都相等（忽略大小写），则认为这两个字符串是相等的
     */
    @Test
    public void test4() {
        String s1 = "ABc";
        boolean b = "abc".equalsIgnoreCase(s1);
        System.out.println(b);
    }

    /**
     * 将字符串对象转换成字节数组
     * public byte[] getBytes()使用平台的默认字符集将此 String 编码为 byte 序列，
     * 并将结果存储到一个新的 byte 数组中
     */
    @Test
    public void test5() {
        byte[] bytes = "abcdef".getBytes();

        System.out.println(Arrays.toString(bytes));

    }

    /**
     * 判断某个子字符串在当前字符串中第一次出现处的索引位置(下标)
     * public int indexOf(String str)返回指定子字符串在此字符串中第一次出现处的索引。返回的整数是
     * public int indexOf(int ch)返回指定字符在此字符串中第一次出现处的索引。
     * 如果在此 String 对象表示的字符序列中出现值为 ch 的字符，则返回第一次出现该字符的索引（以 Unicode 代码单元表示）。
     */
    @Test
    public void test6() {
        System.out.println("fjioaiojfodisajiof".indexOf("java"));
        System.out.println("jasdfijojiofasdjiosafdsjiadf".indexOf('a'));

    }


    /**
     * 判断某个字符串是否为 "空"
     * public boolean isEmpty()当且仅当 length() 为 0 时返回 true。
     *
     */
    @Test
    public void test7() {
        System.out.println("a".isEmpty());
    }
    /**
     * 判断字符串长度和判断数组的长度是否一样
     * 不一样：源码分析: 判断数组的长度是返回 this.length这个成员属性的值
     * 而: 判断字符串的长度是调用this.length()的方法
     */
    @Test
    public void test8() {
        System.out.println("fsdjiasjiodfjioasijodf".length());
        System.out.println("".length());
    }

    /**
     * 判断某个子字符串在当前字符串中最后一次出现的索引下标
     * public int lastIndexOf(int ch)返回指定字符在此字符串中最后一次出现处的索引。
     * 对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 的值，返回的索引（Unicode 代码单元）是
     * public int indexOf(String str)返回指定子字符串在此字符串中第一次出现处的索引。返回的整数是
     */
    @Test
    public void test9() {
        System.out.println("fsdjiojijioijojiojiojif.java".lastIndexOf(".java"));
        System.out.println("jidfjiojoiadfsjioadfsjiasdfjjio".lastIndexOf('i'));
    }


    /**
     * 替换
     * public String replace(CharSequence target,
     *                       CharSequence replacement)
     *    使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     *    该替换从字符串的开头朝末尾执行，例如，用 "b" 替换字符串 "aaa" 中的 "aa" 将生成 "ba" 而不是 "ab"。
     *    public final class String
     *     implements java.io.Serializable, Comparable<String>, CharSequence {
     *     String 类实现了 CharSequence 这个接口
     */
    @Test
    public void test10() {
        String s = "http://www.baidu.com".replace("http://", "https://");
        System.out.println(s);
        String s2 = "name=:zhangsan&password=123&agr=19";
        System.out.println(s2);
        String s3 = s2.replace('=', '#');
        System.out.println(s3);
    }


    /**
     * 拆分
     *  public String[] split(String regex)根据给定正则表达式的匹配拆分此字符串。
     */
    @Test
    public void test11() {
        String[] s2 = "1970-1-1".split("-");
        System.out.println(Arrays.toString(s2));
        String s3 = "name=:zhangsan&password=123&agr=19";
        String[] s4 = s3.split("&");
        System.out.println(Arrays.toString(s4));

    }

    /**
     * 判断某个字符串是否是以某个子字符串开始的
     * public boolean startsWith(String prefix)测试此字符串是否以指定的前缀开始。
     * public boolean endsWith(String suffix)测试此字符串是否以指定的后缀结束。
     */
    @Test
    public void test12() {
        boolean b1 = "http://www.baidu.com".startsWith("http");
        System.out.println(b1);
        boolean b2 = "https://www.baidu.com".endsWith(".com");
        System.out.println(b2);
    }


    /**
     * 截取字符串
     * public String substring(int beginIndex)返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。
     * public String substring(int beginIndex,
     *                         int endIndex)返回一个新字符串，它是此字符串的一个子字符串。
     *                         该子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。
     *  注意是[) 左闭右开的。
     */
    @Test
    public void test13() {
        String s1 = "http://www.baidu.com".substring(7);
        System.out.println(s1);
        String s2 = "https://www.baidu.com".substring(0,5);
        System.out.println(s2);
    }

    /**
     * 将字符串转换为 char[] 字符数组
     * public char[] toCharArray()将此字符串转换为一个新的字符数组。
     */
    @Test
    public void test14() {
        char[] arrs = "我是中国人".toCharArray();
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }


    /**
     * 去除字符串前后的空白
     * public String trim()返回字符串的副本，忽略前导空白和尾部空白。
     */
    @Test
    public void test15() {
        System.out.println("     hello     world    ".trim());
    }

    /**
     * 将非字符串转换为字符串
     * public static String valueOf(boolean b)返回 boolean 参数的字符串表示形式。
     * public static String valueOf(char c)返回 char 参数的字符串表示形式。
     * valeOf()是一个静态方法，类方法，可以直接使用类名调用
     */
    @Test
    public void test16() {
        String s1 = String.valueOf(true);
        System.out.println(s1);
        String s2 = String.valueOf(999);
        System.out.println(s2);
        String s3 = String.valueOf(3.14);
        System.out.println(s3);

        String s4 = String.valueOf(new Customer());
        System.out.println(s4);
    }


}
