package day21;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String 的转换
 */
public class StringTransition {

    /**
     * 基本数据类型 ————————> String
     * String  ——————————> 基本数据类型
     */
    @Test
    public void test() {
        String s = "123";

        // int num = (int)s;  // 错误两个类之间没有继承关系，也没有共同实现的接口关系
        // String ——————> 基本数据类型
        int num = Integer.parseInt(s);
        System.out.println(num);

        // 基本数据类型 ——————> String
        String s2 = String.valueOf(num);
        System.out.println(s2);
        // 或者
        String s3 = num + "";
        System.out.println(s == s3);   // false 存在变量的拼接，不是直接指向方法区中的字符串常量池从


    }

    /**
     * String  ——————> char[]
     * char[]  ——————> String
     * public char[] toCharArray()将此字符串转换为一个新的字符数组。
     */
    @Test
    public void test2() {
        String s = "abc123";

        // 将字符串 转换为 字符数组
        char[] ars = s.toCharArray();
        for (int i = 0; i < ars.length; i++) {
            System.out.println(ars[i]);
        }

        // 将字符数组  转换为 String
        char[] ars2 = new char[]{'a', 'b', '1', '0', '9'};
        String s2 = new String(ars2);
        System.out.println(s2);

    }

    
    /**
     * String  ——————> byte[]  对应的字母的编码值
     * byte[]  ——————> String  abc�й� 如果编码不一致会出现乱码
     * public byte[] getBytes()使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
     * 当此字符串不能使用默认的字符集编码时，此方法的行为没有指定。如果需要对编码过程进行更多控制，则应该使用 CharsetEncoder 类。
     */
    @Test
    public void test3() {
        String s = "abc123";

        // 将  String  转换为  byte[]  注意对应的字母的编码值
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));

        // 对于 String中存有 中文 可以需要指定编码
        // 异常处理，如果该编码不存在呢
        String s2 = "abc中国";
        byte[] byte2 = null;
        try {
             byte2 = s2.getBytes("gbk");   // gbk 一个中文占 2 个字节空间 utf-8 占 3 个字节
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(byte2));

        // byte[] 转换为 String
        String s3 = new String(byte2);  // abc�й� 如果编码不一致会出现乱码
        System.out.println(s3);

    }
}
