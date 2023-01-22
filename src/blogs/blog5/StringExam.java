package blogs.blog5;

import java.util.Scanner;

public class StringExam {
    public static void main(String[] args) {
        String talk = "你玩的真好,SB";

        // 2.定义一个敏感的词库，用于判断是否有脏话，并替换
        String[] arr = {"TMD","CNM","SB","MLGB"};

        // 3. 循环遍历脏话数据库，并进行替换
        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i],"xxx");
        }

        // 替换完后
        System.out.println(talk);
    }


    public static void main10(String[] args) {
        // 1.定义一个字符串的记录的身份证号码
        String id = "321281202001011234";

        // 2. 获取到年月日
        String year = id.substring(6, 10);   // 年
        String month = id.substring(10, 12); // 月
        String day = id.substring(12, 14);   // 日

        System.out.println("人物信息为: ");
        System.out.println(year + "年" + month + "月" + day + "日");
        // 3.  获取性别 (奇数为男性，偶数为女性);
        char gender = id.charAt(16);   // '3' --> 3

        // 将字符 '3' 转换为 数值 3
        // 利用ASCII码表进行转换
        // '0' -->  48
        // '1' --> 49
        // '2' --> 50
        // '3' --> 51
        // '9' + 0 = 48 + 9 = 57;
        // 9 = 57 -48 就成了int 类型的数值的
        int num = gender - 48;
        if (num % 2 == 0) {
            System.out.println("性别为 女");
        } else {
            System.out.println("性别为: 男");
        }


    }

    public static void main9(String[] args) {
        // 1.键盘输入一个金额
        Scanner scanner = new Scanner(System.in);
        int money = 0;

        while (true) {
            System.out.print("请输入一个金额: ");  // 123
            money = scanner.nextInt();
            if (money >= 0 && money <= 99999999) {
                break;
            } else {
                System.out.print("金额无效，重新输入: ");
            }
        }

        // 定义一个变量，用来表示大写，并用于拼接大写
        String moneyStr = "";

        // 2. 获取到 money 输入的金额的最后的数值
        while (money > 0) {
            int index = money % 10;  // 获取money 最后一个数值，个位上的数值
            money = money / 10;  // 继续向前取，十位上的数值

            // 3.把转换之后的大写连接上 moneyStr中
            // moneyStr = moneyStr + capitalNumber;
            // 第一次循环是： 叁
            // 第二次循环是:  叁贰
            // 第三次循环是:  叁贰壹
            // 反一下就可以了，将最后取到的数值放到后面
            moneyStr = getCapitalNumber(index) + moneyStr;
            System.out.println(moneyStr);
        }

        // 4. 不足 7 位数值补 0
        int count = 7 - moneyStr.length(); // 补全7位数值,不足补零
        for (int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }

        System.out.println(moneyStr);

        // 5. 将各个单位插入到对应的位置当中
        // 定义一个数组表示单位:
        String[] arrs = {"佰", "拾", "万", "仟", "佰", "拾", "元"};
        String result = "";

        for (int i = 0; i < moneyStr.length(); i++) {
            char c = moneyStr.charAt(i);  // 将对应的中文大写数值取出来，放入到对应的单位当中去
            result = result + c + arrs[i];
        }

        // 最后打印
        System.out.println(result);

    }

    // 将输入的埃利伯数字转换位中文的大写数字
    // 思路定义一个方法把中文的数字存储起来
    // 阿拉伯的数值 与 中文的大写的数值在下标上相对应上，。
    public static String getCapitalNumber(int number) {
        // 定义中文数字的数组
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

        // 返回对应埃莱伯数值的 转换为对应的 中文大写的数值
        return arr[number];
    }


    public static void main8(String[] args) {
        String str1 = "abcwerthelloyuiodeffhellohellohello";
        String str2 = "cvhellobnm";
        // 存储多个相同的子串
        StringBuilder stringBuilder = new StringBuilder();

        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;

        // 从短子串比较
        int length = minStr.length();

        boolean sign = false;
        for (int i = 0; i < length; i++) {
            int x = 0;
            int y = 0;
            for (x = 0, y = length - i; y <= length; x++, y++) {
                // case：1.完整子串，2.去子串开头，3.去子串结尾，4.去子串开头，结尾
                String subString = minStr.substring(x, y);

                if (maxStr.contains(subString)) {
                    stringBuilder.append(subString + ",");
                }
            }

            // 当存储最长子串的长度不为 0，停止。因为最长相同的子串都存储完了
            if (stringBuilder.length() != 0) {
                break;
            }

        }

        System.out.println(stringBuilder);
    }


    public static void main7(String[] args) {
        String str1 = "abcwerthelloyuiodeff";
        String str2 = "cvhellobnm";

        // 1. 找到主串，子串,长的为主串，短的为子串
        String maxStr = str1.length() > str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;

        int length = minStr.length();   // for遍历次数是子串的长度，因为子串的长度在一点一点的减少
        // 2.将子串的长度，一点一点的减小，与主串比较判断是否存在
        for (int i = 0; i < length; i++) {
            int x = 0;
            int y = 0;
            // case: 1.完整的子串比较判断，2.去开头子串一个字符比较，3.去结尾子串一个字符比较，4.去开头和结尾一个字符比较
            for (x = 0, y = length - i; y <= length; y++, x++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)) {
                    System.out.println(subStr);  // 找到了最长的子串
                    return;
                }
            }
        }
    }

    public static void main6(String[] args) {
        String mainStr = "abcabcabchelloabcworldabc";
        String subStr = "abc";

        int count = 0;
        int index = 0;

        // 1. 当 主串的长度 >= 子串才有，子串的存在
        if (mainStr.length() >= subStr.length()) {
            // 2. indexOf()返回子串在主串的所在索引下标位置
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                // 3. 找下个一个，通过截断找到的一个长度，向后找: index(找到的子串下标位置) + 子串的长度
                mainStr = mainStr.substring(subStr.length(), mainStr.length());
            }
        }

        // 4. 循环结束
        System.out.println(count);
    }


    public static void main5(String[] args) {
        String mainStr = "abcabcabchelloabcworldabc";
        String subStr = "abc";

        int count = 0;
        int index = 0;

        // 1. 首先判断，主串的长度是否 >= 子串，小于的话就是，主串中不存在子串的内容，0个
        if (mainStr.length() >= subStr.length()) {
            // 2. 循环遍历: ，indexOf()找子串所在的下标位置，返回 -1表示不存在
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;

                // 3. 跳过该子串的位置，向后继续找，直到子串不存在了
                index = index + subStr.length();

            }
        }

        // 循环结束，找完了
        System.out.println(count);
    }


    public static void main3(String[] args) {
        String str = "abcdefg";
        System.out.println("反转前: " + str);

        // 1. 创建一个空字符串的 StringBuilder 用于拼接,设置容量为 str.length()的长度的大小。
        // 减少扩容次数，提高效率
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int index = str.length() - 1;
        while (index >= 0) {
            // 2. 从最后面依次取出 str 字符串的字符，拼接上
            stringBuilder.append(str.charAt(index));
            index--;
        }
        System.out.println("反转后: " + stringBuilder);

    }


    public static void main2(String[] args) {
        String str = "abcdefg";

        System.out.println("反转前: " + str);
        // 1.将 String 转换为字符数组
        char[] chars = str.toCharArray();

        // 2. 循环前后反转
        int start = 0;
        int end = chars.length - 1;

        while (start <= end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            end--;
            start++;
        }

        // 3. 转换好的字符数组，作为参数创建 String 对象
        String strCopy = new String(chars);
        System.out.println("反转后: " + strCopy);

    }


    public static void main1(String[] args) {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);  // 4, 添加的是 "null" 这个字符串
        System.out.println(stringBuffer.length());  // 4
        System.out.println(stringBuffer); // "null:

        StringBuffer stringBuffer2 = new StringBuffer(str);   // 抛出 null 异常 java.lang.NullPointerException
        System.out.println(stringBuffer2);
    }
}
