package day35.com.rainbowsea.javase.stearmApi;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 终止操作之:收集 collect
 * 归集:toList/toSet/toMap
 */
public class StreamAPITest13 {
    public static void main(String[] args) {
        // 将流 Stream中的数据全部收集到一个集合中
        // 收集为 List 集合,但是我们List 是一个接口,我们无法知道,这里用的是那个List集合的实现类
        List<String> collect = Stream.of("zhangsan", "lisi", "wangwu").collect(Collectors.toList());
        System.out.println(collect);

        // 收集为 Set 集合,(同样我们也无法知道是具体的那个 Set 集合的实现类)
        Set<String> collect1 = Stream.of("zhangsan", "lish").collect(Collectors.toSet());
        System.out.println(collect1);

        // 收集为 Map集合
        // 匿名内部类
        Map<String, String> map =
                Stream.of("1:zhangsan", "2:lihua","3:wangwu").collect(Collectors.toMap(new Function<String,
                String>() {
            @Override
            public String apply(String s) {
                // Map 集合中的 key 获取
                return s.substring(0, s.indexOf(":"));
            }
        }, new Function<String, String>() {
            @Override
            public String apply(String s) {
                // Map集合中 value 获取
                return s.substring(s.indexOf(":")+1);
            }
        }));
        System.out.println(map);

        // Lambda 表达式
        Map<String, String> map2 = Stream.of("1:zhangsan", "2:lihua")
                .collect(Collectors.toMap(s -> s.substring(0, s.indexOf(":")), s -> s.substring(s.indexOf(":") + 1)));

        System.out.println(map2);

    }
}
