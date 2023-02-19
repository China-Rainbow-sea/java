package day30;

public @interface MyAnnotation2 {

    /*
    指定一个value属性
     */
    String value();

    String name();

    // 注解当中的属性可以是哪一种类型都可以？
    /*
     属性的类型可以是：
      byte short int long float double boolean char String long Class 枚举类型
     */
    int value2();

    int[] value3();
    String[] value1();

    Class parameterType();

    Class[] parameterType2();
}
