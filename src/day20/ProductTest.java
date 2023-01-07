package day20;

/**
 * 线程通信的应用：经典例题: 生产者/消费者问题；
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 */
public class ProductTest {
    public static void main(String[] args) {
        Clark clark = new Clark();

        Thread t1 = new Product(clark);  // 生产者线程
        Thread t2 = new Consumer(clark); // 消费者线程
        Thread t3 = new Consumer(clark); // 消费者2线程

        t1.setName("生产者");
        t2.setName("消费者");
        t3.setName("消费者2");

        t1.start();  // 创建线程，启动run()方法后就结束了
        t2.start();  // 一个线程对象就只能调用 start(创建一个线程)，多了报错
        t3.start();

    }

}


/**
 * 生产者
 */
class Product extends Thread {
    private Clark clark = null;

    public Product(Clark clark) {
        this.clark = clark;
    }

    public Product() {
        super();  // 调用父类的构造器
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产....");
        while (true) {
            try {
                Thread.sleep(20);  // 注意是当前线程睡眠，static 静态的与对象无关，仅仅只是睡眠不会释放手中的"锁"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clark.produceProduct();
        }
    }
}


/**
 * 消费者
 */
class Consumer extends Thread {

    private Clark clark = null;

    public Consumer() {

    }

    public Consumer(Clark clark) {
        this.clark = clark;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费产品.......");
        while (true) {
            try {
                Thread.sleep(20);  // 注意是当前线程睡眠，static 静态的与对象无关，仅仅只是睡眠不会释放手中的"锁"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.clark.consumeProduct();
        }
    }
}


class Clark {
    private int productCount = 0;

    /**
     * 生产产品
     */
    public synchronized void produceProduct() {  // 非静态方法 synchronized 同步方法默认同步监视器"锁"是 this
        if (this.productCount < 20) {   // 换成1
            this.productCount++;
            System.out.println(Thread.currentThread().getName() + "-->开始生产第" + this.productCount + "个产品");
            // 生产完了，打开消费线程，消费
            this.notify();   // 释放被 wait()阻塞的线程，优先高的优先
        } else {
            // 仓库够了，停止，生产
            try {  // 当前线程阻塞：并释放手中中的 "锁"
                this.wait();   // 和在synchronized 代码块/方法中,必须和锁对象一致，不然报错
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 消费产品
     */
    public synchronized void consumeProduct() {  // 非静态同步方法默认的同步监视器"锁"是 this
        if(this.productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "-->开始消费第" + this.productCount + "个产品");
            this.productCount--;
            // 消费了，打开生产的线程，生产
            this.notify(); // 释放被 wait()阻塞的线程，优先级高的优先: 必须在synchronized 同步代码块/方法中才行
        } else {
            // 等待
            try {  // wait()当前线程发生阻塞:并释放手中的"锁"
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
