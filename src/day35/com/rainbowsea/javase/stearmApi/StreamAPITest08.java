package day35.com.rainbowsea.javase.stearmApi;

import java.util.stream.Stream;


/**
 * Stream 中间操作之：concat 合并
 */
public class StreamAPITest08 {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);

        Stream.concat(stream1,stream2).forEach(System.out::println);
    }
}
