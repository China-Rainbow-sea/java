package day21;


import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * jdk8 中日期时间API的使用 LocalDate, LocalTime, LocalDateTime 的使用以及常用的方法
 * 好处:
 * 1.可变性:像日期和时间这样的类应该是不可变的。
 * 2.偏移性: Date中的年份是从1900开始的,而月份都是从0 开始的，
 * 3.格式化: 格式化至对Date有用,Calendar则不行
 * 此外，它们不是线程安全的，不能处理闰秒等。问题
 *
 */
public class JDK8DateTimeTest {

    @Test
    public void test() {
        // jdk8中存在的偏移量的问题(时区差)
        Date date = new Date(2020-1900,9-1,8);
        System.out.println(date);
    }

    /**
     * LocalDate, LocalTime, LocalDateTime 的使用
     * LocalDate(年月日) 没有构造器
     *  通过: public static LocalDate now() 静态方法获取从默认时区的系统时钟获取当前日期。
     *
     *  localTime(时间：时分秒) 也没有构造器
     *   通过:
     *   public static LocalTime now()从默认时区的系统时钟获取当前时间。 获取
     *
     *   LocalDateTime(日期时间: 年月日时分秒)
     *   public static LocalDateTime now()从默认时区的系统时钟获取当前的日期时间。
     *
     *     LocalDate localDate = LocalDate.now(); // 静态方法，获取当前日期时间的 LocalDate对象
     *     LocalTime localTime = LocalTime.now(); // 静态方法，获取当前时间的 LocalTime对象
     *     LocalDateTime localDateTime = LocalDateTime.now();   // 静态方法，获取当前时间的LocalDateTime对象
     */
    @Test
    public void test2() {
        LocalDate localDate = LocalDate.now();  // 静态方法获取到当前日期 localDate对象
        System.out.println(localDate);

        System.out.println("****************************");

        LocalTime localTime = LocalTime.now();  // 静态方法获取到当前时间的 localTime对象
        System.out.println(localTime);

        System.out.println("****************************");

        LocalDateTime localDateTime = LocalDateTime.now();  // 获取当前日期时间
        System.out.println(localDateTime);
    }

    /**
     * public static LocalDateTime of(int year,
     *                                int month,
     *                                int dayOfMonth,
     *                                int hour,
     *                                int minute)
     *    从年，月，日，小时和分钟获得LocalDateTime的实例，将秒和纳秒设置为零。
     *    注意: 没有偏移量
     *    LocalDate.of() 设置日期：年月日
     *    LocalTime.of() 设置时间: 时分秒
     *    LocalDateTime.of()  设置日期时间: 年月日时分秒
     */
    @Test
    public void test3() {
        LocalDate localDate = LocalDate.of(2020,6,6);   // 设置年月日的LocalDate的对象
        LocalTime localTime = LocalTime.of(6, 6, 6);  // 设置时分秒的LocalTime对象
        LocalDateTime localDateTime = LocalDateTime.of(2020,6,6,6,6,6); // 设置年月日时分秒的LocalDateTime对象

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }


    /**
     * LocalDate.getxxx()
     * LocalTime.getxxx()
     * LocalDateTime.getxxx() 静态方法，获取对应的 年月日时分秒
     */
    @Test
    public void test4() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();  // 当前系统时间

        System.out.println(localDate.getMonth());
        System.out.println(localTime.getHour());
        System.out.println(localDateTime.getMonth());
    }

    /**
     * withDayOfMonth()/withDayOfYear()/withMonth()/withYear()
     * 将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象
     * public LocalDateTime with(TemporalField field,
     *                           long newValue)
     *  返回此日期时间的副本，并将指定的字段设置为新值。
     */
    @Test
    public void test5() {
        // 体现不可变性,不是在原本的地址上修改的而是，返回一个新的对象，
        // 与String 是类似
        LocalDateTime localDateTime = LocalDateTime.now();  // 获取当前系统日期时间的LocalDateTime对象
        LocalDateTime localDateTime2 = localDateTime.withHour(23); // 获取设置日期时间的LocalDateTime对象
        System.out.println(localDateTime);
        System.out.println(localDateTime2);


    }

    /**
     * plusDays(), plusWeeks()，plusMonths(), plusYears(),plusHours() 向当前对象添加几天、几周、几个月、几年、几小时
     * minusMonths() / minusWeeks()/minusDays()/minusYears()/minusHours() 从当前对象减去几月、几周、几天、几年、几小时
     */
    @Test
    public void test6() {
        // 不可变性: 不是从原本的对象上修改的，而是返回一个新键修改的对象
        LocalDateTime localDateTime = LocalDateTime.now();  // 获取当前时间的LocalDateTime对象
        System.out.println(localDateTime);
        LocalDateTime dateTime = localDateTime.plusDays(2);  // 添加 2天
        System.out.println(dateTime);
        LocalDateTime dateTime2 = localDateTime.minusDays(2);  // 减 2 天
        System.out.println(dateTime2);

    }

}
