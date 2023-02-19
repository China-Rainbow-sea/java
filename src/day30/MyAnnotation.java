package day30;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD,ElementType.METHOD})  // 表示该注解只能出现在属性上，其它地方不可以出现。不然编译无法通过
public @interface MyAnnotation {

    /*
    我们通常在注解当中可以定义属性，以下这个MyAnnotation的 name就是属性。
    看着像方法，但实际在注解当中是属性 name

     */
    String name();

    /*
    颜色属性
     */
    String color();

    // 注解中的属性还可以定义默认值
    // 定义了默认值的属性，可以不用赋值
    int age() default 25;

}
