package blogs.blog2;

public class StaticTest {
    public static void main1(String[] args) {
        Chinese c1 = new Chinese();
        c1.nation = "CHN";

        Chinese c2 = new Chinese();
        c2.nation = "CHINA";

        System.out.println("c2.nation: "+c1.nation);
        System.out.println("c2.nation: "+c2.nation);

        // 可以通过 类名.静态属性 ()
        Chinese.nation = "中国";
        System.out.println("Chinese.nation: "+Chinese.nation);
    }


    public static void main2(String[] args) {
        // 静态方法可以直接使用  “类名.静态方法”调用
        Chinese.show();
        Earth earth = new Chinese();
        earth.human();
    }


    public static void main(String[] args) {
        Earth earth = new Chinese();  // 多态
        earth.human();
    }

}


class Chinese extends Earth{
    String name;
    int age;
    static String nation;     // 被 static 修饰的静态属性


    public static void show(){
        System.out.println("我是静态方法");
        // name = "TOM";  // 静态方法无法直接调用非静态的属性
        // eat();   // 静态方法无法直接调用非静态的方法，可以通过 new 实例对象，调用

        /*this.name = "Tom";
        super.clone();*/  // 静态方法中无法使用 this./super.

        // 静态方法可以直接调用静态属性，静态方法
        nation = "Hello";   // 静态属性
        sleep();            // 静态方法
    }


    public void eat(){
        System.out.println("吃饭");

        System.out.println("***************************");

        // 非静态方法可以直接调用 静态方法/属性，因为加载内存的先后原因
        nation = "World";     // 静态属性
        sleep();              // 静态方法
    }


    public static void sleep() {
        System.out.println("睡觉");
    }

    public static void human() {
        System.out.println("中国人");
    }
}


class Earth{
    public static void human(){
        System.out.println("人类");
    }

}