package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 为什么要学习正则表达式: ???
 * > 解决上述问题，Java提供了正则表达式技术，专门用于处理类似文本问题
 * > 简单的说: 正则表达式式是对字符串执行模式匹配的技术。
 *
 * 介绍:
 *  1.一个正则表达式，就是用某种模式去匹配字符串的一个公式。很多人因为它们看上去比较古怪而且复杂：
 *  所以不敢去使用，不过，经过练习后，就觉得这些复杂的表达式写起来还是相当简单的，而且，一旦你弄懂它们。
 *  你就能把数小时辛苦而且易错的文本处理工作缩短在几分钟（甚至几秒钟）内完成。
 *
 *  2.这里特别强调，正则表达式不是只有Java才有，实际上很多编程语言都支持正则表达式进行字符串操作，
 *  JavaScript，PHP，java
 */
public class RegTheory02 {

    /**
     * 分析Java正则表达式的底层实现
     */
    @Test
    public void test() {
        String content = "1995年5月23日，JAVA语言诞生（雏形）1996年，1997分别推出JDK1.0，JDK1.1版。" +
                "1999年，JAVA被分成J2SE,J2EE,J2ME2000年，" +
                "JDK1.4发布2004年9月30日18:00PM，J2SE1.5发布，成为Java语言发展史上的又一里程碑。" +
                "为了表示该版本的重要性，J2SE1.5更名为Java SE 5.0 2005年，" +
                "JAVA版本正式更名为JAVAEE,JAVASE, JAVAME2006年12月，" +
                "SUN公司发布JRE6.0 2009年04月20日，Oracle以74亿美元收购Sun。取得java的版权。 " +
                "2010年9月，JDK7.0已经发布，增加了简单闭包功能。 " +
                "2011年7月，甲骨文公司发布java7的正式版。2014年，" +
                "甲骨文公司发布了Java8正式版";

        String regStr = "\\d\\d\\d\\d";  //\\d{4};

        // 1.创建正则表达式对象
        Pattern pattern = Pattern.compile(regStr);

        // 2.创建匹配器，用于正则比较匹配
        Matcher matcher = pattern.matcher(content);



        // 循环比较判断
        while(matcher.find()) { // 整体找到，返回true,否则返回false
            String group = matcher.group();
            System.out.println(group);
        }

        /*
        matcher.find() 完成的任务:

        找第二正则表达式匹配的内容:
        1. 根据指定的正则表达式的规则，定位满足规则的子字符串(比如 1995)
        2. 找到后，将子字符串的开始索引记录到 matcher对象的属性 int[] groups数组当中
           > groups[0] = 0, 把该子字符串的“结束的索引” + 1的值记录到 groups[1] = 3 + 1 = 4
           > groups[20] 默认是 20 个容量，其中的默认值为 -1，
        3. 同时记录oldLast的值为子字符串的结束的所引+1的值为子字符串的结束的索引 +1的值，这里为 4
        ,即下次执行find()时，就从 4 索引开始匹配了

        1. 根据指定的正则表达式的规则，定位满足规则的子字符串(比如 1996)
        2. 找到后，将子字符串的开始索引记录到 matcher对象的属性 int[] groups数组当中
           > 注意字符串的索引下标是从 0 开始的。这一点十分重要的。这里因为是找第二个符合正则表达式的内容
           // 所以从 oldLast的值 为 4 开始找
           > 覆盖第一个找到符合正则表达式的子字符串索引的在 groups[0]&[1]数组的内容
           > groups[0] = 23, 把该子字符串的“结束的索引” + 1的值记录到 groups[1] = 26 + 1 = 27
           > groups[20] 默认是 20 个容量，其中的默认值为 -1，
        3. 同时记录oldLast的值为子字符串的结束的所引+1的值为子字符串的结束的索引 +1的值，这里为 27
        ,即下次执行find()时，就从 27 索引开始匹配了

        ... 如果再次执行 find()方法，仍然是按照上面的方式找寻的。

        matcher.group()的源码:
        public String group() {
        return group(0);
    }
    public String group(int group) {
        if (first < 0)
            throw new IllegalStateException("No match found");
        if (group < 0 || group > groupCount())
            throw new IndexOutOfBoundsException("No group " + group);
        if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
            return null;
        return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
    }                               // groups[0*2],groups[0*2+1]
                                    // 分组的时候: groups[1*2], groups[1*2+1]
                                    // getSubsequence()是一个字符串截断的方法，注意：截断方式是左闭右开的

         */


        pattern = Pattern.compile("(\\d\\d)(\\d\\d)");
        matcher = pattern.matcher(content);

        while(matcher.find()) {
            String group = matcher.group(0);  // 就算不传参数默认是 0 就是不分组的整体的匹配内容
            String group1 = matcher.group(1); // 表示第1组整体后的分组
            System.out.println(group1);
            String group2 = matcher.group(2); // 表示第2组整体后的分组
            System.out.println(group2);

           //  String group3 = matcher.group(3);  // java.lang.IndexOutOfBoundsException: No group 3
            // 注意不能越界了，因为如果越界了不存在的分组，groups[n]= -1 是-1的索引下标:
            // 字符串的索引是没有 -1 下标的，报异常错误。
            /*
            这样的原因是：如下源码的算法决定的:
            public String group(int group) {
        if (first < 0)
            throw new IllegalStateException("No match found");
        if (group < 0 || group > groupCount())
            throw new IndexOutOfBoundsException("No group " + group);
        if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
            return null;
        return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();  // 截断
    }                               // groups[0*2],groups[0*2+1]
                                    // 分组的时候: groups[1*2], groups[1*2+1] 第一分组 groups[2]-[3]
                                    // 第二分组 groups[4]-[5]

             */



        }


        // 分组: 比如(\\d\\d)(\\d\\d)
        // 正则表达式中有()表示分组，第1个()表示第1组，第2个表示第2组...
        // 根据指定的规则，定位满足正则表达式规则的子字符串（比如 (19)(98)）
        // 注意是先从整体上匹配正则表达式，也就是没有分组的时候: \\d\\d\\d\\d ，只有到整体都匹配了
        // 才会再该整体的基础上，再进行分组
        // 找到后:将子字符串的开始索引记录到 matcher对象的属性 int[] groups数组当中
           // 2.1 groups[0]  记录的是整体匹配正则表达式的子字符串的起始位置；(1995) 0
           // groups[1] 记录的是整体匹配正则表达式的子字符串的结束下标索引 +1 (1995) 3+1= 4
           // groups[2] 记录的是再整体匹配正则表达式的基础上再分组的第1个分组的子字符串的起始下标位置: (1995)(19) 0
           // groups[3] 记录的是再整体匹配正则表达式的基础上再分组的第1个分组的子字符串的结束下标位置 + 1：(1995)(19) 1+1=2
           // groups[4] 记录的是再整体匹配正则表达式的基础上再分组的第2个分组的子字符串的起始下标位置: (1995)(95) 2
           // groups[3] 记录的是再整体匹配正则表达式的基础上再分组的第2个分组的子字符串的结束下标位置 + 1：(1995)(95) 3+1=4
           // 第3组，第4组都还是以此类推
        // 这里的 是:
        /*
           记录1组()匹配到的字符串 groups[2] = 0, groups[3]=2
           记录2组()匹配到的字符串 groups[4]=2 ,groups[4] = 4
           如果有更多的分组以此类推
           同时记录oldLast的值为子字符串的结束的所引+1的值为子字符串的结束的索引 +1的值，这里为 27
        ,即下次执行find()时，就从 27 索引开始匹配了
         */
    }
}
