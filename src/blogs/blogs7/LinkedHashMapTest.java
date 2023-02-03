package blogs.blogs7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        // 创建 LinkedHashMap 集合对象
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<String, Integer>();

        // 添加元素数据(键值对)
        linkedHashMap.put("lihua",99);
        linkedHashMap.put("zhangsan",89);
        linkedHashMap.put("lisi",79);
        linkedHashMap.put("wangwu",69);

        // 遍历 LinkedHashMap 集合
        // 获取到key-value 存储的 Set Entry 内部类集合对象
        Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
        // 获取到该 Set Entry 内部类集合的迭代器
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }
}
