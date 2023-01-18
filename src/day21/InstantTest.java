package day21;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * instant 的使用 瞬时:
 * instant: 时间线上的一个瞬时点，这可能被用来记录应用程序中的事件 “时间戳”
 * 1.在处理时间和日期的时候，我们通常会想到年，月，日，时，分，秒，然而，这只是时间
 * 的一个模型，是面向人类的，第二种通用模型是面向机器的，或者是连续的，在此模型中，
 * 时间线中的一个点表示为一个很大的数，这有利于计算机处理，在UNIX中，这个数从1970年开始，以
 * 秒为单位，同样的，在Java中，也是从1970年开始，但以毫秒为单位。
 * 2.java.time包通过值类型instart提供机器视图，不提供处理人类意义上的时间单位，
 * Instart表示时间线上的一点，而不需要任何上下文信息，例如：时区，概念上讲，它只是简单的
 * 表示自1970年1月1日0时0分0秒(UTO)开始的秒数，
 * 因为java.time包是基于纳秒计算的，所以instant的精度可以达到纳秒级
 */
public class InstantTest {

    /**
     * public static Instant now()从系统时钟获取当前瞬间。
     */
    @Test
    public void test() {
        Instant instant = Instant.now(); // 获取到当前系统时间的Instant对象
        System.out.println(instant);

    }

    /**
     * ofEpochMilli(long epochMilli) 静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒
     * 数之后的Instant类的
     * public OffsetDateTime atOffset(ZoneOffset offset)将此瞬间与偏移相结合以创建OffsetDateTime 。
     * 这将返回一个OffsetDateTime在指定的从UTC /格林威治偏移从该时刻形成。 如果瞬间太大而无法适应偏移日期时间，将抛出异常。
     * toEpochMilli() 返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
     * public long toEpochMilli()将此瞬间转换为1970-01-01T00：00：00Z的时期的毫秒数
     */
    @Test
    public void test2() {
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant instant2 = Instant.ofEpochMilli(1000);
        System.out.println(instant2);

        // 添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取当前时间到 1970年1月1日0时0分0秒
        long l = instant.toEpochMilli();
        System.out.println(l);


    }

    /**
     * 通过ofEpochMilli()：通过给定的毫秒数,获取Instant实例 --->Date
     */
    @Test
    public void test3() {
        Instant instant = Instant.ofEpochMilli(1232328989L);
        System.out.println(instant);
    }
}
