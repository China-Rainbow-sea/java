package day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * 深入Collection 集合的 contains()方法
 * boolean contains(Object o) 判断集合中是否包含某个对象 o
 * 如果包含 返回 true,如果不包含返回 false
 * <p>
 * contains()对象方法是用来判断集合中是否包含某个元素的方法，
 * 那么它在底层是怎么判断集合是否包含某个元素的呢？
 * 调用了 equals()方法进行比对。
 * 而对应自定义的类，必须 重写 equals()方法，如果不重写的话，默认调用的就是
 * Object 中的 equals()方法，比较判断的是 对象的引用的地址。
 * 放在 Collection 集合中的类型，一定要重写 equals()对象方法。
 *
 * 重点:
 *  1. 把集合结构记住
 *  2. 把 Collection 接口中常用的方法记住
 *  3. 把迭代器明白
 *  4. 记住 Collection 集合存储的对象元素必须重写 equals()方法，因为Collection 接口中的 remover()
 *   方法和contains()方法底层校验都必须调用equals()方法，如果没有重写equals()方法，则默认是调用
 *   Object equals()方法比较的是对象引用的地址值。
 */
public class CollectionTest02 {


    @Test
    public void test4() {
        // 创建集合对象
        Collection<String> collection = new ArrayList<String>();
        String s = new String("hello");
        collection.add(s);

        String s1 = new String("hello");

        int size = collection.size();
        System.out.println(size);  // 集合中的元素的个数

        // 对于remover 需要一个判断该删除是数据是否存在集合中，需要调用 equals()对象方法，
        // 所以集合存储的对象中必须重写 equals()方法，不然调用的就是 object 中的equals()方法，比较判断的是对象应用的地址值了
        collection.remove(s1);  // 删除集合中对应的元素内容
        System.out.println(collection.size());  // 0 删除成功。
    }

    /**
     * 对于 基本数据类型的包装类，都重写了 equals()方法了
     * String 也是重写了 equals() 方法的
     */
    @Test
    public void test3() {
        Collection<Integer> collection = new ArrayList<Integer>();

        Integer num  = new Integer(1000);
        collection.add(num);

        Integer num2 = new Integer(1000);

        boolean b = collection.contains(num2);  // 调用的是Integer包装类中重写 equals()的方法
        System.out.println(b);

    }

    @Test
    public void test2() {
        Collection<User> collection = new ArrayList<User>();  // Collection接口,ArrayList()实现类
        User u2 = new User("Tom");
        // 加入到 ArrayList()集合中
        collection.add(u2);
        User u3 = new User("Tom");


        // 判断该集合中是否存在 "Tom"这个对象
        boolean b = collection.contains(u3);  //自定义类没有重写 equals()方法，比较判断是调用的是 Object中的 equals()方法，
        // 比较的是地址，所以这里是 false
        // 重写以后：调用的就是重写以后的 equals()方法了，进行比较了。
        System.out.println(b);


    }

    @Test
    public void test() {
        // 创建集合对象,<String> 泛型限定了存储数据类型的
        Collection<String> collection = new ArrayList<String>(); // Collection 接口,ArrayList实现类(多态)

        String s1 = new String("abc");
        collection.add(s1);

        String s2 = new String("def");
        collection.add(s2);

        System.out.println(collection.size());  // 获取到集合中元素的个数

        // 新建的对象String
        String s3 = new String("abc");

        // collection 集合中是否包含 该 s3 ，存在返回true,不存在返回 false
        boolean contains = collection.contains(s3);  // String 重写了 equals()的判断比较规则
        System.out.println(contains);

    }
}


class User {
    String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }


    /**
     * 重写 equals()对象方法;
     * 将来调用 equals()方法的时候，一定是调用这个重写的 equals()方法
     * 这个equals()方法的比较原理是：只要姓名一样就表示同一个用户。对象。
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

}
