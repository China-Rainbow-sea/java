package blogs.blog4;

/**
 * synchronized 修饰方法
 */
public class ThreadTest7 {
    public static void main(String[] args) {
        Thread t1 = new MyThread7();   // 售票窗口1
        Thread t2 = new MyThread7();   // 售票窗口2
        Thread t3 = new MyThread7();   // 售票窗口3

        // 设置线程名
        t1.setName("售票窗口1: ");
        t2.setName("售票窗口2: ");
        t3.setName("售票窗口3: ");

        // 创建线程
        t1.start();
        t2.start();
        t3.start();
    }
}


/**
 * 售票
 */
class MyThread7 extends Thread {
    // 设置为 static 的成员变量，不然会出现每个售票窗口都有 100 张火车票的情况了
    private static int ticket = 100;   // static 静态的和类一起加载,仅仅只会加载一次,所有对象共享。

    @Override
    public void run() {
        while (true) {
            this.sell();
        }
    }

    private synchronized static void sell() {   // synchronized 修饰方法: 同步方法。
        // 有票,便出售
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "所售票号: " + ticket);

            try {
                Thread.sleep(10); // 当前线程睡眠： 0.001s ，提高出现线程安全问题的概率。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;   // 售票成功，减减
        } else {
            return ;
        }
    }
}
