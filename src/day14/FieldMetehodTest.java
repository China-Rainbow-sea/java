package day14;


/**
 * 总结:
 * 1.若子类重写了父类方法,就意味着子类里定义的方法将彻底覆盖了父类里的“同名同参”的方法，
 * 系统将不可能把父类里的方法转移道子类中
 * 2. 对于实例变量则不存在，这样的“重写覆盖”的现象,即使子类里定义了与父类完全相同的实例变量
 * ，这个实例变量依然不可能覆盖父类中定义的实例变量.
 */
public class FieldMetehodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count); // 打印的是 sub中的 count = 10

        s.disPlay();

        System.out.println("*******************");

        // 多态(向上转型): 父类的引用指向子类的引用
        Base b = s;
        // == 对于引用类型来说: 比较的是两个引用数据类型变量的地址值是否相同
        System.out.println(b == s);    // false 比较判断的是 类@地址
        System.out.println(b.count);   // 多态对于变量是看: 右边  20

        b.disPlay();     // 多态调用的是子类重写的方法

    }

}


class Base{
    int count = 10;

    public void disPlay() {
        System.out.println(this.count);
    }
}


class Sub extends Base {
    int count = 20;

    public void disPlay() {
        System.out.println(this.count);
    }

}
