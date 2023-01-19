package day21;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * StringJoiner 是JDK8 特性
 */
public class JDK8StringJoiner {

    /**
     * StringJoiner(CharSequence delimiter) String 实现了CharSequence 接口
     * public StringJoiner(间隔符号) 表示创建一个StringJoiner 对象，并指定拼接时的间隔符号
     * public StringJoiner add(CharSequence newElement)
     * 将给定的副本CharSequence值作为下一个元素StringJoiner值。 如果newElement是null ，则添加"null" 。
     */
    @Test
    public void test() {
        StringJoiner stringJoiner = new StringJoiner("---");

        for (int i = 0; i < 3; i++) {
            stringJoiner.add(String.valueOf(i));  // String.valueOf()将int转换为 String
        }

        System.out.println(stringJoiner);

    }


    /**
     * public StringJoiner(CharSequence delimiter,
     *                     CharSequence prefix,
     *                     CharSequence suffix)
     *
     *public StringJoiner(间隔符号,开始符号,结束符号)
     * 创建一个StringJoiner对象，指定拼接的时间间隔符号，以及开始符号，和结束符号
     *
     */
    @Test
    public void test2() {
        StringJoiner stringjoiner = new StringJoiner("--","[" ,"]");

        for (int i = 0; i < 7; i++) {
            stringjoiner.add(String.valueOf(i)); // String.valueOf()将int类型转换为 String类型
        }

        System.out.println(stringjoiner);
    }
}
