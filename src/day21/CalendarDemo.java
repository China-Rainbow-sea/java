package day21;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * CalendarDemo的使用
 */
public class CalendarDemo {

    /**
     * 1. 获取日历对象
     * 细节: Calender 时一个抽象类，不能直接new 而是通过一个静态方法获取到子类对象
     * 底层原理:
     *    会根据系统的不同时区来获取不同的日历对象，默认表示当前时间，
     *    把会把时间中的纪元，年，月，日，时，分，秒，星期，等等的都放到一个数组当中
     */
    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();

        // 2.修改一下日历代表的时间
        Date date = new Date(0L);
        calendar.setTime(date);

        System.out.println(calendar);
    }

    /**
     * 细节: 月份: 范围: 0~11 如果获取出来的 0 那么实际上就是 1月
     *  星期: 在老外的眼里: 星期日 是一周中的第一天
     *    1(星期日)，2(星期一),3(星期二)， | 4,5,6,7(星期六)
     *
     *  public int get(int field) 取日期中的某个字段信息
     *  public void set(int field,int value) 修改日历的某个字段信息
     *  public void add(int field,int amount) 为某个字段添加/减少指定的值
     */
    @Test
    public void test2() {
        // Java在Calandar类中，把索引对应的数字都定义成常量了
        Calendar c = Calendar.getInstance();   // 像单例模式
        int year = c.get(Calendar.YEAR); //
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "," + month + "," + date + "," + week);
    }
}
