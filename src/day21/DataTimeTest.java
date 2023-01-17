package day21;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8 之前日期和时间的API 测试
 *  java.util.Date 类
 *     |---java.sql.Date 类
 */
public class DataTimeTest {


    /**
     * currentTimeMillis()
     * public static long currentTimeMillis()返回以毫秒为单位的当前时间。
     * 注意，当返回值的时间单位是毫秒时，值的粒度取决于底层操作系统，并且粒度可能更大。
     * 例如，许多操作系统以几十毫秒为单位测量时间。
     * */
    @Test
    public void test1() {
        // 返回的是当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差() 又称为 “时间戳”
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    /**
     * Date 两个构造器的使用
     *     1.Date() 创建一个对应当前时间的Date对象
     *     2.Date(时间戳) 创建指定毫秒值的Date对象
     * 两个方法的使用:
     *   1.toString() 显示当前的 年，月，日，时，分，秒
     *   2.getTime() 显示当前Date对象对应的时间戳
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
     *  注意在: java.sql.Date()中没有空参构造器
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
        utilDate = (java.util.Date)sqlDate;
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

}
