package day19;

/**
 * 多个线程执行的不确定性引起执行结果的不稳定
 * 多个线程对账本的共享，会造成操作的不完整性，会破坏数据
 * 例子： 创建三个小窗口卖票，总票数为 100 张，使用实现Runnable接口的方式创建多线程
 * 1.问题： 卖票过程中，出现了重复，错票 -->出现了线程的安全问题:
 * 2.问题出现的原因: 当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票(而且还操作成功了)
 * 3.如何解决:当一个线程A在操作ticket共用的数据(车票)的时候附加上一把“锁”，其他线程不能参与进来，直到线程A操作完ticket时，
 * 其他线程才可以开始操作ticket,这种情况即使线程A出现了阻塞，其他线程也不能进来。
 * 4.java中，我们通过同步继承，来解决线程的安全问题。
 * 方式一:同步代码块:
 * 说明: 操作共享数据的代码，即为需要被同步的代码
 * 共享数据: 多个线程共同操作的变量，比如：这里的 ticket 火车票就是共享的数据
 * 同步监视器: 俗称为 “锁” 任何一个类的对象，都可以充当锁。
 *            锁的要求: 多个线程必须要共用同一把锁，就是同一个对象。注意作用域
 * synchronized(同步监视器) {
 * // 需要同步的代码
 * }
 * 补充: 1.在实现Runnable接口创建多线程的方式中,我们可以考虑使用this充当同步监视器"锁",因为我们使用的都是
 *       同一个Runnable对象创建的 Thread对象,
 *       2.如果是extends Thread 的方式创建多线程,我们可以考虑使用"类名.class"的方式充当同步监视器"锁",
 *         因为类仅仅只会加载一次,但是这种继承方式慎用 this充当"锁"同名监视器
 * 方式二: 同步方法
 *
 * 同步的方式：解决了线程的安全问题 --- 好处。
 * 操作同步代码时，只能有一个线程参与，其他线程等待，相当于是一个单线程的过程，
 * 缺点就是：效率低了，因为原本是多线程处理的，突然就变成了等待式的单线程了
 */
public class WindowTest1 {

    /**
     * 继承 Thread 的方式创建多个线程，并使用同步代码块的方式：解决多线程的同步安全问题
     * @param args
     */
    public static void main(String[] args) {
        // 3.创建继承 Thread 的类
        Window3 t1 = new Window3();
        Window3 t2 = new Window3();
        Window3 t3 = new Window3();

        // 设置线程名
        t1.setName("窗口一:");
        t2.setName("窗口二:");
        t3.setName("窗口三:");

        // 4.调用start()方法，创建线程，启动run() Thread()中的run()方法不是调用Runnable接口中的方法
        t1.start();
        t2.start();
        t3.start();




    }



    /**
     * 实现Runnable接口创建多线程的方式: 并使用同步代码块解决多线程同步安全问题
     * @param args
     */
    public static void main2(String[] args) {
        // 3.创建实现接口 Runnable 的实现类的对象
        Window2 window2 = new Window2();
        // 4. 将创建的对象，传入到Thread构造器中，创建Thread类对象
        Thread t1 = new Thread(window2);
        Thread t2 = new Thread(window2);
        Thread t3 = new Thread(window2);

        t1.setName("窗口一:");
        t2.setName("窗口二:");
        t3.setName("窗口三:");

        // 5.通过创建下Thread 对象，调用其中的start()方法创建对象,
        t1.start();  // 创建线程，调用重写 Runnable 接口中的run()方法
        t2.start();
        t3.start();  // 一个线程对象start(只能创建一个线程),

    }

}


// 1. 创建实现接口 Runnable 的实现类
class Window2 implements Runnable {
    // 因为都是通过 实现类 的实例对象创建的 Thread所以传的是地址，所以共用的都是同一个对象中的ticket成员变量,无需static修饰
    private int ticket = 100;
    private Object object = new Object();  // 因为使用的时实现的方式：共用同一个对象中的成员方法，
    //这样不用设置为 static静态的(因为都是使用同一个对象创建的Thread中的设置 Runnable对象)，因为锁：要求：多线程需要共用一把 “锁”
    // 2. 重写Runnable 中的run()方法
    @Override
    public void run() {
        // Object object = new Object();   // 这就是不是共用了，每次调用该方法创建的锁都是不同的
        while (true) {
            // synchronized (object) {  // 同步监视器，俗称为 “锁”,多线程需要共用一把“锁”
            synchronized(this) {   // 也可以使用 this 表示本对象,因为使用的是实现的Runnable接口对象的方式,
                // 都是同一个Runnable对象创建的Thread
                if (this.ticket > 0) {
                    try {
                        Thread.sleep(10);  // 睡眠 100毫秒,阻塞，提高被线程同步的概率
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号:" + this.ticket);
                    --this.ticket;
                } else {
                    break;
                }
            }
        }
    }
}



// 1. 创建继承 Thread 的类
class Window3 extends Thread {
    // 2.重写 Thread的方法，其中的Thread()的方法中的run()方法调用的是Runnable接口中的run()抽象方法
    private static int ticket = 100;   // 共享数据，设为 static 所有对象共享 static 和类一起加载
    private static Object object = new Object();
    // 设置为 static 静态的：因为“锁”：多线程需要共用同一把“锁”，注意作用域，静态的和类一起加载，仅仅只加载一次
    @Override
    public void run() {
        while(true) {
            synchronized(Window3.class) { // 类也可以作为对象(类在内存中仅仅只会加载一次): Class clazz = Window3.class,
            // synchronized(object) { // 同步监视器，所称 “锁”，注意锁必须是同一把“锁”，注意作用域
                // synchronized(this) 每次的对象都是不一样的,错误 this代表着 t1,t2,t3的三个对象
                if(ticket > 0) {
                    try {
                        super.sleep(100);  // 睡眠:阻塞，提高同步线程问题的概率
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(super.getName()+"票号:"+ticket);
                    --ticket;
                } else {
                    break;
                }
            }
        }

    }

}