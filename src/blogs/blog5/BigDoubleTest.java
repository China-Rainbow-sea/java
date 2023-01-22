package blogs.blog5;

import java.math.BigDecimal;

public class BigDoubleTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("2.9999999999999999999998");
        BigDecimal bigDecimal2 = new BigDecimal(2);

        BigDecimal divide = bigDecimal.divide(bigDecimal2,6,BigDecimal.ROUND_FLOOR);   // 除
        System.out.println(divide);
    }


    public static void main1(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("2.9999999999999999999998");
        BigDecimal add = bigDecimal.add(new BigDecimal("1"));   // 加
        System.out.println(add);

        BigDecimal subtract = bigDecimal.subtract(new BigDecimal(1));  // 减
        System.out.println(subtract);

        BigDecimal multiply = bigDecimal.multiply(new BigDecimal(2));   // 乘
        System.out.println(multiply);

        BigDecimal divide = bigDecimal.divide(new BigDecimal(2));   // 除
        System.out.println(divide);

    }
}
