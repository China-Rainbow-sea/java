package day35.com.rainbowsea.javase.stearmApi;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SteamApITest02 {
    public static void main(String[] args) {

        String[] names = {"zhangsan", "李四", "王五"};
        Stream<String> stream = Arrays.stream(names);
        System.out.println(stream);


        int[] nums = {1,2,3};
        IntStream stream1 = Arrays.stream(nums);
        System.out.println(stream1);

        Long[] lnums = {1L,2L,3L};
        Stream<Long> stream2 = Arrays.stream(lnums);
        System.out.println(stream2);
    }
}
