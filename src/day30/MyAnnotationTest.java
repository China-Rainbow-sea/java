package day30;

public class MyAnnotationTest {

    // 报错的原因: 如果一个注解当中有属性，那么必须给属性赋值。
    /*@MyAnnotation
    public void doSome() {}*/


    // @MyAnnotation(属性名=属性值)

    @MyAnnotation(name="zhangsan",color="蓝色")  // 注解中对应的类型要一致。
    public void doSome() {

    }
}
