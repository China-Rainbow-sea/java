package day20;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 wait()方法和 notify() 方法实现 "生产者和消费者模式"
 *
 * 什么是生产者和消费者模式？
 *   生产线程负责生产，消费线程负责消费
 *   生产线程和消费线程要达到均衡
 *   这是一种特殊的业务需求，在这种特殊的情况下需要使用 wait()方法和notify()方法
 *
 *   wait() 和 notify()方法不是线程对象中的方法，是Object对象中的方法
 *   wait() 和 notify()方法建立在线程同步的基础之上，因为多线程要同时操作一个仓库。有线程安全问题。
 *   wait()方法作用 ：o.wait() 让正在o对象上活动的线程t进入等待状态，并且释放掉 t线程手中的“锁”
 *   notify()方法作用: o。notify()让正在o对象上等待的线程唤醒，只有通知，不会释放o对象上之前占有的锁.
 *
 *   7. 模拟这样一个需求:
 *       仓库我们采用List集合：
 *       List集合中假设只能存储 1个元素
 *       1 个元素就表示仓库满了
 *       如果List 集合中元素个数是 0 ，就表示仓库空了,
 *       保证List集合中永远都是最多存储 1 个元素
 *       必须做到这种现象: 生产 1个消费1个。
 */


public class ThreadTest7 {
    public static void main(String[] args) {
        List list = new ArrayList();

        // 生产者
        Producer producer = new Producer(list);

        // 消费者
        Consumers consumers = new Consumers(list);

        // 生产者线程
        Thread t1 = new Thread(producer);
        // 消费者线程
        Thread t2 = new Thread(consumers);

        t1.setName("生产者");
        t2.setName("消费者");

        // start()创建线程，启动run()方法，就立即结束
        t1.start();
        t2.start();

    }
}

/**
 * 生产线程
 */
class Producer implements Runnable {
    // 仓库
    private List list;

    public Producer() {

    }

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直生产(使用循环来模拟一直生产)
        while(true) {
            // 给仓库对象 Lis加锁
            synchronized (list) {
                // 仓库为 0 生产
                if(list.size() > 10) { // 大于 0 ，说明仓库中已经有 1个元素了
                    try{
                        // 当前线程进入等待状态，并且释放list手中的锁.
                        list.wait();   // 阻塞
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序能够执行到这里说明仓库是空的，可以生产了
                Object object = new Object();
                list.add(object);   // 链表中增加数据
                System.out.println(Thread.currentThread().getName() + "--->" + object);
                // 增加成功，唤醒 消费者，开始消费
                list.notify(); // 唤醒被 wait()阻塞的线程
            }
        }

    }
}


/**
 * 消费线程
 */
class Consumers implements Runnable {
    // 仓库
    private List list;

    public Consumers() {

    }


    public Consumers(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 一直消费
        while(true) {
            synchronized (list) {   // 同步监视器“锁”是同一个对象，同一把锁
                if(this.list.size() == 0) {
                    // 仓库为空就不要消费了
                    try {
                        list.wait(); //  当前线程阻塞，并释放手中的 “锁”
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 程序执行到说明仓库中有数据可以，消费
                Object object = list.remove(0); // 减少链表中的数据从起始位置开始
                System.out.println(Thread.currentThread().getName() + "--->" + object);
                // 消费完了，唤醒生产者继续生产
                list.notify();
            }
        }
    }
}



