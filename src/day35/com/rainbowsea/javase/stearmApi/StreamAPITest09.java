package day35.com.rainbowsea.javase.stearmApi;


import java.util.stream.Stream;

/**
 * Stream中间操作之 skip + limit
 * skip 是跳过
 * limit 是截取
 */
public class StreamAPITest09 {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9).skip(3).limit(3)
                .forEach(System.out::println);
    }
}
