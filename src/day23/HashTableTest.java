package day23;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Hashtable的使用
 * Hashtable方法都带有synchronized 同步方法,线程安全的，效率低，
 * 线程安全有其他的方法，这个HashTable对线程的处理导致效率低，使用较少了。
 *
 * Hashtable和HashMap 一样，底层都是哈希表的数据结构
 * Hashtable 的初始容量为 11，默认加载因子是 : 0.75
 * Hashtable 的扩容： 原容量 * 2 + 1;
 */
public class HashTableTest {

    /**
     * HashTable()集合中的 key 和value都是不可以为null的
     * HashMap()集合的key 和 value都是可以为 null的，但是 key 也仅仅只能是一个为null,因为
     * HashMap()是无序，不可重复的。
     * HashTable()方法都带有synchronized ,线程安全的。
     */
    @Test
    public void test() {
        Map map = new Hashtable();

        // map.put(null,"123");  // java.lang.NullPointerException
        map.put(123,null);   // java.lang.NullPointerException


    }
}
