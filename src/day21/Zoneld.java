package day21;

import org.junit.Test;

import java.time.ZoneId;
import java.util.Set;

/**
 * 时区
 */
public class Zoneld {

    @Test
    public void test() {
        /*
        static Set<String> getAvailableZoneIds(); 获取java中支持的所有时区
        static ZoneId systemDefault()             获取系统默认时区
        static ZonId of(String zoneId)             获取一个指定时区

         */
        // 1.获取到所有的时区名称
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);  //  America/Cuiaba
        System.out.println(zoneIds.size());   // 共有 599 个时区


        // 2. 获取到当前系统的默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId); // Asia/Shanghai 注意了没有北京的只有上海的
    }
}
