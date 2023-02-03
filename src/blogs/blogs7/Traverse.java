package blogs.blogs7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Traverse {

    // Map集合遍历方式四：
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        // 获取到集合当中所有的 value值
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
    }

    // Map 集合遍历方式三：
    public static void main3(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }



    // Map 集合遍历方式二：
    public static void main2(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        // 1. 获取到 Set<Map.Entry> 集合对象
        Set<Map.Entry<String, String>> entries = map.entrySet();

        // 2. 获取到该 Set<Map.Entry> 集合 的迭代器
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        // 3. 通过迭代器遍历，获取到Map.Entry中存储的 key,value值
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }


    // Map 集合遍历方式一:
    public static void main1(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        // 1.获取到该 Map 集合当中的所有 Key 值
        Set<String> keys = map.keySet();

        // 2.遍历所有的 key 值
        for (String key : keys) {
            // 3. 通过 key 获取到对应的 value 值
            System.out.println(key + "--->" + map.get(key));
        }
    }
}
