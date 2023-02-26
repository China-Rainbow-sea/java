package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-字符匹配符:
 * [] : 可接收的字符列表，[abcd] 表示 a,b,c,d 中的任意1个字符 ：
 * [^]: 不接收的字符列表，[^abc] 表示除了 a,b,c之外的任意 1 个字符，包括数字和特殊符号;
 * - ：连字符  A-Z 表示任意单个 A 到 Z 之间的字母 :a,A
 * .: 匹配除了 "\n" 以外的任何字符,一个“.”点表示一个字符，
 *   > a..b 表示以a开头,b结尾，中间包括2个任意字符的长度为4的字符串 aaab,aefb,a35b,a#*b
 * \\d: 匹配“单”个数字字符，相当于[0-9]
 *   > \\d{3}(\\d)? 包含3个或4个数字的字符串 ? 表示 0~n个 ：123，9876
 * \\D: 匹配“单”个非数字字符，相当于[^0-9]:
 *   > \\D(\\d)* 表示以单个非数字字符，后接任意个数字符串（也可以没有） a3,a,A325
 * \\w : 匹配单个数字，大小写字母字符相当于[0-9a-zA-Z]
 *   > \\d{3}\\w{4} 以3个数字字符开头的长度为7 的数字字母组成的字符串： 234abcd,123456e,1234567
 * \\W: 匹配单个非数字，大小写字母字符，相当于[^0-9a-zA-Z]
 *   >\\W+\\d{2} 以至少一个非数字字母字符开头，2个数字字符结尾的字符串。+ b表示 1~n
 * \\s 匹配任何空白字符（空格，制表符等），注意虽然匹配到了，但是显示的时候我们是看不到的因为空白吗
 * \\S 匹配任何非空白字符，和\s刚好相反：匹配出 "\n" 之外的所有字符，如果要匹配"."本身则需要使用\\
 *
 *
 *  元字符-字符匹配符:
 *  "注意: java中的正则表达式默认是区分字母的大小写的，如何实现不区分大小写的三种方式:
 *   1. (?i)abc ：表示 abc都不区分大小写
 *   2. a(?i)bc ：表示bc不区分大小写
 *   3. a((?i)b)c ： 表示只有b 不区分大小写，其中的(?i) 设置的是邻近左边的不区别大小写，可以使用括号区分
 *   4，Pattern pattern = Pattern.compile(regEx,Pattern.CASE.INSENSITIVE) 表示该设置的正则表达式都会是忽略大小写的。
 *
 *
 *
 */
public class RegTheory04 {

    @Test
    public void test() {

        String content = "abc123567890 ad 999";

        // 正则对象
        //Pattern pattern = Pattern.compile("\\d\\d\\d");  // 表示连续三个数字字符串
        // 或者
        Pattern pattern = Pattern.compile("\\d{3}");
        // 匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }

    }


    /**
     * 正则表达式省略大小写
     */
    @Test
    public void test3() {
        String content = "a11c8 ab&%￥c  ABC_";

       // String regStr = "abc";  // 默认是区分大小写的

        // 不区分大小写
        //String regStr = "(?i)abc";
        //String regStr = "abc";

        // String regStr = "[0-9]";  // 任意数字

        // [^a-z] 不匹配任意一个字母(默认是区分大小写的)
        //String regStr = "[^a-z]";

        //[^0-9] 不匹配任意一个数字字符(默认是区分大小写的)
        //String regStr = "[^0-9]";  // 注意不要写成； [^[0-9]]

        //[abcd] 匹配在 abcd 中的任意一个字符(默认是区分大小写的)
        //String regStr = "[abcd]";

        //String regStr = "\\w";  // 匹配 字母，数字，下划线任意一个字符，

        //String regStr = "\\W";  // 匹配等价于 [^a-zA-z0-9_] 不含上述字符


        String regStr = "\\s";  // 匹配任何空白字符(空格，制表符等)



        // 正则对象
        // Pattern.CASE_INSENSITIVE 忽略大小。
        Pattern pattern = Pattern.compile(regStr,Pattern.CASE_INSENSITIVE);

        // 匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }

    }
}
