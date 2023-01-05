package day19;

/**
 * 创建多线程方式二: 实现Runnable 接口
 * 1.创建一个实现了 Runnable 接口的类
 * 2.实现类去实现Runnable 中的抽象方法 run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()创建线程，调用run()方法
 * class PrimeRun implements Runnable {
 *          long minPrime;
 *          PrimeRun(long minPrime) {
 *              this.minPrime = minPrime;
 *          }
 *
 *          public void run() {
 *              // compute primes larger than minPrime
 *               . . .
 *          }
 *      }
 *
 * --------------------------------------------------------------------------------
 *
 * 然后，以下代码将创建一个线程并启动它运行：
 *
 *      PrimeRun p = new PrimeRun(143);
 *      new Thread(p).start();
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        // 3.创建实现类的对象
        MyRunnable myRunnable = new MyRunnable();
        // 4. 将此实现类对象，作为参数调用Thread()的构造器
        Thread thread = new Thread(myRunnable);
        // 5.通过创建的 thread 调用 start()方法创建线程，调用run()方法
        thread.setName("线程一");
        thread.start();
        /*
        Thread 中的源码:分析： 实际上thread.start()中的 run()方法是重写了 Runnable接口中的重写方法
        private Runnable target;   // 定义Runnable 接口类类型

        public Thread(Runnable target) {   // 构造器为target 赋值
        init(null, target, "Thread-" + nextThreadNum(), 0);
        }
        // 调用重写Runnable 中的抽象方法: target.run()
        public void run() {
            if (target != null) {
            target.run();
            }
        }
         */

        // 可以利用这个 Runnable 的实现类，创建多个线程对象，如下 不同调用的run()方法依旧是重写Runnable实现类的run()方法
        // 因为实现调用的就是重写 Runnable 实现类的 run()方法
        // 一个线程对象，只能创建一个线程 start(),
        Thread t1 = new Thread(myRunnable);
        t1.setName("线程二");
        t1.start();  // 创建线程
        Thread t3 = new Thread(myRunnable);
        t3.setName("线程三");
        t3.start(); // 创建线程
    }
}


// 1. 实现类实现 Runnable 接口
class MyRunnable implements Runnable {

    // 2.重写Runnable 接口中的方法
    @Override
    public void run() {
        // run线程要处理的事务
        for(int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}