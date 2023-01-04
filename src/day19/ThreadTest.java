package day19;


/*

程序，进程，线程
程序: 是为了完成特定任务，用某种语言编写的一组指令的集合，即指一段静态的代码，静态对象，
      是加载到内存当中运行的
进程: 是程序的一次执行过程，或是正在运行的一个程序，是一个动态的过程，有它自身的产生，存在和消亡的过程。 --- 生命周期
      > 如：运行中的QQ，运行中的MP3播放器
      > 程序是静态的，进程是动态的
      > 进程作为资源分配的单位，系统在运行时会为每个进程分配不同的内存区域
线程: 进程可进一步细化为线程，是一个程序内部的一条执行的路径。
      > 若一个进程同一时间“并行”执行多个线程，就是支持 “多线程”的
      > 线程作为调度和执行的单位，每个线程拥有独立的 “运行栈” 和 “程序计数器(PC)” 线程切换的开销小。
      > 一个进程中的多个线程共享相同的内存单元/内存地址空间->(栈区和方法区(堆区)它们从同一个堆中分配对象
      > 可以访问相关的变量和对象，这就使得线程间通信更简便，高效，但多个线程操作共享的系统资源可能就会带来安全的
      > 隐患.

单核CPU  和 多核CPU 的理解
  单核: > 单核CPU: 其实是一种假的多线程: 因为在一个时间单元内，也只能执行一个线程的任务，
        > 主要是通过CPU的高频率，比如多个app的运行处理，一个单核CPU 在一个单位时间内只能处理一个app
        > ，通过时间的轮转，CPU 处理1.app 一个单位的时间就不处理了(注意这时的app并没有处理完)而是空置着
        > 处理 2.app一个单位的时间就不处理了(同样没有处理完),再回去处理1.app的...因为CPU时间单元特别短,
        > 因此感觉不出来,感觉上有多个CPU 处理多个线程app,通过这样的时间轮转的方式:实现一个单核多线程的效果。
         例如：
        > 虽然有多车道，但是收费站只有一个工作人员收费，只有收了费才能通过，那么CPU 就好比收费人员，如果
        > 有某个人不想交钱，那么收费人员可以把他 "挂起"(晾着他，等他想通了，准备好了钱，再去收费)，但是
        > 因为CPU时间单元特别短，因此感觉不出来。

 真正的多核: 如果是多核的话，才能更好的发挥多线程的效率(现在的服务器都是多核的)
        > 一个java应用程序java.exe，其实至少有“三”个线程：main()主线程,gc()立即垃圾回收线程，异常处理线程
        > 当然如果发生异常，会影响主线程.

 并行和并发:
   并行: 多个CPU 同时执行多个任务，比如: 多个人同时做不同的事情，一个车道上的车，并行行驶。
   并发: 一个CPU采用时间片同时执行多个任务，多个线程执行同一个事情: 电商的秒杀，抢票,多个人做同一件事.


 使用多线程的优点:
 背景: 以单核CPU为例，只使用单个线程先后完成多个任务，(调用多个方法)，肯定比用多个线程完成用的时间短
       为何仍需多线程呢: 注意这是一个“单核的”处理多个线程，需要时间的轮转，处理，比单核处理一个线程慢
 多线程的程序的优点:
   1.提高应用程序的响应，对图形化界面更有意义，可增强用户体验，(用户加载图片的速度，一个线程加载文本，一个线程加载图片)
   2.提高计算机系统CPU的利用率。CPU 时间轮转处理，不停的工作。
   3.改善程序结构，将既长又复杂的进程又分为多个线程，独立运行，利于理解和修改。(如模块话)
 何时需要处理多线程
   1.程序需要同时执行两个或多个任务(java: main主线程，和gc垃圾回收)
   2.程序需要实现一些需要等待的任务时，如：用户输入，文件读写，网络操作，搜索等(一个线程处理图片，一个线程处理文本)点外卖
   3.需要一些后台的程序时。



   public class Sample {   // 注意该方式不是多线程，只是一个方法的回调而已。// 使用一个箭头就可以描述完
        public void method1(String str) {
                System.out.println(str);   // 3
        }

        public void method2(String str) {
                method1(str);  // 2
        }

        public static void main(String[] args) {
                Sample s = new Sample;
                s.method2("hello!");  // 1
        }


}


 */

/**
 * java语言的JVM允许程序运行多个线程，它通过 java.lang.Thread 类来体现:
 * <p>
 * Thread 类的特征:
 * > 每个线程都是通过某个特定 Thread对象的run()方法来完成操作的，经常把run()方法的主体称为“线程体”
 * > 通过该Thread对象的start()方法来启动这个线程，而非直接调用run()
 * class PrimeThread extends Thread {
 * long minPrime;
 * PrimeThread(long minPrime) {
 * this.minPrime = minPrime;
 * }
 * <p>
 * public void run() {
 * // compute primes larger than minPrime
 * . . .
 * }
 * }
 * <p>
 * --------------------------------------------------------------------------------
 * <p>
 * 然后，以下代码将创建一个线程并启动它运行：
 * <p>
 * PrimeThread p = new PrimeThread(143);
 * p.start();
 */
// 多线程的创建: 方式一: 继承于 Thread类
 /*
   1. 创建一个继承于 Thread 类的子类
   2. 重写 Thread类的 run()
   3. 创建Thread类的子类的对象
   4. 通过此对象调用 start()
   5.举例: 遍历 100 以内的所有的偶数

   start() : 1. 启动当前线程，2.调用当前线程的 run()方法。
   问题:
   1. 通过对象直接调用run()的方式是无法启动线程的，仅仅只是调用了重写的方法而已
   2. 再启动一个线程: 遍历 100 以内的偶数，不可以还让已经调用start()的对象创建线程了。会报错:IllegalThreadStateException(非法线程状态异常)
      > 已经调用start()方法创建线程执行线程的对象，不可以再创建线程 start()了.
      > 说白了就是一个实例 new 对象只能创建 start()一个线程(创建线程,调用run()方法)，不可以创建多个线程(),

  */
public class ThreadTest {

    public static void main(String[] args) {
        // 3. 创建 Thread 类的子类的对象
        MyThread myThread = new MyThread();
        // myThread.run();   // 直接调用重写的run()方法，并不能启动线程，只是调用方法而已:
        myThread.start();  // 1. 创建线程，2.调用当前线程的 run()方法
        myThread.start(); // 不可以再调用已经 start()创建线程的对象再去执行 start()创建线程了.会报错: IllegalThreadStateException(非法线程状态异常)

        for(int i = 0; i < 100 ; i++) {
            if(i % 2 == 0) {   // currentThread()静态:类名直接访问,返回当前正在执行的线程的引用
                System.out.println(Thread.currentThread().getName() +":" + i);
            }
        }

    }

    public static void main1(String[] args) {
        // 3. 创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        // 4.通过此对象调用 start(): 1.启动当前线程，2.调用当前线程的 run()方法
        myThread.start();  // 创建一个线程: 调用 start()其中的的 run()方法

        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {  // currentThread() 返回对当前正在执行的线程对象的引用 和 this 类似: 是一个静态方法,可以通过类名直接调用
                System.out.println(Thread.currentThread().getName() + ":" + i + ":main******");   // main主线程 和 Thread线程交叉执行
            }                                          // 说明存在的是多个线程而不是，一个线程的方法调用
        }

    }
}


class MyThread extends Thread {
    // 1.重写 interface Runnable 接口中的 run()方法 以及 Thread
    // Thread() 重写其中的 run()的方法
    @Override
    public void run() {
        // run 方法中: 执行要线程处理的事务，程序
        // 2. 创建Thread 类的子类的对象
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {  // currentThread()返回当前正在执行的线程的引用,静态: 类名直接调用
                System.out.println(Thread.currentThread().getName() + ":" + i + ":Thread*****");
            }
        }
    }
}
