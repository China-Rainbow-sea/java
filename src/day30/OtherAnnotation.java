package day30;



public @interface OtherAnnotation {

    // int age; // 该方式是错误的

    int age();


    // 数组属性
    String[] email();
}
