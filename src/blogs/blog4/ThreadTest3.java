package blogs.blog4;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的方式三: implements Callable
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        // 3. 创建Callable 接口的实现类的实例对象
        MyCallable myCallable = new MyCallable();

        // 4.将此Callable的实例对象作为传递到 FutureTask构造器中，创建FutureTask的实例对象
        FutureTask futureTask = new FutureTask(myCallable);

        // 5. 将 FutureTask 对象作为参数传递到 Thread(Runnable target) 构造器中创建 Thread对象
        Thread thread = new Thread(futureTask);

        // 可以将 第 3 步，第 4 步和第 5步结合起来
        Thread thread2 = new Thread(new FutureTask(new MyCallable()));

        // 6. 调用其中的Thread对象中的 start()方法：创建新线程，启动其中的call()方法
        thread.start();

        // main()主线程
        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }

        // 7. 通过FutureTask 中的 get() 对象方法获取到 call()方法的返回值
        try {
            Object object = futureTask.get(); // 获取到 call()方法的返回值
            System.out.println("总和: " + object); // 自动拆箱
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}


// 1. 创建 Callable 的实现类
class MyCallable implements Callable {
    // 2. 重写 Callable 的抽象方法 call() 和 Runnable 中的 run()方法是一样的作用，不同的是 call()有返回值处理
    @Override
    public Object call() {
        int sum = 0;
        for(int i = 0; i <= 100; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + "--->" + i);
            // Thread.currentThread().getName()返回当前线程名
        }

        return sum; // 返回值: 自动装箱
    }
}
