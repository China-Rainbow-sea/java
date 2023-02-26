package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *元字符-限定符：
 *
 * + 说明: 表示出现 1 次到任意多次，比如 a+,1=，\\d+ 我们看看1+ 去匹配 1111111的话
 *
 * * 说明: 表示出现 0 次到 任意多次，比如 a*,1*,\\d* ,我们看看 a1* 去匹配a11111的话
 *
 * ？说明: 表示出现 0次到 1 次，比如: a?, 1?, \\d?,我们看看a1? 去匹配a11111的话，
 */
public class RegTheory06 {


    @Test
    public void test() {
        String content = "a111111";

        //String regStr = "1+"; // 匹配一个或多个

        //String regStr = "\\d+";  // 匹配一个数字或者多个数字

        //String regStr = "1*";  // 匹配任意多个

        String regStr = "a1?";  // 匹配a 或者 a1 , 0 个或 1 个

        // 创建正则对象
        Pattern pattern  =  Pattern.compile(regStr);

        // 创建匹配器
        Matcher matcher = pattern.matcher(content);  // 参数CharSequence接口，String 实现了该接口

        // 循环匹配
        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }



    }
}
