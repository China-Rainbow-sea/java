package blogs.blog4;


/**
 * 创建多线程方式二: implements Runnable
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        // 创建匿名实现类 Runnable
        Thread t1 = new Thread(new Runnable() {
            @Override
            // 打印 100 以内的偶数
            public void run() {
                for(int i = 1; i <= 100 ; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                    // Thread.currentThread().getName() 返回当前线程的名称
                }
            }
        });


        // 创建匿名实现类 Runnable
        Thread t2 = new Thread(new Runnable() {
            @Override
            // 打印 100 以内的奇数
            public void run() {
                for(int i = 1; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                    // Thread.currentThread().getName() 返回当前线程的名称
                }
            }
        });


        // 调用Thread.start()方法创建新线程，启动重写Runnable 抽象方法的 run()方法
        t1.start();
        t2.start();

    }

    public static void main1(String[] args) {
        // 3. 创建 实现 Runnable 接口的实现类的实例对象
        MyRunnable myRunnable = new MyRunnable();
        // 4. 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
        Thread thread = new Thread(myRunnable);
        // 或者 3,4步结合使用
        Thread thread2 = new Thread(new MyRunnable());

        // 5. 调用Thread类的start方法：开启线程，调用Runnable子类接口的run方法
        thread.start();

        // main主线程
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            // Thread.currentThread().getName() 返回当前线程名
        }
    }
}


// 1. 创建 Runnable 的实现类
class MyRunnable implements Runnable {
    // 2. 重写 Runnable 中的 run()抽象方法
    @Override
    public void run() {
        // 实现线程要处理的业务
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            // Thread.currentThread().getName() 返回当前线程名
        }
    }
}