package day22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * jdk5.0 之后推出了一个新特性: 叫做增强for()循环，或者叫 foreach()
 * foreach()的缺点: 没有下标，在需要使用下标的循环中，不建议使用增强for()循环。
 */
public class ForEachTest {
    @Test
    public void test() {
        // int 类型数组
        int[] arr = {422,65,54,756,54};

        // 遍历数组
        // 增加for(foreach())
        for(int num : arr) {
            // 数组中的每个元素对象
            System.out.println(num);
        }
    }


    /**
     * 集合中使用 foreach()
     */
    @Test
    public void test2() {
        // String泛型
        List<String> stringList = new ArrayList<>();
        // 添加集合
        stringList.add("hello");
        stringList.add("world");
        stringList.add("kitty!");

        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

        System.out.println("************************************");

        // 使用 foreach()
        for(String s : stringList) {
            System.out.println(s);
        }


        List<Integer> integerList = new ArrayList<>();
        integerList.add(100);
        integerList.add(200);
        integerList.add(300);

        for(Integer I : integerList) {
            System.out.println(I);
        }

    }
}
