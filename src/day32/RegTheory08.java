package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组:
 *  (pattern) 非命名捕获，捕获匹配的子字符串，编号为 0 的第一个捕获是由整个正则表达式
 *  模式匹配的文本，其它捕获结果则根据左括号的顺序从 1 开始自动编号。
 *
 *  (? <name> pattern) 命名捕获，将匹配的子字符串捕获到一个组名或编号名称中，用于 name
 *  的字符串不能包含任何标点符号，并且不能以数字开头，可以使用单引号替代尖括号<>,例如: (?'name')
 *
 *
 *  特别是分组:
 *  以下的所有括号都不表示分组，而是整体
 *  (?:pattern) 匹配 pattern 但不捕获该匹配的子表达式，即它式一个非捕获匹配，不存储
 *  供以后使用的匹配，这对于用 "or"字符 (|) 组合模式部件的情况很有用。
 *  例如: industr(?:y|les) 是比 "industry | industries 更经济的表达式。
 *  (?=pattern) 它是一个非捕获匹配，例如: "Windows (?=95|98|NT|2000)" 匹配
 *  "windows 2000"中的 "windows" ,但不匹配 Windows 3.1 中的“Windows”
 *
 * (?|patrern) 该表达式匹配不处于匹配 pattern 的字符串的起始点的搜素字符串，它是
 * 一个非捕获匹配。例如： Windows(?!95|98|NT|2000) 匹配 Window 3.1 中的 Windows 但不匹配 Windows 2000
 * 中的 Windows
 */
public class RegTheory08 {

    @Test
    public void test() {
        String content = "hanshunping s7789 nn1189han";

        //String regStr = "(\\d\\d)(\\d\\d)";  // 匹配 4 个数字的字符串

        // 命名分组: 即可以给分组取名:
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr); // String实现了该参数的接口

        // 创建匹配器
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while (matcher.find()) {
            String group = matcher.group(0);  // 整体分组
            System.out.println(group);
            //String group1 = matcher.group(1);  // 第一分组
            String group1 = matcher.group("g1");  // 第一分组
            System.out.println(group1);
            //String group2 = matcher.group(2);  // 第二分组
            String group2 = matcher.group("g2");  // 第二分组  可以用命名也可以用编号
            System.out.println(group2);
        }

    }

    /**
     * 举例特殊分组:
     * 给字符串 ： String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello"
     * 使用非捕获分组完成。如下要求:
     * 1. 找到韩顺平教育，韩顺平老师，韩顺平同学 子字符串
     * 2. 找到韩顺平 这个关键字，但是要求只是查找韩顺平教育和 韩顺平老师中包含有的韩顺平
     * 3. 找到韩顺平 这个关键字，但是要求只是查找不是(韩顺平教育和韩顺平老师)中包含有的韩顺平。
     */
    @Test
    public void test2() {
        String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello 韩顺平";

        //  1. 找到韩顺平教育，韩顺平老师，韩顺平同学 子字符串
        // String regStr = "韩顺平教育|韩顺平老师|韩顺平同学"; 捕获分组
        // 下面这种是非捕获分组
        //String regStr = "韩顺平(?:教育|老师|同学)";  // 该括号不表示分组


        //  2. 找到韩顺平 这个关键字，但是要求只是查找韩顺平教育和 韩顺平老师中包含有的韩顺平
        //String regStr = "韩顺平(?=教育|老师)";  // 该括号不表示分组
        //String regStr = "韩顺平(?=同学)";

        //3. 找到韩顺平 这个关键字，但是要求只是查找不是(韩顺平教育和韩顺平老师)中包含有的韩顺平。
        String regStr = "韩顺平(?!教育|老师)";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环
        while (matcher.find()) {
            String group = matcher.group(0);
            //String group1 = matcher.group(1); 特殊分组中的括号不表示分组,没有分组就无法捕获到分组内容了
            System.out.println(group);
        }
    }


    @Test
    public void test3() {
        String content = "hello1111111ok";

        //String regStr = "\\d+";  // 默认是贪婪匹配：匹配最多的，\\d 数字

        //  非贪婪匹配
        String regStr = "\\d+?";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }

    }
}


