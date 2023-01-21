package blogs.blog5;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneldAndZonedDateTimeTest {
    public static void main(String[] args) {
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
        ZonedDateTime time = ZonedDateTime.ofInstant(instant, zoneId);
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


    public static void main1(String[] args) {
        // 1.获取到所有的时区名称
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);  //  America/Cuiaba
        System.out.println(zoneIds.size());   // 共有 599 个时区


        // 2. 获取到当前系统的默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId); // Asia/Shanghai 注意了没有北京的只有上海的
    }
}
