package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 元字符-定位符:
 * 定位符: 规定要匹配的字符串出现的位置，比如在字符串的开始还是在结束的位置，这个
 * 也是相当有用的，必须掌握:
 *
 *  ^ 指定起始字符:
 *    > ^[0-9]+[a-z]* 表示 以至少 1个数字开头，后接任意个小写字母的字符串: 123，6aa,555edf
 *
 *  $ 指定结束的字符:
 *    > ^[0-9]\\-[a-z]+$ 以1个数字开头后接连字符 “-” ，并以[a-z]至少1个小写字母结尾的字符串: 1-a
 *
 *   \\b 匹配目标字符串的边界
 *   > han\\b 这里说的字符串的边界指的是字串间有空格，或者是目标字符串的结束位置：hanshunping sphan nnhan
 *
 *   \B 匹配目标字符串的非边界， han\\B 和 \b的含义刚刚相反， hanshunping, sphan nnhan
 */
public class RegTheory07 {
    @Test
    public void test() {
        String content = "123-abc";  // a123abc  123abc  123abc12,

        //String regStr = "^[0-9]+[a-z]*"; // 以至少1个数字开头，后接任意个小写字母的字符串

        //String regStr = "^[0-9]+[a-z]+$";  // 以至少1个数字开头，必须以至少一个小写字母界结尾

        String regStr = "^[0-9]+\\-[a-z]+$";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建匹配器
        Matcher matcher = pattern.matcher(content);

        // 循环
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }


    }

    @Test
    public void test2() {
        String content = "hanshunping sphan nnhaan";

        //String regStr = "han\\b";  // 表示匹配边界 han ,边界：空格的子字符串的后面

        String regStr = "han\\B";  // 仅仅只是字符串的结尾，不含空格

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建匹配对象
        Matcher matcher = pattern.matcher(content);  // 该参数是个接口，String 实现了该接口

        // 循环
        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }

}
