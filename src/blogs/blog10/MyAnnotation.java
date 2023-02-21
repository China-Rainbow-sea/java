package blogs.blog10;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  // 生命周期在：运行期，才可以被反射读取到
public @interface MyAnnotation {
    String value() default "Tom";

}
