package day20;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四: 使用线程池:
 * 背景: 经常创建和销毁，使用量特别大的资源，比如并非情况下的线程对性能影响很大。
 * 思路: 提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回线程池中，可以避免频繁创建销毁，实现
 *      > 重复利用。类似生活中的公共交通工具 JDBC中的数据库连接池
 * 好处:
 *     > 提高了响应速度(减少了创建新线程的时间)
 *     > 降低资源销毁(重复利用线程池中线程，不需要每次都创建)
 *     > 便于线程管理
 *         > corePoolSize: 线程池中的大小设置
 *         > maximumPoolSize: 设置线程池中的最下线程数
 *         > keepAliveTime: 线程没有任务时最多保持多长时间后会终止.
 *
 * 面试题：
 *       创建多线程有几种方式：
 *        1.extends Thread
 *        2.implementation Runnable
 *        3.implementation Callable jdk5.0
 *        4.线程池:  ExecutorService executorService = Executors.newFixedThreadPool(10);
 *
 *        解决线程安全问题有几种方式
 *        1.synchronized 同步代码块
 *        2.synchronized 同步方法
 *        3.lock.lock(),lock.unlock() 手动显式锁,必须
 */
public class ThreadPool {
    public static void main1(String[] args) {
        // 1.创建一个可重用固定线程数的线程池:
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() { // 适合执行适用于 Runnable实现接口中的 run()方法
            @Override
            public void run() {

            }
        });

        executorService.submit(new Callable() { // 适合执行适用于 Callable实现接口中的 call()方法的返回值
            @Override                           // 当然 Runnable 接口的实现类也是可以的
            public Object call() throws Exception {
                return null;
            }
        });

        // 2. 执行指定线程的操作，需要提供实现Runnable 接口/Callable接口的实现类的对象中的 run()/call方法
        // 就是所传参数中的 Runnable / Callable 接口的实现类的对象，执行其中的 run()/call()方法
        executorService.execute(new NumberThread());

        // 关闭多线程池
        executorService.shutdown();


    }

    /**
     * 设置线程池的属性值
     * @param args
     */
    public static void main(String[] args) {

        // 1. 创建可重用固定的数量的线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 10个可重用的线程的线程池

        // 2.创建设置线程池的对象
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        /*
        如下 ThreadPoolExecutor 的继承关系
        public class ThreadPoolExecutor extends AbstractExecutorService
        public abstract class AbstractExecutorService implements ExecutorService
        如下 ExecutorService 的继承关系
        public interface ExecutorService extends Executor
         */

        // 设置线程池的核心池的大小
        threadPoolExecutor.setCorePoolSize(15);
        // 设置线程池的最大线程数
        threadPoolExecutor.setMaximumPoolSize(20);
        // 设置线程在终止之前可能保持空闲的时间限制。
        // 如果存在超过当前在池中的线程核心数量，则在等待这段时间而不处理任务之后，多余的线程将被终止。 这将覆盖在构造函数中设置的任何值。
        threadPoolExecutor.setKeepAliveTime(1000,null);

    }
}
/*
static ExecutorService newSingleThreadExecutor​(ThreadFactory threadFactory)
创建一个使用单个工作线程运行无界队列的执行程序，并在需要时使用提供的ThreadFactory创建一个新线程。
static ExecutorService  Executors newCachedThreadPool(): 创建一个可根据需要创建新线程的线程池
static ExecutorService Executors newFixedThreadPool(n): 创建一个可重用固定线程数的线程池
static ExecutorService Executors newSingleThreadExecutor(): 创建一个只有一个线程的线程池
static ExecutorService Executors newScheduledThreadPool(n): 创建一个线程池，它可安排在给定延迟后运行
                                                            命令或者定期地执行。
 */


class NumberThread implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }
    }
}