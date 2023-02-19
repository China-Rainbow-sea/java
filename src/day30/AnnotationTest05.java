package day30;


/**
 * 如果一个注解的属性名字是 values 的话，在使用的时候，该属性名可以省略
 * 存在两个以及以上时属性是不可以省略任何一个
 */
public class AnnotationTest05 {

    // @MyAnnotation2(value = "hello",name = "Tom") // 如果注解当中“只有”一个的属性是 value 的话，可以省略但是其它的属性名则不可以省略
    // 存在两个属性时 value 也是不能省略的。
    public void fun() {

    }


}
