package day20;

/**
 * 创建多线程的第二种方式: 编写一个类实现:java.lang.Runnable 接口的
 *
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        // 3. 创建实现 Runnable 实现类的实例对象
        MyThead3 myThead3 = new MyThead3();
        // 4.将可运行的对象封装成一个线程对象,传入到 Thread()的构造器中
        Thread thread = new Thread(myThead3);
        // 5. 调用start()创建新线程
        thread.start();

        // 还可以一体话
        Thread thread2 = new Thread(new MyThead3());

        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }

    }
}


// 1. 创建实现 Runnable 的实现类
// 这并不是一个线程类，是一个可运行的类，它还不是一个线程
class MyThead3 implements Runnable {
    // 2. 重写其中的 run()方法
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
