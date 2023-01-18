package day21;


import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar 日历类(抽象类) 的使用
 * jdk 8之前的，其中日历时间是可以被修改的
 * public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
 *
 * Comparable 接口与Comparator 的使用的对比，
 * Comparable 接口的方式一旦实现了，保证Comparable 接口实现类的对比在任何位置都可以比较大小
 * Comparator 接口属于临时性的比较，一般通过匿名实现类解决
 */
public class CalendarTest {
    /**
     * 实例化
     * 方式一: 创建其子类(GregorianCalendar) 的对象
     * public static Calendar getInstance()使用默认时区和语言环境获得一个日历。
     * 返回的 Calendar 基于当前时间，使用了默认时区和默认语言环境。
     */
    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();  // 静态方法
        System.out.println(calendar);
        System.out.println(calendar.getClass());  // class java.util.GregorianCalendar
    }

    /**
     * Calendar常用的方法
     * get()对象方法获取Calendar中日期时间的 年月日时分秒
     * set()对象方法设置Calendar中日期时间的 年月日时分秒.
     */
    @Test
    public void test2() {
        Calendar calendar = Calendar.getInstance();  // 静态方法创建 Calender 对象，默认返回的是当前的日期时间
        int moths = calendar.get(Calendar.DAY_OF_MONTH);   // 获取到当前的月份
        System.out.println(moths);

        System.out.println("********************************************");
        Calendar calendar2 = Calendar.getInstance(); // 静态方法创建Calender 对象，默认返回的是当前的日期时间cl
        int day = calendar2.get(Calendar.DAY_OF_MONTH);   // 获取到Calender对象中的天数
        System.out.println(day);
        calendar2.set(Calendar.DAY_OF_MONTH,22);    // 修改Calender对象中的天数
        System.out.println(calendar2.get(Calendar.DAY_OF_MONTH));

    }



    /**
     * public abstract void add(int field,
     *                          int amount)
     * 根据日历的规则，为给定的日历字段添加或减去指定的时间量。例如，要从当前日历时间减去 5 天，可以通过调用以下方法做到这一点
     */
    @Test
    public void test3() {
        Calendar calendar = Calendar.getInstance();  // 获取到当前时间的Calendar 对象
        int dayMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayMonth);
        calendar.add(Calendar.DAY_OF_MONTH,2);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }

    /**
     * public final Date getTime()
     * 返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量(时区差)）的 Date 对象。
     */
    @Test
    public void test4() {
        Calendar calendar = Calendar.getInstance();  // 获取当前时间的Calendar对象
        Date date = calendar.getTime();
        System.out.println(date);
    }

    /**
     * public final void setTime(Date date)使用给定的 Date 设置此 Calendar 的时间。
     * 注：使用 Date(Long.MAX_VALUE) 或 Date(Long.MIN_VALUE) 调用 setTime() 可能产生来自 get() 的错误字段值。
     * // 注意该日期时间的 1 月是 0,以及 0 是星期天
     */
    @Test
    public void test5() {
        Date date = new Date(); // 默认是当前时间的Date类对象

        Calendar calendar = Calendar.getInstance();  // 获取到当前时间的Calendar对象
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        System.out.println(month);
    }



}
