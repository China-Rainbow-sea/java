package blogs.blog5;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        String str = "2023-1-20";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);
    }



    public static void main6(String[] args) {
        String str = "2023-1-20 21:00:01";
        String str2 = "2023年1月20日 22时06分00秒";
        Date date = null;
        Date date2 = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("YYYY年MM月dd日 hh时mm分ss秒");

        try {
            date = simpleDateFormat.parse(str);
            date2 = simpleDateFormat2.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);
        System.out.println(date2);


    }


    public static void main5(String[] args) {
        Date date = new Date();  // 默认是当前系统时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String str = simpleDateFormat.format(date);
        System.out.println(str);
        // 或者
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("YYYY年MM月dd日 hh时mm分ss秒");
        String str2 = simpleDateFormat2.format(date);
        System.out.println(str2);
    }

    public static void main4(String[] args) {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(0L);
        utilDate = sqlDate;
        System.out.println(utilDate);

        // 也可以一体化
        java.util.Date date = new java.sql.Date(0L);  // 注意参数是 long类型，整数默认是 int 类型
        System.out.println(date);


    }

    public static void main3(String[] args) {
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
        // new java.util.Date().getTime() 获取到当前系统时间的时间戳:到 1970年1月1日 0 时 0 分 0 秒 0毫秒 的毫秒值。
        System.out.println(date);

    }


    public static void main2(String[] args) {
        Date d2 = new Date(0L);  // 123 默认是 int 类型的,0L 时间戳:表示的是 1970年1月1日 0时0分0秒 0毫秒

        // 2. 获取到Date对象的时间戳(毫秒值)
        long time = d2.getTime();

        // 将这个毫秒值 + 一年的毫秒值
        time += 1000L * 60 * 60 * 24 * 365;   // 不要将 L long类型给忘记了，不然类型就不对了。

        // 4. 通过该增加了一年的时间戳(毫秒值)
        d2.setTime(time);
        System.out.println(d2);
    }


    public static void main1(String[] args) {
        Date date = new Date();  // 默认获取的当前系统的时间
        System.out.println(date);
        System.out.println(date.getTime());  // 获取到当前系统时间到1970年1月1日 0时0分0秒 0毫秒 的毫秒值

        Date date2 = new Date(0L);  // 设置毫秒值(long类型的)时间戳，创建Date对象
        System.out.println(date2);  // 0L 时间戳:表示的是 1970年1月1日 0时0分0秒 0毫秒
        System.out.println(date2.getTime());


    }

}

