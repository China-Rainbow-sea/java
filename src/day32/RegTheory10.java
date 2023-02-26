package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式三个常用的类:
 * java.util.regex 包主要包括以下三个类 Pattern 类 Matcher 类 和 PatternSyntaxException 异常类
 *
 * Pattern 类:
 *  pattern 对象式一个正则表达式对象，Pattern 类没有公共构造方法，要创建一个Pattern 对象，
 *  调用器静态方法 Pattern.compile() ，返回一个Pattern 对象，该方法接受一个正则表达式作为它的第一个参数
 *
 * Matcher 类:
 * Matcher 对象是对输入字符串进行解释和匹配的引擎，与 Pattern 类一样，Matcher 也没有公共构造方法。
 * 你需要调用Pattern 对象的 matcher 方法来获取一个Matcher 对象，如: pattern.matcher(比较的字符串内容)
 *
 * PatternSyntaxException
 * PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
 */
public class RegTheory10 {

    /**
     * matches 方法，用于整体匹配，在验证输入的字符串的是否满足条件使用:
     * 就可以省略 ^$整体符号了
     */
    @Test
    public void test() {
        String content = "hello abc hello 韩顺平教育";

        //String regStr = "hello";

        String regStr = "hello.*";
        boolean matches = Pattern.matches(regStr, content);
        System.out.println(matches);

        /*源码分析:
         public static boolean matches(String regex, CharSequence input) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }
         */
    }

    @Test
    public void test2() {
        String content = "hello edu jack tom hello smith hello";
        String regStr = "hello";

        // 正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while(matcher.find()) {
            int start = matcher.start();  // 匹配的子字符串的起始下标位置，
            System.out.println(start);
            int end = matcher.end();    //  匹配的子字符串的结束下标位置，
            System.out.println(end);

            // 自己截断
            String substring = content.substring(matcher.start(), matcher.end());
            System.out.println(substring);
        }

        // 整体匹配方法， 常用于: 去校验某个字符串是否满足某个规则。
        boolean matches = matcher.matches();
        System.out.println(matches);


        // 替换: 完成 如果 content 字符串中有对应符合规则的信息，替换为 world
        // 注意: 返回的字符串才是替换后的字符串，原来的 content 不变化。
        String regStr1 = matcher.replaceAll("world");
        System.out.println(regStr1);
    }
}
