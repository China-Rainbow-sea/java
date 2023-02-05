package blogs.blog8;

public interface GenericTest3 {
}


interface MyGeneric<T> {

    // 定义含有泛型的 T 抽象方法：泛型作为返回值;
    public T fun();

    // 定义含有泛型的 T 抽象方法： 泛型作为参数
    public void fun2(T t);

    // 定义含有泛型的 T 抽象方法： T 泛型作为返回值，参数
    public T fun3(T t);

}