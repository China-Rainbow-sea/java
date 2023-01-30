package day24;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections 工具类常用的方法：
 * 因为Collections是一个工具类，所以一般方法都是 “静态方法”，可以通过类名直接访问的。
 * reverse(List)  反转List 中元素的顺序
 * shuffle(list)  对List 集合元素进行随机排序
 * sort(list) 根据元素的自然顺序对指定List集合按升序排序
 * sor(List,Comparator) 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序。
 * swap(List,int i ,int j) 将指定 List 集合中的 i 处元素和 j进行交换
 *
 * Object max(Collection) 根据元素的自然排序，返回给定集合中的最大元素。
 * Object max(Collection ,Comparator) 根据Comparator 指定顺序，返回给定集合中的最大
 * Object min(Collection)
 * Object main(Collection, Object) 根据Comparator 指定顺序，返回给定集合中的最小
 * int frequency(Collection,Object) 返回指定集合中指定元素的出现次数
 * void copy(List dest,List src) 将 src 中的内容复制到dest中
 * boolean replaceAll(List list,Object oldVal,Object newVal) 使用新值替换 List 对
 */
public class CollectionsTest {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(123);
        list.add(34);
        list.add(765);
        list.add(-97);
        list.add(0);


        int frequency = Collections.frequency(list, 1);  // 返回集合对应 1出现的下标位置
        System.out.println(frequency);
        System.out.println(list);

        List dest = new ArrayList();
        // Collections.copy(dest,list);  // 拷贝
        /* // 报异常: java.lang.IndexOutOfBoundsException: Source does not fit in dest
        if (srcSize > dest.size())
            throw new IndexOutOfBoundsException("Source does not fit in dest");
         */
        dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,list);  // 拷贝
        System.out.println(dest);

        //Collections 类中提供了多个synchronizedXXX() 方法，
        // 该方法可使将指定集合包装成线程同步的集合，从而可以解决
        // 多线程并发访问集合时的线程安全问题。

        // 返回的List2 即为线程安全的List
        List list2 = Collections.synchronizedList(list);

    }
}
