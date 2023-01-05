package day19;

/**
 * 例子: 创建三个 c 窗口卖票，总票数为 100 张，三个窗口共同出售票
 * 使用继承的方式创建多个线程:
 * 目前这种方式：存在线程同步的安全问题
 *
 * 比较创建线程的两种方式：
 * 开发中，优先考虑，实现Runnable 接口的方式
 * 原因:  1.实现的方式没有类的单继承的局限性，万一要继承什么呢，也因为单继承性，又无法再继承了
 *        2. 实现的方式更适合来处理多个线程有共享数据的情况，可以使用同一个实现Runnable的实现类的对象，
 *           传入Thread(Runnable  num) 同一个对象，同一个成员变量，传的是类的地址，所以不用static 的方式
 *        3. 实现的方式更符合寓意，现实的意义，
 *        4. 接口可以多继承，没有类的单继承局限性。
 *
 * 联系: public class Thread implements Runnable
 * 相同: 两种方式都需要重写run()，将线程要执行的逻辑声明在 run()中，
 *      目前两种方式，要想启动线程都，需要调用 Thread.类中的start()的方法
 */
/*
  线程的分类:
  java中的线程分为两类: 一种是守护线程，一种是用户线程
   > 它们在几乎每个方面都是相同的，唯一的区别是判断JVM何时离开。
   > 守护线程是用来服务用户线程的，通过在start()方法前调用
     thread.setDaemon(true) 可以把一个用户线程变成一个守护线程
   > java垃圾回收就是一个典型的守护线程
   > 若JVM中都是守护线程，当前JVM将退出
   >

 线程的生命周期:
 要想实现多线程，必须在主线程中创建新的线程对象，java语言使用Thread类及其子类的对象来表示线程，在它的一个完整的生命周期中通常
 经历如下五中状态:
    > 新建: 当一个Thread的类或者子类的对象被声明并创建时，新生的线程对象处于新建状态。
    > 就绪: 处于新建状态的线程被start()后，将进入线程队列等待cpu时间，此时他已经具备了运行的条件，只是
      没分配(获取)到cpu的执行权
    > 运行: 当就绪的线程被调度并获得 cpu的执行权，便进入运行状态，run()方法定义了线程的操作和功能
    > 阻塞: 在某种特殊情况下，被人为挂起或执行输入输出操作时，让出 cpu并临时中止自己的执行，进入阻塞状态
    > 死亡: 线程完成了它的全部工作或线程被提前强制性地中止或出现异常导致结束。
    注意: 所有的线程的终点都是 死亡; 而不是无限执行下去(成“死锁”)
 */
public class WindowTest {

    /**
     * 通过实现 Runnable接口的方式创建多线程: 卖票
     *
     * @param args
     */
    public static void main(String[] args) {
        // 3. 创建实现Runnable 接口的实现类
        Window1 window1 = new Window1();
        // 4. 将实现Runnable接口的对象，当作参数传入到Thread构造器中创建Thread对象
        Thread t1 = new Thread(window1);
        t1.setName("窗口1:");
        // 5. 调用Thread.start()的方法创建线程
        t1.start();   // 创建线程start(一个线程对象只能创建一个线程)，调用Runnable中被重写的 run()方法

        // 通过实现 Runnable 创建多个线程对象。
        Thread t2 = new Thread(window1);
        t2.setName("窗口2:");
        t2.start(); // 创新线程start(一个线程对象只能创建一个线程)，调用Runnable中被重写的run()方法

        Thread t3 = new Thread(window1);
        t3.setName("窗口3:");
        t3.start();  // 创新线程start(一个线程对象只能创建一个线程)，调用的还是Runnable中被重写的run()方法


    }


    /**
     * 通过继承的方式创建多个线程，卖票
     * @param args
     */
    public static void main1(String[] args) {
        // 3.创建继承Thread 的子类对象
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        // 设置线程名:
        w1.setName("窗口1:");
        w2.setName("窗口2:");
        w3.setName("窗口3:");

        // 4. 通过对象调用start()
        w1.start();  // 创建线程，调用run()方法，一个线程对象只能start(创建一个线程)，
        w2.start();
        w3.start();
    }


}


// 1. 创建类继承 Thread
class Window extends Thread {
    // 票数要设置为 static 的所有对象(窗口)共用，和类一起加载到内存当中，仅仅加载一次
    private static int ticket = 100;

    // 2. 重写 run()方法
    @Override
    public void run() {
        // run(0) 中线程要处理的事务
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ":" + "票号为:" + this.ticket);
                --this.ticket;
            } else {
                break;  // 票买光了
            }
        }
    }
}


// 1. 创建实现 Runnable 的实现类
class Window1 implements Runnable {

    /**
     * 因为使用都是 同一个 Window1 的实例对象，Thread(window1)的地址调用的构造器，
     * 所以是同一个对象中的 ticket 的成员变量，不用static 静态修饰
     */
    private int ticket = 100;
    // 2. 重写 Runnable 的抽象方法run()
    @Override
    public void run() {
        while(true) {
            if(this.ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"票号:"+this.ticket);
                --this.ticket;
            } else {
                break;  // 票卖光了
            }
        }
    }

}
