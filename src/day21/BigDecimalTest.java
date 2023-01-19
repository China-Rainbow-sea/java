package day21;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

/**
 * BigDecimal 属于大数据，精度很高，不属于基本数据类型，属于java对象(引用数据类型)
 * 这是sun提供的一个类，专门用在财务软件当中。
 * 2.注意: 财务软件中的double 是不够的，当处理财务数据时，用那一种类型 ?
 *   千万不能用 double 要用java.math.BigDecimal 中的类的这个对象
 */
public class BigDecimalTest {


    @Test
    public void test() {
        // 这个 100 不是普通的 100 ，是精度极高的100
        BigDecimal bigDecimal = new BigDecimal(100);
        // 精度极高的 200
        BigDecimal bigDecimal2 = new BigDecimal(200);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);

        //  求和
        // bigDecimal + bigDecima2 ; 这样是不行的，bigDecimal 和bigDecimal2 都是引用类型，
        // 不能直接使用 + 算术运算符求和的。
        BigDecimal v = bigDecimal.add(bigDecimal2);  // 调用求和的对象方法
        System.out.println(v);
    }

    /**
     * 随机数
     */
    @Test
    public void test2() {
        // 创建随机数对象
        Random random = new Random();

        // 随机产生一个int类型数组范围的数字
        int num1 = random.nextInt();
        System.out.println(num1);


        // 产生[0~100]之间的随机数，不能产生 101
        // nextInt(101)翻译为: 下一个int类型的数据是 101，表示只能到 100
        int num2 = random.nextInt(101);  // 注意不包括 101
        System.out.println(num2);

    }


    /**
     * 编写程序；生成 5 个不重复的随机数[0~100] 。重复的话重新生成
     * 最终生成的5个随机数放到数组中，要求数组中的这 5 个随机数不重复
     */
    @Test
    public void test3() {
        // 创建5个容量的数组
        int[] arr = new int[5];  // 默认存放的是 0
        int index = 0;
        Random random = new Random();
        while(index < arr.length) {
            int temp = random.nextInt(101) + 1; // 不要生成 0
            System.out.println(temp);
            // 判断该生成是数，是否在数组中已经存在了
            if(!(contains(arr,temp))) {
                arr[index++] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 判断该数是否存在数组中，存在返回 true,不存在返回 false
     * @param arr 数组
     * @param num 判断值
     * @return  存在返回 true,不存在返回 false
     */
    private boolean contains(int[] arr,int num) {
        for (int i = 0; i < arr.length; i++) {
            if(num == arr[i]) {
                return true;
            }
        }

        return false;
    }
}
