package day24;


import org.junit.Test;

import java.util.*;

/**
 * 向TreeMap中添加key-value,要求key必须是由同一个类创建的对象。
 * 因为要按照key进行排序，自然排序，定制排序
 * TreeMap 默认会排序，升序排序，其中需要排序的话，其存放的类型必须都是一致的，不一致无法比较，更无法排序；；了
 * 报异常
 */
public class TreeMapTest {


    // 对应存储的类，实现 Comparable接口重写 compareTo()重写方法
    //  TreeMap 默认会排序，升序排序，其中需要排序的话，其存放的类型必须都是一致的，不一致无法比较，更无法排序；；了
    // * 报异常
    @Test
    public void test() {
        TreeMap map = new TreeMap();
        map.put("123", 123);
        map.put(123, 123);

    }

    /**
     * TreeMap 存储的对象必须要有一个可以比较的排序，实现Comparable接口并重写 CompareTo()方法，或者构造器传入定制排序
     */
    @Test
    public void test2() {
        TreeMap<User,Integer> map = new TreeMap<User,Integer>();
        User u1 = new User("Tom",18);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",23);
        User u4 = new User("Rose",20);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set<Map.Entry<User, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<User, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<User, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }



    // 构造器传入匿名的定制排序
    @Test
    public void test3() {
        TreeMap<User,Integer> map = new TreeMap<User,Integer>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getAge(),o2.getAge());  // 默认升序，直接掉Integer已经重写的compare()方法
            }
        });

        User u1 = new User("Tom",18);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",23);
        User u4 = new User("Rose",20);

        map.put(u1,98);
        map.put(u2,89);
        map.put(u3,76);
        map.put(u4,100);

        Set<Map.Entry<User, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<User, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<User, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }

    @Test
    public void test7() {

    }

}


class User implements Comparable<User>{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    // 升序规则：
    // this > 参数 返回 >0
    // this < 参数 返回 < 0
    // this = 参数 返回 == 0
    @Override
    public int compareTo(User u) {
        if (this.age > u.age) {
            return 1;
        } else if (this.age < u.age) {
            return -1;
        } else {
            return 0;
        }
    }
}