package day19;

/**
 * 练习: 创建两个分线程，其中一个线程遍历 100以内的偶数，另外一个线程遍历 100以内的奇数
 */
public class ThreadDemo {
    // 实现方式二: 通过创建匿名 Thread类的匿名子类的方式
    public static void main(String[] args) {
        // 1. 创建继承Thread的类
        new Thread() {
            // 2.重写其中的 run()方法
            @Override
            public void run() {
                // run()方法体中就是线程要处理的事务
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();   // 3. 创建对象调用 start()方法创建线程，启动run()方法(操作系统决定)


        // 1. 创建继承Thread的类
        new Thread() {
            // 2.重写其中的run()方法
            @Override
            public void run() {
                // run()线程要处理的事务
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" +i);
                    }
                }

            }
        }.start(); // 3.创建对象 4.调用start()方法创建对象，启动run()方法(操作系统决定)

    }

    // 实现方式一: 创建两个具体的分线程，处理
    public static void main1(String[] args) {
        // 3.创建继承 Thread的子类的实例对象
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        // 4.通过创建的实例对象，调用start()开始创建线程，调用其中的run()方法，run()的线程的执行是由操作系统决定的
        myThread1.start();
        myThread2.start();  // 一个线程对象，只能创建一个线程调用一次start()，不然报错

    }
}


// 1. 创建类继承 Thread
class MyThread1 extends Thread {
    // 2.重写 run()方法
    @Override
    public void run() {
        // run方法中处理实际要处理的业务:输出偶数
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

// 1. 创建类继承 Thread
class MyThread2 extends Thread {
    // 2.重写 run()方法
    @Override
    public void run() {
        // run()实际要处理的业务:求奇数
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
