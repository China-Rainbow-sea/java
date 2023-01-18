package day21;

import org.junit.Test;

/**
 * 一些有关String字符串的练习题目
 */
public class StringExam {

    /**
     * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
     * 转为”gfedcba”
     * // 方式一: 转换为 char[] 字符数组，后遍历反转
     */
    @Test
    public void test1() {
        String str = "abcdefg";

        // 1. 将字符串转换为字符数组
        char[] arrs = str.toCharArray();
        int start = 0;
        int end = arrs.length - 1;

        // 2. 循环反转
        while (start < end) {
            char temp = arrs[end];
            arrs[end] = arrs[start];
            arrs[start] = temp;
            end--;
            start++;
        }

        // 3.将反转好的字符数组，转换为字符串 new
        String str2 = new String(arrs);
        System.out.println(str);
        System.out.println(str2);

    }

    // 方式二:使用String 从后往前拼接
    @Test
    public void test2() {
        String str = "abcedefg";

        String reverseStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr = reverseStr + str.charAt(i);
        }

        System.out.println(str);
        System.out.println(reverseStr);
    }

    // 方式三: 使用StringBuffer /StringBuilder 替换String
    @Test
    public void test3() {
        String str = "abcefg";
        // 1. 创建 StringBuilder 实例对象
        StringBuilder stringBuilder = new StringBuilder(str.length()); // 实际大小是 str.length + 16

        // 2. 循环append() 拼接
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }

        System.out.println(str);
        System.out.println(stringBuilder);
    }

    /**
     * 获取subStr 在 mainStr 中出现的次数
     * 方式一: 使用 indexOf()
     */
    @Test
    public void test4() {
        String mainStr = "abcabcabchelloabcworldabc";
        String subStr = "abc";
        int index = 0;
        int count = 0;

        // 只有当: 主串 >= 子串，才有
        if (mainStr.length() >= subStr.length()) {
            // 1. 使用indexOf()对象方法，是否存在子串，不存在返回 -1,存在返回索引下标位置
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;

                // 2. 找到一个，跳过该位置，子串的长度，后面继续找
                index = index + subStr.length();
            }

            System.out.println(count);
        }

    }

    // 方式二:使用substring(截断)方法
    @Test
    public void test5() {
        String mainStr = "abcabcabchelloabcworldabc";
        String subStr = "abc";
        int count = 0;
        int index = 0;
        // 只有主串 >= 子串 才有
        if (mainStr.length() >= subStr.length()) {
            // indexOf()返回对应出现子串的下标位置，不存在返回 -1
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                // 找下个一个，通过截断找到的一个长度，向后找: index(找到的子串下标位置) + 子串的长度
                mainStr = mainStr.substring(index + subStr.length());
            }
        }

        System.out.println(count);

    }


    /**
     * 获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     * public boolean contains(CharSequence s)当且仅当此字符串包含指定的 char 值序列时，返回 true。
     * 前提是，两个字符串中只有一个最大相同的子串
     */
    @Test
    public void test6() {
        String str1 = "abcwerthelloyuiodeff";
        String str2 = "cvhellobnm";

        // 1.找到长的为主串，短的为子串
        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;

        int length = minStr.length();

        // 2.将子串的长度，一点一点的减小，与主串比较判断是否存在
        for (int i = 0; i < length; i++) {
            int x = 0;
            int y = 0;
            // case: 1.完整的子串比较判断，2.去开头子串一个字符比较，3.去结尾子串一个字符比较，4.去开头和结尾一个字符比较
            for (x = 0, y = length - i; y <= length; y++, x++) {
                String subStr = minStr.substring(x, y);

                if (maxStr.contains(subStr)) {
                    System.out.println(subStr);  // 找到了最长的子串
                    break;
                }
            }
        }

    }

    // 如果存在多个相同最大长度的子串：
    // 此时可以先将其全部存储到String[] 数组中，后面可以用集合中的ArrayList替换，较为方便
    // 或者分割开存储起来
    @Test
    public void test7() {
        String str1 = "abcwerthelloyuiodeffhellohellohello";
        String str2 = "cvhellobnm";
        // 存储多个相同的子串
        StringBuilder stringBuilder = new StringBuilder();

        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;

        // 从短子串比较
        int length = minStr.length();

        boolean sign = false;
        for(int i = 0; i < length; i++) {
            int x = 0;
            int y = 0;
            for (x = 0,y = length -i; y <= length; x++,y++) {
                // case：1.完整子串，2.去子串开头，3.去子串结尾，4.去子串开头，结尾
                String subString = minStr.substring(x,y);

                if(maxStr.contains(subString)) {
                    stringBuilder.append(subString + ",");
                }
            }

            if(stringBuilder.length() != 0) {
                break;
            }
        }

        System.out.println(stringBuilder);

    }


    /**
     * 面试题
     */
    @Test
    public void test() {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);  // 4, 添加的是 "null" 这个字符串
        System.out.println(stringBuffer.length());  // 4
        System.out.println(stringBuffer); // "null:

        StringBuffer stringBuffer2 = new StringBuffer(str);   // 抛出 null 异常 java.lang.NullPointerException
        System.out.println(stringBuffer2);
    }
}
