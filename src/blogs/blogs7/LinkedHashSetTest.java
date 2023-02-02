package blogs.blogs7;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(123);
        linkedList.add(456);
        linkedList.add(789);

        // 获取到集合的迭代器，注意迭代器需要和集合结构保持一致性，同步上
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }
}
