package blogs.blog5;

import java.time.Instant;

public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.ofEpochMilli(1000);
        System.out.println(instant);

        // 获取当前时间到 1970年1月1日0时0分0秒
        Instant instant2 = Instant.now();
        long toEpochMilli = instant2.toEpochMilli();
        System.out.println(toEpochMilli);  // 获取到对应 Instant 对象中的时间戳,毫秒值


    }

    public static void main2(String[] args) {
        // 通过 Instant.now() 创建 Instant 对象
        Instant instant = Instant.now();  // 默认是当前系统的日期时间
        System.out.println(instant);

    }
}
