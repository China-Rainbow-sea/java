package day32;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 正则表达式-应用实例
 */
public class RegTheory12 {


    /**
     * 正则表达式：经典的结巴程序
     * 把类似："我...我要...学学学学...编程java!";
     * 通过正则表达式 修改成 "我要学编程Java"
     */
    @Test
    public void test() {
        String content = "我...我要...学学学学...编程java!";

        // 1.去掉所有的.
        String regStr = "\\.";

        // 正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 匹配器对象
        Matcher matcher = pattern.matcher(content);
        // 1. 去掉所有的. 使用 matcher.replaceAll("") 替换为 空
        content = matcher.replaceAll("");

        // 2. 去重复的子，我我要学学学学编程Java
        // 思路:
        //(1)使用(.)\\1+ 找到重复的
        //(2)使用 反向引用$1 来替换匹配到的内容： 因为是在正则表达式外部了，反向引用格式是 $
        pattern = Pattern.compile("(.)\\1+");
        matcher = pattern.matcher(content);

        System.out.println(content);

        // 循环
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }
        //(2)使用 反向引用$1 来替换匹配到的内容： 因为是在正则表达式外部了，反向引用格式是 $
        content = matcher.replaceAll("$1");  //将 我我替换成 单个我，将学学学学替换成单个学
        System.out.println(content);


        // 还可以


    }


    // 方式2 一条语句完成:
    @Test
    public void test2() {
        String content = "我...我要...学学学学...编程java!";

        // 1.去除.
        content = Pattern.compile("\\.+").matcher(content).replaceAll("");

        content = Pattern.compile("(.)\\1+").matcher(content).replaceAll("$1");
        System.out.println(content);
    }


    /**
     * 替换功能;
     * String 类 public String replaceAll(String regex,String replacement)
     * 参数1是正则表达式，参数2是字符串
     * 将如下文字 JDK1.3 JDK1.4 统一替换成 JDK
     * fajiodfjasiofjioasjJDK1.3afsjoiadsjfoiasjJDK1.4
     */
    @Test
    public void test3() {

        String content = "fajiodfjasiofjioasjJDK1.3afsjoiadsjfoiasjJDK1.4";

        // 使用正则表达式，将JDK1.3和JDK1.4替换成JDK
        String regStr = content.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
        System.out.println(regStr);
    }


    /**
     * 要求: 验证一个手机号，要求必须是以138 139 开头的
     * 使用 String 类 public boolean matchers(String regex) {} 方法
     */
    @Test
    public void test4() {
        String content = "13812312123";

        boolean matches = content.matches("(138|139)\\d{8}");
        System.out.println(matches);
    }

    /**
     * 使用 String 类 public String[] split(String regex)
     * 将 "hello#abc-jack12smith~北京’
     * 要求按照 # 或者 -或者 ~ 或者数字来分割
     */
    @Test
    public void test5() {
        String content = "hello#abc-jack12smith~北京";

        String[] split = content.split("#|-|~|\\d+");
        for (String regStr : split) {
            System.out.println(regStr);
        }
    }


    /**
     * 验证电子邮件格式是否合法
     * 规定电子邮件规则为:
     * 1. 只能有一个@
     * 2. @前面是用户名，可以是a-z,A-Z,0-9 _字符
     * 3. @后面是域名，并且域名只能是英文字母，比如: sohu.com 或者 tsinghua.org.cn
     * 4.写出对应的正则表达式，验证输入的字符串是否为满足规则。
     */
    @Test
    public void test6() {
        String content = "f3213@qq.com";
        String regStr = "[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";

        boolean matches = content.matches(regStr);
        System.out.println(matches);
    }

    /**
     * 要求：验证是不是整数或者小数
     * 这个题目要考虑正数和负数
     * 123 -345 34.89 -87.9 -0.01 0.45
     */
    @Test
    public void test7() {
        //String content = "123 -345 34.89 -87.9 -0.01 0.45";

        String content = "0.56";
        // 思路先写简单的正则表达式
        // 在逐步完善
        //String regStr = "^\\d+$"; // 判断数值

        //String regStr = "^[-+]?\\d+(\\.\\d+)?$";  // 包含正负和小数
        // 处理特殊情况 000123.45
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";  // 包含正负和小数
        boolean matches = content.matches(regStr);
        System.out.println(matches);
    }


    /**
     * 对 url 进行解析:
     * https://www.sohu.com:8080/abc/index.htm
     * 获取协议 https
     * 获取域名: www.sohu.com
     * 端口： 8080
     * 文件名: index.htm
     */
    @Test
    public void test8() {
        String content = "https://www.sohu.com:8080/abc/index.htm";

        String regStr = "^([a-zA-Z]+)://([a-zA-z.]+):(\\d+)[\\w-/]*/([\\w.])+$";
        //String regStr = "^([a-zA-Z]+)://([a-zA-z.]+):(\\d+)[\\w-/]*/([\\w.%￥#(特殊符号)])+$"; 不够的时候还可以加

        // 正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 匹配器
        Matcher matcher = pattern.matcher(content);

        if(matcher.matches()) {  // 整体匹配，成功获取信息
            String group = matcher.group(1);
            System.out.println(group);
            String group2 = matcher.group(2);
            System.out.println(group2);
            String group3 = matcher.group(3);
            System.out.println(group3);
            String group4 = matcher.group(4);
            System.out.println(group4);

        } else {
            System.out.println("匹配失败");
        }


    }
}
