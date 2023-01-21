package blogs.blog5;


import java.util.Arrays;


class Commodity implements Comparable {
    String name;
    double price;

    public Commodity() {
        // 无参构造器
    }

    public Commodity(String name, double price) {
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


    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        /**
         * 比较规则:
         * * 如果当前对象this > 形参对象Obj，则返回正整数。
         * * 如果当前对象 this < 形参对象 Obj，则返回负整数，
         * * 如果当前对象 this == 形参对象 Obj，则返回。
         */
        // 1. 首先判断该类，是否是 Commodity 的实例，不是就不用比较了，类都不一样
        if (o instanceof Commodity) {
            // 2.强制转换为对应的 Commodity 的实例对象，获取到其中的比较值
            Commodity commodity = (Commodity) o;
            if (this.price > commodity.price) {
                return 1;
            } else if (this.price < commodity.price) {
                return -1;
            } else {
                // 对于价格相同的商品，对商品名进行“降序” 二次排序
                // 这里我们直接调用 String 类型中已经重写好的 compareTo()方法就进行排序
                return -this.name.compareTo(commodity.name);
                // 这里我们 附加一个 "-1"负数的意思是：compareTo()默认就是 “升序”
                // 升序: this > 参数对象，返回正整数，this < 参数对象，返回负整数
                // 降序: this > 参数对象，返回负整数, this < 参数对象，返回正整数
                // 这两者的结果刚好相反：所以：我们将升序的返回结果 填一个“-” 符号就变成了，降序的
            }

        }
        throw new RuntimeException("传入的数据类型不一致");
    }

}


public class ComparableTest {
    public static void main(String[] args) {
        Commodity[] commodities = new Commodity[5];
        commodities[0] = new Commodity("lenovoMouse", 34);
        commodities[1] = new Commodity("dellMouse", 34);
        commodities[2] = new Commodity("xiaoMouse", 12);
        commodities[3] = new Commodity("huaweiMouse", 65);
        commodities[4] = new Commodity("roogyao", 65);

        Arrays.sort(commodities);

        System.out.println(Arrays.toString(commodities));
    }


    public static void main1(String[] args) {
        String[] arr = {"AA", "CC", "BB", "FF", "DD", "EE"};
        // 排序前:
        System.out.println(Arrays.toString(arr));
        // 排序后:
        Arrays.sort(arr);  // 排序默认是(升序)
        System.out.println(Arrays.toString(arr));

    }
}
