package day21;

import org.junit.Test;

/**
 * String常用方法
 * % int length()：返回字符串的长度： return value.length
 * % char charAt(int index)： 返回某索引处的字符return value[index]
 * % boolean isEmpty()：判断是否是空字符串：return value.length == 0
 * % String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 * % String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 * % String trim()：返回字符串的副本，忽略前导空白和尾部空白
 * % boolean equals(Object obj)：比较字符串的内容是否相同
 * % boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
 * % String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
 * % int compareTo(String anotherString)：比较两个字符串的大小
 * % String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从
 * % beginIndex开始截取到最后的一个子字符串。
 * % String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字
 * 符串从beginIndex开始截取到endIndex(不包含)的一个子字符串
 * % boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 * % boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 * % boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的
 * 子字符串是否以指定前缀开始
 * % boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
 * % int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 * % int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
 * 现处的索引，从指定的索引开始
 * % int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 * % int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
 * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
 */
public class StringMethod {

    /**
     * CharAt() 返回指定索引处的 char 值。
     * 注意：起始下标位置是从 0 开始的。注意不要越界访问了,不然报: java.lang.StringIndexOutOfBoundsException
     * 以及方式 java.lang.NullPointerException 空引用
     */
    @Test
    public void test1() {
        String s = "helloWorld";
        System.out.println(s.length());
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(9));
        System.out.println(s.charAt(10));  // java.lang.StringIndexOutOfBoundsException

    }

    /**
     * isEmpty()判断字符串是否为空，length()是否为 0
     * 为 0 /空返回 true,否则返回 false
     */
    @Test
    public void test2() {
        String s = "";
        System.out.println(s.isEmpty());
        String s2 = null;
        System.out.println(s2.isEmpty());
    }

    /**
     * public char[] toCharArray() 将此字符串转换为一个新的字符char[]数组
     */
    @Test
    public void test3() {
        String s = "helloWorld";
        char[] chars = s.toCharArray();
        System.out.println(chars);
    }


    /**
     * public String toLowerCase() 要转换为小写的 String。
     * public String toUpperCase() 要转换为大写的 String。
     * 注意：都是仅仅不会改变调用对象的String中的内容，而是返回一个新的被修改后的字符串String
     */
    @Test
    public void test4() {
        String s = "HELLOworld";
        String s1 = s.toLowerCase();   // 返回修改为小写的String 字符串
        System.out.println(s1);
        String s2 = s.toUpperCase();   // 返回修改为大写的String 的字符串
        System.out.println(s2);
        System.out.println(s);
    }


    /**
     * public String trim() 返回字符串的副本，忽略前导空白和尾部空白。
     */
    @Test
    public void test5() {
        String s = "  he  llo  world  ";
        String s2 = s.trim();

        System.out.println("---->" + s + "<----");
        System.out.println("---->" + s2 + "<----");

    }

    /**
     * public boolean equals(Object anObject)
     * 将此字符串与指定的对象比较。当且仅当该参数不为 null，并且是与此对象表示相同字符序列的 String 对象时，结果才为 true。
     * 比较两个字符串的内容是否相等，相等返回 true,不相等返回 false
     * 建议: "hello".equals(s)
     * public boolean equalsIgnoreCase(String anotherString) 将此 String 与另一个 String 比较，不考虑大小写。如果两个字符串的长度相同，并且其中的相应字符都相等（忽略大小写），则认为这两个字符串是相等的
     * 相等返回 true ，不相等返回false
     */
    @Test
    public void test6() {
        String s = "hello";
        String s2 = "world";
        String s3 = "hello";

        System.out.println(s.equals(s2));
        System.out.println(s.equals(s3));
        System.out.println("hello".equals(s)); // 建议使用这种方式，防止null异常


        String s4 = "HELLO";
        System.out.println(s4.equalsIgnoreCase(s)); // 忽略大小写内容上的判断

        System.out.println("WORLD".equalsIgnoreCase(s2));  // 建议使用这种方式，防止null异常


    }


    /**
     *public int compareTo(String anotherString) 按照字符串中的内容中的字符比较大小
     *   所有都相等返回 0，调用对象中的字符串 大于 参数中的字符串对象的内容，返回  >0
     *   否则返回 < 0
     *   public int compareToIgnoreCase(String str) 忽略大小写，按照和 compareTo一样
     */
    @Test
    public void test7() {
        String s = "abc";
        String s1 = "efg";
        String s2 = "a";

        System.out.println(s.compareTo(s1));
        System.out.println(s2.compareTo(s2));
        System.out.println(s.compareTo(s2));

        System.out.println("***************************");

        String s5 = "HELLO";
        String s6 = "hello";
        System.out.println(s5.compareTo(s6));   // 不会忽略大小写
        System.out.println(s5.compareToIgnoreCase(s6));   // 会忽略大小写

    }


    /**
     *  public String concat(String str) 将指定字符串连接到此字符串的结尾
     *  如果参数字符串的长度为 0，则返回此 String 对象。否则，创建一个新的 String 对象，
     *  用来表示由此 String 对象表示的字符序列和参数字符串表示的字符序列连接而成的字符序列
     */
    @Test
    public void test8() {
        String s = "abc";
        String s1 = s.concat("def");

        System.out.println(s);
        System.out.println(s1);

    }


    /**
     * public String substring(int beginIndex)返回一个新的字符串，
     * 它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。
     *
     * public String substring(int beginIndex,
     *                         int endIndex) 注意的是：所取的范围是[beginIndex,endIndex) 左闭右开的
     *   返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，
     *  直到索引 endIndex - 1 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。
     */
    @Test
    public void test9() {

        String s = "上海伦敦东京纽约";
        String s2 = s.substring(1);
        System.out.println(s2);
        String s3 = s.substring(4);
        System.out.println(s3);
        String s4 = s.substring(0,2);
        System.out.println(s4);
        String s5 = s.substring(0,3);
        System.out.println(s5);

    }

    /**
     *  public boolean endsWith(String suffix)测试此字符串是否以指定的后缀结束。
     *  是返回 true,不是返回 false.
     *  public boolean startsWith(String prefix)测试此字符串是否以指定的前缀开始。
     *  public boolean startsWith(String prefix,
     *                           int toffset)
     *                           测试此字符串从指定索引开始的子字符串是否以指定前缀开始
     */
    @Test
    public void test10() {
        String s = "helloworld";
        boolean b = s.endsWith("ld");
        boolean b2 = s.endsWith("ab");
        System.out.println(b);
        System.out.println(b2);

        System.out.println("****************startsWith() ************");
        String s2 = "HelloWorld";
        System.out.println(s2.startsWith("Hello"));
        System.out.println(s2.startsWith("s"));

        System.out.println("*************startsWith(prefix,toffset)*************");
        String s3 = "HelloWorld";
        System.out.println(s3.startsWith("ld", 8));
        System.out.println(s3.startsWith("World", 5));
        System.out.println(s3.startsWith("World", 4));

    }


    /**
     * public boolean contains(CharSequence s)当且仅当此字符串包含指定的 char 值序列时，返回 true。
     * // 说白一点就是：判断调用该方法的字符串对象是否含有 所传参数的 s的子串，含有返回 true,不含有返回false
     */
    @Test
    public void test11() {
        String s = "HelloWorld";
        System.out.println(s.contains("Hello"));
        System.out.println(s.contains("hello"));
        System.out.println(s.contains("World"));
    }

    /**
     * public int indexOf(int ch)返回指定字符在此字符串中第一次出现处的索引。如果在此 String 对象表示的字符序列中出现值为 ch 的字符，
     * 则返回第一次出现该字符的索引（以 Unicode 代码单元表示）。对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 的值，返回值是
     * // 存在返回所出现的字符串的下标索引位置，不存在返回 -1
     * public int indexOf(int ch,
     *                    int fromIndex)返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
     * 在此 String 对象表示的字符序列中，如果带有值 ch 的字符的索引不小于 fromIndex，
     * 则返回第一次出现该值的索引。对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 值，返回值是
     * public int lastIndexOf(int ch)返回指定字符在此字符串中最后一次出现处的索引。
     * 对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 的值，返回的索引（Unicode 代码单元）是
     * public int lastIndexOf(int ch,
     *                        int fromIndex)返回指定字符在此字符串中最后一次出现处的索引，
     *                        从指定的索引处开始进行反向搜索。对于 0 到 0xFFFF（包括 0 和 0xFFFF）范围内的 ch 值，
     */
    @Test
    public void test12() {
        String s = "HelloWorld";
        System.out.println(s.indexOf("io"));
        System.out.println(s.indexOf("Hello"));
        System.out.println(s.indexOf("Wo", 4));   // 从指向下标为位置开始找
        System.out.println(s.indexOf("World", 5));
        int i1 = s.lastIndexOf("ld");   // 查找对于字符串最后出现的下标位置。
        System.out.println(i1);

        int i2 = s.lastIndexOf("H", 5);   // 指定位置从右往左找，对于字符串最后出现的位置。
        System.out.println(i2);

        /*
        什么情况下：indexOf(str) 和 lastIndexOf(str)返回值相同 ？？？
        indexOf(str) 从左往右，查找第一次出现的字符串的下标位置。
        lastIndexOf() 从右往左，查找最后一次出现的字符串的下标位置。
        1. 只有一个字符时，两个对象方法查询的结果时一样的。
        2. 该字符不存在 两个对象方法都是返回 -1
         */

    }

    /**
     * public String replace(char oldChar,
     *                       char newChar)返回一个新的字符串，
     *                       它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
     * 如果对应对象方法的中不存在，可以被替换的字符，不会报错，也不会替换
     *
     * public String replace(CharSequence target,
     *                       CharSequence replacement)使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
     *                       该替换从字符串的开头朝末尾执行，例如，用 "b" 替换字符串 "aaa" 中的 "aa" 将生成 "ba" 而不是 "ab"。
     *                      替换字符串，注意参数是 CharSequence 接口，String 类实现了该接口
     *                     该参数也可以使用正则表达式，进行一个筛选
     *
     *                      public final class String
     *     implements java.io.Serializable, Comparable<String>, CharSequence {
     *
     */
    @Test
    public void test13() {
        String s = "四大魔都上海东京纽约伦敦，上海";

        String s2 = s.replace('东', '南');

        System.out.println(s);
        System.out.println(s2);

        String s3 = s.replace('我','你');
        System.out.println(s3);

        String s4 = s.replace("上海", "北京");
        System.out.println(s4);


    }

    /**
     * public boolean matches(String regex)告知此字符串是否匹配给定的正则表达式。
     * public String[] split(String regex)根据给定正则表达式的匹配拆分此字符串。
     *
     */
    @Test
    public void test14() {
        String s = "上海,东京,伦敦,纽约";
        String[] strs = s.split(",");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }


}
