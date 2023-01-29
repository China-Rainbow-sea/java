package day23;


import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * java.util.Map 接口中常用的方法:
 * 1.Map 和 Collection 没有继承关系
 * 2.Map集合以 Key 和 Value 的方式存储数据: 键值对
 *   key 和 value 都是引用数据类型
 *   key 和 value 都是存储对象的内存地址，
 *   key 起到主导的地位，value是 key 的一个附属品.
 * 3.Map 接口中常用的方法:
 *   void clear() 清空Map 集合
 *   boolean containKey(object key)  判断该 value值是否存在
 *   boolean containValue(object value) 判断该 value值是否存在
 *   v get(object key) 通过 key 获取到对应的 value值
 *   boolean isEmpty() 判断该 Map 集合是否为空
 *   Set<K> keySet() 获取到Map集合中所有的key 值(所有的键是一个 set 集合)
 *   V put(key, value) 添加对应的键值对
 *   V remove(Object key) 移除对应 key中的元素
 *   int size();   // 获取 Map 集合中键值对的个数。
 *   Collection<V> value() 获取Map集合之哦个你所有的 value,返回一个Collection
 *   Set<Map.Entry<K,V>> entrySet() 将 Map集合转换成 Set集合
 *   假设现在有一个 Map集合 ，如下所示:
 *     map1 集合对象
 *     key               value
 *     1                 zhangsan
 *     2                 lisi
 *     3                 wangwu
 *     4                 zhaoliu
 *
 *     Set set = mop1.entrySet();
 *     set 集合对象
 *     1=zhangsan
 *     2=lisi
 *     3=wangwu
 *     4=zhaoliu
 *     注意: Map集合通过entrySet()对象方法，转换成这个Set集合，Set集合中元素的类型是Map.Entry<K,V>
 *         Map.Entry 和String一样，都是一种类型的名字，只不过：Map.Entry是静态的内部类。
 *         是Map中的静态内部类
 *
 */
public class MapTest {
    @Test
    public void test() {
        // 创建 Map集合对象
        Map<Integer,String> map = new HashMap<Integer,String>();

        // 向Map集合中添加键值对
        map.put(1,"zhangsan");   // 1在这里进行自动装箱操作
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"xiaoliu");

        // 通过 key 获取到对应的 value 值
        String s = map.get(2);
        System.out.println(s);


        // 获取到键值对的数量
        System.out.println(map.size());

        // 通过 key 删除 key-value
        map.remove(2);
        System.out.println(map.size());

        // 注意: contains 方法底层调用的都是equals进行比对的，所以对于自定类的类型需要重写 equals方法()

        // 判断是否包含某个 key 值
        boolean b = map.containsKey(2);
        System.out.println(b);

        boolean b3 = map.containsKey(new Integer(1));
        System.out.println(b3);

        // 判断是否包含某个value
        boolean b2 = map.containsValue("xiaoliu");
        System.out.println(b2);

        // 清空 Map 集合
        map.clear();
        System.out.println(map.size());

        // 判断该Map集合是否为空
        System.out.println(map.isEmpty());
    }


    /**
     * Map 集合的遍历
     */
    @Test
    public void test2() {

        Map<Integer,String> map = new HashMap<Integer,String>();

        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");

        // 方式一: 获取所有的key,通过遍历 key,来遍历 value
        // 获取到所有的 key 值，key是通过 Set 集合存储，该Set 接口实现 Collection接口可以使用迭代器，但没有下标
        // 再通过 key 获取到对应的 get()对象方法获取到 value 值
        Set<Integer> set = map.keySet();
        // 迭代器，遍历,
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(map.get(next));
        }


        System.out.println("*******************************");

        // 方式二: 使用 foreach() 增强for()循环
        // 同样需要获取到 map 所有的 key 值
        // 再通过 key 获取到对应的 value 值
        Set<Integer> set2 = map.keySet();
        for(Integer key : set2) {
            System.out.println(map.get(key));
        }


        // 第三中方式: Set<Map.Entry<k,v> entrySet()
        // 以上这个方法是把 map集合直接全部转换成 Set集合
        // set集合中元素的类型是 Map.Entry
        // 这种方式效率比较高，因为获取key和value都是从node对象中获取的属性值，
        // 这种方式比较适合比较大的数据量。
        /*
         static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
         */
        Set<Map.Entry<Integer,String>> set3 = map.entrySet();
        // 迭代器遍历
        Iterator<Map.Entry<Integer, String>> iterator2 = set3.iterator();

        while(iterator2.hasNext()) {
            Map.Entry<Integer, String> node = iterator2.next();
            Integer key = node.getKey();  // 获取到对应指针所在的 key 值
            String value = node.getValue(); // 获取到对应指针所在的 value值

            System.out.println(key + "--->" + value);
        }

        System.out.println("*****************************");
        // 也可以使用 foreach()循环
        //
        for(Map.Entry<Integer,String> node : set3) {
            System.out.println(node.getKey() + "--->" + node.getValue());
        }
    }
}
