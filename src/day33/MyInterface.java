package day33;


/**
 * 自定义函数式接口
 *
 *
 * 什么式函数式接口：
 * 1. 只包含一个抽象方法的接口，称为 “函数式接口”
 * 2. 你可以通过 Lambda 表达式来创建该接口的对象。(若Lambda)表达式拖出一个受检异常
 * (即: 非运行时异常)，那么该异常需要在目标接口的抽象方法上进行声明。
 * 3.我们可以在一个接口上使用 @Functionallnterface 注解，这样做可以检查它是否是一个是一个函数式接口。
 * 同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
 * 在java.util.function 包下定义了 java8 的丰富的函数式接口 .
 *
 * 所以以前用匿名实现类表达是的现在都可以用Lambda表达式来写。
 *
 */

@FunctionalInterface
public interface MyInterface {
    void method1();
}
