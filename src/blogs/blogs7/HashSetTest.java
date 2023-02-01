package blogs.blogs7;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        // 创建 HashSet 对象
        HashSet<Integer> hashSet = new HashSet<Integer>();

        // 添加元素数据
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add(789);

        // 遍历
        Iterator<Integer> iterator = hashSet.iterator();  // 获取该集合的迭代器，需要和集合结构同步
        while(iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }

    }
}
