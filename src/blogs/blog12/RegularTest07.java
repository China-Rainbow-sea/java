package blogs.blog12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest07 {
    public static void main(String[] args) {
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


    public static void main2(String[] args) {
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
}
