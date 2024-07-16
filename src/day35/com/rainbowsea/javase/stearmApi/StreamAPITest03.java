package day35.com.rainbowsea.javase.stearmApi;

import java.util.stream.Stream;

public class StreamAPITest03 {
    public static void main(String[] args) {

        // stream 是一个顺序流，单线程
        Stream<String> stream = Stream.of("abc", "def", "xyz");
        System.out.println(stream);

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        System.out.println(integerStream);

        Stream<String> parallel = stream.parallel();
        System.out.println(parallel);

        System.out.println(stream == parallel); // true
        boolean parallel1 = parallel.isParallel(); // true
        System.out.println(parallel1);

    }
}
