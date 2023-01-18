package day21;


import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Integer 类作为int的包装类,能存储的最大整数值为2^31-1,Long类也是有限的，
 * 最大为2^63-1，如果要表示再大的整数，不管是基本数据类型还是它们的包装类都无能为力。
 * 更不用说进行运算了.
 *
 * java.math包的BigInteger 可以表示不可变的任意精度的整数，Biginteger提供所有 java
 * 的基本数据操作符的对应，并提供了java.lang.Mathd 的所有相关方法另外
 * BigInteger 还提供以下运算，模算术，GCD计算，质数测试，素数生成，位操作以及一些其他的操作。
 *
 * 构造器
 *  >BigInteger(String val) 根据字符串构建BigInteger对象
 *  >一般的Float类和Double类可以用来做科学计算成工程计算，但在商业计算中，要求数字精度比较高，
 *  故用到java.math.BigDecimal类
 *  BigDecimal 类支持不可变的，任意精度的有符号十进制定点数.
 */
public class BigIntegerTest {

    @Test
    public void test() {
        BigInteger bigInteger = new BigInteger("31231283912830128930128301283081203812038831203801283012");
        System.out.println(bigInteger);
        BigDecimal bigInteger2 = new BigDecimal("12356" +
                ".999999999999999999999999999999999999999999999999999999999999999");
        System.out.println(bigInteger2);
        BigDecimal bigDecimal = new BigDecimal(0.98349023432);

        // 加法
        System.out.println(bigInteger.add(bigInteger));
        System.out.println(bigInteger2.add(bigDecimal));
    }
}
