package day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List 集合的使用
 * 1.List 集合存储元素特点: 有序可重复。
 * 2.有序: List 集合中的元素有下标
 * 3.从0开始，以1递增，可重复；存储一个1，还可以再存储1.
 *
 * 从List既然是 Collection 接口的子接口，那么肯定List接口有自己“特色”的方法，
 * 以下只列出 List 接口特有的常用的方法:
 *   void add(int index,object element)
 *   E get(int index)
 *   int indexOf(Object o)
 *   int lastIndexOf(Object o)
 *   E remove(int index)
 *   E set(int index, E element)
 *   List 接口是实现了 Collection 接口的
 *
 *
 */
public class ListTest01 {

    @Test
    public void test2() {
        List<String> myList = new ArrayList<String>();

        // 添加元素:
        myList.add("a");
        myList.add("a");
        myList.add("a");
        myList.add("a");
        myList.add("a");
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");

        // 获取指定对象第一次出现处的索引下标
        int index = myList.indexOf("a");
        System.out.println(index);  // 获取


        // 获取指定对象最后一次出现处的索引
        int index1 = myList.lastIndexOf("a");
        System.out.println(index1);


        // 删除指定下标位置的元素: 对于List ArrayList 效率低
        // 删除下标为 7 的元素
        myList.remove(7);
        for(String s : myList) {
            System.out.println(s);
        }
    }


    @Test
    public void test() {
        List<String> myList = new ArrayList<String>();

        // 添加元素:
        myList.add("a");
        myList.add("b");
        myList.add("c");
        myList.add("d");

        // 在列表的指定位置插入指定元素(第一个参数是下标)
        // 这个方法使用不多，因为对于ArrayList集合来说效率比较低
        myList.add(1,"hello");  // 在指定的下标位置添加元素内容

        // 迭代遍历
        Iterator<String> iterator = myList.iterator(); // 注意: 迭代器要和集合结构一致同步(集合改变了迭代器也要改变)

        while(iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

        // 根据下标获取集合中的元素的内容
        String s2 = myList.get(1);
        System.out.println(s2);
        // 因为有下标，所以List 集合有自己比较特殊的遍历方式:
        // 通过下标遍历，List集合特有的方式，Set 没有下标是没有的
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // 或者使用 foreach()循环
        for(String s : myList) {
            System.out.println(s);
        }

    }

}
