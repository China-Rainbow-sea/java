package blogs.blog4;

/**
 * 模拟火车站卖票，一共有 100 张火车票，让三个人工售票窗口(三个线程)一起售票
 */
public class ThreadTest6 {
    public static void main(String[] args) {
        // 创建窗口对象
        Window window = new Window();
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
class Window implements Runnable {
    private int ticket = 100;
    Object object = null;

    @Override
    public void run() {
        while (true) {
            synchronized (object) {  // 字符串池的存在：所有对象/线程共享
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
            }
        }
    }
}
