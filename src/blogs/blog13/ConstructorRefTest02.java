package blogs.blog13;

import java.util.Arrays;
import java.util.function.Function;

public class ConstructorRefTest02 {
    /**
     * Function中的R apply(T t)
     */
    public static void main(String[] args) {
        // 匿名实现接口 <> 注意泛型不能使用基本数据类型
        Function<Integer,String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };

        String[] apply = function.apply(5);  // 调用 Function 接口中的 重写的apply()抽象方法
        System.out.println(Arrays.toString(apply));

        // Lambda 表达式
        Function<Integer,String[]> function2 = (leng)->new String[leng];
        String[] apply2 = function2.apply(5);  // 调用 Function 接口中的 重写的apply()抽象方法
        System.out.println(Arrays.toString(apply2));


        // 数组引用
        Function<Integer,String[]> function3 = String[]::new;
        String[] apply3 = function3.apply(5);  // 调用 Function 接口中的 重写的apply()抽象方法
        System.out.println(Arrays.toString(apply3));

    }
}
