package blogs.blogs7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        updateList2(list);   // 判断的是 int 类型的下标
        for (Object o : list) {
            System.out.println(o);
        }

       /* System.out.println("**************************");

        updateList2(list); // 判断的是 Object 引用数据类型的内容值
        for (Object o : list) {
            System.out.println(o);
        }*/
    }


    public static void updateList(List list) {
        list.remove(2);  // 注意这里移除的对于下标索引位置上的元素的数据
    }

    public static void updateList2(List list) {
        list.remove(new Integer(2));  // 这里移除的是比较同以内容的元素数据。
        // 需要重写 equals()方法
    }


    public static void main2(String[] args) {
        // List 接口，ArrayList 实现类，<Integer> 泛型限定了该集合存储类型
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(456);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(789);
        list2.add(999);

        boolean b = list.addAll(0, list2);
        System.out.println(b);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    public static void main1(String[] args) {
        // List 接口，ArrayList 实现类，<Integer> 泛型限定了该集合存储类型
        List<Integer> list = new ArrayList<Integer>();
        list.add(123);
        list.add(456);
        list.add(123);

        list.add(0,999);  // 在0号下标添加 999
        System.out.println(list.get(0));

        System.out.println(list.indexOf(999));  // 获取该 999 元素数据在集合中首次出现的下标位置。
        System.out.println(list.lastIndexOf(123));   // 获取该 123元素数据在集合中首次出现的下标位置。

        System.out.println(list.remove(1));   // 移除该下标上的元素数据，并返回该元素数据内容

        System.out.println(list);
        System.out.println(list.set(0, 999999));  // 为指向下标位置上修改元素数据内容，并返回修改前的数值内容

        System.out.println(list);


    }
}
