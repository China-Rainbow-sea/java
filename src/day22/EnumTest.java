package day22;


import org.junit.Test;

/**
 * 运用jdk 5.0 的枚举新特性
 * 使用 enum 修饰类
 */

enum Season2 {

    // 3. 定义枚举常量: 访问:提供当前枚举类的多个对象: public static final 的
    // 提供当前枚举类的多个对象,可以直接通过"类名.属性名"的方式获取到
    // 1.提供当前枚举类的对象，三个对象之间 “,”隔开
    SPRING("春天", "春暖花开"),   // 多个同一样的类型 enum，不可以用";"分号，要用逗号要使用
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");    // 但是最后一个要用 ";" 分号结尾
    // 对于 jdk5.0 中的 enum 枚举类可以省略: public static final Season 修饰的属性，以及 new Season()
    // 但是需要注意的是: 枚举类中常量要定义在最前面，才行
    //public static final Season WINTER = new Season("冬天","冰天雪地");
    // 1. 提供当前枚举类的多个对象: 其中省略了: public static final 修饰，还是静态的，可以直接使用类名直接访问
    // 1.声明 对应的对象的属性为: private final 修饰


    private final String seasonName;
    private final String seasonDesc;

    // 2.构造器私有化，并对对象属性赋值，对于 final 修饰的变量不赋值的话，报异常.
    private Season2(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    // 4. 其他诉求: 获取枚举类对象的属性:
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    // 可以把 toString()方法省略了。
    /*@Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/


}

/**
 * 枚举类的使用
 * 类的对象只有有限个，并且是确定的
 * 举例:
 * > 星期: 星期一...... 星期天
 * > 性别: 男,女
 * > 月份: 十二个月
 * > 季节: 四季
 * > 支付方式: 现金,微信，银行卡，支付宝，信用卡
 * > 就职状态:
 * > 线程状态: 新建，就绪，运行，阻塞，死亡
 * > 订单状态:
 * 当需要定义一组常量时，强烈建议使用枚举类。
 * m么经济
 */
public class EnumTest {

    /**
     * 枚举类的使用:
     * 1.枚举类的理解，类的对象只有有限个，并且是确定的。
     * 2. 当需要定义一组常量时，强烈建议使用枚举
     * 3. 如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
     * 自定义枚举类
     */
    @Test
    public void test1() {
        System.out.println(Season.SPRING);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);

    }

    @Test
    public void test2() {
        // 可以访问，枚举类中定义的特定的方法
        System.out.println(Season.WINTER.getSeasonDesc());
        System.out.println(Season.WINTER.getSeasonName());
    }


    /**
     * 使用 jdk 5.0 enum 枚举类中的特性
     */
    @Test
    public void test3() {
        // 同样可以使用 类名.属性名，直接访问,:因为只是将 public static final 省略了，
        // 但是并没有去了
        System.out.println(Season2.WINTER);   // ，默认是显示的对于定义的枚举常量名(没有重写toString()方法的前提下)
        System.out.println(Season2.SPRING);   // 不是地址值,
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.WINTER);

        // 需要注意的是: enum 枚举类，继承的父类不是 Object的，而是 class java.lang.Enum
        System.out.println(Season2.class.getSuperclass());

    }


    /**
     * enum类中主要的方法:
     * 注意了，只有被 enum jdk5定义的创建的枚举类，才有如下方法
     * values()方法:返回枚举类型的对象数组,该方法可以很方便的遍历所有的枚举值。
     * valueOf(String str) 可以把一个字符串转为对应的枚举类对象,要求字符串必须是枚举类型对象的“名字”，
     * 如不是，会有运行时异常，liiegalArgumentException
     * toString() 返回当前枚举类型类对象常量的名称。
     */
    @Test
    public void test4() {
        // values(); 返回 对应的枚举类的对象，以数组的方式存储起来
        Season2[] values = Season2.values();

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }


        System.out.println("******************************************");

        // 线程状态的，枚举类
        Thread.State[] threads = Thread.State.values();   // 返回 Thread 线程状态的对象
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i]);
        }

        System.out.println("*********************************");

        // valueOf(String objName) 返回枚举类中对象名时 objName的对象。
        Season2 winter = Season2.valueOf("WINTER");
        System.out.println(winter);

        // 注意了如果 valueOf(所传的参数不是枚举类定义的常量值)，报异常 java.lang.IllegalArgumentException
        // Season2 season2 = Season2.valueOf("ABC");



    }


}

/**
 * 自定义枚举类型
 */
class Season {
    // 3. 定义枚举常量: 访问:提供当前枚举类的多个对象: public static final 的
    // 提供当前枚举类的多个对象,可以直接通过"类名.属性名"的方式获取到
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");
    // 1.声明 对应的对象的属性为: private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2.构造器私有化，并对对象属性赋值，对于 final 修饰的变量不赋值的话，报异常.
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 其他诉求: 获取枚举类对象的属性:
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}


