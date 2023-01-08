package day20;

/**
 * 采用匿名内部类，创建多线程
 */
public class ThreadTest4 {
    public static void main(String[] args) {

        // 实现Runnable 接口的方式创建匿名实现类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
        });
        thread.start();

        // extend Thread 实现匿名子类的创建
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0 ; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + i);
                }
            }
        };

        thread2.start();
    }
}
