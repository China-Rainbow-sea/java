package day21;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * JDK8 DateTimeFormatter的使用
 * DateTimeFormatter：格式化或解析日期: 时间
 * 类似于simpleDateFormat
 */
public class JDK8DateTimeFormatter {

    /**
     * 方式一: 如 ISO_LOCAL_DATE;IOS_LoCAL_DATE;ISO_LOCAL
     * 格式化: 日期 ---> 字符串
     */
    @Test
    public void test() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化: 日期 ---> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();   // 日期
        String str = dateTimeFormatter.format(localDateTime); // 使用localDateTime.format()日期 转换字符串
        System.out.println(str);
        System.out.println(localDateTime);

        // 解析: 字符串 ---> 日期
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse("2019-02-18T15:42:18.797");
        System.out.println(temporalAccessor);

        // 重点: 方式三: 自定义的格式，如: ofPattern("yyy-MM-dd hh:mm:ss")
        // 创建自定义格式的 DateTimeFormatter 对象的实例
        // 将日期 ---> 字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String s = formatter.format(LocalDateTime.now()); // LocalDateTime.now()默认是当前系统时间的LocalDateTime对象
        // format(TemporalAdjuster)参数是 TemporalAdjuster 其中LocalDateTime实现了该TemporalAdjuster对象
        /*
        public final class LocalDateTime
        implements Temporal, TemporalAdjuster, ChronoLocalDateTime<LocalDate>, Serializable {
         */
        System.out.println(s);
        // 将字符串 ————> 日期
        TemporalAccessor parse = formatter.parse("2019-09-07 02:09:09");  // 注意格式需要对应起来,
        System.out.println(parse);


    }
}
