package blogs.blog5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JDK8Date {
    public static void main(String[] args) {
        // 不可变性: 不是从原本的对象上修改的，而是返回一个新键修改的对象
        LocalDate localDate = LocalDate.now();  // 静态方法获取到当前系统日期(年月日) localDate对象
        System.out.println(localDate);
        LocalDate localDate2 = localDate.plusYears(1);   // 增加 1 年份,，不可变，返回一个新的LocalDate对象
        System.out.println(localDate2);
        LocalDate localDate3 = localDate.minusYears(1);   // 减去 1 年份,，不可变，返回一个新的LocalDate对象
        System.out.println(localDate3);

        LocalTime localTime = LocalTime.now();  // 静态方法获取到当前系统时间(时分秒) localTime对象
        System.out.println(localTime);
        LocalTime localTime2 = localTime.plusHours(20);   // 增加 20 小时，不可变，返回一个新的LocalTime对象
        System.out.println(localTime2);
        LocalTime localTime3 = localTime.minusHours(20);   // 减少 20 小时，不可变，返回一个新的LocalTime对象
        System.out.println(localTime3);


        LocalDateTime localDateTime = LocalDateTime.now();  // 静态方法获取当前系统日期时间 LocalDateTime 对象
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = localDateTime.plusMonths(6);  // 增加 6 月份，不可变，返回一个新的LocalDateTime对象
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.minusMonths(6);  // 减少 6 月份，不可变，返回一个新的LocalDateTime对象
        System.out.println(localDateTime3);

    }



    public static void main4(String[] args) {
        LocalDate localDate = LocalDate.now();  // 静态方法获取到当前系统日期(年月日) localDate对象
        System.out.println(localDate);
        LocalDate localDate2 = localDate.withYear(2020);   // 修改年份,，不可变，返回一个新的LocalDate对象
        System.out.println(localDate2);

        LocalTime localTime = LocalTime.now();  // 静态方法获取到当前系统时间(时分秒) localTime对象
        System.out.println(localTime);
        LocalTime localTime2 = localTime.withHour(20);   // 修改小时，不可变，返回一个新的LocalTime对象
        System.out.println(localTime2);

        LocalDateTime localDateTime = LocalDateTime.now();  // 静态方法获取当前系统日期时间 LocalDateTime 对象
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = localDateTime.withMonth(6);  // 修改月份，不可变，返回一个新的LocalDateTime对象
        System.out.println(localDateTime2);


    }

    public static void main3(String[] args) {
        LocalDate localDate = LocalDate.now();  // 静态方法获取到当前系统日期(年月日) localDate对象
        System.out.println(localDate.getDayOfYear());  // 获取年份

        LocalTime localTime = LocalTime.now();  // 静态方法获取到当前系统时间(时分秒) localTime对象
        System.out.println(localTime.getHour());   // 获取小时

        LocalDateTime localDateTime = LocalDateTime.now();  // 静态方法获取当前系统日期时间 LocalDateTime 对象
        System.out.println(localDateTime.getDayOfWeek());         // 获取星期
    }

    public static void main2(String[] args) {
        LocalTime localTime = LocalTime.of(15,20,36);
        LocalDate localDate = LocalDate.of(2023,1,20);
        LocalDateTime localDateTime = LocalDateTime.of(2023,1,20,15,20,36);

        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);
    }


    public static void main1(String[] args) {
        LocalDate localDate = LocalDate.now();  // 静态方法获取到当前系统日期(年月日) localDate对象
        System.out.println(localDate.getDayOfYear());  // 获取年份
        LocalTime localTime = LocalTime.now();  // 静态方法获取到当前系统时间(时分秒) localTime对象
        System.out.println(localTime.getHour());   // 获取小时
        LocalDateTime localDateTime = LocalDateTime.now();  // 静态方法获取当前系统日期时间 LocalDateTime 对象
        System.out.println(localDateTime.getDayOfWeek());         // 获取星期

    }
}
