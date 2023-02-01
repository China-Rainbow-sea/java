package blogs.blogs7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        // Collection 接口，ArrayList 实现类
        Collection collection = new ArrayList();

        // 添加元素
        collection.add("abc");
        collection.add("def");
        collection.add(100);
        collection.add(new Object());

        Iterator iterator = collection.iterator();

        while (iterator.next() != null) {  // 注意: 这里 iterator.next()已经向下移动了
            System.out.println(iterator.next()); // 这里又向下移动了，可能后面就没有元素了。报异常
        }
    }


    public static void main3(String[] args) {
        // Collection 接口，ArrayList 实现类
        Collection collection = new ArrayList();

        // 添加元素
        collection.add("abc");
        collection.add("def");
        collection.add(100);
        collection.add(new Object());


        // 获取到该集合操作完之后的迭代器
        Iterator iterator = collection.iterator();

        while(iterator.hasNext()) {  // 判断该集合后面是否有数据有，返回true,没有返回 false
            Object o = iterator.next();
            if("abc".equals(o)) {
                iterator.remove();  // 删除当前迭代器所指向的元素数据。
            }
            System.out.println(o);
        }

    }


    public static void main2(String[] args) {
        // Collection 接口，ArrayList 实现类
        Collection collection = new ArrayList();

        // 获取到该接口集合的 迭代器对象:
        // 注意了，这时候我们获取到的是当前集合没有添加元素的迭代器。
        Iterator iterator = collection.iterator();

        // 添加元素
        collection.add("abc");
        collection.add("def");
        collection.add(100);
        collection.add(new Object());

        // 注意这里我们使用的是，集合没有添加元素时的迭代器，存在问题:
        // 集合在生成的迭代器后面，添加了元素数据，集合发生了改变，而迭代器没有改变
        // 迭代器和集合没有保持一致性，会出问题。
        while(iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println(o);
        }

    }


    public static void main1(String[] args) {
        // Collection 接口，ArrayList 实现类
        Collection collection = new ArrayList();
        // 添加元素
        collection.add("abc");
        collection.add("def");
        collection.add(100);
        collection.add(new Object());

        // 获取到该接口集合的 迭代器对象:
        Iterator iterator = collection.iterator();

        while(iterator.hasNext()) {  // hasNext()判断该迭代器后面是否含有元素数据存储，有返回 true,没有返回fasle
            Object o = iterator.next();  // next()获取到给迭代器所指向的位置上存储的元素数据，并向下移动该迭代器。
            System.out.println(o);
        }
    }
}
