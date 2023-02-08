package day26;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 标准输出输出流
 * java.io.printStream： 标准的字节输出流：默认输出到控制台
 */
public class PrintStreamTest {
    public static void main1(String[] args) {
        // 这是是连起来写的
        System.out.println("hello world");

        //   public final static PrintStream out = null;
        PrintStream printStream = System.out;
        printStream.println("hello zhangsan");
        printStream.println("hello lisi");
        printStream.println("hello wangwu");

        // 标准输出流不需要手动close() 关闭
    }

    /**
     * 可以改变标准输出的输出方向？
     * system.gc();
     * system.currentTimeMillis();
     * PrintStream ps = System.out
     * System.exit()
     * @param args
     */
    public static void main2(String[] args) {
        // 设置标准输出流的方向到：temp3文件当中
        PrintStream printStream = null; // 注意后缀
        try {
            printStream = new PrintStream(new FileOutputStream("src/day26/temp3"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(printStream);
        // 再输出
        System.out.println("hello world");
        System.out.println("你好世界");
        System.out.println("hello world");


    }


    public static void main(String[] args) {
        log("调用了System类的gc()方法，建议启动垃圾回收");
        log("调用了UserService的doSome()方法");
        log("用户尝试进行登录，验证失败");
    }
    /**
     * 测试的日志方法
     * @param msg
     */
    public static void log(String msg) {
        // 指向一个日志文件
        PrintStream printStream = null;//注意：后缀
        try {
            printStream = new PrintStream(new FileOutputStream("src/day26/temp3",true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 改变输出方向
        System.setOut(printStream);
        // 日期当前时间
        Date nowTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        String strTime = simpleDateFormat.format(nowTime);

        System.out.println(strTime + ":" + msg);

    }
}
