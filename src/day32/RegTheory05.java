package day32;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配符: 在匹配某个字符串的时候是选择性的，即: 即可以匹配这个，又可以匹配那个，要用到
 * 选择匹配符号
 * | : 匹配 "|" 之前或之后的表达式， ab|cd 匹配 ab或 dc
 *
 * 元字符-限定符:
 *  * 指定字符重复 0次或n次(无要求)0~n 0 到多
 *    > (abc)* 仅包含任意个 abc 的字符串，等效于\W: abc,abcabc
 *  + 指定字符重复1次或n次(至少一次) 1到多
 *    > m+(abc)* 以至少1个 m字符开头 ，后接任意个(abc)字符串 : m,mabc,mabcabc
 *  ? 指定字符重复0次或1次(最多一次) 0到1
 *    > m + abc? 以至少1个m开头，后接 ab或abc的字符串 : mab,mabc,mmmmab,mmabc,
 *  {n} 只能输入n个字符
 *    >[abcd]{3} 由abcd 中字母组成的任意长度为 3的字符串： abc, dbc, adc
 *  {n,} 指定至少 n 个匹配
 *    > [abcd]{3,} 由 abcd中字母组成的任意长度不小于3 的字符串 ： aab,dbc,aaabdc
 *  {n,m} 指定至少 n 个但不多于 m 个匹配
 *    > [abcd]{3,5} 由 abcd 中字母组成的任意长度不小于 3,不大于 5的字符串 :abc,abcd,aaaaa,bcdab
 *
 *   补充：{n} 表示出现的次数，比如 a{3} 1{4}
 *   但是注意一点： 1{3} 去匹配 11111111的话，默认Java中匹配是贪心匹配的(优先将字符串多的，匹配出来)
 */
public class RegTheory05 {

    @Test
    public void test() {
        String content = "hanshunping 韩 寒 ";

        String regStr = "han|韩|寒";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 匹配器
        Matcher matcher = pattern.matcher(content);

        // 循环
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);

        }
    }


    @Test
    public void test2() {
        String content = "1111111aaaaaahello";

        //String regStr = "a{3}";  // 表示匹配 aaa

        //String regStr = "1{4}";  // 表示匹配 1111

        //String regStr = "\\d{2}";  // 表示匹配两位任意数字字符


        //a{3,4} 1{4,5} \\d{2,5}

        // 表示匹配 aaa / aaaa
        //String regStr = "a{3,4}";  // 细节: Java匹配默认贪婪匹配，尽可能匹配最多的。

        //String regStr = "1{4,5}";  // 表示匹配 1111 或者 11111


        String regStr = "\\d{2,5}";  // 表示匹配2位数或3,4,5位数

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建匹配器对象
        Matcher matcher = pattern.matcher(content);

        // 循环匹配
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }
    }
}
