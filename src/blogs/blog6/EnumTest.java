package blogs.blog6;


class Season {
    // 1.创建枚举类中的含有的特定的属性： 注意是被: private final 修饰的,也可以没有枚举类特有的属性
    private final String stringName;
    private final String stringDesc;

    // 2.创建枚举类常量: 注意是: public static final 修饰的,常量所有字母大写的
    // 被 static 修饰，静态的和类一起加载到内存当中,仅仅只会加载一次,所以对象共用,可以直接使用 "类名.常量"的方式访问
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");



    // 3. 构造器私有化: 将枚举类定义的特定的被 final 修饰的属性，附上值。
    // 注意： 被 final 修饰的属性/变量，必须赋值，不然报异常
    private Season(String stringName, String stringDesc) {
        this.stringName = stringName;
        this.stringDesc = stringDesc;
    }

    // 4. 其他诉求的方法的定义: 这里我们定义一个获取 属性的get方法
    // 因为属性被 final 修饰了,所以我们不需要创建 set方法

    public String getStringName() {
        return stringName;
    }

    public String getStringDesc() {
        return stringDesc;
    }

    // 或者来一个重写 toString()方法

    @Override
    public String toString() {
        return "Season{" +
                "stringName='" + stringName + '\'' +
                ", stringDesc='" + stringDesc + '\'' +
                '}';
    }
}

public class EnumTest {
    public static void main(String[] args) {
        // 访问自定义的枚举类型的常量,static 静态的，使用类名.常量名
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);

    }

}
