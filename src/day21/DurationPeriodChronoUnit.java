package day21;


import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 对于 Duration,Period,ChronoUnit 日期时间的工具类的使用
 * Duration 用于计算两个 "时间" 间隔(秒，纳秒)
 *
 * Period 用于计算两个 "日期" 间隔(年，月，日)
 * ChronoUnit 用于计算两个 "日期" 间隔
 */
public class DurationPeriodChronoUnit {

    @Test
    public void test() {
        // 当前系统的年月日中 的LocalDate 对象
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // 生日的年月日
        LocalDate birthDate = LocalDate.of(2000,1,1);
        System.out.println(birthDate);

        // Period 用于计算两个 "日期" 间隔的工具类
        Period period = Period.between(birthDate,today);  // 第二个参数 - 第一个参数
        System.out.println("相差的时间间隔对象: " + period);
        System.out.println(period.getYears());  // 相差的年
        System.out.println(period.getMonths());  // 相差的月
        System.out.println(period.getDays());  // 相差的天数

        System.out.println(period.toTotalMonths());  // 相差的总月数


    }


    /**
     * Duration 用于计算两个 "时间" 间隔(秒，纳秒)
     */
    @Test
    public void test2() {
        // 创建当前系统时间的 LocalDateTime 对象
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 创建指定时间的 LocalDateTime 对象
        LocalDateTime birthDate = LocalDateTime.of(2000,1,1,0,00,00);
        System.out.println(birthDate);

        // 创建Duration 计算两个“时间” 间隔的工具对象。
        Duration duration = Duration.between(birthDate,today); // 第二个参数 - 第一个参数
        System.out.println("相差的时间间隔对象: " + duration);

        System.out.println(duration.toDays());  // 两个时间差的天数
        System.out.println(duration.toHours()); // 两个时间差的小时数
        System.out.println(duration.toMinutes()); // 两个时间差的分钟数
        System.out.println(duration.toMillis());  // 两个时间差的毫秒数
        System.out.println(duration.toNanos());  // 两个时间差的纳秒数
    }


    /**
     * ChronoUnit 用于计算两个 "日期" 间隔
     */
    @Test
    public void test3() {
        // 获取当前系统日期时间的 LocalDateTime 对象
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        // 创建自定义日期时间的 LocalDateTime对象
        LocalDateTime birthDate = LocalDateTime.of(2000,1,1,0,0,0);
        System.out.println(birthDate);

        System.out.println("相差的年数: " + ChronoUnit.YEARS.between(birthDate, today));
        System.out.println("相差的月数: " + ChronoUnit.MONTHS.between(birthDate, today));
        System.out.println("相差的周数: " + ChronoUnit.WEEKS.between(birthDate, today));
        System.out.println("相差的天数: " + ChronoUnit.DAYS.between(birthDate, today));
        System.out.println("相差的时数: " + ChronoUnit.HOURS.between(birthDate, today));
        System.out.println("相差的分钟数: " + ChronoUnit.MINUTES.between(birthDate, today));
        System.out.println("相差的秒数: " + ChronoUnit.SECONDS.between(birthDate, today));
        System.out.println("相差的毫秒数: " + ChronoUnit.MILLIS.between(birthDate, today));
        System.out.println("相差的纳秒数: " + ChronoUnit.NANOS.between(birthDate, today));
        System.out.println("相差的微秒数: " + ChronoUnit.MICROS.between(birthDate, today));
        System.out.println("相差的半天数: " + ChronoUnit.NANOS.between(birthDate, today));
        System.out.println("相差的十年数: " + ChronoUnit.DECADES.between(birthDate, today));
        System.out.println("相差的世纪(百年)数: " + ChronoUnit.CENTURIES.between(birthDate, today));
        System.out.println("相差的千年数: " + ChronoUnit.MILLENNIA.between(birthDate, today));
        System.out.println("相差的纪元数: " + ChronoUnit.ERAS.between(birthDate, today));

    }
}
