package blogs.blog8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericTest2 {
    // Map 集合中使用泛型存取数据
    public static void main(String[] args) {
        // 使用泛型<String,Integer> 限定 Map 集合存储的类型对象
        // 注意：泛型中只能存储引用类型的，基本数据类型不可以(int,double)
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 99);
        map.put("李华", 89);
        map.put("张三", 79);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());

        }
    }


    // Set 集合中使用泛型存取数据
    public static void main2(String[] args) {
        // 使用泛型<Integer> 限定Set 集合存储的类型对象
        // 注意：泛型中只能存储引用类型的，基本数据类型不可以(int,double)
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }


    // List 集合中使用泛型存取数据
    public static void main1(String[] args) {
        // 使用泛型<String> 限定 List 集合存储的类型对象，
        // 注意：泛型中只能存储引用类型的，基本数据类型不可以(int,double)
        List<String> list = new ArrayList<>();

        list.add("Tom");
        list.add("李华");
        list.add("张三");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }


    }
}
