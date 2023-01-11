package blogs.blog4;

/**
 * 守护线程的设置
 */
public class ThreadTest12 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread12());

        t1.setName("t1 用户线程");

        Thread.currentThread().setName("main 主线程");

        // 创建新线程
        t1.start();

        // main 主用户线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            if (i == 5) {
                int num = 1 / 0;  // 让main 主用户线程异常终止
            }
        }
    }
}


class MyThread12 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);

            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}