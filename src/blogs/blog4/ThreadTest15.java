package blogs.blog4;

/**
 * yield() 与 wait()的比较
 */
public class ThreadTest15 {
    public static void main(String[] args) {
        MyThread15 myThread15 = new MyThread15();

        Thread t1 = new Thread(myThread15);
        Thread t2 = new Thread(myThread15);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}


class MyThread15 implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
                if (i == 5) {
                    try {
                        Thread.sleep(1000 * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}