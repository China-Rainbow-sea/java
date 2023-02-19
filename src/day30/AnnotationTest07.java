package day30;

import org.junit.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;


/**
 * 反射读取注解信息
 */
@Ann("hi")
public class AnnotationTest07 {

    @Ann("hello")
    public void fun() {

    }

    @Test
    public void test() throws Exception{
        // 获取 该类对象信息
        Class<?> clazz = Class.forName("day30.AnnotationTest07");

        // 获取 fun()方法
        Method method = clazz.getDeclaredMethod("fun");

        // 判断该方法上是否存在这个注解:
        if(method.isAnnotationPresent(Ann.class)) {
            // 获取该注解对象.
            Ann annotation = method.getAnnotation(Ann.class);
            // 获取该注解的属性值，就像对象.属性一样
            System.out.println(annotation.value());
        }

    }
}



@Retention(RetentionPolicy.RUNTIME) // 表示该注解可以被 反射读取到
@interface Ann {

    String value();

}