package blogs.blog12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 限定符
 */
public class RegularTest06 {

    public static void main(String[] args) {
        String content = "aaabb ";

        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile("a+?");

        // 2. 创建匹配器
        Matcher matcher = pattern.matcher(content);

        // 3.循环匹配
        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }


    public static void main1(String[] args) {
        String content = "a111111";

        //String regStr = "1+"; // 匹配一个或多个

        //String regStr = "\\d+";  // 匹配一个数字或者多个数字

        //String regStr = "1*";  // 匹配任意多个

        String regStr = "a1?";  // 匹配a 或者 a1 , 0 个或 1 个


        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);

        // 2. 创建匹配器
        Matcher matcher = pattern.matcher(content);

        // 3.循环匹配
        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
