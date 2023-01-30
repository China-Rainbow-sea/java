package day24;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Iterator 对象称为迭代器(设计模式的一种)，主要用于遍历Collection 集合中的元素，
 * GOF给迭代器模式的定义为： 提供一种方法访问一个容器(container)对象中各个元素，而又不需要暴露
 * 该对象的内部细节，迭代器模式，就是为容器而生，类似于“公交车上的售票员”，“火车上的乘务员”，“空姐”
 * Iterator仅用于遍历集合，Iterator本身并不提供承装对象的能力，如果需要创建iterator对象，
 * Collection 接口继承了java.lang.Iterable 接口，该接口又一个 iterator()方法，那么所有实现了
 * Collection接口的集合类都有一个iterable()方法，用以返回一个实现了iterator接口的的对象。
 * 则必须有一个被迭代器的集合。
 * 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 * <p>
 * 注意: Iterator必须和集合的结构保持一致性，同步的。不然存在异常
 *
 * 集合元素的遍历操作: 使用迭代器Iterator接口
 * 1.内部的方法: hasNext() 和 next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 * 3.默认迭代器游标都在集合的第一个元素之前。
 * 内部定义的remove(),可以在遍历的时候，删除集合中的元素,此方法不同于集合直接调用remove()
 *
 * 4.Iterator 可以删除集合的元素，但是是遍历过程中通过迭代器对象的 remove()方法，不是
 * 集合对象的 remove()方法。
 * 如果还未调用 next() 或在上一次调用 next()方法之后已经调用了 remove()方法
 * 再调用remove()都会报 IIlegalStatEception.
 *
 */
public class IteratorTest {

    @Test
    public void test() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));
        collection.add(false);

        Iterator iterator = collection.iterator();

        // 方式一:
        while (iterator.hasNext()) { // 判断后面是否还有元素数据,判断是否还有下一个元素
            // next()：指针下移，将下移动以后的集合位置上的元素返回
            Object o = iterator.next();  // 移动指针，并获取到对应指针中的元素的数据。
            System.out.println(o);
        }

        System.out.println("*****************");
        // 方式二:
        Iterator iterator2 = collection.iterator();
        for (int i = 0; i < collection.size(); i++) {
            Object o2 = iterator2.next();
            System.out.println(o2);
        }

        //
        System.out.println("******************************");
        // 方式三:
        for(Iterator iterator3 = collection.iterator();iterator3.hasNext();) {
            System.out.println(iterator3.next());
        }


    }


    // Iterator 的错误方式: java.util.NoSuchElementException
    // Iterator 必须和集合保证一致，同步性的。
    @Test
    public void test2() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));
        collection.add(false);

        Iterator iterator = collection.iterator();

        while (iterator.next() != null) {  // 注意: 这里 iterator.next()已经向下移动了
            System.out.println(iterator.next()); // 这里又向下移动了，可能后面就没有元素了。报异常
        }
    }


    /**
     * iterator。remove()删除对应迭代器所在指向的位置的元素数据
     */
    @Test
    public void test3() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry", 20));
        collection.add(new String("Tom"));
        collection.add(false);

        Iterator iterator = collection.iterator();
        while(iterator.hasNext()) {
            Object o = iterator.next();
            if("Tom".equals(o)) {
                iterator.remove();  // 删除迭代器所在指向的位置上的元素的数据
            }
        }

        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
