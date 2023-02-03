package day24;



import org.junit.Test;

import java.util.*;

/**
 * |---Map 双列数据，存储key-value对的数据，---类似于高中的函数.
 *    |-- HashMap 作为Map的主要实现类，线程不安全的，效率高，存储 null的key 和 value
 *      |-- LinkedHashMapTest 保证再遍历map元素时，可以按照添加的顺序实现遍历，
 *           原因: 在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *           对于频繁的遍历操作，此类执行效率高于HashMap
 *    |--TreeMap:保证按照添加的 key-value键值对进行排序，实现排序遍历.此时考虑key的自然排序或定制排序
 *               底层使用红黑树:
 *    |-- Hashtalbe: 作为古老的实现类，线程安全的，效率低,不可以存储 null
 *        |--Properties:
 *
 *    HashMap的底层： 数组 + 链表 (jdk7及之前)
 *                    数组+链表+红黑树(jdk8)
 *
 *    面试题：
 *    1.HashMap的底层实现原理:
 *    2.HashMap 和 Hashtable 的异同？
 *    3.CurrentHashMap 与 Hashtable 的异同
 *
 *    二 Map 的结构的理解:
 *     Map中的 key: 无序的，不可重复的，使用Set存储所有的key,--->key所在的类要重写equals()和hashCode()为例
 *     Map中的value: 无序的，可重复的，使用Collection 存储所有的value--->value所在的类要重写 equals()方法
 *     一个键值对： key-value 构成一个Entry对象。
 *     Map中的entry: 无序的，不可重复的，使用Set存储所有的entry
 *
 *     三: HashMap的底层实现原理？以jdk7为例子说明:
 *        HashMap Map = new HashMap();
 *        在实例化以后，底层创建了长度为 16的一维数组Entry[] table,
 *        ...可能已经执行过多次put...
 *        map.put(key1,value1)
 *        首先，调用 key1所在类的hashCode()计算Key1哈希值，此哈希值经过某种算法计算以后，
 *        得到Entry数组中的存放位置，
 *        如果此位置上的数据为空，此时的Key1-value1添加成功 ——> 情况1
 *        如果此位置上的数据不为空(意味者此位置上存在一个或多个数据(以链表形式存在)，比较key1和已经存在的一个或
 *        多个数据的哈希值)
 *            如果Key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功 ——> 情况2
 *            如果key1的哈希值和已经存在的某一个数据的哈希值相同，继续比较，调用key1所在的类的equals(key2)方法
 *            如果equals()返回false,此时key1-value1添加成功。 ——> 情况3
 *            如果equals()返回 true ,使用value1替换value2
 *
 *        补充: 关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储。
 *
 *        在不断的添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来
 *
 *        jdk8 相较于 jak7 在底层实现方面的不同：
 *        1.new HashMap(),底层没有创建一个长度为 16的数组
 *        2.jdk8 底层的数组是 Node[] ,而非 Entry()
 *        3.首次调用put()方法时，底层创建长度为16的数组。
 *
 *       jdk7 底层结构只有：数组 + 链表，jdk8 中底层结构: 数组 + 链表 + 红黑树
 *         当数组的某一个索引位置上的元素以链表形式存在的数据个数 > 8 且当前数组的长度 > 64时，
 *         此时此索引位置上的所有数据改为使用“红黑树”存储。当小于 8 时，有会变成链表的形式存储.
 *
 *         DEFAULT_INITIAL_CAPACITY ： HashMap的默认容量 16
 *         DEFAULT_LOAD_FACTOR: HashMap 的默认加载因子 0.75
 *         threshold: 扩容的临界值，= 容量*填充因子： 16 * 0.75 => 12
 *         TREFIFY_THRESHOLD: Bucket 中链表长度大于 该默认值。转化为红黑树 8
 *         Min_TREEIFY_CAPACITY 桶中的Node被树化时最小的hash表容量：64
 *
 *
 *     4.LinkedHashMap的底层实现原理(了解)
 *     源码:
 *     static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;  // 能够记录添加的元素的先后顺序。
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *     常用的方法:
 *     添加 put(Object key,Object value)
 *     删除: remove(object key)
 *     修改:put(Object key,Object value)
 *     查询: get(Object key)
 *     长度: size();
 *     遍历: keySet()/values()/entrySet()
 *
 */
public class MapTest {

    /**
     * Hashtable 不可以存储 null
     * HashMap()可以存储 一个null,不可重复的
     */
    @Test
    public void test() {
        Map map = new HashMap();

        // map = new Hashtable();
        map.put(null,null);
    }

    @Test
    public void test2() {
        Map<Integer,String> map = new HashMap<Integer,String>();

        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);


    }

    /**
     * 添加，删除，修改操作:
     * Object put(Object key,Object value) 将指定key-value添加到(或修改)当前map对象中
     * void putAll(Map m) 将m中的所有key-value对存放到当前map中
     * Object remove(Object key) 移除指定Key的 key-value对，并返回value
     * void clear() 清空当前Map 中的所有数据
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        // 添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        map.put("AA",87);

        System.out.println(map);
    }

    @Test
    public void test4() {
        Map map = new HashMap();
        // 添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        System.out.println(map);
        // 修改
        map.put("AA",87);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        // 将 map1集合添加到 map集合中
        map.putAll(map1);
        System.out.println(map);

        // remove(object key),不存在返回null
        Object value = map.remove("CC");
        Object value2 = map.remove("CC3");
        System.out.println(value);
        System.out.println(value2);
        System.out.println(map);

        map.clear(); // 清空 与 map = null 不同
        System.out.println(map.size());
        System.out.println(map);


    }


    /**
     * 元素查询操作
     * object get(object key) 获取指定key对应的value
     * boolean containsKey(Object key) 是否包含指定key
     * boolean containsValue()  是否包含指定的value
     * int size() 返回map中key-value对的个数
     * boolean isEmpty() 判断当前map是否为空
     * boolean equals(object obj) 判断当前map和参数obj是否相等。
     */
    @Test
    public void test5() {
        Map map = new HashMap();

        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);
        // get(key) 通过key获取到对应的value值
        System.out.println(map.get(45));

        // containsKey() 判断对应的key是否存在
        boolean b2 = map.containsKey("BB");
        System.out.println(b2);

        // containsValue() 判断对应的value值是否存在
        boolean b3 = map.containsValue(123);
        System.out.println(b3);

        map.clear();
        System.out.println(map.isEmpty()); // 判断map是否为空


    }

    @Test
    public void test6() {
        Map map = new HashMap();

        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        // 遍历所有的Key集： keySet()
        Set set = map.keySet();  // 返回该map 所有的 key值，被Set集合存储者

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o + "---->" + map.get(o));
        }

        // 遍历所有的value集 values()
        Collection values = map.values();  // 返回该map所有的value值，被Collection存储
        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println("****************************");
        // 遍历所有的key-value值
        // entrySet()
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()) {
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        // 方式二:
    }
}
