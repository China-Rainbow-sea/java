package day30;

import org.junit.Test;

import java.lang.annotation.Annotation;

@Deprecated
public class AnnotationTest03 {


    @Deprecated
    /*
    @Deprecated 这个注解标注的元素过时。
    这个注解主要是向其它程序员传达一个信息，告知已过时，有更好的解决方案存在。

     */
    public static void doSome() {
        System.out.println("do something");
    }



    public void doOther() {
        System.out.println("do other...");
    }


    @Test
    public void test() {
        AnnotationTest03.doSome();

    }
}

class Test2 {
    @Test
    public void test() {
    AnnotationTest03.doSome();  // 表示过时的了
    }
}

