package blogs.blog8;

public class GenericTest5 {
}

// 父类
class Father<T1,T2> {

}

// 父类有泛型，子类继承父类：并保留了父类的`部分`泛型(部分指明了父类的泛型具体类型，部分没有指明父类的泛型具体类型)，外加子类定义自己独有的泛型
class Son4K<T2,E,E2> extends Father<String,T2> {

}

// 子类继承父类：并保留了父类的泛型(并没有指明具体类型)，外加子类定义自己独有的泛型
class Son4<T1,T2,E,E2> extends Father<T1,T2> {

}

// 子类保留了父类的泛型，并没有指明父类的具体类型
// 注意：因为没有指明父类泛型的具体类型，所以子类要沿用上父类的泛型<>从而对父类上的泛型(赋予具体类型)
class Son3<T1,T2> extends Father<T1,T2> {

}

// 子类保留了父类的泛型，并指明了父类中泛型的具体类型
class Son2 extends Father<String,Integer> {

}


// 子类没有保留父类的泛型，擦除了: 等价于class Son extends Father<Object,Object>{}
class Son1 extends Father{

}
