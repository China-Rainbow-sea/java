package blogs.blogs7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        // 多态: Collection 接口，ArrayList 该接口的实现类
        // <Integer> 泛型限定了集合可以存储的数据类型
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(123);
        collection.add(456);
        collection.add(789);

        Collection<Integer> collection2 = new ArrayList<Integer>();
        collection2.add(123);
        collection2.add(456);
        collection2.add(789);

        boolean b = collection.containsAll(collection2);  // 判断两个集合的存储的内容是否完全相同
        System.out.println(b);


    }




    public static void main6(String[] args) {
        // 多态: Collection 接口，ArrayList 该接口的实现类
        // <Integer> 泛型限定了集合可以存储的数据类型
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(123);
        collection.add(456);
        collection.add(789);
        System.out.println(collection);

        Collection<Integer> collection2 = new ArrayList<Integer>();
        collection2.add(789);

        boolean b = collection.retainAll(collection2);
        System.out.println(b);
        System.out.println(collection);
    }


    public static void main5(String[] args) {
        // 多态: Collection 接口，ArrayList 该接口的实现类
        // <Integer> 泛型限定了集合可以存储的数据类型
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(123);
        collection.add(456);
        collection.add(789);
        System.out.println(collection);

        Collection<Integer> collection2 = new ArrayList<Integer>();
        collection2.add(456);
        boolean b = collection.removeAll(collection2);  // 移除该集合包含 collection2元素数据。成功返回 true,失败返回false
        System.out.println(collection);
    }


    public static void main4(String[] args) {
        // 多态: Collection 接口，ArrayList 该接口的实现类
        // <Integer> 泛型限定了集合可以存储的数据类型
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(123);
        collection.add(456);
        System.out.println(collection);

        Collection<Integer> collection2 = new ArrayList<Integer>();
        collection2.add(789);
        collection2.add(101112);

        collection.addAll(collection2);
        System.out.println(collection);
    }

    public static void main3(String[] args) {
        // 多态: Collection 接口，ArrayList 该接口的实现类
        // <Integer> 泛型限定了集合可以存储的数据类型
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(123);
        collection.add(456);
        collection.add(789);

        System.out.println(collection);
        collection.remove(456);  // 移除该集合中的 456 的内容，integer包装类已经重写了 equals()方法
        System.out.println(collection);

        int hashCode = collection.hashCode();  // 返回该集合的哈希码值。哈希码值集合存储的类型也是要重写的
        System.out.println(hashCode);

        Object[] array = collection.toArray();  // 将该集合转换成Object 数组。
        System.out.println(Arrays.toString(array));

        boolean b1 = collection.contains(123);  // 判断该集合是否存在 123该参数内容，注意需要重写 equals()方法的
        System.out.println(b1);  // 存在返回 true,不存在返回 false;

        boolean b2 = collection.contains(456);
        System.out.println(b2);

    }


    public static void main2(String[] args) {
        // 多态: Collection 接口，ArrayList 该接口的实现类
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(123);
        collection.add(456);
        collection.add(789);
        System.out.println(collection.size());  // 返回集合实际存储的元素个数
        System.out.println(collection.isEmpty());  // 判断该集合是否为空，是返回 true,不是返回 false

    }


    public static void main1(String[] args) {
        Collection collection = new ArrayList();

        // 添加元素
        // 注意集合存储的是引用类型的地址值，不可以存储基本数据类型
        collection.add(123);  // 自动装箱为 Integer包装类
        collection.add(456);
        collection.add("A");
        collection.add(3.14);
        collection.add(true);
        collection.add(new Person2("Tom",19));

        int size = collection.size();  // 返回该集合实际存储的元素的个数，不是集合的容量
        System.out.println(size);

        boolean b1 = collection.isEmpty();  // 判断该集合是否为空，为空返回 true,不为空返回 fasle
        System.out.println(b1);

        collection.clear();  // 清空该集合中的元素数据
        boolean b2 = collection.isEmpty();
        System.out.println(b2);
    }
}


class Person2 {
    String name;
    int age;

    public Person2(){

    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
