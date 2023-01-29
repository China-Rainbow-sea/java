package day23;

import org.junit.Test;

import java.util.*;

/**
 * java.util.Collection 集合接口
 * java.util.Collections 集合工具类，方便集合的操作
 */
public class CollectionsTest {

    @Test
    public void test() {
        // ArrayList 集合不是线程安全的
        List<String> list = new ArrayList<String>();

        // 变成线程安全的
        Collections.synchronizedList(list);

        // 排序
        list.add("abf");
        list.add("sbx");
        list.add("abc");
        list.add("abe");

        // 注意: 对于List集合中元素排序，需要保证 List集合中的元素实现了Comparable接口
        Collections.sort(list);  // 为集合排序
        for(String s : list) {
            System.out.println(s);
        }
    }


    @Test
    public void test2() {
        Set<String> set = new HashSet<>();
        set.add("king");
        set.add("kingsoft");
        set.add("king2");
        set.add("king1");

        // 将Set集合转换成List集合
        List<String> myList = new ArrayList<>(set);
        for(String s : myList) {
            System.out.println(s);
        }
    }

}
