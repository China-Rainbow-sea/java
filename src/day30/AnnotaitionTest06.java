package day30;

public class AnnotaitionTest06 {

    @OtherAnnotation(age=25,email = {"zhangsan@123.com","lisi@123.com"})
    public void fun() {

    }

    @OtherAnnotation(age=25,email = {"Tom@123.com"})
    public void fun2() {

    }

    // 如果注解数组属性上只有一个值，可以省略大括号
    @OtherAnnotation(age= 25,email = "Tom@123.com")
    public void fun3() {

    }
}
