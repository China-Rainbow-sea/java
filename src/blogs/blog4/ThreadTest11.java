package blogs.blog4;

/**
 * 线程的优先级的获取/设置
 */
public class ThreadTest11 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread11());  // 线程一
        Thread t2 = new Thread(new MyThread11());  // 线程二
        Thread t3 = new Thread(new MyThread11());  // 线程二
        Thread t4 = new Thread(new MyThread11());  // 线程二

        // 设置线程名
        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");
        t4.setName("线程三");

        // 设置线程的优先级
        t1.setPriority(Thread.MIN_PRIORITY);  // 最小 1
        t2.setPriority(Thread.NORM_PRIORITY); // 默认 5
        t3.setPriority(Thread.MAX_PRIORITY);  // 最大 10
        t4.setPriority(20);   // 设置为 6

        // 创建新线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}


class MyThread11 implements Runnable {
    @Override
    public void run() {        // Thread.currentThread().getPriority() 获取当前线程的优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
