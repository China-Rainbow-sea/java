package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的应用举例
 */
public class RegTheory09 {

    /**
     * 匹配汉字
     */
    @Test
    public void test() {
        String content = "你好世界321";

        String regStr = "^[\\u0391-\\uffe5]+$";  // 整体匹配，获取汉字

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


    /**
     * 邮政编码:
     * 要求：是 1-9 开头的一个六位数，比如: 12324
     */
    @Test
    public void test2() {
        String content = "123456";

        //String regStr = "^[1-9]{6}$";
        String regStr = "^[1-9]\\d{5}$";
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


    /**
     * qq号码:
     * 要求: 1-9 开头的一个(5位数-10位数) 比如: 12389,
     */
    @Test
    public void test3() {
        String content = "123999";

        String regStr = "^[1-9]\\d{4,9}$";  // ^开头$结尾表示整体匹配，也可以使用方法String中，或者Pattern 中的整体匹配
        //String regStr = "^[1-9]{5,10}$";  // ^开头$结尾表示整体匹配，也可以使用方法String中，或者Pattern 中的整体匹配

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


    /**
     * 手机号:
     * 要求: 必须以13,14,15,18 开头的11位数;
     */
    @Test
    public void test4() {
        String content = "13856403839";

        String regStr = "^1[3|4|5|8]\\d{9}$";  // ^$表示整体匹配，可以使用方法

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

    /**
     * 判断URL的合理性
     * https://space.bilibili.com/651245581?spm_id_from=333.337.0.0
     *
     */
    @Test
    public void test5() {
        String content = "https://search.bilibili.com/all?keyword=%E9%9F%A9%E9%A1%BA%E5%B9%B3&from_source=webtop_search&spm_id_" +
                "from=333.1007&search_source=2";


        /* 思路:
        1. 先确定url 的开始部分 https:// | http://
        2/  https://www.bilibili.com/
         */

        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=%&_/.]*)?$";
        // 注意: [.] 表示匹配的就是.本身。

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

    /**
     * 注意[.\] 表示的都是.本身，以及\本身
     */
    @Test
    public void test6() {
        String content = "hello . ?adbc .? 111";

        //String regStr = "."; // 表示匹配除了 \n 的所有字符串
        //String regStr = "[.]"; // 表示匹配"." 点本身.
        //String regStr = "\\."; // 或者转义表示 .

        String regStr = "[?]"; // 表示? 问号本身
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

}
