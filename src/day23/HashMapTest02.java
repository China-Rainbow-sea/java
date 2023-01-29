package day23;

import org.junit.Test;

import java.util.*;


/**
 * 向Map集合中存，已经Map集合中取，都是先调用key的hashCode()方法(得到哈希值，再经过哈希算法/哈希函数)，
 * 获取到存储数据的数组下标位置，然后再调用equals()方法，equals()方法可能调用，也有可能不调用。
 *   拿put(k,v) 举例，什么时候equals()不会调用
 *      k.hashCode()方法返回哈希值，
 *      哈希值经过哈希算法转换成数组下标
 *      数组下标位置上如果是null,equal()不需要执行。
 *   拿 get(K) 举例,什么时候equals()不会调用
 *     k.hashCode()方法返回哈希值，
 *     哈希值经过哈希算法转换成数组下标。
 *     数组下标位置上如果是null,equals()也是不会被调用的(可以再equals()方法中输出一天语句)
 *
 *     注意: 如果一个类的equals()方法重写了，那么hashCode()方法也必须重写的
 *     并且equals()方法返回如果是true(),hashCode()方法返回的值必须是一样的。
 *     equals()方法返回true表示两个对象相同，再同一个单向链表上比较。
 *     那么对于同一个单向链表上的节点来说，他们的哈希值都是相同的。
 *     所以hashCode()方法的返回值也应该相同。
 *
 *     3.hashCode()方法和equals()方法不用研究了，直接使用IDEA工具生成
 *
 *     4.终极结论:
 *     放在hasMap集合key部分的，以及放在HashSet()集合中的元素，需要同时重写hashCode()方法和equals()方法。
 *
 *     5.用于哈希表数据结构来说:
 *     如果o1和o2的hahs值相同，一定是放到相同一个单向链表上的。
 *     当然如果 o1和o2的hash值不同，但由于哈希算法执行结束之后转换的数组下标可能相同，此时会发生"哈希碰撞"
 *
 *
 */
public class HashMapTest02 {


    @Test
    public void test() {
        Student s1 = new Student("zhangsan",18);
        Student s2 = new Student("zhangsan",18);

        // 重写equals之前是false,调用的是Object中的 equals()方法(比较判断的是地址值)
        System.out.println(s1.equals(s2));

        System.out.println("s1的hasCode: " + s1.hashCode());  // 没有重写hashCode()方法：1440047379
        System.out.println("s2的hasCode:" + s2.hashCode());   // 没有重写hashCode()方法： 343965883
        // 重写以后 -1432604525 hasCode()方法返回的都是一样的。

        // s1.equals(s2) 结果已经是true,表示s1和s2是一样的，相同的，那么由hashSet集合中放的话，
        // 按说只能放进去1个，(HashSet集合特点：无序，不可重复的)
        Set<Student> studentSet = new HashSet<Student>();
        studentSet.add(s1);
        studentSet.add(s2);

        System.out.println(studentSet.size()); //

        // 遍历
        for(Student student : studentSet) {
            System.out.println(student);
        }



    }


    /**
     * HashMap()集合key部分允许null吗
     * HashMap()中的key 和 value值可以为 null,但是 key 也仅仅只能有一 null值
     * 因为 HashMap()是无序，不可重复的
     */
    @Test
    public void test2() {
        Map map = new HashMap();

        // HashMap集合允许key为null
        map.put(null,null);
        System.out.println(map.size());

        // key 重复的话，value()是覆盖
        map.put(null,100);
        System.out.println(map.get(null));  // 获取到对于key值上的value值
        System.out.println(map.size());

        Set set = map.entrySet(); // 获取到Map集合中所有的key和value值
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
