package blogs.blog5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateVisual {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个日期，格式是:（2020-5-26）：");
        String str = scanner.nextLine();
        System.out.println();

        //获取时间转化类，把字符串转为时间对象
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date parse = dateFormat.parse(str);

        //获取日历类，把时间对象转为日期对象
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(parse);

        //获取本月这天的月份
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        //初始化月份值为1
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        System.out.println("日\t一\t二\t三\t四\t五\t六");


        //让月份获取对应的星期数
        for (int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK) - 1; i++) {
            System.out.print("\t");
        }

        //获取这个月的最大数
        int days = calendar.getActualMaximum(Calendar.DATE);

        //循环遍历月份
        for (int i = 1; i <= days; i++) {

            if (day == calendar.get(Calendar.DAY_OF_MONTH)) {

                System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
            } else {

                System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
            }

            //判断当月份为星期六时换行
            if (calendar.get(Calendar.DAY_OF_WEEK) == 7) {
                System.out.println();
            }

            //月份向前加1
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
