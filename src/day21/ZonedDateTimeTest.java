package day21;


import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 带时区的 ZoneDateTime类
 * static ZonedDateTime now() 获取当前时间的ZonedDateTime对象
 * static ZonedDateTime ofxxx(....) 获取指定时间的ZoneDateTime对象
 * static ZonedDateTime withXxx(时间) 修改时间系别的方法
 * static ZonedDateTime minusXxx(时间) 减少时间系别的方法
 * static ZonedDateTime plusXxx(时间) 增加时间系别的方法
 *
 * 细节:
 *   jdk8 新增的时间对象都是不可变的
 *   如果我们修改了，减少了，增加了时间
 *   那么调用者是不会发生该改变的，而是生产一个新的时间。
 */
public class ZonedDateTimeTest {

    @Test
    public void test() {
        // 1. 获取当前系统时间的对象(带时区)
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        // 2. 获取指定时间对象(带时区的)
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(2023, 10, 1,
                11, 12, 12, 0, ZoneId.of("Asia/Shanghai"));

        System.out.println(zonedDateTime2);

        // 通过Instant + 时区的方式指定获取时间对象
        Instant instant = Instant.ofEpochMilli(0L);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime time = ZonedDateTime.ofInstant(instant,zoneId);
        System.out.println(time);


        // 3.withxxx 修改时间系别的方法
        ZonedDateTime time2 = time.withYear(2000);
        System.out.println(time2);


        // 减少时间
        ZonedDateTime time3 = time.minusYears(1);
        System.out.println(time3);

        // 增加时间
        ZonedDateTime time4 = time.plusYears(1);
        System.out.println(time4);
    }
}
