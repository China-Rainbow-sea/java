package day33;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 * 消费型接口 Consumer<T>  void accept(T t)
 * 供给型接口 Supplier<T>  T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 */
public class LambdaTest03 {

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test() {
        happyTime(500, new Consumer<Double>() {

            @Override
            public void accept(Double aDouble) {
                System.out.println("好好学习，天天向上");
            }
        });

        // Lambda 实现 只有一个参数，没有返回值，{} () 都可以省略不写的。
        happyTime(400,aDouble -> System.out.println("hello world"));

    }


    /**
     * 根据给定的规则，过滤集合中的字符串，此规则由 Predicate 的方法决定
     */
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();


        for(String s : list) {
            if(pre.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }


    @Test
    public void Test3() {
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京","普京");

        List<String> filterString = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");  //判断 字符串中含有 “京” 返回 true,否则返回 false
            }
        });

        System.out.println(filterString);

        // 使用Lambda 表达式 一个参数，一个返回值
        List<String> list2 = filterString(list,s->s.contains("京") );
        System.out.println(list2);
    }
}
