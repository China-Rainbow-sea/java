package day16;


/**
 * Jdk 8 中的接口新特性: 除了定义全局常量和抽象方法之外，还可以定义静态方法，默认方法
 * > 接口中的静态方法：只能通过接口.xxx,的方式调用，因为是静态的所以可以直接通过类名调用.无法通过继承的方式调用
 * > 默认方法可以通过，继承的对象调用。
 *
 * 接口中静态方法: 使用 static 关键字修饰，可以通过接口直接调用静态方法，并执行其方法体，我们
 *               经常在相互一起使用的类中使用静态方发，你可以在标准库中找到像Collection/Collections
 *               或者 Path/Paths这样成对的接口和类。
 *
 * 接口中的默认方法: 使用 default 关键字修饰，可以通过实现类对象来调用，我们在已有的接口中提供
 * 新方法的同时，还保持了与旧版本代码的兼容性，比如 java 8 API 中对 Collection，List,Comparator等接口提供了丰富的默认方法
 *
 * 2. 如果实现类重写了，接口中默认的方法 default 则执行的是重写以后的方法。多态。
 * 3. 静态方法不可以重写。
 *
 * 4. 如果接口中和 继承的父类中含有同名同参数的方法，而该实例类又没有重写其中同名同参数的方法的情况下，
 *    默认调用的是继承类中父类中的方法，不是接口中的方法，————> 类优先，如果重写了就是子类中的方法，
 *    寻找的属性和方法的顺序是 : 1.本类，2.父类，3.接口
 *
 * 5. 如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法
 *  那么在实现类没有重写此方法的情况下，报错——> 接口冲突
 */
public class SubClassTest {
    public static void main(String[] args) {
        // 调用不同位置中被重写的方法。本类中的方法，父类中的方法，接口中的默认方法,静态方法
        SubClass subClass = new SubClass();
        subClass.func();

    }


    public static void main3(String[] args) {
        Ca ca = new Ca();
        ca.func();
    }




    public static void main2(String[] args) {
        // 默认方法：可以通过实现类的对象，调用该方法
        SubClass s = new SubClass();
        s.method2();
        // Static method may be invoked on containing interface class only
        // s.method1();  // 接口中的静态方法：只能通过接口.调用，
        CompareA.method1();

        // 如果实现类重写了，默认接口中的默认方法，调用时，执行的是重写以后的方法.
        s.method3();

    }
}


interface CompareA{

    // 接口中定义: 静态方法：不是抽象方法
    public static void method1(){
        System.out.println("接口中的静态方法: CompareA: 北京");
    }

    // 接口中定义：默认方法
    public default void method2(){
        System.out.println("CompareA:上海");
    }


    // 接口中定义：默认方法，不是抽象方法
    default void method3(){
        System.out.println("接口中的CompareA: 深圳");
    }


}

class SuperClass{
    public void method3(){
        System.out.println("SuperClass 父类中的 同名同参数的方法");
    }
}

// 实现 implements 接口，因为对应该接口中没有抽象方法，所以不用重写方法
class SubClass extends SuperClass implements CompareA{

    @Override
    public void method3(){
        System.out.println("本类中的SubClass:上海");
    }

    // 调用不同位置中被重写的方法。本类中的方法，父类中的方法，接口中的方法
    public void func(){
        // 调用本类中的方法
        this.method3();
        // 调用父类中的方法
        super.method3();
        // 调用接口中的方法(默认方法)
        CompareA.super.method3();
        // 调用接口中静态方法()
        CompareA.method1();

    }

}



interface Aa{
    /*default void func(){
        System.out.println("Aa");
    }*/

    public abstract void func();
}


interface Ba{
    /*default  void func(){
        System.out.println("Ba");
    }*/
    public abstract void func();

}


// day16.Ca inherits unrelated defaults for func() from types day16.Aa and day16.Ba
// 如果实现类，所实现的接口中存在同名同参数的 default 默认方法，如果该实现类没有重写其中的同名同参数的方法
// 则会报错，接口冲突。解决方法：就是实现类重写 多个接口中同名同参数的default 默认方法即可。
class Ca implements Aa,Ba{


    @Override
    public void func() {
        System.out.println("你好");
    }
}