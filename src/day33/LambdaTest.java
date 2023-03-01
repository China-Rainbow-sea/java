package day33;

import org.junit.Test;

import java.util.Comparator;


public class LambdaTest {

    @Test
    public void test() {

        // 匿名实现匿名接口
        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                System.out.println("我爱天安门");
            }
        };

        runnable.run();
        System.out.println("**********************");


        // 表示lambda 表达式
        Runnable r2 = ()->System.out.println("我爱故宫");
        r2.run();
    }

    @Test
    public void test2() {
        // 匿名实现接口
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };


        int compare = com.compare(12, 21);
        System.out.println(compare);

        // 使用lambda 表达式的写法
        Comparator<Integer> com2 = (o1,o2)->Integer.compare(o1,o2);
        int compare1 = com2.compare(21, 12);
        System.out.println(compare1);

        // 方法引用
        Comparator<Integer> com3 = Integer::compareTo;
        int compare2 = com3.compare(32, 23);
        System.out.println(compare2);

    }
}
