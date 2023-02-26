package day32;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 * 提出需求:
 *  给你一段文本，请你找出所有四个数字连在一起的的子串，并且这四个数字要满足
 *   1. 第1位与第4位相同: 5775
 *   2. 第2位与第3位相同: 1221
 *
 *  1.分组：
 *   我们可以用圆括号组成一个比较复杂的匹配模式，那么一个圆括号的部分，我们可以看作是一个子表达式/一个分组。
 *  2. 捕获
 *    把正则表达式中子表达式/分组匹配的内容，保存到内存中以数字编号或显式命名的组里。
 *    方便后面引用，从左向右，以分组的左括号为标志，第一个出现的分组的组号为 1，
 *    第二个为 2 ，以此类推，组0代表的是整个正则式。
 *
 *  3. 反向引用:
 *   圆括号的内容被捕获后，可以在这个括号后被使用，从而写出一个比较实用的匹配模式，
 *   这个我们称为 "反向引用"，这种引用既可以是正则表达式内部，也可以是在正则表达式外部，
 *   内部反向引用格式为 : \\分组号，外部反向引用$分组号。
 */
public class RegTheory011 {

    /**
     * 案例说明:
     * 1.要匹配两个连续的相同数字 (\\d)\\1
     * 2.要匹配五个连续的相同数字 (\\d)\\1{4}  = (\\d)\\1\\1\\1\\1\\1
     * 3.要匹配个位与千位相同，十位与百位相同的数: 5225,1551(\\d)(\\d)\\2\\1
     *
     * 请在字符串中检索商品编号，形式如: 12321-3339991111这样的号码，
     * 要求满足前面是一个五位数，然后一个 -号，然后是一个九位数，连续的每三位要相同。
     */
    @Test
    public void test() {
        String content = "hello jack14 tom11 jack222222 yyy  5225, 1551 xxx";
       // String regStr = "(\\d)\\1";  // 11,22 两个连续的数字 \\1反引用：表示该位置上的值是重复第一个位置上的值。

        // 匹配五个连续的相同数字: (\\d)\\1{4}  \\1 表示第一个反引用该位置上的值是(重复第一个位置上的值))
        //String regStr = "(\\d)\\1{4}";

        // 要匹配个位与千位相同，十位与百位相同的数： 5225, 1551 (\\d)(\\d)\\2\\1
        // \\2 表示位于第二个反引用(重复)：该位置的数值是重复第二个位置上的值
        // \\1 表示位于第一个反引用(重复)：该位置的数值是重复第一个位置上的值
        String regStr = "(\\d)(\\d)\\2\\1";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建比较器对象
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }

    }


    /**
     * 请在字符串中检索商品编号，形式如: 12321-333999111
     * 要求满足前面是一个五位数，然后一个1号，然后是一个九位数，连续的每三位要相同
     */
    @Test
    public void test2() {

        String content = " 12321-333999111";

        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建比较器对象
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
