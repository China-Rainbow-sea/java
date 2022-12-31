package day17;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 异常处理:
 * 过程一: “抛", 程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应的异常类的对象。
 * 并将此对象抛出，
 * 一旦抛出对象以后，其后的代码就不再继续执行了。
 * <p>
 * 过程二: “捕获” 可以理解为异常的处理方式， 1.try-catch-finally, throws
 * <p>
 * 二 try-catch-finally 的使用
 * try {
 * // 可能出现的异常的代码
 * } catch (异常类型1 变量名) {  注意: 异常也是一种对象
 * <p>
 * } catch(异常引用类型 变量名2) {
 * <p>
 * } finally {
 * // 一定会被执行的代码
 * }
 *
 * 说明:
 * 1. finally 是可选项
 * 2. 使用try将可能出现异常的代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此
 * 对象的类型，去 catch 中进行匹配。
 * 3. 一旦try 中的异常对象匹配"捕获"到某个catch(中的异常类型对象)，就会进入catch中进行异常的处理，一旦处理完成，就会
 * 跳出当前的 try-catch 的结构，在没有写 finally的情况下，继续执行其后面的代码。
 * 4. catch中的异常类型如果 “没有” 子父类的关系，则在 catch()中，谁声明在上，谁声明在下都无所谓，都不会报错，都是并列的
 *   但是如果 catch 异常类型()中 “含有”子父类的关系，则在catch()中，则要求子类一定要声明在父类的上面，否则报错
 *   因为: 后面的子类异常是不会被执行的，会被父类异常类型给截取了。
 * 5. 常用的异常对象处理的方式: String getMassage() 提示异常错误位置, printStackTrace() 报红异常错误
 *
 * 6. 在try-catch 结构中声明的变量，再出try 结构以后，就不能再被调用了,解决方法: 将需要在try-catch外面继续使用的变量,声明在
 *                       try-catch 的括号外来,声明 int num;
 * 7. 使用 try-catch-finally 处理编译时异常，是得程序在编译时就不再报错，但是运行时仍可能报错，
 *    相当于我们使用 try-catch-finally 将一个编译时可能出现的异常，延迟到运行时出现。
 *
 * 8. 开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally 了，
 *    针对于编译时异常，我们说一定要考虑异常的处理。(一般运行时异常，我们基本上是通过修改源代码解决的而不是使用
 *     try-catch-finally ) 而一般针对于 编译时异常是使用  try-catch-finally 处理的，因为编译异常不处理就无法
 *     编译生成字节码文件，进行一个运行了。
 */
public class ExceptionTest1 {


    @Test
    public void test2() {
        try {
            File file = new File("hello.txt");
            FileInputStream fis = new FileInputStream(file);

            int date = fis.read();

            while (date != -1) {
                System.out.println((char) date);
                date = fis.read();
            }

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        @Test
    public void test1() {
        String str = "123";
        str = "abc";

        try {
            int num = Integer.parseInt(str); // 将字符串转换为基本数据类型
            System.out.println("hello world");
        } catch (NumberFormatException e) {  // 注意异常也是一个对象
            System.out.println(e.getMessage());
            e.printStackTrace();   // 报红异常
            System.out.println("出现数值类型异常，转换失败");
        } catch (NullPointerException e) {
            System.out.println("出现空指针异常了");
        } catch(Exception e) {
            System.out.println("异常");
        }
        System.out.println("hello-------2");
    }
}
