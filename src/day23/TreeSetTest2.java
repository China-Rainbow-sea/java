package day23;


import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * TreeSet 集合中元素可排序的第二种方式，使用比较器的方式：
 *  最终结论:
 *    放到 TreeSet 或者 TreeMap 集合 key 部分的元素要想做到排序，包括两种方式()
 *    1.放在集合中的元素实现java.lang.Comparable接口
 *    2.在构造TreeSet 或者 TreeMap集合的时候给它传一个比较器对象
 *
 *   Comparable 和 Comparator 怎么选择
 *   当比较器规则不会改变的时候，或者说当比较规则只有一个的时候，建议使用Comparable接口的方式
 *   如果比较规则有多个，并且需要斗个比较规则之间频繁切换，建议使用Comparator 接口
 *   Comparator接口的设计符合OCP原则。
 */
public class TreeSetTest2 {

    /**
     * TreeSet集合中元素可排序的第二种方式，使用比较器的方式
     */
    @Test
    public void test() {
        // 创建TreeSet 集合的时候，需要使用这个比较器
        // 给构造方法，传递一个构造器
        TreeSet<Vip> treeSet = new TreeSet<Vip>(new Comparator<Vip>() {


            // 升序规则:
            // o1 > o2 返回 > 0
            // o1 < o2 返回 < 0
            // o1 == o2 返回 0
            @Override
            public int compare(Vip o1, Vip o2) {
                if(o1.age == o2.age) {
                    return 0;
                } else if(o1.age > o2.age) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        treeSet.add(new Vip(18));
        treeSet.add(new Vip(8));
        treeSet.add(new Vip(6));

        Iterator<Vip> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Vip next = iterator.next();
            System.out.println(next);
        }
    }


}


class Vip {
    int age;

    public Vip() {
    }

    public Vip(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "age=" + age +
                '}';
    }
}