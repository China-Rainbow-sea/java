package blogs.blog13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest02 {
    /**
     * 根据给定的规则，过滤集合中的字符串，此规则由 Predicate 的方法决定
     */
    public static List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list) {
            if(pre.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京");

        List<String> list2 = filterString(list, (String s) -> {
            return s.contains("京");
        });

        System.out.println(list2);

    }

    public static void main3(String[] args) {
        List<String> list = Arrays.asList("北京","天津","南京","东京","西京");

        List<String> list2 = filterString(list, new Predicate<String>() {
            // 重写 Predicate 接口中的 test(T t) 抽象方法
            @Override
            public boolean test(String s) {
                return s.contains("京"); // 字符串中含有 京 字的返回 true,否则返回 false
            }
        });

        System.out.println(list2);
    }



    public static void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    // Lambda 表达式处理
    public static void main2(String[] args) {
        // 调用方法
        happyTime(600,(Double d)-> System.out.println("Hello World"));

    }

    // 匿名实现接口 传递接口实例
    public static void main1(String[] args) {
        // 调用方法
        happyTime(600,new Consumer<Double>() {

            // 重写 Consumer 接口中的 accept()抽象方法
            @Override
            public void accept(Double aDouble) {
                System.out.println("Hello World");
            }
        });
    }


}
