package day24;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * List接口: 存储有序的，可重复的数据。
 *   |--- ArrayList 作为List接口的主要实现类；线程不安全的，效率高，底层使用Object[] elementDate 存储
 *   |--- LinkedList：对于频繁的插入，删除操作，使用此类效率比ArrayList 高，底层使用的是双向链表存储
 *   |--- Vector: 作为List 接口的古老实现类；线程安全的，效率低，底层使用Object[] elementDate存储
 *
 *   面试题:
 *   ArrayList,LinkedList,Vector 三者的异同
 *   三个类都实现了List接口，存储数据的特点相同，存储有序的，可重复的数据，
 *   不同: 见上
 *
 *   ArrayList 源码分析: jdk7情况下:
 *    ArrayList list = new ArrayList() ; // 底层创建了长度是 10的object[]数组 elementDate
 *    list.add(123) // elementDate[0] = new Integer(123)
 *    ...
 *    list.add(11) 如果此次的添加导致底层elementDate数组容量不够，则扩容，
 *    默认情况下，扩容为原来的容量的1.5倍，同时需要将原有的数组中的数据复制到新的数组当中去。
 *    结论: 建议开发中使用带参数的构造器 ArrayList list = new ArrayList(int capacity)
 *
 *    2.3 jdk8 中的ArrayList的变化:
 *    ArrayList list = new ArrayList()；// 底层object[] elementData初始化为{}，并没有创建
 *    长度为10的数组。
 *    list.add(123); 第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementDate中
 *    ...
 *    后续的添加和扩容操作与 jkd 7 一样的。
 *
 *    总结： jdk7 会先创建 10 个容量的数组，与单例模式中的懒汉式一样，
 *           jdk8 不会先创建 10 个容量的数组，而是在添加 add()的时候创建 10 个容量的数组，与单例模式中的饿汉式一样
 *           延时了数组的创建，节省内存。
 *
 *    LinkedList 源码分析:
 *     LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，
 *     默认值为null,
 *     list.add(123); // 将123封装到 Node中，创建了Node对象。
 *     其中，Node定义为：体现了LinkedList 的双向链表的说法。
 *     private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *     4. Vector 的源码分析: jdk7 和 jdk8 中通过 Vector()构造器创建对象时，底层都创建了长度为10的数组。
 *     在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 *
 *
 *     /* List 中常用的方法:
 *    > void add(int index, Object ele):在index位置插入ele元素
 * > boolean addAll(int index, Collection eles):从index位置开始将eles中
 * 的所有元素添加进来
 * > Object get(int index):获取指定index位置的元素
 * > int indexOf(Object obj):返回obj在集合中首次出现的位置
 * > int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * > Object remove(int index):移除指定index位置的元素，并返回此元素
 * > Object set(int index, Object ele):设置指定index位置的元素为ele
 * > List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 *
 * 总结: 常用的方法;
 *  增 add(Object obj)
 *  删 remove(int index)/remove(Object obj)
 *  改 set(int index ,object ele)
 *  查: get(int index)
 *  插: add(int index,Object ele)
 *  长度: size();
 *  遍历: 1.Iterator迭代器的方式
 *       2.增强for循环
 *       3.普通的循环
 *
 */
public class ListTest {

    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        // void add(int index,Object o) 在index下标位置插入o元素
        list.add(1,999);

        // boolean addAll(int index,Collection eles);从index位置开始将eles 中的所有元素添加到该集合中
        List list2 = Arrays.asList(1,2,3);
        list.addAll(list2);   // 默认添加到最后面的位置上。
        list.addAll(0,list2);
        for (Object o : list) {
            System.out.println(o);

        }

        System.out.println("**********************************");
        // int indexOf(Object obj) 返回obj在集合中首次出现的位置，如果不存在，返回-1;
        int index = list.indexOf(1);
        System.out.println(index);

        // int lashIndexOf(Object obj) 返回obj在集合中末位出现的位置.
        System.out.println(list.lastIndexOf(1));

        // Object remove(int index) 移除指定index位置的元素，并返回此元素。
        Object o = list.remove(0);
        System.out.println(o);

        System.out.println("***************");
        for (Object o2 : list) {
            System.out.println(o2);
        }


        System.out.println("**************");
        // Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        for (Object o2 : list) {
            System.out.println(o2);
        }


    }



    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        // list subList(int fromIndex,int toIndex): 返回从fromIndex到toIndex位置的左闭右开区间
        List subList = list.subList(2, 4);
        for (Object o : subList) {
            System.out.println(o);
        }
    }

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        // 方式一: Iterator迭代器的方式
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 方式二:
        for (Object o : list) {
            System.out.println(o);
        }
    }

    // 面试题;
    @Test
    public void test4() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        updateList2(list);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    public void updateList(List list) {
        list.remove(2);  // 注意这里移除的对于下标索引位置上的元素的数据
    }

    public void updateList2(List list) {
        list.remove(new Integer(2));  // 这里移除的是比较同以内容的元素数据。
        // 需要重写 equals()方法
    }
}
