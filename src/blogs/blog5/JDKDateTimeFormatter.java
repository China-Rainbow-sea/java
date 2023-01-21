package blogs.blog5;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class JDKDateTimeFormatter {
    public static void main3(String[] args) {
        // 重点: 方式三: 自定义的格式，如: ofPattern("yyy-MM-dd hh:mm:ss")
        // 将日期 ---> 字符串
        // 创建自定义格式的 DateTimeFormatter 对象的实例
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String s = formatter.format(LocalDateTime.now()); // LocalDateTime.now()默认是当前系统时间的LocalDateTime对象
        System.out.println(s);


        // 将字符串 ————> 日期
        TemporalAccessor parse = formatter.parse("2019-09-07 02:09:09");  // 注意格式需要对应起来,
        System.out.println(parse);
    }


    public static void main2(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        // 格式化： 将日期 --> 字符串类型
        LocalDateTime localDateTime = LocalDateTime.now();  // 当前系统的时间
        String str = dateTimeFormatter.format(localDateTime);  // 将日期 --> 字符串类型
        System.out.println(str);

        // 解析: 将字符串  --> 日期时间类型
        String str2 = "2019-02-18T15:42:18.797";   // 注意格式：日期时间的格式 要 和字符串的格式 一致，不然报异常
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse(str2);
        System.out.println(temporalAccessor);
    }
}
