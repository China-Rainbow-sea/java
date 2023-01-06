package day19;

/**
 *
 * 死锁代码要会写
 * 一般面试官要求你会写
 * 只有会写，才会在以后的开发中注意这个事情
 *
 * 聊一聊，我们以后开发中应该怎么解决线程安全问题：
 *  1.是一上来就选择线程同步吗？ synchronized
 *   > 不是，synchronized 会让程序的执行效率降低，用户体验不好，系统的用户的吞吐量降低，用户体验差，在
 *   > 不得以的情况下，再选择线程同步机制，
 *
 *  2. 第一种方案，尽量使用局部变量代替“成员变量和静态成员变量”
 *  3. 第二种方案: 如果必须是成员变量,那么可以考虑创建多个对象，这样成员变量的内存就不是共享的(锁就不是唯一的一把了)
 *     > (一个线程对应一个对象，100个线程对应100个对象，对象不共享，就没有数据安全问题了)
 *  4. 第三种方案: 如果不能使用局部变量，对象也不能创建多个，这个时候就只能选择synchronised了，线程同步机制
 */
public class DeadLock2 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new MyThread5(o1,o2);
        Thread t2 = new MyThread6(01,02);

        t1.start();
        t2.start();

    }
}


class MyThread5 extends Thread{
    Object o1 = null;
    Object o2 = null;

    public MyThread5(Object o1,Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized(o1) {
            try {
                super.sleep(1000*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized(o2) {

            }
        }
    }
}


class MyThread6 extends Thread{
    Object o1 = null;
    Object o2 = null;

    public MyThread6(Object o1,Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized(o2) {
            try {
                super.sleep(1000*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized(o1) {

            }
        }
    }
}
