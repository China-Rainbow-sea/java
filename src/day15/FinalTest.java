package day15;

/**
 * final: 最终的
 * 1.final可以用来修饰的结构: 类,方法,变量,局部变量(形参)
 * 2. final 用来修饰一个类,此类不能被其他类所继承.
 * 3.  比如: String 类,System类,StringBuffer类 :因为里面的方法基本都实现了,没有必要再通过继承扩展了
 * 4. final 用来修饰方法,表明此方法不可以被重写,比如: Object 类中 getClass();
 * 5. final 用来修饰变量,此时的变量 就称为是一个常量
 *    final 修饰属性,可以考虑赋值的位置有: 显示初始化,代码块初始化,构造器 注意是:赋值不是修改
 * 6. final 修饰局部变量:
 *    尤其是使用 final 修饰形参时,表明此形参时一个常量,当我们调用此方法时,给常量形参赋一个实参,一旦赋值以后
 *    ,就只能在方法体内使用此形参,但不能进行重新赋值.
 *
 * 7. 一般是  static final 用来修饰属性,全局常量. 需要注意的是一般 static 的成员属性,方法也是static 的
 */
public class FinalTest {
    final int num = 10;

    // num = 9;   // 被 final 修饰的变量不可以被修改了
//    final int f ;
//    f = 10;

    final int LEFT ;
    final int RIGHT;
//    final int DOW;

    {
        LEFT = 10;
    }

    public FinalTest() {
        RIGHT = 2;
    }

    public FinalTest(int n) {
        RIGHT = n;
    }

/*    public void setDOW(int num) {  // 使用 set方法无法设置被 final 修饰的变量.
        this.DOW = num;
    }*/

    public void show(final int num) {
        // num = 20;  // 形参 num 被 final 修饰的无法修改.
        System.out.println(num);
    }
}


final class FinalA{
}


//class B extends FinalA{} // 被final修饰的类无法继承
//class C extends String{}  // String 同样是被 final 修饰的类无法被继承的

class AA{
    public final void show() {

    }
}

class BB extends AA{
//    public void show() {}   // 被 final 修饰的方法无法被重写
}