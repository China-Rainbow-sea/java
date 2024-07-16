package day35.com.rainbowsea.javase.stearmApi;


import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Stream终止操作之: 收集 collect
 * 归集:转换成数组形式
 */
public class StreamAPITest16 {
    public static void main(String[] args) {
        // 没有指定数组的类型时,默认转换成 Object[] 数组
        Object[] objects = Stream.of(1, 2, 3).toArray();
        System.out.println(Arrays.toString(objects));

        // 转换为指定类型的数组
        Integer[] integers = Stream.of(1, 2, 3).toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));

        String[] strings = Stream.of("a", "b", "c").toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }
}
