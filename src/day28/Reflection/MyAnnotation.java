package day28.Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME) // 表示会加载到内存当中,被反射读取到
public @interface MyAnnotation {
    String value() default "hello";  // 这是属性,value 可以省略不写,default可以省略赋值,使用默认值
}

