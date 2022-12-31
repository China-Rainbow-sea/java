package day17;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * java.lang.Throwable
 * |------java.lang.Error: 一般不编写针对代码运行处理.
 * |------java.lang.Exception: 可以进行异常的处理。
 * |------ 编译异常(checked)
 * |----FileNotFoundException
 * |----ClassNotFoundException
 * <p>
 * |-------运行时异常:
 * |----- NullPointerException
 * |----- ArrayIndexOutOfBoundsException
 * |----- ClassCastException
 * |----- NumberFormatException
 * |----- InputMismatchException
 * |----- ArithmaticException
 */
public class ExceptionTest {


    // java.lang.ArithmeticException: / by zero 除数为 0 (无穷大了)
    @Test
    public void test6() {
        int a = 10;
        int b = 0;

        System.out.println( a / b);
    }

    // Exception in thread "main" java.util.InputMismatchException  输入不匹配
    public static void mains(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

//        scanner.close();   // 关闭IO流
    }

    // java.lang.NumberFormatException: For input string: "abc" 包装类中的所传参数异常
    @Test
    public void test5() {
        String str = "abc";

        int num = Integer.parseInt(str);
    }



    // java.lang.ClassCastException: java.util.Date cannot be cast to java.lang.String 类转换异常
    @Test
    public void test4() {

        // String str2 = (String)new Date(); 如下操作: 先向上转型为同一个父类,再强制类型转换向下转型为子类

        Object object = new Date();   // 向上转型 "多态"
        String str = (String)object;  // 向下转型,骗过编译器,但无法强制转换成功，因为这Date 与 String 没有多态上的继承关系，是并列的关系


    }

    // java.lang.StringIndexOutOfBoundsException: String index out of range: 3 字符串超出索引范围
    @Test
    public void test3() {
        String str = "abc";
        System.out.println(str.charAt(3));
    }


    // java.lang.ArrayIndexOutOfBoundsException: 3 数组越界异常
    @Test
    public void test2() {
        int[] arr = new int[3];

        System.out.println(arr[3]);
    }


    // java.lang.NullPointerException 空指针访问异常
    @Test
    public void test1() {
        int[] arr = null;
        System.out.println(arr[0]);
    }
}
