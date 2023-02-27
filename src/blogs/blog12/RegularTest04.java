package blogs.blog12;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符匹配符的使用
 */
public class RegularTest04 {
    public static void main(String[] args) {
        String content = "abc Abc aBc ABC abC";

        // 1. 创建正则表达式对象，并设置忽略大小写
        Pattern pattern = Pattern.compile("abc",Pattern.CASE_INSENSITIVE);

        // 2. 创建匹配器
        Matcher matcher = pattern.matcher(content);

        // 3.循环匹配
        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }



    public static void main2(String[] args) {
        String content = "abc ABC aBC aBc Abc";

        // 1. 创建对应的正则表达式对象
        Pattern pattern1 = Pattern.compile("(?i)abc");  // abc 都忽略大小写
        Pattern pattern2 = Pattern.compile("a(?i)bc");  // bc 忽略大小写
        Pattern pattern3 = Pattern.compile("a((?i)b)c");  // 只有 b 是忽略大小写的

        // 2. 创建对应的 匹配器对象
        Matcher matcher1 = pattern1.matcher(content);

        // 3. 循环匹配
        System.out.print("abc 都忽略大小写: ");
        while (matcher1.find()) {
            System.out.print(" " + matcher1.group());
        }

        Matcher matcher2 = pattern2.matcher(content);
        System.out.print("\nbc 忽略大小写: ");
        while (matcher2.find()) {
            System.out.print(" " + matcher2.group());
        }

        Matcher matcher3 = pattern3.matcher(content);
        System.out.print("\n只有 b 是忽略大小写: ");
        while (matcher3.find()) {
            System.out.print(" " + matcher3.group());
        }
        System.out.println();
    }


    public static void main1(String[] args) {

        String content = "adc 999fajoi111 fajoidfj000";

        // 编写正则表达式
        String regStr = "\\d\\d\\d"; // \\d 表示[0-9]的数字字符
        // 或者
        String regStr2 = "\\d{3}";  // 表示三个连续的数字字符

        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);

        // 2. 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while (matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }


    }


}
