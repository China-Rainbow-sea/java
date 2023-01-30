package day24;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set 接口的框架:
 * |---Collection 接口: 单列集合: 用来存储一个一个的对象。
 *    |---Set接口，存储无序的，不可重复的数据，
 *    |---HashSet 作为Set接口的主要实现类，线程不安全的。
 *    |---LinkedHashSEt 作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历.
 *    |---TreeSet: 可以按照添加对象的指定属性，进行排序。
 */
public class SetTest {
    /**
     * 存储无序的，不可重复的数据
     * 1.无序性: 不等于随机性，存储的数据在底层数组中并非按照数组索引的顺序添加的。
     *        而是根据数据的哈希值决定的。
     *
     * 2.不可重复的，保证添加的元素按照equal()判断时，不能返回 true.
     * 即：相同的元素只能添加一个，
     * 添加元素的过程: 以HashSet 为例:
     *    我们向HashSet中添加元素a,首先调用元素a所在类的hasCode()方法，计算元素a的哈希值
     *    此哈希值，接着通过某种算法计算出在HashSet底层数组中的存放位置(即为：索引位置)，判断
     *    数组此位置上是否已经有元素。
     *          如果此位置上没有其他元素，则元素 a 添加成功。——>情况1
     *          如果此位置上有其他元素(或以链表形式存在的多个元素)
     *             判断:如果 hash值不相同，则元素a添加成功。  ——>情况2
     *                  如果 hash值相同，进而需要调用元素a所在类的equals()方法。
     *                       equals()返回true().元素a添加失败，
     *                       euals()返回 false,则元素添加成功。 ————> 情况3
     *
     *     对于添加成功的情况2和情况3而言，元素a 与已经存在指定索引位置上数据以链表的方式存储。
     *     jdk7: 元素a 存放到数组中，指定原来的元素。
     *     jdk8: 原来的元素在数组中，指向元素1
     *     总结: 七上八下。
     *
     *   底层也是数组，初始容量为16，当如果使用率，超过 0.75，(16* 0.75 = 12)
     *   就会扩大容量为原来的2倍，(16扩容为32 ，依次为64.128等)
     *
     *   HashSet底层: 数组+链表的结构
     *
     *   Set 即可中没有额外定义的方法，使用的都是Collection中声明过的方法。
     *   要求: 向Set中添加的数据，其所在的类一定要重写 equals() 和 hashCode()的方法,因为无可重复性的特点。
     *   要求: 重写的hashCode()和 equal()方法尽可能保持一致性，相等的对象必须具有相等的散列码。
     *   重写两个方法的小技巧：对象中用作 equals()方法比较的 Field,都应该用来计算 hashCode
     *
     *
     */

    @Test
    public void test() {
        Set set = new HashSet();
        set.add(456);
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(129);

        for (Object o : set) {
            System.out.println(o);
        }

    }

    // 无序不代表：随机性，无序指的是存储无序
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(129);

        for (Object o : set) {
            System.out.println(o);
        }
    }


    /**
     * LinkedHashSet的使用
     * LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前后数据
     * // 数据和后一个数据。
     * 优点: 对于频繁的遍历操作,LinkedHashSet效率高于HashSet
     */
    @Test
    public void test3() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));
        set.add(129);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
