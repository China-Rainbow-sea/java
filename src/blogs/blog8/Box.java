package blogs.blog8;

public class Box<T> {

    // T t2 = new T();  // Type parameter 'T' cannot be instantiated directly


    T[] arr = (T[]) new Object[6];

    // 泛型<T> 应用类属性当中
    T t;


    // 无参构造器
    public Box() {

    }

    // 带泛型参数构造器
    public Box(T t) {
        this.t = t;
    }


    // 泛型<T> 应用到方法返回值中
    public T fun() {
       return null;
    }

    // 泛型<T> 应用到参数当中
    public void fun2(T t) {

    }

    // 泛型<T> 应用到返回值，参数当中
    public T set(T t) {
        return null;
    }


}


