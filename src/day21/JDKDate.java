package day21;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java中的日期的处理
 */
public class JDKDate {

    /*
    获取系统当前时间(精确到毫秒的系统当前时间)
    直接调用无参数构造方法执行
     */
    @Test
    public void test1() {
        Date nowTime = new Date();

        // java.util.Date 类的toString()方法已经被重写了
        // 输出的应该不是一个对象的地址，应该是一个日期字符串
        System.out.println(nowTime);  // Thu Jan 19 10:34:21 CST 2023

        // 日期可以格式化吗？
        // 将日期类型Date,按照指定的格式进行转换， Date -->转换成具有一定格式的日期字符串 --->String
        // SimpleDateFormat 是java.text包下的，专门负责日期格式化的

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String nowTimeStr = simpleDateFormat.format(nowTime);
        System.out.println(nowTime);
        System.out.println(nowTimeStr);

        // 将现有的一个日期字符串String 转换成Date类型的 ？
        String time = "2020-09-08 09:09:38";
        //new SimpleDateFormat("格式不能随便写，要和日期字符串的格式相同，不然报异常");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            // 注意: 字符串的日期格式和SimpleDateFormat()对象指定的日期格式要一致,不
            date = simpleDateFormat2.parse(time);   // 将日期字符串转换为指定格式日期时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);  // Tue Sep 08 09:09:38 CST 2020

    }


    /**
     * 获取自1970年1月1日 00:00:00 000 到当前系统时间的总毫秒数。
     * 1秒 = 1000 毫秒
     */
    @Test
    public void test3() {
        // 获取自1970年1月1日 00:00:00 000 到日期系统时间的总毫秒数
        long nowTimeMillis = System.currentTimeMillis();
        System.out.println(nowTimeMillis);  // 1674097318266


    }

    @Test
    public void test4() {

        // 这个时间是什么时间 ?
        // 1970年1月1日0时0分0秒
        Date time = new Date(0L); // 所传参数，毫秒值

        // 设定日期时间显示的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        // 将计算机所识别的时间戳(毫秒值)转换为 字符串
        String strTime = simpleDateFormat.format(time);
        // 北京东8区时间
        System.out.println(strTime);  // 1970-01-01 08:00:00 000

        // 获取昨天的此时的时间
        Date date = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        // 将日期时间(毫秒值/时间戳)转换为String 字符串
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }


}
