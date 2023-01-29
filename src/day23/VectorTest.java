package day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Vector:
 * 1. 底层也是一个数组
 * 2. 初始化容量： 10
 * 3.怎么扩容的？
 * 扩容之后是原来容量的 2倍
 * ArrayList 集合扩容特点:
 * 10---> 15---> 15*1.5
 * <p>
 * Vector 中所有的方法都是线程同步的，都带有synchronized关键字
 * 是线程安全的。多线程变成了单线程，效率比较低，使用较少了。
 *
 * 怎么将一个线程不安全的ArrayList 集合转换成线程安全的呢?
 * 使用集合工具类:
 * java.util.Collections;
 * java.util.Collection 是集合的接口
 * java.util.Collections 是集合工具类。
 */
public class VectorTest {


    /**
     *  使用集合工具类:
     *  java.util.Collections;
     *  java.util.Collection 是集合的接口
     *  java.util.Collections 是集合工具类。
     */
    @Test
    public void test2() {
        List myList = new ArrayList();

        // 将集合线程不安全的转换为对应集合安全的 List 对应的集合
        List list = Collections.synchronizedList(myList);

        myList.add(1);
        myList.add(2);
        myList.add(3);
    }

    @Test
    public void test() {
        // 创建一个Vector 集合
        List<Integer> vector = new Vector<Integer>();
        // Vector vector = new Vector(); 这样也是可以的 List 是一个接口，Vector 是实现类

        // 添加元素
        // 默认容量10个
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(10);

        // 满了之后扩容(扩容之后的容量是 0 )
        vector.add(11);

        for (Integer i : vector) {
            System.out.println(i);
        }

    }
}
