package day17;

/**
 * Error:
 * java 虚拟机无法解决的严重问题，如: JVM系统内部错误，资源耗尽严重情况在比如：StackOverflowError
 * Error 一般是部编写针对性的代码进行处理。
 * // 一般的错误都是以 Error 结尾的。
 *
 * 异常: 在Java语言中，将程序执行中发生的不正常情况称为 "异常"。(开发过程中的语法错误和逻辑错误不是异常)
 * Java程序在执行过程中: 所发生的异常事件可分为两类:
 *   1. Error: 错误，Java虚拟机无法解决的严重问题，如: jvm系统内部错误，资源耗尽等严重情况，
 *   比如: StackOverflowError 和 OOM,一般不编写针对性的代码进行受理。
 *   2. Exception: 其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理，如：
 *     1. 空指针访问
 *     2. 试图读取不存在的文件
 *     3. 网络连接中断
 *     4. 数组角标越界
 *
 */
public class ErrorTest {
    public static void main(String[] args) {
        // 堆区空间溢出: java.lang.OutOfMemoryError: Java heap space
        Integer[] arr = new Integer[1024 * 1024 * 1024];
    }


    public static void main1(String[] args) {
        main1(args);   // 演示: 递归调用: JVM 栈溢出的情况.
        // 栈溢出: java.lang.StackOverflowError
    }
}
