package day17;



import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常处理的方式二: throw + 异常类型 将异常向上抛出，交给另外一个调用者处理.
 *  1. throws + 异常类型 “写方法的声明”此处，指明此方法执行时，可能会出现的异常类型
 *  一旦当方法执行时，出现异常，仍会在异常代码生成一个异常类型的对象，此对象满足throws 后异常类型时，就会被抛出。
 *    异常代码后续的代码，就不再执行！
 *
 * 2. 体会: try-catch-finally ： 真正的将异常处理掉了。
 *    throws 的方式只是将异常抛给了方法的调用者，并没有真正将异常处理掉。
 */
public class ExceptionTest2 {

    public static void main(String[] args) {
        ExceptionTest2 exe = new ExceptionTest2();

        try {  // 最后使用 try-catch-finally 实际的解决所抛出的异常
            exe.method2();
        } catch (IOException e) {
            e.printStackTrace();   // 报红错误
        }


    }


    @Test
    public void method4() {
        method3();    // method3()处理了 try-catch-finally throws 向上抛出的异常，后面的调用者就不用处理异常了
    }

    public void method3() {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void method2() throws  IOException{  // throws 异常处理: 将异常抛出调用者
        method1();
    }

    public void method1() throws FileNotFoundException, IOException {  // throws 异常处理: 将异常像向上抛出给调用者
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();

        while( data != -1) {
            System.out.println((char)data);
            data = fis.read();
        }
    }
}
