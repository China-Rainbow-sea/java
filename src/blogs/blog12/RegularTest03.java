package blogs.blog12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 转义字符的使用
 */
public class RegularTest03 {
    public static void main(String[] args) {
        String content = "abc.$(abc123c).";

        // 匹配 (创建正则表达式对象
        Pattern pattern = Pattern.compile("\\.");  // 单个未转义的"."表示任意字符

        // 匹配器
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while(matcher.find()) {
            String group = matcher.group(0);  // 整体没有分组的情况
            System.out.println(group);
        }
    }
}
