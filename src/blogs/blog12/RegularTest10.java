package blogs.blog12;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 反向引用：
 */
public class RegularTest10 {

    /**
     * 请在字符串中检索商品编号，形式如: 12321-333999111
     * 要求满足前面是一个五位数，然后一个1号，然后是一个九位数，连续的每三位要相同。
     */
    public static void main(String[] args) {
        String content = " 12321-333999111";

        String regStr = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建比较器对象
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }


    public static void main2(String[] args) {
        String content = "hello jack14 tom11 jack222222 yyy  5225, 1551 xxx";

        // 反向引用在正则表达式内部中使用的 \\ 反斜杠的格式。
        // 要匹配个位与千位相同，十位与百位相同的数： 5225, 1551 (\\d)(\\d)\\2\\1
        String regStr = "(\\d)(\\d)\\2\\1"; // \\1反引用：表示重复使用第一个分组号中的内容
        // \\2 反引用：表示重复使用第2个分组号中的内容

        // 创建正则对象
        Pattern pattern = Pattern.compile(regStr);

        // 创建比较器对象
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }
}


// 匹配五个连续的相同数字: (\\d)\\1{4}  \\1 表示第一个反引用该位置上的值是(重复第一个位置上的值))
//String regStr = "(\\d)\\1{4}";

// 要匹配个位与千位相同，十位与百位相同的数： 5225, 1551 (\\d)(\\d)\\2\\1
// \\2 表示位于第二个反引用(重复)：该位置的数值是重复第二个位置上的值
// \\1 表示位于第一个反引用(重复)：该位置的数值是重复第一个位置上的值
