package blogs.blog3;

public class InterfaceJDK8 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method2();  // 调用接口中的默认方法
    }


    public static void main2(String[] args) {
        // 调用接口中静态方法
        CompareA.method1();

        SubClass subClass = new SubClass();
        // subClass.method1();   // jdk8中接口中定义的静态方法无法 实例对象调用,只能接口名.方法名的方式调用
    }

}


interface CompareA{

    // 接口中定义: 默认方法
    default void method2(){
        System.out.println("CompareA接口中的: 默认方法");
    }

    // 接口中定义：静态方法
    public static void method1(){
        System.out.println("接口中的静态方法 method1");
    }

}

interface CompareB{
    // JDK8 接口: 默认方法
    default void method2() {
        System.out.println("CompareB: 接口中的默认方法");
    }
}

class SubClass implements CompareA,CompareB{
    @Override
    public void method2() {
        System.out.println("实例类中重写的默认方法");
    }
}