package day19;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三:
 * Lock锁
 * 从JDK5.0 开始，java提供了更强大的线程同步机制——通过显式定义同步锁对象实现同步，同步
 * 锁使用Lock对象充当。
 * java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具，锁提供了
 * 对共享资源的独占空间，每次只能有一个线程对 Lock对象加锁，线程开始访问共享数据之前应先
 * 获得Lock对象。
 * ReentrantLock 类实现了Lock,它拥有synchronized 相同的并发性和内存语义，在实现线程安全的控制中，
 * 比较 常用的是ReentrantLock ，可以显式加锁，释放锁，更加的灵活
 *
 * 1.面试题: synchronized 与 lock的异同
 *   相同: 二者都可以解决线程安全问题
 *   不同: synchronized 机制在执行完相应的同步代码以后，自动的释放同步监视器(锁)
 *   lock需要手动的启动同步Lock(),同时结束同步也需要手动的实现
 *   Lock是显式锁，手动启动和关闭锁，别忘记关闭锁了一般会写在 finally 当中一定会被执行，关闭锁，不然就一直占用该锁了，其他线程无法进入
 *   Lock 只有代码锁，synchronized 有代码块锁和方法锁
 *   使用Lock锁，JVM将花费较少的时间来调整线程，性能更好，并且具有更好的扩展性(提供更多的子类)
 *
 *   优先使用的顺序:
 *   Lock ——> 同步代码块(已经进入方法体，分配了相应的资源)->同步方法(在方法体之外)
 */
public class LookTest {
    public static void main(String[] args) {
        Window6 window6 = new Window6();

        Thread t1 = new Thread(window6);
        Thread t2 = new Thread(window6);
        Thread t3 = new Thread(window6);

        t1.setName("窗口一:");
        t2.setName("窗口二:");
        t3.setName("窗口三:");

        t1.start();
        t2.start();
        t3.start();

    }

}


class Window6 implements Runnable {
    private int ticket = 100;

    // 1.创建ReentrantLock 实例对象调用其中的 lock()启动锁，unlock() 手动解锁
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // 2.调用lock()显式启动锁
        try {
            while (true) {
                lock.lock();
                if (this.ticket > 0) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号:" + this.ticket);
                    --this.ticket;
                } else {
                    break;
                }
            }
        } finally {
            // 调用解锁方法 unlock()
            lock.unlock();  // 注意使用上 finally 一定会解锁；
        }
    }
}