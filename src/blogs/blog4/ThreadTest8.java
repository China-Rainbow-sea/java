package blogs.blog4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决多线程同步机制的方式三： Lock
 */
public class ThreadTest8 {
    public static void main(String[] args) {
        // 创建窗口对象
        Window8 window = new Window8();
        Thread t1 = new Thread(window);    // 售票窗口一
        Thread t2 = new Thread(window);    // 售票窗口二
        Thread t3 = new Thread(window);    // 售票窗口三

        t1.setName("售票窗口一:");
        t2.setName("售票窗口二:");
        t3.setName("售票窗口三:");

        t1.start();
        t2.start();
        t3.start();

    }

}

/**
 * 火车窗口
 */
class Window8 implements Runnable {
    private int ticket = 100;
    // 1.创建ReentrantLock 实例对象调用其中的 lock()启动锁，unlock() 手动解锁
    private ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            try {
                reentrantLock.lock(); // 2.调用lock()显式启动锁
                // 有票,便出售
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "所售票号: " + this.ticket);

                    try {
                        Thread.sleep(10); // 当前线程睡眠： 0.001s ，提高出现线程安全问题的概率。
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.ticket--;   // 售票成功，减减
                } else {
                    break;   // 没票了，停止出售。
                }
            } finally {
                reentrantLock.unlock();  // 3.释放锁,注意使用 finally 无论是否出现异常都一定会被执行，一定会释放锁
            }
        }

    }

}
