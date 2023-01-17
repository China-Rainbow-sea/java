package day21;


import org.junit.Test;

/**
 * StringBuffer / StringBuild 的使用
 * String  / StringBuffer / StringBuild 的区别
 * String : 不可变的字符序列
 * StringBuffer: 可变的字符序列，线程安全的 synchronized ，但是效率低，底层使用char[] 存储
 * StringBuild:  可变的字符序列 jdk5.o 新增的线程不安全，但是效率高，底层使用char[] 存储
 * <p>
 * String str = new String(); // new char[0]
 * String str = new String("abc"); // new char[]{'a','b','c'}
 * StringBuffer sb1 = new StringBuffer();  // char[] value = new char[16]; 底层创建了一个长度是 10 的char[] 字符串
 * sb1.append('a'); value[0] = 'a';
 * sb1.append('b'); value[1] = 'b';
 * StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length() + 16];
 * // 问题1. System.out.println(sb2.length); // 3
 * 问题2. 扩容问题：如果要添加的数据底层数组装不下了，那么就需要扩容底层的数组
 * 默认情况下，扩容为原理容量的2倍 + 2，同时将原有数组中的元素复制Arrays.copyOf()新扩容的数组当中
 * <p>
 * 建议: 开发中建议大家使用: StringBuffer(int capacity) 或StringBuilder(int capacity)
 * <p>
 * // 总结:
 * 增加: append(xxx)
 * 删: delete(int start,int end)
 * 改: setCharAt(int n,char ch) / replace(int start,int end, String str)
 * 查: charAt(int n)
 * 插: insert(int offset, xxx)
 * 长度: length()
 * 遍历: for + charAt()/toString()
 */
public class StringBufferBuilderTest {

    /**
     * public void setCharAt(int index,
     * char ch)将给定索引处的字符设置为 ch。此序列将被转换，以表示等同于原字符序列的新字符序列，唯一的不同在于新序列在 index 处包含 ch。
     * index 参数必须大于等于 0，且小于此序列的长度。
     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');   // 直接修改的是String 字符串的
        // 而String 则是无法修改的而是一个返回值
        System.out.println(sb1);

    }


    /**
     * append(xxx): 提供了很多的append()方法，用于进行字符串拼接
     */
    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(9);   // 添加 int
        s1.append('1');  // 添加 char 类型
        s1.append("hello"); // 添加 String 类型
        s1.append(true);    // 添加 boolean 类型
        s1.append(3.14);    // 添加 false 类型

        System.out.println(s1);
    }

    /**
     * public StringBuffer replace(int start,
     * int end,
     * String str)
     * 使用给定 String 中的字符替换此序列的子字符串中的字符。该子字符串从指定的 start 处开始，一直到索引 end - 1 处的字符，如果不存在这种字符，
     * 则一直到序列尾部。先将子字符串中的字符移除，然后将指定的 String 插入 start。（如果需要，序列将延长以适应指定的字符串。）
     * 将对应字符串 "下标位置中" 的内容替换为指定 "内容"
     */
    @Test
    public void test3() {
        StringBuffer sb = new StringBuffer("helloWorld");
        System.out.println(sb);
        sb.replace(1, 2, "999");
        System.out.println(sb);
    }


    /**
     * public StringBuffer delete(int start,
     * int end)   //
     * 移除此序列的子字符串中的字符。该子字符串从指定的 start 处开始，一直到索引 end - 1 处的字符，
     * 如果不存在这种字符，则一直到序列尾部。如果 start 等于 end，则不发生任何更改。
     * <p>
     * // 删除字符串中指定的 下标范围的内容。注意是 [) 左闭右开的
     */
    @Test
    public void test4() {
        StringBuffer sb = new StringBuffer("helloWorld");
        System.out.println(sb);
        sb.delete(0, 5);
        System.out.println(sb);

    }


    /**
     * public StringBuffer insert(int offset,
     * xxxx)将 char 参数的字符串表示形式插入此序列中。
     */
    @Test
    public void test5() {
        StringBuffer sb = new StringBuffer("上海伦敦东京");
        System.out.println(sb);
        sb.insert(0, 99); // 插入 int
        sb.insert(sb.length(), 3.14);  // 插入 false 类型
        sb.insert(2, "纽约");
        sb.insert(5, true);
        System.out.println(sb);
    }


    /**
     * public StringBuffer reverse()将此字符序列用其反转形式取代。如果序列中存在代理项对 (surrogate pair)，在 reverse 操作中将其作为单个字符处理。
     * 因此，高-低代理项的顺序不会反转。
     * 假设 n 为执行 reverse 方法前此字符序列的字符长度（并非 char 值的长度），则新字符序列中索引 k 处的字符将等于原字符序列索引 n-k-1 处的字符。
     */
    @Test
    public void test6() {
        StringBuffer sb = new StringBuffer("helloWorld");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

    }


    /**
     * 截断
     * public String substring(int start,
     * int end)
     * 返回一个新的 String，它包含此序列当前所包含的字符子序列。
     * 该子字符串从指定的 start 处开始，一直到索引 end - 1 处的字符。
     * 注意是 “左闭右开”的
     */
    @Test
    public void test7() {
        StringBuffer sb = new StringBuffer("helloWorld");
        System.out.println(sb);
        String s2 = sb.substring(5, sb.length());
        System.out.println(s2);
    }


    /**
     * public char charAt(int index)返回此序列中指定索引处的 char 值。第一个 char 值在索引 0 处，
     * 第二个在索引 1 处，依此类推，这类似于数组索引。
     * index 参数必须大于等于 0，且小于此序列的长
     */
    @Test
    public void test8() {
        StringBuffer sb = new StringBuffer("helloWorld");
        System.out.println(sb);
        char c = sb.charAt(2);
        System.out.println(c);
        System.out.println(sb.charAt(5));
    }

    /**
     * public void setCharAt(int index,
     * char ch)
     * 将给定索引处的字符设置为 ch。此序列将被转换，以表示等同于原字符序列的新字符序列，唯一的不同在于新序列在 index 处包含 ch。
     * index 参数必须大于等于 0，且小于此序列的长度。
     */
    @Test
    public void test9() {
        StringBuffer sb = new StringBuffer("helloWorld");
        System.out.println(sb);
        sb.setCharAt(0, '中');
        System.out.println(sb);

    }


    /**
     * 对比String / StringBuffer / StringBuilder 三者的效率
     * 从高到低排列: StringBuilder > StringBuffer > String
     */
    @Test
    public void test10() {
        // 设置初始比较时间
        long startTime = 0L;   // 默认 整数是 int 类型
        long endTime = 0L;

        String stringTest = "";
        StringBuffer stringBufferTest = new StringBuffer("");
        StringBuilder stringBuilderTest = new StringBuilder("");

        // String 执行
        startTime = System.currentTimeMillis();    // 获取到当前的毫秒值(时间戳)

        for (int i = 0; i < 200000; i++) {
            stringTest += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String: " + (endTime - startTime));


        // StringBuffer 执行
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 200000; i++) {
            stringBufferTest.append(String.valueOf(i));  //将int 类型转换为 String
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (endTime - startTime));

        // StringBuilder
        startTime = System.currentTimeMillis();  // 获取到当前系统的毫秒数(时间戳)
        for (int i = 0; i < 200000; i++) {
            stringBuilderTest.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (endTime - startTime));

    }


}
