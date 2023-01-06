package day19;

/**
 * 死锁问题：
 * 死锁：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源("锁")，就形成了线程的死锁
 * 出现死锁后，不会出现异常，不会出现提示，只是所有线程都处于阻塞状态，无法继续。
 * 说白了就是：比如：第一个线程要获取到的锁，被第二个线程给获取到了，而第二个线程需要的锁被，第一线程
 * 给获取到了，因为synchronized()无论是同步代码块，还是同步方法都是要执行完/或Error/Exception等等才会释放锁
 * 因为两个线程的所需要的锁都被对方获取到了，导致无法结束执行完程序，无法释放锁，对方也就无法获得其需要的锁，结束程序导致了死锁
 *
 *
 * 解决方法：
 *  >专门的算法，原则
 *  >尽量减少同步资源的定义
 *  >尽量避免嵌套同步锁：
 */
public class ThreadTest2 {
    public static void main(String[] args) {
       StringBuffer s1 = new StringBuffer();
       StringBuffer s2 = new StringBuffer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");

                    System.out.println(s1);
                    System.out.println(s2);
                    try {
                        Thread.currentThread().sleep(1000);  // 睡眠，阻塞，提高
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }


            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");

                    System.out.println(s1);
                    System.out.println(s2);

                    try {
                        Thread.currentThread().currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();

    }


}



