package blogs.blog6;


// 使用JDK5.0 新特性中的定义枚举类关键字 enum
enum Season2 {

    // 1. 首先将枚举类中的常量定义在第一行，如果不是定义在定义行的话，编译报错的
    // 省略了 public static final Season 和 new Season的
    // public static final Season SPRING = new Season("春天", "春暖花开");
    SPRING("春天", "春暖花开"),    // 注意: 因为要定义在第一行，所以枚举常量之间使用","逗号分隔
    SUMMER("夏天", "夏日炎炎"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冰天雪地");    // 最后使用,“;”分号结束 枚举常量的定义

    // 2. 定义枚举类型特有的属性
    // 注意: 被 private final 修饰防止被修改，这个根据需求设定就好，可以没有
    private final String stringName;
    private final String stringDesc;


    // 3. 私有化构造器(因为定义了枚举类特定的属性，所以需要额外定义构造器为其赋值),没有特定属性的话，可以省略的
    // final 必须赋值，不然报异常
    private Season2(String stringName, String stringDesc) {
        this.stringName = stringName;
        this.stringDesc = stringDesc;
    }


    // 4.处理特定的诉求 这里我们定义 get方法()
    // 因为 特定的属性被 final 修饰了，所以不用定义 set的
    public String getStringName() {
        return stringName;
    }

    public String getStringDesc() {
        return stringDesc;
    }

    // 重写toString方法


    @Override
    public String toString() {
        return "Season2{" +
                "stringName='" + stringName + '\'' +
                ", stringDesc='" + stringDesc + '\'' +
                '}';
    }
}

public class EnumTest2 {


    public static void main5(String[] args) {
        Season2 season2 = Season2.valueOf("SPRING3");

    }



    public static void main4(String[] args) {
        Season2 season2 = Season2.valueOf("SPRING");  // valueOf()类方法，返回对应枚举常量名的对象
        System.out.println(season2);
    }

    public static void main3(String[] args) {
        Season2[] season2s = Season2.values();  // 返回枚举类中所有的常量值，存储到枚举类数组中

        // 遍历获取到其中，枚举类数组
        for(int i = 0; i < season2s.length; i++) {
            System.out.println(season2s[i]);  // 如果重写了toString()方法，就调用的是重写的toString()方法
        }
    }


    public static void main2(String[] args) {
        // 打印其中的 enum 的父类
        System.out.println(Season2.class.getSuperclass());
    }


    public static void main1(String[] args) {
        System.out.println(Season2.SPRING);
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.WINTER);
    }


}
