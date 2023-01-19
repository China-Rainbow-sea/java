package blogs.blog5;


import org.junit.Test;

/**
 * 关于String 博客的编写需要
 */
public class StringTest {
    public static void main(String[] args) {
        String str = new String("abc");

        System.out.println(str);
    }




    @Test
    public void test() {
        String str1 = "abc";

        byte[] bytes = {'a', 'b', 'c'};
        String str2 = new String(bytes);
        // 指定 bytes[] 数组中的“起始位置”,和“长度” 转换为字符串
        // String str3 = new String(bytes,定义对应数组的开始位置,以及需要转换为字符串的长度);
        String str3 = new String(bytes, 1, 1);

        char[] chars = {'a', 'b', 'c'};
        String str4 = new String(chars);

        // 同样可以指定char[] 数组中的“起始位置”,和“长度” 转换为字符串
        // String str5 = new String(chars,定义对应数组的开始位置,以及需要转换为字符串的长度);
        String str5 = new String(chars, 0, 3);

        String str6 = new String("abc");
    }




}
