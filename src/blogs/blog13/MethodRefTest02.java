package blogs.blog13;

import java.util.Comparator;
import java.util.function.Function;

public class MethodRefTest02 {
    /**
     * Function  中的 apply(T t)
     * Math 中的 Long round(Double d)  // 四舍五入
     *   两个方法的结构一致。
     */
    public static void main(String[] args) {
        // 匿名实现接口的方式
        Function<Double,Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d); // 四舍五入
            }
        };

        Long apply = function.apply(12.3);  // 调用Function 接口中的重写的apply()方法
        System.out.println(apply);

        // Lambda 表达式
        Function<Double,Long> function2 = d->Math.round(d);
        Long apply2 = function2.apply(12.3);  // 调用Function 接口中的重写的apply()方法
        System.out.println(apply2);

        // 方法引用
        Function<Double,Long> function3 = Math::round;
        Long apply3 = function3.apply(12.3);  // 调用Function 接口中的重写的apply()方法
        System.out.println(apply3);


    }


    public static void main1(String[] args) {
        // 匿名实现接口方式
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = comparator.compare(12, 21);  // 调用其Comparator接口中重写的compare()抽象方法
        System.out.println(compare);


        // Lambda 表达式
        Comparator<Integer> comparator2 = (o1,o2)->Integer.compare(o1,o2);
        int compare2 = comparator2.compare(12, 21);  // 调用其Comparator接口中重写的compare()抽象方法
        System.out.println(compare2);

        // 方法引用
        Comparator<Integer> comparator3 = Integer::compareTo;
        int compare3 = comparator3.compare(12, 21);  // 调用其Comparator接口中重写的compare()抽象方法
        System.out.println(compare3);
    }
}
