package day20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器的使用指定定时任务：
 * 定时器：
 *   定时器的作用：
 *    间隔特定的时间，执行特定的程序
 *    每周要进行银行账户的总账操作。
 *    每天要进行数据的备份操作。
 *
 *    在实际的开发中，每隔多久执行一段特定的程序，这种需求是很常见的，
 *    那么在Java中其实可以采用多种方式实现：
 *        可以使用sleep 方法，睡眠，设置睡眠时间，没到这个时间点醒来，执行
 *        任务，这种方式是最中原始的定时器 （比较Low）
 *    在Java的类库种已经写好了一个定时器，java.util.Timer,可以直接拿来用
 *    不过，这种方式在目前的开发中也很少用，因为现在有很多高级框架都是支持定时任务的。
 *
 *
 *    在实际开发中，目前使用较多的是Spring框架中提供的SpringTask框架，
 *    这个框架只要进行简单的配置，就可以完成定时器的任务。
 *
 */
public class TimerTest {
    public static void main(String[] args) {
        // 创建定时器对象
        Timer timer = new Timer();
        // 创建守护线程的方式
        Timer timer2 = new Timer(true);

        // 指定定时任务
        // timer.schedule(定时任务,第一次执行时间，间隔多久执行一次(单位：毫秒));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = null;
        try {
            firstTime = sdf.parse("2023-01-8 16:52:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(new LogTimerTask(),firstTime,1000*10);
        // 也可以设置间隔一年的时间如下
        timer.schedule(new LogTimerTask(), firstTime, 1000 * 60 * 60 * 24 * 365);
        /*
        1000 *60 一分钟
        1000 * 60 * 60 一个小时
        1000 * 60 * 60 *24 一天
        1000 * 60 * 60 * 24 * 365 一年
         */

        // 也可以编写匿名的执行的任务的类
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("匿名实现子类");
            }
        },firstTime,1000*1);
    }


}


// 编写一个定时任务类
// 假设是一个记录日志的定时任务
// public abstract class TimerTask implements Runnable
class LogTimerTask extends TimerTask {
    @Override
    public void run() {
        // 编写你需要执行的任务就行了
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strTime = simpleDateFormat.format(new Date());  // 现在的时间点
        System.out.println(strTime + ": 成功完成了一次数据备份");
    }
}

/*
Timer​() 创建一个新的计时器。
Timer​(boolean isDaemon) 创建一个新的定时器，其相关线程可以指定为 run as a daemon 。
Timer​(String name) 创建一个新的定时器，其相关线程具有指定的名称。
Timer​(String name, boolean isDaemon) 创建一个新的定时器，其相关线程具有指定的名称，可以指定为 run as a daemon 。

public abstract class TimerTask
extends Object
implements Runnable 可以由 Timer 进行一次性或重复执行的任务 。
计时器任务不可重用。 一旦一个任务被安排执行在一个Timer或取消，随后的尝试安排它执行将抛出IllegalStateException 。

 */