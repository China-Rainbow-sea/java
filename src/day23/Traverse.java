package day23;

import org.junit.Test;

import java.util.*;


/**
 * 集合中的遍历
 */
public class Traverse {


    // 实现了Collection 接口的 List 存在下标，可以使用 for()循环，以及迭代器
    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<String>();

        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    // 使用迭代器.注意: 迭代器必须和集合的结构保持一致，同步才行
    @Test
    public void test2() {
        ArrayList<String> list = new ArrayList<String>();

        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 可以修改为 for()循环


        for (Iterator<String> it2 = list.iterator(); it2.hasNext(); ) {
            System.out.println(it2.next());
        }


    }


    // foreach()
    @Test
    public void test3() {
        ArrayList<String> list = new ArrayList<String>();

        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        for(String s : list) {
            System.out.println(s);
        }

    }


    // set 无法没有下标无法访问
    @Test
    public void test4() {
        // 创建对象
        HashSet<String> set = new HashSet<String>();

        // 添加元素
        set.add("abc");
        set.add("def");
        set.add("king");

        // set 集合中的元素不能通过下标取了，没有下标的
        // 迭代器
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("*******************");
        // foreash()
        for(String s : set) {
            System.out.println(s);
        }
    }


    // Map 实现的接口的遍历
    @Test
    public void test5() {
        Map<Integer,String> map = new HashMap<Integer,String>();

        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");

        // 遍历方式一: 先获取所有的key 存储在 Set,Set 实现了Collection接口可以使用迭代器
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry<Integer, String> p = iterator.next();
            System.out.println(p.getKey() + "--->" + p.getValue());  // 获取到对应指针元素的key,和value值
        }

        // 方式二:  通过下标访问对应的 key,和 value 的值
        Set<Integer> integers = map.keySet();  // 获取到 map 集合中所有的key值
        for (int i = 0; i < integers.size(); i++) {
            String s = map.get(i);
            System.out.println(s);
        }

        Set<Map.Entry<Integer, String>> set1 = map.entrySet();
        for( Map.Entry<Integer,String>  s : set1) {
            System.out.println(s.getKey() + "--->" + s.getValue());
        }

    }
}
