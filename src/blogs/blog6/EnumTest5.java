package blogs.blog6;

interface Info {
    public abstract void show();

}

//  enum 枚举类 implements 接口
enum Season5 implements Info {

    // 1. 首先将枚举类中的常量定义在第一行，如果不是定义在定义行的话，编译报错的
    // 省略了 public static final Season 和 new Season的
    // public static final Season SPRING = new Season("春天", "春暖花开");
    SPRING("春天", "春暖花开") {
        // 枚举值(枚举常量值)实现对应接口的抽象方法
        @Override
        public void show() {
            System.out.println("找春天");
        }
    },    // 注意: 因为要定义在第一行，所以枚举常量之间使用","逗号分隔
    SUMMER("夏天", "夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏日，蝉鸣");
        }
    },
    AUTUMN("秋天", "秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋日，枫叶飞舞");
        }
    },
    WINTER("冬天", "冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬日，雪花飞舞");
        }
    };    // 最后使用,“;”分号结束 枚举常量的定义

    // 2. 定义枚举类型特有的属性
    // 注意: 被 private final 修饰防止被修改，这个根据需求设定就好，可以没有
    private final String stringName;
    private final String stringDesc;


    // 3. 私有化构造器(因为定义了枚举类特定的属性，所以需要额外定义构造器为其赋值),没有特定属性的话，可以省略的
    // final 必须赋值，不然报异常
    private Season5(String stringName, String stringDesc) {
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
        return "Season5{" +
                "stringName='" + stringName + '\'' +
                ", stringDesc='" + stringDesc + '\'' +
                '}';
    }
}



public class EnumTest5 {
    public static void main(String[] args) {
        Season5[] values = Season5.values();  // 静态方法/类方法：获取到对应枚举类中所有的枚举值(枚举常量值)，并存储在数组中

        for(int i = 0; i < values.length; i++) {
            values[i].show();  // 调用对应枚举值(枚举常量值)中特有的方法
        }
    }
}
