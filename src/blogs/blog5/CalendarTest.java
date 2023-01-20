package blogs.blog5;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        // Calendar.getInstance() 类方法(静态方法)/创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();  // 默认是当前系统的时间。
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.YEAR));  // 获取 Calendar 对象的年份
        calendar.set(Calendar.YEAR, 2000);  // 修改 Calendar 对象的年份
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(Calendar.YEAR, 1);     // 添加 1 年
        System.out.println(calendar.get(Calendar.YEAR));  // 获取Calendar 对象的年份
        calendar.add(Calendar.YEAR, -2);    // 减少 2 年
        System.out.println(calendar.get(Calendar.YEAR));  // 获取Calendar 对象的年份

    }


    public static void main1(String[] args) {
        // 调用 Calendar.getInstance() 类方法(静态方法)/创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();  // 默认是当前系统的时间
        int month = calendar.get(Calendar.MONTH);  // 获取到Calendar 对象中的月份
        int year = calendar.get(Calendar.YEAR);   // 获取到Calendar 对象中的年
        int date = calendar.get(Calendar.DATE);   // 获取到Calendar 对象中的天数

        System.out.println(month);
        System.out.println(year);
        System.out.println(date);

    }
}
