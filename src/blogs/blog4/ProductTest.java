package blogs.blog4;

/**
 * 生产者和消费者模型
 */
public class ProductTest {
    public static void main(String[] args) {
        // 创建仓库的实例对象
        Clark clark = new Clark();

        // 创建两个线程：生产者/消费者
        Thread t1 = new Thread(new Product(clark));   // 生产线程，生产和消费是同一个仓库
        Thread t2 = new Thread(new Consumer(clark));  // 消费线程，生产和消费是同一个仓库

        // 设置线程名
        t1.setName("生产者");
        t2.setName("消费者");

        // 创建线程
        t1.start();
        t2.start();
    }
}


/**
 * 仓库
 */
class Clark {
    private int productCount = 0;

    public Clark() {

    }

    /**
     * 生产产品
     */
    public synchronized void produceProduct() {  // 非静态方法 synchronized()默认同监视器"锁"是 this 对象锁，无法修改
        // 仓库最多存放 1 个产品，仓库没有满生产
        if (productCount < 10) {  // 修改为 10 个
            // 生产 ++
            this.productCount++;
            System.out.println(Thread.currentThread().getName() + "-->开始生产第" + this.productCount + "个产品");
            // 生产完了，打开消费线程，消费
            this.notifyAll();  // 释放被 wait()阻塞的线程，优先高的优先
        } else {
            // 仓库满了，停止生产，停止生产线程 wait() 进入阻塞状态，并释放手中的锁。
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 消费产品
     */
    public synchronized void consumeProduct() { // 非静态方法 synchronized()默认同监视器"锁"是 this 对象锁，无法修改
        // 仓库中有产品，才可以消费
        if (this.productCount > 0) {
            // 消费
            System.out.println(Thread.currentThread().getName() + "-->开始消费第" + this.productCount + "个产品");
            this.productCount--;
            // 消费完了，打开生产线程，生产
            this.notifyAll();
        } else {
            // 仓库没有产品，停止消费，该消费线程进入 阻塞状态 wait(),并释放手中的锁
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Product implements Runnable {
    // 定义仓库
    private Clark clark = null;

    public Product() {
        super(); // 调用父类中的构造器
    }

    public Product(Clark clark) {
        super(); // 调用父类中的构造器，必须首行(一次)
        this.clark = clark;
    }

    /**
     * 生产产品
     */
    @Override
    public void run() {
        while (true) {
            this.clark.produceProduct();
        }
    }
}


/**
 * 消费者
 */
class Consumer implements Runnable {
    private Clark clark = null;

    public Consumer() {
        super(); // 调用父类的构造器，首行(一次)
    }

    public Consumer(Clark clark) {
        super();  // 调用父类的构造器，首行(一行)
        this.clark = clark;
    }

    /**
     * 消费
     */
    @Override
    public void run() {
        while (true) {
            this.clark.consumeProduct();
        }
    }
}