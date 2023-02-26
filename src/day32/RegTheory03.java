package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式语法:
 * 》 元字符(\\) 转义号:
 * \\ 符号 说明: 在我们使用正则表达式去检索某些特殊字符的时候，需要用到转义符号，否则
 * 检索不到结果，甚至会报错的。案例: 用 $ 去匹配 "abc$(" 会怎么样 ? 用(去匹配 "abc$") 会怎样?
 *
 * 再次提示:
 *   在Java的正则表达式中，两个 \\代表其他语言中的一个 \
 *
 * 需要用到转义符号的字符有以下: {*,+,(),$,/,\,?,[],^,{},}
 *
 */
public class RegTheory03 {

    /**
     * 演示转义字符的使用
     */
    @Test
    public void test() {
        String content = "abc$(abc123c)";

        // 匹配 (创建正则表达式对象
        //Pattern pattern = Pattern.compile("\\(");  // （需要使用转义，不然编译都无法通过 \\ 表示\
        Pattern pattern = Pattern.compile("\\$");  // 需要转义不转义无法找到

        // 匹配器
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while(matcher.find()) {
            String group = matcher.group(0);  // 整体没有分组的情况
            System.out.println(group);
        }


    }

    /**
     * \\. 匹配.当个.
     * 注意特殊的的[.] 表示的就是点本身，不需要转义
     */
    @Test
    public void test2() {
        String content = "abc&(123.231.6( )";

        // 创建正则对象
        Pattern pattern = Pattern.compile("\\."); // 如果没有使用转义的话 "."单个.表示任意字符

        // 匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }

    }
}
