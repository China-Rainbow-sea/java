package day22;


import org.junit.Test;

enum Season3 implements Info {

    SPRING("春天", "春暖花开") {
        @Override
        public void show() {
            System.out.println("春天，春暖花开");
        }
    },   // 注意使用逗号",",分隔开来.

    SUMMER("夏天","夏日炎炎") {
        @Override
        public void show() {
            System.out.println("夏日，夏日炎炎");
        }
    },

    AUTUMN("秋天","秋高气爽") {
        @Override
        public void show() {
            System.out.println("秋天，秋高气爽");
        }
    },

    WINTER("冬天","冰天雪地") {
        @Override
        public void show() {
            System.out.println("冬天，冰天雪地");
        }
    };   // 最后以 “;” 分号结尾

    private final String seasonName;
    private final String seasonDesc;


    private Season3(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


}


interface Info {
    // public abstract 抽象修饰
    public abstract void show();
}

/**
 * 使用 enum 关键字定义的枚举类实现接口的情况:
 * 情况一: 实现接口，在 enum 类中实现抽象方法
 * 情况二: 让枚举类的对象分别实现接口中的抽象方法
 */
public class EnumTest2 {

    // 分别执行其中，对应不同枚举类型的中的 show()方法
    @Test
    public void test() {
        Season3[] values = Season3.values();   // 返回对应枚举类型中所有的属性值
        for(int i = 0; i < values.length; i++) {
            values[i].show();
        }

    }
}
