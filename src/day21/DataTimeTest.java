package day21;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JDK 8 之前日期和时间的API 测试
 * java.util.Date 类
 * |---java.sql.Date 类
 */
public class DataTimeTest {


    /**
     * currentTimeMillis()
     * public static long currentTimeMillis()返回以毫秒为单位的当前时间。
     * 注意，当返回值的时间单位是毫秒时，值的粒度取决于底层操作系统，并且粒度可能更大。
     * 例如，许多操作系统以几十毫秒为单位测量时间。
     */
    @Test
    public void test1() {
        // 返回的是当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差() 又称为 “时间戳”
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    /**
     * Date 两个构造器的使用
     * 1.Date() 创建一个对应当前时间的Date对象
     * 2.Date(时间戳) 创建指定毫秒值的Date对象
     * 两个方法的使用:
     * 1.toString() 显示当前的 年，月，日，时，分，秒
     * 2.getTime() 显示当前Date对象对应的时间戳
     */
    @Test
    public void test2() {
        // 构造器一：创建当前时间的Date对象
        Date date = new Date();  // 默认是当前的时间
        System.out.println(date);  // Tue Jan 17 21:35:02 CST 2023
        // 也可以通过改对象获取到当前的时间戳(毫秒) 使用getTime()方法
        System.out.println(date.getTime());  // 显示获取当前Date对象对应的时间戳

        // 构造器: 通过指定时间戳(毫秒值)创建是Date 对象
        Date date2 = new Date(155592390L);
        String s = date2.toString();
        System.out.println(s);


    }


    /**
     * 对应数据库中Java.sql.Date() 创建一个对应当前时间的Date变量
     * 注意在: java.sql.Date()中没有空参构造器
     */
    @Test
    public void test() {
        // 通过 new java.util.Date().getTime() 获取到当前时间戳(当前时间到1970y1M1d0h0m0s的毫秒值)
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        System.out.println(date);
    }

    /**
     * 将java.util.Date对象转换为 java.sql.Date对象
     * 以及: java.sql.Date  ——————> java.util.Date 对象 (可以直接复制因为 java.spl.Date extends java.util.Date)
     * public class Date extends java.util.Date {}
     */
    @Test
    public void test3() {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(0L);
        System.out.println(utilDate);
        utilDate = (java.util.Date) sqlDate;
        System.out.println(utilDate);
        System.out.println(sqlDate);

        // """""""" 如下错误演示 ***
        // 将 父类 java.util.Date 强制转换为子类 java.sql.Date 会报类型转换异常
        // 如果可以将父类类型 强制转换为子类类型(不是多态)的话，那子类中该有的成员变量/方法都会没有的，不合理
       /*
        java.util.Date utilDate2 = new java.util.Date();
        java.sql.Date sqlDate2 = new java.sql.Date(0L);
        sqlDate2 = (java.sql.Date)utilDate2;  // 报类型转换异常 java.lang.ClassCastException java.util.Date cannot be cast to java.sql.Date
        */

        // 正确的演示 将java.util.Date对象转换为 java.sql.Date对象 通过共同的时间戳()转换
        java.util.Date uDate = new java.util.Date(999L);
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        System.out.println(uDate);
        System.out.println(sDate);
    }

    /**
     * SimpleDateFormat的使用: SimpleDateFormat对日期Date类的格式化和解析
     * 两个操作:
     * 1.格式化: 日期 ---> 字符串
     * 2.解析: 格式化的逆过程: 字符串 ---> 日期
     * 该方法是 DateFormat 类中的，其中SimpleDateFormat 继承了该类
     * public final String format(Date date)将一个 Date 格式化为日期/时间字符串。
     * <p>
     * public Date parse(String source)
     * throws ParseException
     * 从给定字符串的开始解析文本，以生成一个日期。该方法不使用给定字符串的整个文本。
     */
    // 2.SimpleDateFormat的实例化 在 text 包下
    @Test
    public void test4() {
        // 实例化SimpleDateFormat 对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        // 格式化 : 日期 ---> 字符串
        Date date = new Date();  // 默认是当前时间
        System.out.println(date);
        String format = simpleDateFormat.format(date);
        System.out.println(format);


        // 解析: 字符串  ——————> 日期
        String str = "23-1-18 上午11:22";
        Date date2 = null;
        try {
            date2 = new SimpleDateFormat().parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date2);

        // 通过 SimpleDateFormat()对象，new时设定相关的日期时间格式如下
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date3 = new Date();  // 默认是当前时间
        String s3 = simpleDateFormat2.format(date3);
        System.out.println(s3);

        // 也可以通过指定格式，的字符串，转换为 日期时间
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date4 = null;
        try {
            date4 = simpleDateFormat3.parse("20220-9-23 7:7:0");  // 如果格式不对,会报错
        } catch (ParseException e) {
            // 如果字符串所设置的格式，不符合你创建 SimpleDateFormat()所设置的格式，抛异常 java.text.ParseException
            e.printStackTrace();
        }

        System.out.println(date4);

    }

    /**
     * 字符串: "2020-09-08" 转换为java.sql.Date
     */
    @Test
    public void test5() {
        String birth = "2020-09-08";
        Date udate = null;;
        try {
            //  1.通过SimpleDateFormat()设置对应时间的字符串的格式，获取java.utils.Date 的时间类型
            udate = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 通过获取到 java.util.Date中的时间戳(到19701y1M1d0h0m0s的毫秒时间间隔)
        java.sql.Date sdate = new java.sql.Date(udate.getTime());
        System.out.println(sdate);
    }
    /**
     * 三天打鱼，两天晒网 1990-01-01 是打鱼还是晒网
     * 举例: 2020-09-08 ？总天数
     * 思路:
     *  以5天为一个周期，循环
     *  总天数 % 5 = 1，2，3 该天打鱼
     *  总天数 % 5 = 4 晒网
     *  总天数的计算:
     *  方式一:
     *  //
     *  (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24 )
     *  方式二: 1990-09-08 --> 2019-12-31  + 2020-01-01 ---> 2020-09-08
     *    者三个时间段的时间
     */

}
