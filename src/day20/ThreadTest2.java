package day20;


/**
 * 实现多线程的第一种方式：
 *   编写一个类：直接继承 java.lang.Thread 重写其中的run()方法不是调用 Runnable 接口的run()方法
 *
 *
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        // 这里是 main 方法，这里的代码属于主线程，在主线程中运行
        // 3.新建一个分支线程对象，创建 继承Thread的类的实例对象
        Thread thread = new MyThread();  // 多态

        // 4. 启动线程
        // start()方法的作用是：创建一个线程，在JVM中开辟一个新的栈空间交给这个新创建的线程，
        // 这段代码任务完成之后，瞬间就结束了
        // 这段代码的任务只是为了开启一个新的栈空间，只要新的栈空间开出来了，start()方法就结束了
        // 启动成功的线程会自动调用run()方法，并且run()方法在分支线程的栈底部(压栈)
        // run方法在分支栈的栈底部，main()方法在主栈的栈底部，run()和main()是并列的
        //thread.run();  // 不会启动线程，不会分配新的分支线程，仅仅只是调用了被重写的Thread中的run()方法

         thread.start();  // 创建线程，启动run()方法就结束了


        // 这里的代码还是运行在主线程当中的
        for(int i = 0; i < 100; i++) {
            System.out.println("主线程--->" + i);

            // 线程之间是相互独立的，互不干扰的，各自使用各自独立的栈: main线程结束了,分支线程可能还没有结束
            int num = 3 /0;
        }
    }

}


// 1. 继承 Thread 的类
class MyThread extends Thread {
    // 2. 重写 Thread中的 run()方法
    @Override
    public void run() {
        // 编写程序，这段程序运行在分支线程中(分支线程)
        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--> " + i);
        }
    }

}