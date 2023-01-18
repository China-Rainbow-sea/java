package day21;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 定制排序: java.util.Comparator
 * 1.当元素的类型没有实现java.lang.Comparable 接口而又不方便修改代码.
 * 或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以
 * 使用Comparator 的对象来排序，强行对多个对象进行整体排序的比较
 * 2.重写compare(Object o1,Object o2) 方法，比较o1 和 o2 的大小，如果方法返回正整数
 * 则表示 o1 大于 o2 ，如果返回 0 ，表示相等, 返回 负整数，表示 o1 小于 o2
 * 3. 可以将Comparator 传递给 sort 方法 如:Collections sort 或Arrays.sort
 * 从而允许在排序上实现精确控制.
 * 4. 还可以使用Comparator 来控制某些数据结构(如:有序 set或没有序映射)的顺序，或者
 * 为那些没有自然顺序的对象 collection提供排序
 */

public class ComparatorTest {

    @Test
    public void test() {
        String[] arr = {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr,new Comparator() {

            /**
             * 一般对于 Comparator的使用都是一次性的，所以一般都是使用匿名的方式
             * @param o1
             * @param o2
             * @return
             */
            @Override
            public int compare(Object o1, Object o2) {
                // 1.判断是否是对应比较的实例对象
                if(o1 instanceof String && o2 instanceof String) {
                    // 强制转换为对应的实例对象，调用其中的对象中的属性比较判断
                    String s1 = (String)o1;
                    String s2 = (String)o2;

                    // compareTo()默认是降序的(当前对象 > 参数对象) 返回 >=1 ，升序是返回 < 1的
                    return -s1.compareTo(s2);  // 调用String 对应类中重写的compareTo()方法:默认是降序的

                }

                // throw 异常可以代替 return
                throw new RuntimeException("类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));

    }
}
