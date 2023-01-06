package day19;


/**
 * 使用同步方法:解决实现Runnable接口的线程安全问题:
 * 如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的，同步方法
 * 同步方法的总结：
 * 1.同步方法仍然涉及到同步监视器 “锁”的，只是不需要我们显式的声明了
 * 2.一个extends Thread的类创建多线程，使用的是 static 因为要使用同一把锁:而静态的和类一起加载一次，所有对象共用(共用成员方法)，锁是:类.class 类对象
 * 3.一个implements Runnable 接口的方式创建多线程，使用的是锁是 this.对象本身，因为共用的是同一个Runnable实现对象，创建的Thread的实例对象，
 *     传的是地址，调用Thread的构造器，共用的成员属性。和成员方法
 * implements
 */
public class WindowTest3 {
    /**
     * 使用同步方法处理：extends Thread 创建多线程的
     * @param args
     */
    public static void main(String[] args) {
        // 3.创建 extends Thread 类的实例对象
        Window5 t1 = new Window5();
        Window5 t2 = new Window5();
        Window5 t3 = new Window5();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        // 4.调用start()方法，创建线程，启动run()方法，调用的Thead 中的 run()方法，不是调用Runnable中的run()方法
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 使用同步方法处理： implements Runnable接口创建多线程
     * @param args
     */
    public static void main2(String[] args) {
        // 3.创建Runnable接口的实现类，的对象
        Window4 window4 = new Window4();

        // 4.通过传入 Runnable的实现类的对象，创建Thread对象
        Thread t1 = new Thread(window4);
        Thread t2 = new Thread(window4);
        Thread t3 = new Thread(window4);

        t1.setName("窗口一:");
        t2.setName("窗口二:");
        t3.setName("窗口三:");

        // 5. 通过Thread的对象，调用start()方法，创建线程
        t1.start();  // 一个线程对象只能调用一次start(创建一个线程)，多了报错
        t2.start();
        t3.start();  // 调用的是Runnable接口被重写的run()方法
    }


}


// 1. 创建实现Runnable接口的实现类
class Window4 implements Runnable {
    private int ticket = 100;   // 因为使用的是Runnable接口的同一个对象，创建的Thread所以成员变量是同一个
    // 不用加 stiatc
    // 重写2.Runnable接口中的抽象方法
    @Override
    public void run() {
        while(true) {
            show();
        }

    }


    private synchronized void show() {  //同步方法： 非静态方法使用的是 : this 这把“锁” 同步监视器
        if(this.ticket > 0) {
            try {
                Thread.currentThread().sleep(10); // 睡眠，阻塞提高线程安全发生的概率
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"票号:"+this.ticket);
            --this.ticket;
        }
    }
}


// 1.继承Thread 类
class Window5 extends Thread {
    private static int ticket = 100; // 共享数据，使用static 和类一起加载，一样和类仅仅只是加载一次，所有对象共享
    // 2. 重写 Thread中的run()方法，不是调用Runnable 中的run()方法了
    @Override
    public void run() {
        while(true) {
            this.show();
        }
    }

// public synchronized void show() 错误的，不是同一把锁: t1,t2,t3，
    public static synchronized void show() {   // 同步方法：因为要是同一把锁:""继承的方式要用 "static" 静态的方法:所有对象共享
        if(ticket > 0) {                       // 静态的同步监视器 锁：是 window4.class ,类对象，因为类仅仅只会加载一次，所有对象共用此类
            try {
                sleep(30); // 睡眠，阻塞，提高线程同步问题的概率
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"票号:"+ticket);
            --ticket;
        }
    }
}
