package blogs.blog4;


/**
 * 创建多线程的方式一： extends Thread
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Thread thread = new MyThread();  // 多态性

        // 分支线程的创建,启动run()方法
        thread.start();

        // main主线程，int num =  2/0; 算数异常，线程中止
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            int num = 2 / 0;  // 算数异常中止
        }

    }

    public static void main2(String[] args) {
        Thread t1 = new Thread(){   // 多态性
            // 重写其中的乱方法
            @Override
            public void run() {
                // 打印 100 以内的 偶数
                for(int i = 1; i < 100; i++) {
                    if( i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "--->" + i);
                    }
                }
            }
        };
        // 创建多线程，启动run()方法
        t1.start();

        Thread t2 = new Thread() {
            @Override
            // 打印奇数
            public void run() {
                for(int i = 1; i < 100; i++) {
                    if(i % 2 != 0) {   // Thread.currentThread().getName()返回当前线程名
                        System.out.println(Thread.currentThread().getName() + "-->" + i);
                    }
                }
            }
        };

        t2.start();
    }


    public static void main1(String[] args) {
        // 3. 创建 extends Thread 的子类的实例对象
        MyThread myThread = new MyThread();
        Thread thread = new MyThread();   // 多态性: 动态绑定

        // 4. 调用Thread中的 start()方法，创建新线程，并启动run()方法
        myThread.start();

        // main 主线程执行的任务。
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                try { // 当前线程进入 休眠(阻塞)状态，让 Jconsole 可以查看到当前线程
                    Thread.sleep(1000 * 10);  // 当前main主线程休眠 10s
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }
        }
    }
}


// 1. 创建继承 Thread 的类
class MyThread extends Thread {
    // 2. 重写 Thread 类中的 run()方法:
    // run()方法就是该分支线程要执行代码，处理的业务
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-->" + i);
                // Thread.currentThread()  // 静态方法，方法当前线程的引用
                // Thread.currentThread().getName() // 返回当前线程名
        }
    }

}
