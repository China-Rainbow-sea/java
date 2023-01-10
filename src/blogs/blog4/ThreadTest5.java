package blogs.blog4;


/**
 * Thread 类中常用的一些方法的介绍和使用
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread5());

        // 直接调用 run()方法不会创建新的线程，仅仅只是方法之间的回调而已
        thread.start();
        thread.setName("分支线程");   // 设置线程名

        Thread.currentThread().setName("主线程");   // 设置主线程名，先通过Thread.currentThread()方法获取当前线程的引用

        // main 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            // 判断当前线程是否存活。
            System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().isAlive());  //
            if (i == 5) {
                try {
                    thread.join();  // 当前线程停止，让 thread 分支线程执行完，再处理 Main 主线程中的程序
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + "-->" + thread.isAlive());

            }

        }
    }
}


class MyThread5 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
