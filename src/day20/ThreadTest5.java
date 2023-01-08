package day20;

/**
 * 守护线程
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        Thread t1 = new BakDataThread();
        t1.setName("备份数据的线程");

        // 启动线程之前：将线程设置为守护线程
        t1.setDaemon(true);   // main主用户线程结束，守护线程也就结束了。

        t1.start(); // 创建线程，启动run()就结束了
        //

        // 主线程：主线程是用户线程
        for(int i = 0; i< 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            int num = 2 / 0;  // 让主线程用户线程异常中止，线程结束，但是分支线程继续，

            try {
                Thread.sleep(1000*1); // 静态方法与对象无关，睡眠不会释放手中的锁同步监视器
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class BakDataThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while(true) {
            //即使是死循环，但由于该线程是守护线程，当用户线程结束了，守护线程自动结束
            System.out.println(Thread.currentThread().getName() + "--->" + ++i);
            try {
                Thread.sleep(1000*1); // 静态方法，与对象无关，睡眠当前线程，不会释放手中的锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}