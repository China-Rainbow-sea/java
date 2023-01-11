package blogs.blog4;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 */
public class ThreadTest13 {
    public static void main(String[] args) {
        // 3.创建定时器对象
        Timer timer = new Timer();
        // 这里我们也可以创建守护线程(当用户线程结束了，守护线程自动结束)的方式创建定时器对象
        Timer timer2 = new Timer(true);

        // 4.指定：定时任务 调用 timer.schedule()对象方法
        // timer.schedule(定时任务,第一次执行时间，间隔多久执行一次(单位：毫秒));

        // 设置时间类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = null;

        try {
            firstTime = sdf.parse("2023-01-11 21:25:10");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        timer.schedule(new LogTimerTask(), firstTime, 1000 * 10);  // 间隔十秒

    }
}


// 编写一个定时任务类
// 假设是一个记录日志的定时任务
// public abstract class TimerTask implements Runnable
// 1.创建一个 extends TimerTest 类的子类
class LogTimerTask extends TimerTask {
    // 2. 重写 Runnable 中的 run()方法
    @Override
    public void run() {
        // 编写你需要执行的任务就行了
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = simpleDateFormat.format(new Date());  // 现在的时间点
        System.out.println(strTime + ": 成功完成了一次数据备份");
    }
}