package day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 单链表中的节点:
 * 1. 节点是单向链表的基本单元，任何一个节点
 * 链表的优点: 随机增删元素效率较高，(因为增删元素不涉及到大量元素的位移)
 *     由于链表上的元素在空间存储上内存地址不连续。
 *     所以随机增删元素的时候不会有大量元素位移，因此随机增删效率较高
 *     在以后的开发中，如果遇到随机增删集合中元素的业务比较多时，建议使用LinkedList.
 *
 * 链表的缺点: 查询效率较低，每一次查找某个元素都需要从头节点开始。
 *    不能通过数学表达式，计算被查找元素的内存地址，每一次查找都是从头节点开始遍历，
 *    直到找到为止，所以LinkedList 集合检索/查找的效率较低。
 *
 *   ArrayList
 *   LinkedList
 *   加元素都是往末尾添加，所以ArrayList 用的比 LinkedList 多
 *
 *   ArrayList 集合式非线程安全的。
 */
public class LinkedListTest {


    /**
     * LinkedList 集合中有初始化容量吗？？ 没有
     * 最初这个链表中没有任何元素，first 和 last 引用都是 null
     * 不管式 LinkedList 还是 ArrayList ，以后写代码时不需要关心具体是哪个集合。
     * 因为我们要面向接口编程，调用的方法都是接口中的方法。
     */
    @Test
    public void test2() {
        List myList1 = new ArrayList();  // 这样写的话：底层用了数组，
        List MyList2 = new LinkedList(); // 这样写表示底层你用了双向链表
        MyList2.add("123");
        MyList2.add("456");
        MyList2.add("789");

        for (int i = 0; i < MyList2.size(); i++) {
            System.out.println(MyList2.get(i));  // 通过下标获取到对应集合中的内容。
        }
    }

    @Test
    public void test() {

        // 创建 LinkedList 对象， LinkedList 实现了List接口，List接口实现了Collection接口
        // LinkedList 集合底层也是有下标的。
        // 注意: ArrayList 之所以检索效率比较高，不是单纯因为下标的原因；
        // LinkedList 集合照样有下标，但是检索/查找某个元素的时候效率比较低，因为只能从
        // 头节点一个一个遍历。
        List list = new LinkedList();

        list.add("a");
        list.add("b");
        list.add("c");

        // list 接口存在性下标索引
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
