package day19;

/**
 * 测试Thread中的常用方法
 * 1.start() : 启动当前线程，调用当前线程的run()方法
 * 2.run(): 通常需要重写Thread()类中的方法，将创建的线程要执行的操作声明在此方法中(线程实际要处理的事务)
 * 3.currentThread()：静态方法，返回当前执行的线程的引用
 * 4.setName()设置线程名,在创建线程start()之前/或在Thread()构造器中创建线程名。
 * > 如果是设置主线程名的话，需要先获取到当前执行的线程的引用: Thread.currentThread(),
 * > 因为main主线程没有继承 Thread 类，无法直接调用父类中的方法。
 * 5.getName()获取线程名。
 * 6.yield()释放当前cpu执行的线程: 注意了:但是下一次cpu可能执行的还是这个我们(刚刚释放掉的线程)，原因是
 * 这个刚刚释放的线程有抢到(获取的)cpu的执行权限了。
 * > 暂停当前cpu正在执行的线程，把执行的机会让给优先级相同或更高的线程,若队列中没有同优先级的线程，忽略此方法
 * 7.join(): 在线程 A中调用线程B的join()(B.join()),此时线程A就进入阻塞状态.直到线程B完全执行完以后，线程A才会结束阻塞状态
 * > 说白了就是：A线程调用了B线程对象.join()方法，此时A线程就需要等待B线程结束才会可能被执行。
 * > 注意的是：不是调用对象.join()发生阻塞，而是当前线程发生阻塞。
 * 8.stop():已过时，当前执行此方法时，强制结束当前线程
 * 9.sleep(long millis)：让当前线程“睡眠”指定的 millis 单位毫秒，在指定的 millis 毫秒时间内，当前线程是
 * > 是阻塞状态的。
 * 10.isAlive() 判断当前线程是否存在。存在返回 true,不存在返回false
 * 11.线程的优先级:
 * > 线程的优先级等级:
 * > MAX_PRIORITY: 10
 * > MIN_PRIORITY: 1
 * > NORM_PRIORITY: 5  默认一个线程值为 5
 * > 涉及的方法
 * > getPriority(): 返回线程的优先值
 * > setPriority(int newPriority) ：改变线程的优先级
 * > 说明
 * > 线程创建时继承父线程的优先级
 * > 低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
 *
 * 高优先级的线程要抢占低优先级的线程cpu的执行权，但是只是从概率撒谎上讲，高优先级的线程高概率的情况下
 * 被执行，并不意味着只有当高优先级的线程执行完毕以后，低优先级的线程才执行，只是概率高一点，但不是绝对的
 */
public class ThreadMethodTest {


    /**
     * getPriority() 返回线程的优先级，默认线程的优先级是: 5
     * setPriority(int newPriority) 改变线程的优先级，[10~1] 这是优先级的范围，超过了 java.lang.IllegalArgumentException 非法参数异常
     * 注意：并不是优先级越高的就一定会被优先执行，只是优先级高的线程优先执行的概率更高而已。
     * @param args
     */
    public static void main(String[] args) {
        MyThead3 myThead3 = new MyThead3();
        myThead3.setName("分支线程:");
        Thread.currentThread().setName("主线程:");
        myThead3.start();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);  // 10
        myThead3.setPriority(Thread.MIN_PRIORITY);    // 1
        myThead3.setPriority(6);   // java.lang.IllegalArgumentException 非法参数异常

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority() + ":" + i);
            }
        }
    }


    /**
     * isAlive()判断当前线程是否存在，存在返回true,不存在返回 false
     *
     * @param args
     */
    public static void main8(String[] args) {
        MyThead3 myThead3 = new MyThead3();
        myThead3.start();

        // 设置主线程的线程名
        Thread.currentThread().setName("主线程");


        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (i == 20) {
                try {
                    myThead3.join();   //让线程myThead3执行完，当前线程才可能被执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isAlive());   // 判断线程的状态

        System.out.println(myThead3.getName() + ":" + myThead3.isAlive());
    }

    /**
     * sleep()方法: 让当前线程“睡眠”指定的 时间 单位毫秒，在指定的睡眠时间内，当前线程是阻塞状态
     *
     * @param args
     */
    public static void main7(String[] args) {
        MyThead3 myThead3 = new MyThead3();
        myThead3.start();
    }

    /**
     * join() : A线程当中调用了 B 线程对象.join()，则A线程发生阻塞，必须等到B线程结束才可能被执行.
     * > 注意是当前线程发生阻塞。不是 线程对象.join()调用方发生阻塞
     *
     * @param args
     */
    public static void main6(String[] args) {
        // 给主线程设置线程名
        Thread.currentThread().setName("主线程:");
        MyThead3 myThead3 = new MyThead3();
        myThead3.start(); // 创建线程,调用run(操作系统决定)，一个线程对象只能调用start(创建一个线程)一次，不然报错

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i == 20) {
                try {
                    myThead3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * yield()方法：释放当前cpu执行的线程,但可能当前线程又抢到(获得)了cpu的执行权限
     *
     * @param args
     */
    public static void main5(String[] args) {
        MyThead3 myThead3 = new MyThead3();
        myThead3.start(); // 创建线程，调用run(操作系统决定)方法，一个线程只能调用start(创建一个线程)不然报错:
        // 设置主线程名: currentThread()返回当前执行的线程的引用，静态方法
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    /**
     * 通过构造器设置创建的线程名
     *
     * @param args
     */
    public static void main4(String[] args) {
        HelloThread thread = new HelloThread("线程一");
        thread.start(); // 创建线程，调用run()一次线程对象只能创建一个start()线程
    }

    /**
     * setName()设置线程名:
     *
     * @param args
     */
    public static void main3(String[] args) {
        MyThead3 myThead3 = new MyThead3();

        myThead3.setName("线程一");   // 设置线程名
        myThead3.start(); // 创建线程，2.调用run()方法(操作系统决定)
        System.out.println(myThead3.getName());   // 获取线程名

        // 设置主线程的名称
        Thread.currentThread().setName("主线程");  // 注意在 start()创建线程之前修改名称
        System.out.println(Thread.currentThread().getName());  // 获取线程名
        // currentThread()静态方法:返回当前执行的线程的引用
    }

    // 3.创建 extends 类的对象
    // 4. 调用start()方法，1.创建线程，2.调用 run()方法(操作系统决定)
    // 5. 一个线程对象只能 start()创建一个线程，不然报错.
    public static void main1(String[] args) {
        MyThead3 myThead3 = new MyThead3();
        myThead3.start();
    }

    /**
     * 创建多个线程
     *
     * @param args
     */
    public static void main2(String[] args) {
        // 创建多个线程: 循环创建
        for (int i = 0; i < 30; i++) {
            MyThead3 myThead3 = new MyThead3();
            myThead3.start();  // 创建线程，启动run()方法，一个线程对象只能调用start()一次创建一个线程
        }
    }

}

// 1. 创建继承Thread的类
class MyThead3 extends Thread {
    // 2. 重写 run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + getPriority() + ":" + i);
            }
        }
    }

    public void run2() {
        // 线程要处理的事务
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                /*try {
                    sleep(1000*1);  // 停顿“睡眠”毫秒，阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i % 20 == 0) {
                yield();  // 线程让步，释放当前cpu执行的线程
                yield();
                // 或者写成如下
                // Thread.currentThread().yield();的方式
            }
        }
    }
}


// 创建设置线程名的构造器
class HelloThread extends Thread {

    public HelloThread() {

    }

    // 设置线程名的构造器
    public HelloThread(String name) {
        super(name);
        this.setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(super.getName() + ":" + i);
            }
        }
    }


}



