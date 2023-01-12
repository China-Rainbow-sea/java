package blogs.blog4;

/**
 * 使用两个线程打印1-100。线程1, 线程2 交替打印  ： 线程1 打印偶数，线程2打印奇数
 */
public class ThreadTest14 {
    public static void main(String[] args) {
        MyThread14 myThread14 = new MyThread14();

        Thread t1 = new Thread(myThread14);
        Thread t2 = new Thread(myThread14);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();

    }
}

/**
 * 打印偶数
 */
class MyThread14 implements Runnable {
    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();  // 唤醒被 wait()阻塞的线程，打印偶数
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + "--->" + num++);
                    // 奇数打印完了，该线程进入阻塞状态,让另外一个线程进入，打印偶数
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}
