package day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 关于 java.util.Collection 接口中常用的方法:
 * 1.Collection中能存放什么元素？？？
 * 没有使用<泛型> 之前，Collection中存放Object 的所有子类型。
 * 使用了“泛型”之后，Collection中只能存储某个具体的类型。
 * “集合中不能直接存储基本数据类型，也不能存储Java对象，只是存储Java对象的内存地址。”
 * 2. Collection 中常用的方法
 * boolean add(Object e) : 向Collection 向集合中添加元素
 * int size(); 获取集合中元素的个数。
 * void clear(); 清空集合。
 * boolean contains(Object o) 判断当前集合当中是否包含元素 o,包含返回 true,不包含返回false
 * 注意对于自定义的类需要重写 equals()方法，规定比较的值。
 * boolean remove(Object o) 删除集合中的某个元素。
 * boolean isEmpty() 判断该集合中元素的个数是否为 0，为 0 返回 true,否则返回 false
 * Object[] toArray() 调用这个方法可以把集合转换成数组
 */
public class CollectionTest {


    /**
     * HashSet 集合，无序不可重复的
     * 无序的: 存储元素数据的内容不是一块连续的地址，而是散列的
     * 不可重复的：不可存储数据内容相同的数据，重复的不会报错，但是不会粗存储进去
     */
    @Test
    public void test6() {
        // 即
        // <(Integer>泛型，限定了该集合可以存储的数据类型只能是 Integer 类型，其他的报编译错误
        Collection<Integer> collection = new HashSet<Integer>();  // 多态性: Collection接口,HashSet 实现类

        collection.add(1);
        collection.add(2);
        collection.add(5);
        collection.add(3);
        collection.add(4);
        collection.add(1);
        collection.add(1);
        collection.add(1);

        // 迭代器遍历该 HashSet 集合
        // 创建该集合的迭代器
        Iterator<Integer> iterator = collection.iterator();
        while(iterator.hasNext()) {  // 判断该集合后面是否存在更多的元素 ，存在返回true,不存在返回false
            Integer next = iterator.next();  // 移动指针并，取出指针所在的元素的数据内容

            System.out.println(next);

        }
    }

    public static void main(String[] args) {
        // 创建一个集合对象
        //  多态
        Collection c = new ArrayList();

        // 测试 collection 接口中的常用方法
        c.add(1200);  // 自动装箱 (java5)的新特性，实际上是放进去了一个对象的内存地址，
        // Integer x = new Integer(12000)
        c.add(3.14);  // 自动装箱
        c.add(new Object());
        c.add(new Student());
        c.add(true);  // 自动装箱

        // 获取集合中元素的个数
        System.out.println("集合中元素个数是: " + c.size());

        c.clear();  // 清空集合，不是 c = null,而是将 Collection 集合中的数据删除了
        System.out.println(c.size());

        // 再向集合中添加元素
        c.add("hello");  // "hello" 对象的内存地址放到了集合当中。


    }

    // 迭代器的使用2
    @Test
    public void test5() {
        // 创建对象
        Collection collection = new ArrayList();  // 多态； Collection接口，ArrayList实现类

        collection.add(1);
        collection.add(2);
        collection.add(3);

        // 迭代集合
        // 获取集合的迭代对象
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {  // 判断集合后面是否存在元素数据
            Object next = iterator.next();  // 移动指针，并取出对应指针所指向的下标位置。
            if (next instanceof Integer) {  // 判断 next 对象是否是 Integer的实例对象
                Integer num = (Integer) next;
                System.out.println(next);
            }
        }
    }

    /**
     * 关于集合遍历/迭代专题
     * 注意: 以下讲解的遍历方式/迭代方式，是所有Collection 通用的一种方式。
     * 在Map 集合中不能用，在所有的Collection 以及子类中是使用。
     */
    @Test
    public void test4() {
        // 创建集合对象
        Collection c = new ArrayList();
        c.add("abc");
        c.add("def");
        c.add(100);
        c.add(new Object());

        // 对集合Collection 进行遍历/迭代
        // 第一步: 获取集合对象的迭代器对象iterator
        Iterator iterator = c.iterator();
        // boolean hasNext() 如果仍有元素可以迭代，则返回 true
        // Object next() 返回迭代的下一个元素。

        // 第二步: 通过以上获取的迭代器对像开始迭代/遍历集合

        /*if (iterator.hasNext()) {  // 判断后面是否存在元素数据了，存在返回 true,不存在返回false
            Object next = iterator.next();  // 移动指针，并取出对应指针所对应的元素的数据内容。不管你当前存进去什么，取出来的统一都是Object的
            System.out.println(next);
        }*/

        while (iterator.hasNext()) {  // 判断后面是否还存在数据
            Object next = iterator.next();  // 向后移动指针，并判断取出对应元素的数据内容
            System.out.println(next);
        }


    }

    @Test
    public void test3() {
        // 创建 Collection 对象，new ArrayList<> 对象 多态
        Collection<String> collection = new ArrayList<String>();
        collection.add("h");
        collection.add("e");
        collection.add("l");
        collection.add("l");
        collection.add("o");

        Object[] objects = collection.toArray();

        for (int i = 0; i < objects.length; i++) {
            String s = (String) objects[i];
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        // 创建Collection 对象，new ArrayList<> 对象
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(1);
        collection.add(2);
        collection.add(3); // 添加元素,使用上泛型: 限定了只能存储 Integer 类型的数据类型，无法
        // 存储其他类型的数据，不然报编译异常.

        // 转换为数组
        Object[] array = collection.toArray();

        for (int i = 0; i < array.length; i++) {
            Integer integer = (Integer) array[i];
            System.out.println(integer);
        }


    }

    @Test
    public void test1() {
        Collection<String> collection = new ArrayList<String>();  // 多态性
        collection.add("hello");
        collection.add("world");
        collection.add("浩克");
        collection.add("绿巨人");
        // collection.add(1);  // 使用了泛型，限定了只能存放 String 类型的地址，其他的报错误
        boolean b = collection.contains("hello");
        System.out.println(b);

        boolean b2 = collection.contains("world2");
        System.out.println(b2);

        System.out.println(collection.size());
        // 删除集合中某个元素
        collection.remove("hello");
        System.out.println(collection.size());

        // 清空Collection
        collection.clear();

        // 判断集合是否为 "空"
        System.out.println(collection.isEmpty()); // 空，返回 true,
    }
}
