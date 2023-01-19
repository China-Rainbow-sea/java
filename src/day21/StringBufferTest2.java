package day21;


import org.junit.Test;

/**
 * 思考: 我们在实际的开发中，如果需要进字符串的频繁拼接，会有什么问题 ？？？
 * 因为java中的字符串是不可变的，每一次拼接都会产生新字符串。
 * 这样会占用大量的方法区内存，造成内存空间的浪费。
 *  String s = "abc"
 *  s += "hello"
 *  就以上两行代码，就导致在方法区字符串常量池当中创建了3个对象:
 *  "abc"
 *  "hello"
 *  "abchello"
 *
 */
public class StringBufferTest2 {
    @Test
    public void test() {
        String s = "";
        // 这样做会给java方法区字符串常量池带来很大的压力.
        for(int i = 0; i < 100; i++) {
            // s+ = i
            s = s + String.valueOf(i);
            System.out.println(s);
        }
    }


    /**
     *  如果以后需要进行大量字符串的拼接操作，建议使用JDK自带的:
     *     java.lang.StringBuffer
     *     java.lang.StringBuilder
     *
     */
    @Test
    public void test2() {
        // 创建一个初始容量为 16个byte[]数组，字符串缓冲区对象
        StringBuffer stringBuffer = new StringBuffer();

        // append()对象方法，拼接字符串，以后拼接字符串统一调用 append()方法。
        // append 是附加，追加的意思。
        stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append(3.14);
        stringBuffer.append(true);

        // append方法底层在进行追加的时候，如果byte数组满了，会自动扩容。
        stringBuffer.append(100L);
        System.out.println(stringBuffer);
    }


    /**
     * 如何优化StringBuffer的性能？
     * 在创建StringBuffer的时候尽可能给定一个初始化容量。
     * 最好减少底层数组的扩容次数，预估计一下,给一个大一些初始化容量。
     * 关键点: 给一个合适的初始化容量，可以提高程序的执行效率(减少扩容的次数)
     */
    @Test
    public void test3() {
        // 指定初始化容量的StringBuffer 对象(字符串缓冲区对象)
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("hello");
        stringBuffer.append("hello");
        stringBuffer.append("hello");
        stringBuffer.append("hello");
        stringBuffer.append("hello");

        System.out.println(stringBuffer);
    }
}

