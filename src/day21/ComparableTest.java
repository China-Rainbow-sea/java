package day21;


import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 自然排序：java.lang.Comparable
 * Comparable接口强行对实现它的每个类的对象进行整体排序。这种排序被称为类排序
 * 2. 实现Comparable 的类必须实现 compareTo(Object obj) 方法，两个对象即通过
 * compareTo(Object obj) 方法的返回值来比较大小。如果当前对象 this > 形参对象obj
 * ，则返回正整数，如果当前对象 this < 形参对象obj,则返回负整数，如果当前对象this 等于形参对象obj，则返回 0
 * 3. 实现Comparable接口的对象列表(和数组) 可以通过 Collections.sort 或Arrays.sort()进行排序。
 * 实现此接口的对象可以用作，有序映射中的键或有序集合中的元素，无需指定比较器
 * 4.对于类C 的每一个e1 和 e2 来说,当且仅当 e1.compareTo(e2) == 0 与 e1.equals(e2) 具有相同的boolean值
 * 时，类 C的自然排序才叫做 equals一致，建议(虽然不是必需的)最好使自然排序与 equals 一致。
 * <p>
 * 说明:
 * Java中的对象，正常情况下，只能进行比较， == 或 !=,不能使用 > 或 < 的
 * 但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 * 如何实现？ 使用两个接口中的任何一个 Comparable 或 Comparator
 */
public class ComparableTest {

    @Test
    public void test() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 像String，包装类等实现了Comparable接口，并重写了compareTo()方法，给出了比较两个
     * 对象大小
     * > 重写compareTo()的规则：
     * > 如果当前对象this 大于 形参对象obj,则返回正整数
     * > 如果当前对象 this 小于 形参对象obj,则返回负整数,如果当前对象this等于形参对象obj,
     * > 如果当前对象 this  == 形参对象obj, 则返回 0
     * 在定义类来说,如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo()
     * 在compareTo(obj)方法中指明如何排序。
     */
    @Test
    public void test2() {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaoMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);

        Arrays.sort(arr, new Comparator() { // 会调用Arrays.sort 重写的compareTo()方法，
            @Override
            public int compare(Object o1, Object o2) {
                // 1.首先判断是否，为比较对象的实例，是比较，不是抛异常
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    // 2. 强制转换为对应的实例对象，获取到比较判断的属性
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;

                    if (g1.getName().equals(g2.getName())) {
                        return -Double.compare(g1.getPrice(), g2.getPrice()); // 默认是降序，改为升序 填个-
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("类型不一致");
                // 指定商品比较大小的方式：按照商品名称以升序的方式，再按照价格从降序
            }
        });

        System.out.println(Arrays.toString(arr));

    }


    class Goods implements Comparable {
        private String name;
        private double price;

        public Goods() {
        }

        public Goods(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        /**
         * 重写Comparable 接口中的compareTo抽象方法
         * 指明商品比较大小的方式: 按照价格从低到高排序
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
            // 方式一:
            // 判断该比较判断的对象是否时，对应的类类型，是比较，不是抛出异常
            if (o instanceof Goods) {

                Goods goods = (Goods) o; // 多态:强制转换为对应的，实例对象
                // 当前对象 > 参数对象
                if (this.price > goods.price) {
                    return 1;
                } else if (this.price < goods.price) {  // 当前对象 < 参数对象
                    return -1;
                } else {   // 当前对象 == 参数对象
                    return 0;   //
                }
            }

            // 异常可以 处理代替 return 返回
            throw new RuntimeException("传入的数据类型不一致");  // 抛出运行时异常

            // 方式二: 直接使用 Double.compare()包装类中重写的compare()默认就是降序的
        }

        // 处理方式二: 指明商品比较大小的方式：按照价格从低到高排序，再按照商品名称从高到低排序
        public int compareTo2(Object o) {

            // 判断是否是，该比较对象的实例，是才可以比较判断，不是抛出异常
            if (o instanceof Goods) {
                Goods goods = (Goods) o; // 强制转换为对应的实例对象，获取到其中的成员变量

                // 当前对象 > 参数对象 返回 大于>= 1
                if (this.price > goods.price) {
                    return 1;
                } else if (this.price < goods.price) { // 当前对象 < 参数对象 返回 -1
                    return -1;
                } else {
                    // 当前对象 == 参数对象，进一步再次比较:  调用对应类的compareTo()比较，
                    return -this.name.compareTo(goods.name); // 默认是降序的, 当前对象 > 参数对象 返回 1 降序,我们填个 - 就是升序了
                    // 填上一个 -1负数；就是： 当前对象 > 参数对象 返回 -1;
                }

            }

            // throw 异常可以替换掉 return
            throw new RuntimeException("传入的数据类型不一致");
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}