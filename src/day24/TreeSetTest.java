package day24;


import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 向TreeSet中添加的数据，要求是相同类的对象
 * // 不能添加不同类的对象;
 */
public class TreeSetTest {

    //
    @Test
    public void test() {
        // java.lang.ClassCastException 对于 TreeSet 不可以添加不同的类的对象，
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(456);
        set.add(new String("Tom"));

    }

    @Test
    public void test2() {
        TreeSet set = new TreeSet();
        set.add(-1);
        set.add(2);
        set.add(123);

        Iterator iterator = set.iterator();  // 迭代器必须和集合结构保持一致。不然报异常
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
