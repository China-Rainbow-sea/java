package day21;
import java.util.Scanner;


public class StringExam2 {

    /**
     * 关于String的项目题
     * 2135
     * 贰壹叁伍
     * 零零零零贰壹叁伍
     * 零佰零拾零万零贰仟壹佰叁拾伍元
     */
    public static void main1(String[] args) {
        // 1.键盘输入一个金额
        Scanner scanner = new Scanner(System.in);
        int money = 0;

        while(true) {
            System.out.print("请输入一个金额: ");  // 123
            money = scanner.nextInt();
            if(money >= 0 && money <= 99999999) {
                break;
            } else {
                System.out.print("金额无效，重新输入: ");
            }
        }

        // 定义一个变量，用来表示大写，并用于拼接大写
        String moneyStr = "";

        // 2. 得到money 中的每个数值，方便转换为对应的中文大写数值
        while(money > 0) {
            // % 从右往左一一取出
            int ge = money % 10;
            // 将埃利伯数字转换为 中文大写数值
            String capitalNumber = getCapitalNumber(ge);

            // 把转换之后的大写连接上 moneyStr中
            // moneyStr = moneyStr + capitalNumber;
            // 第一次循环是： 叁
            // 第二次循环是:  叁贰
            // 第三次循环是:  叁贰壹
            // 反一下就可以了，将最后取到的数值放到后面
            moneyStr = capitalNumber + moneyStr;
            System.out.println(moneyStr);

            money = money / 10; // 去掉一个，已经取过的往前取最后一个

        }

        int count = 7 -moneyStr.length(); // 补全7位数值,不足补零

        // 3. 补零
        for(int i = 0; i < count; i++) {
            moneyStr = "零" + moneyStr;
        }

        // 4. 将各个单位插入到对应的位置当中
        // 定义一个数组表示单位:
        String[] arrs = {"佰","拾","万","仟","佰","拾","元"};
        String result = "";

        for(int i = 0; i < moneyStr.length(); i++) {
            char c = moneyStr.charAt(i);  // 将对应的中文大写数值取出来，放入到对应的单位当中去
            result = result + c + arrs[i];
        }

        // 最后打印
        System.out.println(result);


    }

    // 1. 将输入的埃利伯数字转换位中文的大写数字
    // 思路定义一个方法把中文的数字存储起来
    // 阿拉伯的数值 与 中文的大写的数值在下标上相对应上，。
    public static String getCapitalNumber(int number) {
        // 定义中文数字的数组
        String[] arr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

        // 返回对应埃莱伯数值的 转换为对应的 中文大写的数值
        return arr[number];
    }


    /**
     * 从身份征中读取信息
     * 通过字符串的截断获取
     *
     */
    public static void main2(String[] args) {
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
        if(num % 2 == 0) {
            System.out.println("性别为 女");
        } else {
            System.out.println("性别为: 男");
        }
    }


    /**
     * 脏话替换
     */
    public static void main(String[] args) {
        // 1.定义一句说的脏话
        String talk = "你玩的真好,SB";

        // 2.定义一个敏感的词库，用于判断是否有脏话，并替换
        String[] arr = {"TMD","CNM","SB","MLGB"};

        // 3. 循环判断 所说的话中是否存在其中词库中的敏感词，存在替换了
        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i],"xxx");
        }

        System.out.println(talk);
    }



}
