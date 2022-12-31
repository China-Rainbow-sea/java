package day17;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * try-catch-finally 中 finally的使用
 * 1.finally 时可选的
 * 2.finally 中声明的是一定会被执行的代码,即使catch()中又出现异常下,try中有return语句catche中有
 * return 语句等情况
 * 3.像数据库连接，输入输出流，网络编程Socket等资源，JVM是不能自动的回收的，我们需要自己手动的进行资源的
 * 释放。此时的资源释放,就需要声明在 finally中。
 */
public class FinallyTest {

    public void test2() {
        FileInputStream fis = null;

        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while(data != -1) {
                System.out.println((char)data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();   // 报红错误
        } finally {
            try {
                if(fis != null) {
                    fis.close();  // 防止null引用
                }
            } catch (IOException e) {
                e.printStackTrace();  // 报红错误
            }
        }
    }

    @Test
    public void testMethod() {
        int num = method();
        System.out.println(num);
    }

    public int method() {
        try {
            int[] arr = new int[10];
            System.out.println(arr[10]);
            return 3;
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();   // 报红错误
            return 2;  // 返回之前,先执行 finally() 中的代码块
        } finally {
            System.out.println("我一定会被执行,无论是否存在异常都会被执行，计算有 return 也会被执行");
        }
    }



    @Test
    public void test1() {

        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            int[] arr = new int[10];
            System.out.println(arr[10]);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Hello World");
        }
    }
}
