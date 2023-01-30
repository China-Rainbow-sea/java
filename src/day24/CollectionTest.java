package day24;


import org.junit.Test;

import java.sql.Connection;
import java.util.*;

/**
 * 集合框架的概述:
 * 1. 集合，数组都是对多个数据进行存储操作的结构
 * 2. 说明，此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储(.txt,.jpg,avi,数据库中)
 *
 * 2.1 数组在存储多个数据方面的特点：
 *    > 一旦初始化以后，其长度就确定了。
 *    > 数组一旦定义好，其元素的类型也就确定了，我们也就只能操作指定类型的数据了。
 *    比如: String[] arr, int[] arr, Object[] arr
 *    数组在存储多个数据方面的缺点:
 *     > 一旦初始化以后，其长度就不可修改。
 *     > 数组中提供的方法非常有限，对于添加，删除，插入数据等操作，非常不便，同时效率不高。
 *     > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用。
 *     > 数组存储数据的特点: 有序，可重复，对于无序，不可重复的需求，不能满足。
 *
 *     java 集合可分为 Collection 和 Map 两种体系
 *     > Collection 接口: 单列数据，定义了存取一组对象的方法的集合。
 *     > List 元素有序，可重复的集合。
 *     > Set 元素无序，不可重复的集合。
 *     > Map 接口，双列数据，保存具有映射关系 “key-value对”的集合。
 *
 *
 *     集合框架:
 *     |---Collection 接口: 单列集合，用来存储一个一个的对象，
 *         |--- List 接口: 存储有序的，可重复的数据
 *         |--- Set 接口: 存储无序的，不可重复的数据，
 *     |---Map 接口: 双列集合，用来存储一对(key-value) 一对的数据
 *
 *     注意: 集合存储的是对于对象的引用的地址。
 */

public class CollectionTest {
    /**
     * Collection 接口中声明的方法的测试:
     * 结论:
     *  向 Collection 接口的实现类的对象中添加数据Object 时，
     *  要求Object 所在类型要重写equals()方法，因为涉及到其中的
     *  contains()查询，remove()移除的比较判断的规则。
     */


    @Test
    public void test() {
        Collection collection = new ArrayList();  // Collection 接口，ArrayList 实现类

        collection.add("AA");
        collection.add("BB");
        collection.add(123);  // 自动装箱
        collection.add(new Date());

        // size()：获取添加的元素的个数。
        System.out.println(collection.size());

        // addAll(): 将coll集合中的元素添加到当前的集合中
        Collection coll = new ArrayList();
        coll.add(456);
        coll.add("CC");

        collection.addAll(coll);
        System.out.println(collection.size());

        for(Object o : collection) {
            System.out.println(o);
        }

        // isEmpty(): 判断当前集合是否为空,为空，返回true,不为空返回 fasle
        System.out.println(collection.isEmpty());  //

        // clear(): 清空集合元素，不是 collection = null 的方式清空的
        collection.clear();
        System.out.println(collection.isEmpty());
    }


    @Test
    public void test2() {
        Collection coll = new ArrayList(); // Collection 接口，ArrayList 实现类,多态

        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",18));

        // contains(Object o): 判断当前集合中是否包含Obj
        boolean b = coll.contains(123);
        System.out.println(b);
        System.out.println(coll.contains(new String("Tom")));  // true

        boolean b2 = coll.contains(new Person("Jerry", 18));  // false
        System.out.println(b2);

        // 2. containsAll(collection coll) 判断形参coll中的所有元素是否都存在于当前集合中.
        Collection collection = Arrays.asList(123,456);
        boolean b3 = coll.containsAll(collection);  // true
        System.out.println(b3);
    }


    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",18));

        // remove(Object o) 移除对应元素内容的节点
        coll.remove(12);
        coll.remove(123);

        for(Object o : coll) {
            System.out.println(o);
        }

        // removeAll(Collection coll) 从当前集合中移除 coll 中所有的元素
        Collection collection = Arrays.asList(123,456,99);
        coll.removeAll(collection);

        System.out.println("******************");
        for(Object o: coll) {
            System.out.println(o);
        }
    }


    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",18));

        // retainAll(Collection coll) : 交集: 获取当前集合和coll结合的交集，并返回给当前的集合
        Collection collection = Arrays.asList(123,456,789);
        coll.retainAll(collection);
        for(Object o : coll) {
            System.out.println(o);
        }


    }


    @Test
    public void test6() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",18));


        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(new String("Tom"));
        coll2.add(false);
        coll2.add(new Person("Jerry",18));

        // equals(object obj): 注意想要返回true，需要当前集合和形参结合的元素都相同，同时集合所存储的对象都重写了equals()方法
        boolean b = coll.equals(coll2);
        System.out.println(b);


        // hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());


        // 8. 集合 ---> 数组 toArray()
        Object[] array = coll.toArray();

        System.out.println("********************");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("*******************");

        // 9. 数组 ---> 集合（调用Arrays 类的静态方法asList()）
        List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});
        for (String s : list) {
            System.out.println(s);
        }


        List<Integer> list1 = Arrays.asList(123, 456);
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        System.out.println("************");

        List<int[]> arrs = Arrays.asList(new int[]{789, 123});
        for (int[] arr : arrs) {
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }




}


class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name,int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
