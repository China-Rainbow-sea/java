package day30;


/**
 * 关于JDK  long包下的 Override 注解
 * 源代码：
 * public @interface Override {}
 *
 * 标识性注解：给编译器做参考的。
 * 编译器看到方法上有这个注解的时候，编译器会自动检查该方法是否重写了父类的方法。
 * 如果没有重写，报错。
 * 这个注解只是在编译阶段器作用，和与运行期无关。
 */
public class AnnotationTest02 {
    @Override  // 该注释从编译期间就告知了我们的错误。提示我们修改。
    // 该注解：表示的是从父类中继承，重写的方法的声明。

    /*
    @Override 这个注解只能注解方法。
    @Override 这个注解是给编译器参考的，和运行阶段没有关系。
    凡是Java中的方法带有这个注解的，编译器都会进行编译检查，如果这个方法不是重写父类的方法
    ，编译器就报错。

     */
    public String toString() {
        return "toString";
    }



}
