package day20;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三: 实现Callable 接口: ---JDK5.0新增的方式
 * Future 接口：
 *  1. 可以对具体的 Runnable,Callable 任务的执行结果进行取消，查询是否完成，获取其中的返回值
 *  2. FutureTask 是Future 接口的唯一的实现类
 *  3.FutureTask 同时实现了Runnable,Future接口，它既可以作为Runnable被线程执行，又可以作为Future得到
 *  Callable的返回值
 *
 *  如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大 ？？？
 *    1. Callable 中的 call()方法有返回值
 *    2. Callable 中的 call()可以抛出异常(Exception比那一异常)，被外面的操作捕获，获取异常信息
 *    3.Callable 是支持泛型的
 */
public class NumThread {
    public static void main(String[] args) {
        // 3. 创建实现 Callable 的实现类的对象
        NumThread2 numThread2 = new NumThread2();

        // 4. 将此Callable的实例对象作为传递到 FutureTask构造器中，创建FutureTaek的实例对象
        // 通过 Future 的接口唯一实现类 FutureTask 类，通过传入 Callable 对象的参数，或Runnable的对象的参数
        FutureTask futureTask = new FutureTask(numThread2);
        /*
        FutureTask​(Runnable runnable, V result) 创建一个 FutureTask ，将在运行时执行给定的 Runnable ，
        并安排 get将在成功完成后返回给定的结果。
        FutureTask​(Callable<V> callable) 创建一个 FutureTask ，它将在运行时执行给定的 Callable 。
         */

        // 5.将FutureTask 对象作为参数传递Thread类的构造器中，创建Thread对象中
        Thread thread = new Thread(futureTask); // FutureTask implements RunnableFuture implements Runnable
        // public Thread(Runnable target)
        // public class FutureTask<V> implements RunnableFuture<V> {
        // public interface RunnableFuture<V> extends Runnable, Future<V>
        //
        thread.start();  // 创建线程，启动run()方法，就立刻结束

        try {
            // 6. 获取Callable中的call方法的返回值
            // get()返回值是: FutureTack(Callable callable)构造器中所传参数的Callable实现类重写call()的返回值
            Object sum = futureTask.get();   // 获取到 Callable 重写的 call 的返回值
            System.out.println("总和: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


// 1. 实现 Callable 接口
class NumThread2 implements Callable {

    // 2. 重写 Callable接口中的 call()抽象方法，和 重写Thread 类 和 Runnable的接口中的 run()方法是一样的，
    // 不同的是这个有 返回值
    @Override
    public Object call() throws Exception {
        int sum = 0;

        for(int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }

        return sum;
    }
}
