package day23;


import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet 集合:
 * 无序不可重复
 */
public class HashSetTest {
    @Test
    public void test() {
        // HashSet 集合特点:
        // 泛型限定存储的数据类型
        Set<String> strs = new HashSet<String>();

        // 添加元素
        strs.add("hello3");
        strs.add("hello2");
        strs.add("hello1");
        strs.add("hello2");

        //迭代器遍历
        Iterator<String> iterator = strs.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

    }
}
