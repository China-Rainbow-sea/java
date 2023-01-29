package day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * ArrayList 集合:
 *    1. 默认初始化容量 10
 *    2. 集合就是一个Object[] 数组。
 *    3.构造方法:
 *       new ArrayList();
 *       new ArrayList(20);
 *
 *
 *    4. ArrayList 集合底层是数组，怎么优化:
 *      尽可能少的扩容，因为数组扩容效率低，建议在使用 ArrayList集合的时候
 *      预估计元素的个数，给定一个初始化容量
 *    5. 数组的优点:
 *      检索效率比较高。
 *    6.数组的缺点:
 *      随机增删元素效率低
 *      数组无法存储大数据量。(很难找到一个块非常巨大的连续的内存空间)
 *    7. 向数组末尾添加元素，效率高，不受影响
 *    8.面试官经常问的一个问题
 *      这么多的集合中，你用哪个集合最多，
 *      答: ArrayList 集合。
 *      因为往数组末尾添加元素，效率不受影响
 *      另外，我们检索/查找某个元素的操作比较多。
 */
public class ArrayListTest01 {
    @Test
    public void test() {
        List myList = new ArrayList();
        List myList2 = new ArrayList(100);

        // 创建一个HashSet 集合
        Collection collection = new HashSet();
        collection.add(100);
        collection.add(200);
        collection.add(900);
        collection.add(30);

        // 通过这个构造方法就可以将HashSet集合转换成List集合。
        List myList3 = new ArrayList(collection);

        for (int i = 0; i < myList3.size(); i++) {
            System.out.println(myList3.get(i));
        }
    }
}
