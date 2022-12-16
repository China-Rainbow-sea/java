package day14;


import org.junit.Test;

/**
 * 关于包装类的使用的面试题:
 */
public class InterviewTest2 {
    @Test
    public void test1() {
        Object ob = true ? new Integer(1) : new Double(2.0);
        System.out.println(ob);  // 1.0;
        // 因为需要保证: ? 三目运算符,保证两者的变量类型是一致的.所以 Integer 会自动提升为Double类型

    }


    @Test
    public void test2() {
        Object o2;
        if(true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.println(o2);  // 1
    }


    @Test
    public void test3() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);  // true

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n); // true

        /*
        Integer 内部定义了IntegerCache结构,IntegerCache中定义了Integer[]
        保存了从 -128~127范围的整数，如果我们使用自动装箱的方式，给Integer赋值的范围在
        -128~127 范围内时，可以直接使用数组中的元素,不再去new了。目的,提高效率
         */


        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y); // false

        /*
        存在缓存的机制 [-128~127] 数值的存储值，提高速度
         private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }
         */

    }
}
