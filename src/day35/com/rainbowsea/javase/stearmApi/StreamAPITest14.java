package day35.com.rainbowsea.javase.stearmApi;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 终止操作之:收集 Collect
 * 归集: toCollection
 * 以指定的集合类型进行收集
 */
public class StreamAPITest14 {
    public static void main(String[] args) {
        // 注意: ArrayList::new 是构造方法引用
        // 以 ArrayList 集合进行收集
        ArrayList<String> arrayList = Stream.of("zhangsan", "lisi", "李华").collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);

        // 以 LinkedList 集合进行收集
        LinkedList<String> linkedList = Stream.of("zhangsan", "lisi", "李华").collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedList);

        // 以HashSet集合收集
        HashSet<Integer> hashSet = Stream.of(1, 2, 3, 100, 1, 1, 1, 666).collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);

        // 以TreeSet 集合收集
        TreeSet<Integer> treeSet = Stream.of(1, 2, 3, 100, 1, 1, 1, 666).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);


    }
}
