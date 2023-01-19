package day21;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 日期时间类
 */
public class DateTest {

    @Test
    public void test() {
        // 创建一个日期对象
        Date d1 = new Date(); // 默认是当前系统时间到 1970y1M1d0h0m0s 的毫秒值(时间戳)
        System.out.println(d1);

        // 创建一个指定时间戳的Date对象
        Date d2 = new Date(0L);
        System.out.println(d2);

        // 修改Date对象中的参数时间戳的值
        d2.setTime(1000L);
        System.out.println(d2);

        // getTime 获取到Date对象的毫秒值
        System.out.println(d1.getTime());
        long time = d2.getTime();
        System.out.println(time);

    }

    /**
     * 需求: 打印时间原点开始一年之后的时间
     */
    @Test
    public void test2() {
        Date d2 = new Date(0L);  // 123 默认是 int 类型的,

        // 2. 获取到Date对象的时间戳(毫秒值)
        long time = d2.getTime();

        // 将这个毫秒值 + 一年的毫秒值
        time += 1000L * 60 * 60 * 24 * 365;   // 不要将 L long类型给忘记了，不然类型就不对了。

        // 4. 通过该增加了一年的时间戳(毫秒值)
        d2.setTime(time);
        System.out.println(d2);
    }


    /**
     * 比较两个Date对象，哪个时间在前，哪个时间在后
     */
    @Test
    public void test3() {
        Random random = new Random(); // 生成随机值对象

        Date date1 = new Date(Math.abs(random.nextLong()));
        Date date2 = new Date(Math.abs(random.nextLong()));  // 生成Long范围的随机值作为时间戳

        // 获取到Date 中的毫秒值(对应时间到 1970年1月1日0时0分0秒的毫秒值)时间戳
        if(date1.getTime() > date2.getTime()) {
            System.out.println("date2时间在前");
        } else if(date1.getTime() < date2.getTime()){
            System.out.println("date1时间在后");
        } else {
            System.out.println("两个时间一样");
        }

    }

    /**
     * 需求:
     * 秒杀活动 2023 年 11月 11日 0:0:0 (毫秒值)
     * 开始时间: 2023年 11 月 11日 0:10:0 (毫秒值)
     * 小贾下单开付款的时间为: 2023年11月11日 0:01:00
     * 小皮下单开付款的时间为: 2023年11月11日 0:11:0
     * 用代码说明这两位同学有没有参加上秒杀活动
     */
    @Test
    public void test4() {
        // 1. 定义字符串表示三个时间段
        String startStr = "2023年11月11日 0:0:0";
        String endStr = "2023年11月11日 0:0:0";
        String orderStr = "2023年11月11日 0:01:0";

        // 2. 将上述三个字符串转换为 Date 类型
        // 注意字符串的格式，与 SimpleDateFormat()所传参数的格式要一致不然报异常
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        Date startDate = null;
        Date endDate = null;
        Date orderDate = null;

        try {
            startDate = simpleDateFormat.parse(startStr);
            endDate = simpleDateFormat.parse(endStr);
            orderDate = simpleDateFormat.parse(orderStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 3.得到三个设置的Date 对象的毫秒值时间戳
        long startDateTime = startDate.getTime();
        long endDateTime = endDate.getTime();
        long orderDateTime = orderDate.getTime();

        // 4. 判断
        if( orderDateTime >= startDateTime && orderDateTime <= endDateTime) {
            System.out.println("参加了秒杀活动成功");
        } else {
            System.out.println("参加秒杀活动失败");
        }

    }
}
