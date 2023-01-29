package day23;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap集合底层是哈希表/散列表的数据结构
 * 1.哈希表是一个怎样的数据结构
 *   哈希表是一个数组和单向链表的结合体
 *   数组: 在查询方面效率很高，随机增删方面很低
 *   单向链表: 在随机增删方面效率较高，在查询方面效率很低，
 *   哈希将以上两种数据结构融合在一起，充分发挥它们各自的优点。
 * 3.HasMap集合底层的源代码:
 *   public class HashMap {
 *       // HashMap底层实际上就是一个数组(一堆数组)
 *       Node<K,V> table;
 *
 *       // 静态的内部类 HashMap.Node
 *       static class Node<K,V> {
 *           final int hash; // 哈希表(哈希值是 key的hashCode()方法的执行结果，hash值通过哈希函数/算法，得到|)
 *           final K key; // 存储到Map集合中的哪个key
 *           V value;   // 存储到Map集合中的哪个 value
 *           Node<K,V> next // 下一个节点的内存地址
 *       }
 *   }
 *
 *   哈希表/散列表: 一堆数组，这个数组中每个元素是一个单向链表，(数组和链表的结合体)
 *    最主要掌握的是:
 *      map.put(K,V)
 *      v = map.get(K)
 *      以上这两个方法的实现原理，是必须掌握的
 *
 *      HashMap集合的key部分特点:
 *      无序，不可重复。
 *      为什么无序？
 *      无序：因为不一定挂到哪个单链表上，不是连续的存储的
 *      不可重复是怎么保证的
 *      equals（）方法来保证HashMap集合的key不可重复
 *      如果key重复了，value会覆盖。
 *      放在HashMap集合key部分的元素其实就是放到了HashSet集合中了
 *      所以HashSet集合中的元素也需要同时重写hashCode() + equals()方法
 *
 *      6. 哈希表HashMap使用不当时无法发挥性能？
 *      假设将所有的hashCode()方法，返回值固定为某个值，那么会导致底层哈希表变成了
 *      纯单向链表。这种情况下我们称为：散列分别不均匀
 *
 *      什么时散列分布不均匀
 *      假设我们有 100 个元素，10个单向链表，那么每个单向链表上有10个节点，这是最好的，是
 *      散列分布均匀的。
 *
 *      7. 假设将所有的hashCode()方法返回设定为不一样的值，可以吗？，有什么问题：
 *       不行，因为这样的话导致底层哈希表就成为了一维数组，没有链表的概念了。
 *       也是散列分布不均匀。
 *       散列分别均匀与需要你重写的hashCode()方法是有一定的技巧。
 *
 *      8.重点: 放在HashMap集合 key部分的元素，以及放在HashSet集合中的元素，需要同时重写hashCode()和equals()方法
 *      // String 和 Integer 这些包装类都重写了 hashCode()和equals()方法
 *
 *      HashMap集合的默认初始化容量16，默认加载因子是0.75,
 *      这个默认加载因子是当HashMap集合底层数组的容量到达75%，数组开始扩容
 *      重点: 记住：HashMap集合初始化容量必须是2倍数，这也是官方推荐的，
 *      这是因为到达散列均匀，为了提高HashMap集合的存取效率，所必须的。
 *
 */
public class HashMapTest {
    @Test
    public void test() {
        // 测试HashMap()集合key部分的元素特点:
        // Integer 是key，它的hashCode和equals都重写了.
        Map<Integer,String> map = new HashMap<Integer,String>();

        map.put(111,"zhangsan");
        map.put(666,"lisi");
        map.put(999,"wangwu");
        map.put(222,"zhangsan");
        map.put(111,"lihua");  // key重复的时候value会自动覆盖


        System.out.println(map.size());

        // 遍历Map集合
        Set<Map.Entry<Integer, String>> set = map.entrySet(); // 获取到map中的所有的key值和value值

        for(Map.Entry<Integer,String> entry : set) {
            //
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
