package day20;

/**
 * 多线程:
 *     > 什么是多线程，什么是线程
 *       进程是一个应用程序: 一个进程是一个软件，
 *       线程是一个进程中的执行场景/执行完毕
 *       一个进程可以启动多个线程
 *     对于Java程序来是说，当在Dos命令窗口中输入 java helloworld 回车之后
 *     会先启动JVM，而JVM就是一个进程
 *     JVM启动一个主线程调用main方法
 *     同时再启动一个垃圾回收线程负责看护，回收垃圾
 *     至少有三个线程并发： 一个是垃圾回收线程，一个main主线程，一个异常处理线程
 *
 *
 * 进程和线程是什么关系？举个例子
 *   阿里巴巴：进程
 *          马云：阿里巴巴的一个线程
 *          童文红：阿里巴巴的一个线程
 *
 *   京东：
 *        强东：京东的一个线程
 *         员工：京东的一个线程
 *
 *    进程可以看做是现实生活当中的公司
 *    线程可以看做是公司当中的某个员工
 *
 *    注意：
 *       进程A和进程B 的内存是独立不共享的，(阿里巴巴和京东资源是不会共享的)
 *       线程A 和进程B
 *         在Java语言中：
 *            线程A和线程B，堆内存和方法内存共享
 *            但是栈内存独立，一个线程一个栈
 *
 *         假设：启动10个线程，会有10个栈空间，每个栈和每个栈之间，互不干扰，各自执行各自的，这就是多线程并发
 *
 *         火车站：可以看做是一个进程
 *         火车站中的每一个售票窗口可以看做是一个线程。
 *         我在窗口1购票，你可以在窗口2购票，你不需要等我，我也不需要等你
 *         所以多线程并发可以提高效率。
 *         Java中之所以有多线程机制，目的就是为了提高程序的处理效率。
 *
 *         思考一个问题：
 *         使用了多线程机制之后，main方法结束，是不是有可能程序也不会结束。
 *         main方法结束只是主线程结束了，主栈空了，其它的栈(线程)可能还在压栈弹栈
 *
 *         分析一个问题，对于单核的cpu来说，真的可以做到真正的多线程并发吗？？？
 *            > 对于多核的cpu电脑来说，真正的多线程并发是没有问题的
 *            > 4核cpu表示同一个时间点上，可以真正的有 4 个线程并发执行
 *
 *            什么是真正的多线程并发 ？？？
 *             t1线程执行 t1的
 *             t2线程执行 t2的
 *             t3 不会影响t2,t3 也不会影响t1,这叫做真正的多线程并发
 *
 *             单核的cpu表示只有一个大脑
 *               > 不能够做到真正的多线程并发，但是可以做到给人一种“多线程并发”的感觉，
 *               对于单核的cpu来说，在某一个时间点上实际上只能处理一件事情，但是由于cpu的处理速度极快，
 *               多个线程之间频繁切换执行，跟人来的感觉是：多个事情同时在做！！！！！
 *               线程A：播放音乐。
 *               线程B:运行魔兽游戏
 *               线程A 和 线程B 频繁切换执行，人类会感到音乐一直在播放，游戏一直在运行，给我们的感觉是同时并发的
 *
 *
 *               电影院采用胶卷播放电影，一个胶卷一个胶卷播放速度达到一定程度之后，人类的眼睛产生了错觉，感觉
 *               是动画的，这说明人类的反应速度很慢，就像一根钢针扎到手上，到最终感觉到疼，这个过程是需要“很长的”
 *               时间的，在这个期间计算机可以进行亿万次的循环，所以计算机的执行速度很快，时间片的轮转
 */
public class ThreadTest {

    /*
    下面这种只是一个线程，不是多线程，只是一个线程的方法的调用
     */
    public static void main(String[] args) {
        System.out.println("main begin ");
        method1();
        System.out.println("main over");
    }

    private static void method1() {
        System.out.println("method1 begin");
        method2();
        System.out.println("method1 over");
    }

    private static void method2() {
        System.out.println("method2 begin");
        method3();
        System.out.println("method3 over");
    }

    private static void method3() {
        
    }
}
