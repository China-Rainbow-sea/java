package day35.com.rainbowsea.javase.stearmApi;


import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Stream终止操作之：reduce (规约/归纳/总结)
 * 作用：将流中的所有数据，按照指定的规则，最终计算出一个结果
 */
public class StreamAPITest11 {

    public static void main(String[] args) {
        // 将集合中的所有数字求和
        Integer integer = Stream.of(1, 2, 3, 4).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                //return "运算规则（加还是减，还是除法）"
                return x + y;
            }
        }).get();
        System.out.println(integer);
        // Lambda表达式
        System.out.println(Stream.of(1, 2, 3, 4).reduce((x, y) -> x + y).get());

        // 使用数学工具类(方法引用)

        System.out.println(Stream.of(1, 2, 3, 4).reduce((x, y) -> Math.addExact(x, y)).get());
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Math::addExact).get());

        // 需求: 获得集合中所有元素的"相乘"的结果
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Math::multiplyExact).get());

        // 需求:获得最大长度的元素
        System.out.println(Stream.of("abc", "adv", "123", "hello").reduce((s1, s2) -> s1.length() > s2.length() ? s1 :
                s2).get());


        // 需求: 获得所有学生的总年龄
        Integer integer1 = StudentService.getStudent().stream().map(Student::getAge).reduce(Math::addExact).get();
        System.out.println(integer1);

        // 需求:获得10和集合中所有元素"相加"的结果
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(10, Math::addExact);
        System.out.println(reduce);
    }


}
