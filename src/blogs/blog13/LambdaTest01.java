package blogs.blog13;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (o1,o2)->Integer.compare(o1,o2);
        int compare = comparator.compare(21, 12);// 调用该接口中重写的抽象方法
        System.out.println(compare);

    }


    public static void main6(String[] args) {
        Comparator<Integer> comparator = (o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int compare = comparator.compare(21, 12);// 调用该接口中重写的抽象方法
        System.out.println(compare);


        System.out.println("*****************************");
        // 或者
        Comparator<Integer> comparator1 = (o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };

        int compare2 = comparator.compare(21, 12);// 调用该接口中重写的抽象方法
        System.out.println(compare2);
    }


    public static void main5(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
                //或者 return Integer.compare(o1,o2);
            }
        };

        int compare = comparator.compare(21, 12);// 调用该接口中重写的抽象方法
        System.out.println(compare);
    }


    public static void main4(String[] args) {
        Consumer<String> consumer = s-> System.out.println(s);
        consumer.accept("你好");  // 调用接口中重写的抽象方法
    }


    public static void main3(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("你好");  // 调用接口中重写的抽象方法
    }




    public static void main2(String[] args) {
        Runnable runnable = ()->System.out.println("你好世界");

        runnable.run();
    }



    public static void main1(String[] args) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("你好世界");
            }
        };

        run.run();
    }
}
