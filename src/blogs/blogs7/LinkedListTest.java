package blogs.blogs7;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(123);
        linkedList.add(456);
        linkedList.add(789);

        for (Integer integer : linkedList) {
            System.out.println(integer);
        }

        System.out.println("******************");

        linkedList.addFirst(000); // 在该 LinkedList 集合的首节点添加元素数据
        linkedList.addLast(999);  // 在该 LinkedList 集合的尾节点添加元素数据

        System.out.println(linkedList.getFirst()); // 获取到该 LinkedList 集合的首节点的元素数据
        System.out.println(linkedList.getLast());  // 获取到该 LinkedList 集合的尾节点的元素数据

        System.out.println("******************");
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        System.out.println("******************");

        linkedList.removeFirst(); // 删除该 LinkedList 集合首节点的元素数据
        linkedList.removeLast();  // 删除该 LinkedList 集合尾节点的元素数据

        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
    }
}
