package day35.com.rainbowsea.javase.stearmApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 * 获取Steam流对象的第一种方式：通过 Collection接口的steam()方法来获取Steam对象
 */
public class StreamAPITest01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // 注意：这个流属于顺序流，本质是单线程的。数据量如果不是很多，采用这种方式。
        Stream<Integer> stream = list.stream();  // java.util.stream.ReferencePipeline$Head@14ae5a5
        // 通过 steam 对象可以对集合中的元素进行计算
        System.out.println(stream);


        // 这是一个并行流(底层自动启动多线程，你不需要管，程序员不需要干涉)
        // 在计算的时候自动会启动多线程去运算
        // 什么时候用？如果数据量非常庞大的时候，（可以对比测一下，并行和串行的速度）
        Stream<Integer> parallelStream = list.parallelStream();


    }
}
