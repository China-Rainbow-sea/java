package blogs.blog12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest02 {


    /**
     *public String[] split(CharSequence input) 分割字符串
     */
    public static void main(String[] args) {
        String content = "one:two:three:four:five";

        // 1.创建正则表达式对象
        Pattern pattern = Pattern.compile(":");  // 以 : 分割

        String[] split = pattern.split(content);
        for (String regStr : split) {
            System.out.println(regStr);
        }
    }

    /**
     * public static boolean matches(String regex,CharSequence input) 方法
     */
    public static void main4(String[] args) {
        String content = "jfdasij123";

        boolean matches = Pattern.matches("\\w*123", content);
        System.out.println(matches);

        boolean matches2 = Pattern.matches("\\d", "1");
        System.out.println(matches2);
    }



    /**
     * 使用 replaceFirst(String) and replaceAll(String)
     */
    public static void main3(String[] args) {
        String content = "aabfooaabfooabfoob";

        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile("a*b");

        // 2. 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        String replaceAll = matcher.replaceAll("-");  // 替换全部
        System.out.println("replaceAll: " + replaceAll);

        String replaceFirst = matcher.replaceFirst("-");  // 替换第一个
        System.out.println("replaceFirst: " + replaceFirst);


    }


    /**
     * 使用 matches 和 lookingAt 方法
     */
    public static void main2(String[] args) {
        String content = "hiiiiiiiiiii";

        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile("hi");

        // 2. 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        System.out.println("lookingAt():" + matcher.lookingAt());  // true 只要其中匹配的字符串存在满足该正则表达式的规则返回true,

        System.out.println("matches():" + matcher.matches());  // false 必须要该匹配的字符串整体满足正则表达式的规则才返回 true
    }


    /**
     * matcher 中的 start / end 的使用
     */
    public static void main1(String[] args) {
        String content = "hello hello fdafd hello";

        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile("\\bhello\\b");

        // 2. 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while (matcher.find()) {
            System.out.print("start: " + matcher.start());  // 返回所匹配的子字符串的起始下标位置
            System.out.print("\t" + "end: " + matcher.end()); // 返回所匹配的子字符串的结束下标位置 + 1
            System.out.println();
        }
    }
}
