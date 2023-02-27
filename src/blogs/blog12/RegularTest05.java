package blogs.blog12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配符 |
 */
public class RegularTest05 {
    public static void main(String[] args) {
        String content = "你 您 拟 ";

        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile("你|您");

        // 2. 创建匹配器
        Matcher matcher = pattern.matcher(content);

        // 3.循环匹配
        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
