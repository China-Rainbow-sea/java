package blogs.blog4;

/**
 * 死锁现象
 */
public class ThreadTest9 {
    public static void main(String[] args) {
        Object o1 = new Object();   // 锁一
        Object o2 = new Object();   // 锁二

        Thread t1 = new MyLock1(o1,o2);  // 线程一
        Thread t2 = new MyLock2(o1,o2);  // 线程二

        // 设置线程名
        t1.setName("线程一:");
        t2.setName("线程二:");

        // 创建新线程,启动run()
        t1.start();
        t2.start();

    }
}


class MyLock1 extends Thread {
    private Object o1 = null;
    private Object o2 = null;

    public MyLock1() {
        super();
    }

    public MyLock1(Object o1, Object o2) {
        super();   // 调用父类的构造器
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        // 锁一
        synchronized (o1) {
            System.out.println(Thread.currentThread().getName() + "begin");

            try {
                Thread.sleep(1000);  // 当前线程睡眠 1s,模拟网络延迟了 1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 锁二
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "end");
            }
        }

    }
}

class MyLock2 extends Thread {
    private Object o1 = null;
    private Object o2 = null;

    public MyLock2() {
        super();
    }

    public MyLock2(Object o1, Object o2) {
        super();   // 调用父类的构造器
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        // 锁一
        synchronized (o2) {
            System.out.println(Thread.currentThread().getName() + "begin");

            try {
                Thread.sleep(1000);  // 当前线程睡眠 1s,模拟网络延迟了 1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 锁二
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "end");
            }
        }

    }

}