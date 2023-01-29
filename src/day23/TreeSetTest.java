package day23;


import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet 集合存储元素的特点:
 *   1. 无序不可重复的，但是存储的元素可以自动按照大小顺序排序，自然排序，升序
 *   称为：可排序集合。
 *
 *   TreeSet 集合底层实际上是一个TreeMap
 *   TreeMap 集合底层是一个二叉树
 *   放到TreeSet 集合中的元素，等同于放倒是 TreeMap集合key部分了。
 *   TreeSet集合中的元素: 无序不可重复，但是可以按照元素的大小自动排序，默认是升序的。
 *
 *
 */
public class TreeSetTest {
    @Test
    public void test() {
        // <String> 泛型限定存储的数据类型
        Set<String> strs = new TreeSet<String>(); // Set 接口，TreeSet 实现类。多态

        // 添加元素
        strs.add("A");
        strs.add("D");
        strs.add("F");
        strs.add("B");
        strs.add("C");

        // 遍历 迭代器遍历
        Iterator<String> iterator = strs.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("***************************************");
        // foreach()遍历

        for(String s : strs) {
            System.out.println(s);
        }


    }



    @Test
    public void test2() {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(100);
        treeSet.add(300);
        treeSet.add(90);
        treeSet.add(900);
        treeSet.add(100);

        for(Integer integer : treeSet) {
            System.out.println(integer);
        }
    }


    /**
     * java.lang.ClassCastException: day23.Person cannot be cast to java.lang.Comparable
     * 报上述异常是因为: TreeSet默认是会排序的，如果你存放的类型没有实现 java.lang.Comparable接口中的
     * 抽象方法是会报异常的
     */
    @Test
    public void test3() {
        TreeSet<Person> treeSet = new TreeSet<Person>();
        Person p1 = new Person(34);
        Person p2 = new Person(24);
        Person p3 = new Person(18);
        Person p4 = new Person(19);

        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);

        // 遍历
        Iterator<Person> iterator = treeSet.iterator();

        while(iterator.hasNext()) {
            Person p = iterator.next();
            System.out.println(p);
        }
    }
}

/**
 * 放在TreeSet集合中的元素需要实现 java.lang.Comparable接口，
 * 并且实现compareTo()抽象方法,equals()方法可以不写
 */
class Person implements Comparable<Person>{
    int age;

    public Person() {

    }

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // 需要在这个方法中编写比较的逻辑，或者说比较的规则，按照什么进行比较
    // k.compareTo(t.key)
    // 拿参数k和集合中的每一个 k 进行比较，返回值可能是 > 0 , < 0  ,== 0的
    // 升序；比较规则
    // this > 参数 ，返回 >0
    // this < 参数， 返回 < 0
    // this == 参数，返回 0
    @Override
    public int compareTo(Person o) {
        // this 和 o 比较的
        if(this.age == o.age) {
            return 0;
        } else if(this.age > o.age) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
