package day20;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现多线程的第三种方式：
 *   实现 Callable 接口
 *    这种方式的优点: 可以获取到线程的执行的结果
 *    这种方式的缺点：效率比较低，需要等待获取 t线程执行的结果的时候，当前线程受阻塞，效率较低.
 */
public class ThreadTest6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 第一步: 创建一个 "未来任务类" 对象
        FutureTask task = new FutureTask(new Callable() {
            // 匿名接口的实现类
            @Override
            public Object call() throws Exception {  // call()方法就相当于run()方法，只不过这个有返回值

                // 线程执行一个任务，执行之后可能就会有一个执行结果
                // 模拟执行
                System.out.println("call method begin");
                Thread.sleep(1000 * 10);
                System.out.println("call method end");

                int a = 100;
                int b = 200;

                return a + b; // 自动装箱
            }
        });

        // 创建线程对象
        // public class FutureTask<V> implements RunnableFuture<V>
        // public interface RunnableFuture<V> extends Runnable, Future<V>
        Thread t1 = new Thread(task);

        // 启动线程
        t1.start();

        // 这里main方法，这里在主线程中
        // 在主线程中，怎么获取t线程发返回值，结果
        Object object = task.get();
        System.out.println("该线程的执行结果:" + object);
        // main方法这里的程序要想执行必须等待 get()方法的结束
        // 而get()方法可能需要很久，因为get()方法是为了拿到另一个线程的执行结果
        // 另一个线程执行是需要时间的（）

        System.out.println("Hello World");
    }
}
