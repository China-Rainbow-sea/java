package day21;


import org.junit.Test;

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


}
