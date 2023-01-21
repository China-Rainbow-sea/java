package blogs.blog5;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] arr = {"AA", "CC", "DD", "GG", "EE", "FF", "DD", "ZZ"};

        // 排序前
        System.out.println(Arrays.toString(arr));

        // 通过匿名实现 Comparator 接口,并重写其中的 compare()抽象方法
        Arrays.sort(arr, new Comparator() {

            // 重写 compare()抽象方法，降序
            @Override
            public int compare(Object o1, Object o2) {
                // 1. 首先判断：是否是比较的对象的类型
                if (o1 instanceof String && o2 instanceof String) {
                    // 2. 强制转换为对于的实例对象，获取到比较的值
                    String s1 = (String) o1;
                    String s2 = (String) o2;

                    // 3. 这里我们调用 String 已经重写好的 compareTo()方法，默认是升序
                    // 这里我们附加上一个 '-' 负号变成，降序
                    return -s1.compareTo(s2);
                }
                // 异常可以代替 return 返回值
                throw new RuntimeException("比较类型不一致");
            }
        });

        // 排序后的结果:
        System.out.println(Arrays.toString(arr));
    }
}
