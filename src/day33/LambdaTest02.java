package day33;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda 表达式的使用
 * 满足：一个接口中只有一个抽象方法。才可以
 * 1.举例: (o1,o2)-> Integer.compare(o1,o2)
 * 2.格式:
 *       ->: Lambda 操作符 或箭头操作符
 *       -> (箭头)左边:lambda形参列表，( 其实就是接口中的抽象方法的参数列表中的参数)
 *       -> (箭头)右边 lambda体 (其实就是对接口中的抽象方法重写的方法体的)
 *
 * Lambda 表达式的本质：作为接口的实例。就是接口的实例
 *
 * 接口的抽象方法中的形参列表的参数类型可以省略(类型推断)： 如果Lambda 形参列表只有一个参数，其一对() 也可以省略
 * 如果接口的抽象方法中有多条语句，则需要使用{} 括起的。如果Lambda 体中只有一条执行语句(可能是 return 语句) 可以省略这对{}和 return关键字 注意需要都省略才行
 * Lambda 表达式的本质：作为函数式接口的实例。(匿名实现接口重写其中的抽象方法)
 *
 * 重点: 如果一个接口中，只声明了一个抽象方法，则此接口就称为 "函数式接口"


 */
public class LambdaTest02 {

    /**
     * 语法格式一: 无参，无返回值，一条语句
     */
    @Test
    public void test() {
        // 不用lambda表达式，使用匿名实现接口
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱天安门");
            }
        };

        runnable.run();

        System.out.println("*****************************");

        // 使用 lambda表达式
        // () 表示没有参数
        // -> System.out.println() 是该实现的接口中的抽象方法中方法体的执行的语句：注意：只有一条语句。
        //
        Runnable runnable2 = () -> System.out.println("我爱故宫");
    }


    /**
     * 语法格式二: Lambda 需要一个参数，但是没有返回值
     */
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("谎言和誓言的区别是什么？");

        // 使用Lambda 表达式
        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept("一个是听得人当真了");

        // 或者
        Consumer<String> con3 = (String s) -> {
            System.out.println(s);
        };

        con3.accept("一个是说的人当真了");
    }


    /**
     * 语法格式三： 数据类型可以省略，因为可由编译器推断导出，称为 "类型推断"
     */
    @Test
    public void test3() {
        Consumer<String> con = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }

        };

        con.accept("一个是听得当真了，一个是说的人当真了");

        Consumer<String> con2 = (s) -> {  // 省略了数据类型，因为上面已经定义了 数据类型了，可以自行推断出来.
            System.out.println(s);
        };

        con2.accept("一个999");
    }


    /**
     * 其它内容上的类型推断
     */
    @Test
    public void test4() {
        ArrayList<String> list = new ArrayList<>();  // 类型推断
        int[] arr = {1, 2, 3};  // 类型推断，1,2,3 直接就是 int 类型的数据.
    }


    /**
     * 语法格式四: Lambda 若只需要一个参数时，参数的小括号可以省略
     * 注意 ： 空参数的时候是不可以省略的。
     */
    @Test
    public void test5() {
        Consumer<String> con = (s) -> {  // 其实就是Lambda 接口中实例
            System.out.println(s);
        };
        // 当接口中的抽象方法只有一个参数时，可以省略括号，直接使用参数名
        Consumer<String> con2 = s -> {
            System.out.println(s);
        };

        con2.accept("一个 666");
    }


    /**
     * 语法格式五: Lambda 需要两个以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void test6() {
        Comparator<Integer> com1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                System.out.println(o1);
                System.out.println(o2);

                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(21, 12));  //
        System.out.println("*******************************");
        Comparator<Integer> com2 = (o1,o2)-> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(12, 21));

    }


    /**
     * 语法格式六: 当Lambda 体只有一条语句，return 与大括号若有都可以省略
     * 注意: 如果要省略的话就必须两者都省略掉，不可以省略单个
     */
    @Test
    public void test7() {
        Comparator<Integer> com1 = (o1,o2)-> {
            return o1.compareTo(o2);
        };

        System.out.println(com1.compare(12, 21));

        Comparator<Integer> com2 = (o1,o2)-> o1.compareTo(o2);
        System.out.println(com2.compare(21, 12));
    }



    @Test
    public void test8() {
        Consumer<String> con = s -> {
            System.out.println(s);
        };

        con.accept("Hello");


        Consumer<String> con2 = s-> System.out.println(s);

        con2.accept("World");
    }




}
