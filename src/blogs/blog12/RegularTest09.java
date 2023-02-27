package blogs.blog12;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java中正则表达式底层的实现原理
 */
public class RegularTest09 {
    public static void main(String[] args) {
        String content = "1995年5月23日，JAVA语言诞生（雏形）1996年，1997分别推出JDK1.0，JDK1.1版。" +
                "1999年，JAVA被分成J2SE,J2EE,J2ME2000年，" +
                "JDK1.4发布2004年9月30日18:00PM，J2SE1.5发布，成为Java语言发展史上的又一里程碑。" +
                "为了表示该版本的重要性，J2SE1.5更名为Java SE 5.0 2005年，" +
                "JAVA版本正式更名为JAVAEE,JAVASE, JAVAME2006年12月，" +
                "SUN公司发布JRE6.0 2009年04月20日，Oracle以74亿美元收购Sun。取得java的版权。 " +
                "2010年9月，JDK7.0已经发布，增加了简单闭包功能。 " +
                "2011年7月，甲骨文公司发布java7的正式版。2014年，" +
                "甲骨文公司发布了Java8正式版";

        // 这里我编写一个获取连续4个数字的子字符串
        String regStr = "(\\d\\d)(\\d\\d)";

        // 1. 创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);

        // 2. 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 3.循环遍历匹配
        while(matcher.find()) {
            String group = matcher.group(0);  // 获取整体正则表达式内容
            System.out.println(group);
            String group1 = matcher.group(1);  // 获取在符合匹配整体正则表达式内容的基础上，再的第1个分组(编号是从左往右)
            System.out.println(group1);
            String group2 = matcher.group(2);
            System.out.println(group2);       // 获取在符合匹配整体正则表达式内容的基础上，再的第2个分组(编号是从左往右)

        }
    }
}
