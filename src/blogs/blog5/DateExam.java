package blogs.blog5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateExam {
    public static void main(String[] args) {
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
        if (orderDateTime >= startDateTime && orderDateTime <= endDateTime) {
            System.out.println("参加了秒杀活动成功");
        } else {
            System.out.println("参加秒杀活动失败");
        }

    }


    public static void main1(String[] args) {
        Random random = new Random();

        // random.nextLong()生产 long范围内的随机值，Math.abs()绝对值
        Date date1 = new Date(Math.abs(random.nextLong()));
        Date date2 = new Date(Math.abs(random.nextLong()));

        if (date1.getTime() > date2.getTime()) {
            System.out.println("date2时间在前");
        } else if (date1.getTime() < date2.getTime()) {
            System.out.println("date1时间在前");
        } else {
            System.out.println("date1 == date2 的时间");
        }
    }
}
