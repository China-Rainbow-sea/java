package blogs.blog12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组
 */
public class RegularTest08 {

    /**
     *
     *  对 2020-05-10 20:23:05 日期时间进行 8 次分组。分为日期：年月日，时间：时分秒。
     */
    public static void main(String[] args) {
        String content = "2020-05-10 20:23:05";

        String regStr = "((\\d{4})-(\\d{2})-(\\d{2})).((\\d{2}):(\\d{2}):(\\d{2}))";

        // 1.创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);

        // 2. 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 3.循环匹配遍历
        while(matcher.find()) {
            System.out.println("日期时间:" + matcher.group(1));
            System.out.println("年:" + matcher.group(2));
            System.out.println("月:" + matcher.group(3));
            System.out.println("日:" + matcher.group(4));
            System.out.println("时间:" + matcher.group(5));
            System.out.println("时:" + matcher.group(6));
            System.out.println("分:" + matcher.group(7));
            System.out.println("秒:" + matcher.group(8));
        }

    }

    /**
     * 从“李华校长 李华院长 李华老师 李华同学 “字符串中找到身份不是院长，校长，老师的李华姓名
     *
     */
    public static void main4(String[] args) {
        String content = "李华校长 李华院长 李华老师 李华同学";

        String regStr = "李华(?!校长|院长|老师)";
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


    /**
     * 从“李华校长 李华院长 李华老师 李华同学 “字符串中找到身份为校长院长”名为李华的名字。
     *
     */
    public static void main3(String[] args) {
        String content = "李华校长 李华院长 李华老师 李华同学";

        String regStr = "李华(?=校长|院长)";
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

    public static void main2(String[] args) {
        String content = "9988fasjiofas";

        //String regStr = "(\\d\\d)(\\d\\d)";  // 匹配 4 个数字的字符串

        // 命名分组: 即可以给分组取名:
        String regStr = "(?<num1>\\d\\d)(?<num2>\\d\\d)";  // 注意命名不可以数字开头

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr); // String实现了该参数的接口

        // 创建匹配器
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while (matcher.find()) {
            String group = matcher.group(0);  // 整体分组
            System.out.println(group);
            //String group1 = matcher.group(1);  // 第一分组
            String group1 = matcher.group("num1");  // 第一分组
            System.out.println(group1);
            //String group2 = matcher.group(2);  // 第二分组
            String group2 = matcher.group("num2");  // 第二分组  可以用命名也可以用编号
            System.out.println(group2);
        }
    }



    public static void main1(String[] args) {
        String content = "2020-05-10 20:23:05";

        String regStr = "(\\d{4}-\\d{2}-\\d{2}).(\\d{2}:\\d{2}:\\d{2})";

        // 1.创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);

        // 2. 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 3.循环匹配获取
        while (matcher.find()) {
            String group = matcher.group();  // 0 / 不传参数，默认获取是整体正则表达式匹配的内容
            System.out.println("整体：日期和时间：" + group);
            String group1 = matcher.group(1); // 1 获取到表示第一个分组内容
            System.out.println("第一个分组(第一个圆括号的内容)日期：" + group1);
            String group2 = matcher.group(2);  // 2获取到表示第二个分组的内容
            System.out.println("第二个分组(第二个圆括号的内容)时间：" + group2);
            // 注意不存在： group(3) 第三组分组的内容，获取的话报异常
            //String group3 = matcher.group(3);

        }
    }
}
