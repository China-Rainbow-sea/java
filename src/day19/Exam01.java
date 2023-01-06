package day19;

/**
 * 面试题:
 * main
 * Thread t1 = new MyThread3(myClass);
 * Thread t2 = new MyThread3(myClass);  // 多态性
 *1.  该代码中: doOther方法执行的时候需要等待doSome 方法的锁释放结束吗？？？
 * 不需要：因为 doSome 没有上锁，所有线程都可以同时访问
 * 2. 如果 doOther 加上 synchronized 后 doOther 方法执行的时候需要等待doSome方法的锁释放结束吗？？？
 * 需要: 因为这里的同步方法锁：同步监视器"锁"是 this 当前的对象，由于这边锁被 doSome 占用了，还没有将锁释放出来，
 * doOther 无法拿到该 this锁，也就无法进入该同步方法，执行其中的程序，
 *
 * 3. 修改 main方法
 *         MyClass m1 = new MyClass();
 *         MyClass m2 = new MyClass();
 *
 *         Thread t1 = new MyThread3(m1);
 *         Thread t2 = new MyThread3(m2);  // 多态性
 * 这时候的 doOther 方法执行的时候需要等待doSome方法的执行吗，其中doOther 附加上了 synchronized 锁
 * :不需要: 因为MyClass 对象是两个，两把不同的锁，没有锁的占用的情况
 *
 * 4.doOther 与 doSome 方法都附加上 static 方法后，这时候的 doOther 方法执行的时候需要等待doSome方法的执行吗，
 * ：需要，因为 static 和类一起加载的(和类一样，仅仅只会加载一次,所有对象共用) 同步监视器是“锁”是: 类.class对象，仅仅只有一个所有对象共用
 * 静态方法的 synchronized 同步监视器"锁"：默认是 类.class 类对象，所有对象共用这一把锁
 * 非静态方法的 synchronized 同步监视器“锁”：默认是 this 当前对象，
 */
public class Exam01 {
    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        MyClass m2 = new MyClass();

        Thread t1 = new MyThread3(m1);
        Thread t2 = new MyThread3(m2);  // 多态性

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        try {
            Thread.sleep(1000);   // 这个睡眠的作用: 为了保证t1线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}


class MyThread3 extends Thread{
    private MyClass mc;

    public MyThread3(MyClass mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        if("t1".equals(super.getName())) {
            mc.doSome();
        }

        if("t2".equals(super.getName())) {
            mc.doOther();
        }
    }

}


class MyClass {
    public static synchronized void doSome() {  // 这里的同步监视器是: this 锁
        System.out.println("doSome begin");

        try {
            Thread.currentThread().sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }



    public static synchronized void doOther() {
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }
}