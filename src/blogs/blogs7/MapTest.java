package blogs.blogs7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        // Map 接口 , HashMap实现类，多态,<String,Integer> 泛型
        Map<String,Integer> map = new HashMap<String,Integer>();

        // 添加元素数据:
        map.put("zhangsan",66);
        map.put("lisi",89);
        map.put("wangwu",97);
        map.put("lihua",99);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            // getKey()获取 key 值，getValue()获取value值
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    public static void main4(String[] args) {
        // Map 接口 , HashMap实现类，多态,<String,Integer> 泛型
        Map<String,Integer> map = new HashMap<String,Integer>();

        // 添加元素数据:
        map.put("zhangsan",66);
        map.put("lisi",89);
        map.put("wangwu",97);
        map.put("lihua",99);

        Set<String> keys = map.keySet();  // 返回此集合当中所有的 key 值存储到 Set 集合当中
        for (String s : keys) {
            System.out.println(s);
        }

        System.out.println("****************");
        Collection<Integer> values = map.values();  // 返回此集合当中所有的 value 值存储到 Collection 集合当中
        // Collection 接口集合可以使用迭代器
        Iterator<Integer> iterator = values.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    public static void main3(String[] args) {
        // Map 接口 , HashMap实现类，多态,<String,Integer> 泛型
        Map<String,Integer> map = new HashMap<String,Integer>();

        // 添加元素数据:
        map.put("zhangsan",66);
        map.put("lisi",89);
        map.put("wangwu",97);
        map.put("lihua",99);

        System.out.println(map.get("zhangsan"));  // 获取到对应 key上的 value值
        System.out.println(map.containsKey("zhangsan"));  // 判断该集合当中是否存在 key = zhangsan的键值对
        System.out.println(map.containsValue(99));  // 判断该集合当中是否存在 value = 99的键值对
        System.out.println(map.isEmpty());  // 判断该集合是否为空
        System.out.println(map.equals(map)); //  判断当前map和参数对象 o 是否相等

    }


    public static void main2(String[] args) {
        // Map 接口 , HashMap实现类，多态,<String,Integer> 泛型
        Map<String,Integer> map = new HashMap<String,Integer>();

        // 添加元素数据:
        map.put("zhangsan",66);
        map.put("lisi",89);

        Map<String,Integer> map2 = new HashMap<String,Integer>();
        map2.put("wangwu",97);
        map2.put("lihua",99);

        map.putAll(map2);  // 将 map2 集合中所有的key-value键值对添加到此 map集合当中去
                           // 注意：两者集合存储的元素数据类型必须是一致的才可以添加成功。
        System.out.println(map);
    }

    public static void main1(String[] args) {
        // Map 接口 , HashMap实现类，多态,<String,Integer> 泛型
        Map<String,Integer> map = new HashMap<String,Integer>();

        // 添加元素数据:
        map.put("zhangsan",66);
        map.put("lisi",89);
        map.put("wangwu",97);
        map.put("lihua",99);

        System.out.println(map);
        int size = map.size();  // 返回该集合中存储的键值对的数量。
        System.out.println(size);

        System.out.println("*********************");

        Integer zhangsan = map.remove("zhangsan");  // 移除key = zhangsan的元素数据,并返回该移除的value值。
        System.out.println(zhangsan);
        System.out.println(map);

        map.clear();  // 清空该Map 集合当中的存储的元素数据
        System.out.println(map.size());


    }
}
