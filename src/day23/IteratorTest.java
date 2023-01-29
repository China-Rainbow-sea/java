package day23;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * IteratorTest 使用的注意事项
 * 当集合中的结构发生了改变时，其中定义的迭代器也要发生改变，及时更新，
 * 必须要保持，迭代器的和集合是同步的。不然会报异常： 就像git 中的 远程仓库 与 本地仓库同步一致。
 *
 */
public class IteratorTest {

    @Test
    public void test2() {
        Collection<Integer> collection = new ArrayList<Integer>(); // Collection接口，ArrayList实现类

        collection.add(1);
        collection.add(2);
        collection.add(3);

        // 创建迭代器
        Iterator<Integer> iterator = collection.iterator();
       /* while(iterator.hasNext()) {
            Integer next = iterator.next();
            // 删除元素
            collection.remove(1);  // 注意这里会报错: 因为集合的结构发生了改变，而迭代器中存储的还是没有发生改变的集合
            // 出现 迭代器 与 集合中的内容不一致的异常错误。
            // 删除元素之后，集合的结构发生了变化，应该重新去获取迭代器，
            // 但是，循环下一次的时候，并没有重新获取迭代器，所以会出现异常。
            System.out.println(next);
        }*/

        // 修改: 调用 iterator.remove()中的删除元素。
        while(iterator.hasNext()) {
            Integer num = iterator.next();

            // 使用迭代器来删除可以
            iterator.remove();  // 删除当前迭代器指向的当前元素，会自动更新迭代器，并且更新集合(删除集合中的元素)
            System.out.println(num);
        }

        System.out.println(collection.size());

    }

    @Test
    public void test() {
        // 创建集合对象
        Collection<Integer> collection = new ArrayList<Integer>();
        // 注意: 此时获取的迭代器，指向的是集合中没有元素状态下的迭代器
        // 一定要注意: 集合结果只要发生改变，迭代器必须重新获取。
        // java.util.ConcurrentModificationException 使用这时未添加元素的 迭代器，其中时报异常
        // 因为这时候的迭代器中并没有元素数据，因为这时候迭代器临时拷贝的是集合中未添加元素的集合
        // 导致的错误
        Iterator<Integer> iterator = collection.iterator();  // java.util.ConcurrentModificationException

        // 添加元素
        collection.add(1);
        collection.add(2);
        collection.add(3);

        // 这里定义一个集合修改后完后，创建的迭代器
        iterator = collection.iterator();

        while(iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }

    }


}
