package blogs.blog4;


import java.util.concurrent.*;

/**
 * 创建多线程的第四种方式：线程池
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        // 1. 创建一个可重用固定的线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 3. 将创建的线程类Runnable/Callable实现类的对象交给线程池，让线程池中的线程来复杂执行
        executorService.execute(new MyRunnable2());   // 用于 Runnable 接口类型的
        Future future = executorService.submit(new MyCallable2());// 用于 Callable 接口类型的有返回值
        try {
            System.out.println("总值: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 4. 使用完线程池，关闭线程池
        executorService.shutdown();

    }
}


// 2. 创建一个实现 Runnable 接口的实现类 / Callable 接口的实现类
class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}


// 2. 创建一个实现 Callable 接口的实现类
class MyCallable2 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
        return sum;
    }
}
