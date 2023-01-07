package day20;


/**
 * 线程通信的例子: 使用两个线程打印 1~100 ,线程1，线程2 交替打印
 * 使用到三个方法:
 * wait(): 一旦执行此方法，当前线程就进入阻塞状态,并释放同步监视器“锁”
 * notify():  一旦执行此方法，就会唤醒被wait()方法的一个线程，如果有多个线程被wait()阻塞了,就会优先唤醒优先机高的那个
 * notifyAll(): 一旦执行此方法，就会唤醒被 wait()阻塞的所有线程，
 *
 *
 * 说明:  synchronized
 * wait(),notify(),notifyAll() 三个方法必须使用再同步代码块或者同步方法中才行 synchronized，不然报错 IllegalMonitorStateException(非法监控状态例外)
 * wait(),notify(),notifyAll() 三个方法的调用者必须是同步代码块或者同步方法种的同步监视器“锁”一致，不然报错: IllegalMonitorStateException
 * wait(),notify(),notifyAll() 三个方法是定义在java.lang.Object 类中的
 *
 * 面试题: sleep()  和 wait() 的异同 ？？？
 *  相同点: 一旦执行，都可以使得当前线程进入阻塞状态。
 *  不同点: 1.两个方法的声明的位置不同，wait()必须在synchronized同步代码块/同步方法当中，而且调用的对象必须和同步监视器“锁”的对象一致，不然报，sleep()任意
 *         2.wait() 是在 Object 类当中的对象方法，sleep()是在Thread中的静态方法
 *         3.sleep()阻塞不会释放手中的同步监视器“锁”，wait()阻塞的同时会释放手中的同步监视器"锁"
 *
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();  // 创建线程，启动run()方法就结束了
    }
}


class Number implements Runnable {
    private int number = 1;
    private Object object = new Object();
    @Override
    public void run() {
        // notify(); wait(),notify(),notifyAll()不可以在 synchronized 同步监视器外使用.
        while(true) {   // notify(),wait(),notifyAll() 的对象调用必须和 synchronized()同步监视器的锁对象一致不然报错。
            synchronized(object) {   // 当前对象，作为同步监视器，"锁": 需要共用的一把“锁”对象/数据，才可以解决同步线程安全问题
                object.notify();  // 唤醒被wait()阻塞的线程，该方法同样继承于Object的类,默认是this.notify()
                if(number <= 100) {  // 不同的对象/数据，就等于每一个线程使用的都不是同一把锁，而且每一个线程所抢到的锁都不是同一把
                              // 等于没有锁
                    try {
                        Thread.sleep(10*1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "-->"+ this.number);
                    number++;

                    try {
                        // 使得调用如下wait()方法的当前线程进入阻塞状态,注意这是时候的阻塞:会释放“锁”
                        object.wait();   // 继承的是Object中的类，默认是 this.wait()
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}