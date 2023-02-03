package blogs.blogs7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> src = new ArrayList<Integer>();
        src.add(1);
        src.add(99);
        src.add(-1);
        src.add(66);

        // 创建一个 和 src 集合存储类型一样的  Arrays.asList(new Integer[src.size()])数组，并设置该数组的大小长度为 src.size()
        // 再使用这个数组创建拷贝存储的 desc 集合对象，默认数组没有添加数据(这里的是 null)
        // 这样就 desc 就拥有了一个和 sec集合一样大小的 size()长度了。
        List<Integer> desc = new ArrayList<Integer>();
        desc = Arrays.asList(new Integer[src.size()]);
        for (Integer integer : desc) {
            System.out.println(integer);
        }

        // copy()拷贝
        Collections.copy(desc, src);

        System.out.println("***********  拷贝  ************");
        for (Integer num : desc) {
            System.out.println(num);
        }
    }
}
