package blogs.blog5;

import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("-3");
        BigInteger abs = bigInteger.abs();          // 绝对值
        System.out.println(abs);

        BigInteger bigInteger2 = new BigInteger("2");

        BigInteger remainder = bigInteger.remainder(bigInteger2);   // 取模 %
        System.out.println(remainder);

        BigInteger pow = bigInteger.pow(2);    // 次方
        System.out.println(pow);
    }

    public static void main1(String[] args) {
        BigInteger bigInteger = new BigInteger("9999999999");
        BigInteger bigInteger2 = new BigInteger("1");

        BigInteger add = bigInteger.add(bigInteger2);              // +
        System.out.println(add);

        BigInteger subtract = bigInteger.subtract(bigInteger2);    // -
        System.out.println(subtract);

        BigInteger multiply = bigInteger.multiply(bigInteger2);    // *
        System.out.println(multiply);

        BigInteger divide = bigInteger.divide(bigInteger2);        // /
        System.out.println(divide);

    }
}
