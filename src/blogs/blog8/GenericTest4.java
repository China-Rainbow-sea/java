package blogs.blog8;



public class GenericTest4 {
    public static void main2(String[] args) {
        // 泛型方法的调用:
        MyClass myClass = new MyClass();
        myClass.fun();
        myClass.fun2(new String("Hello"));
        String s = myClass.fun3("你好世界");
        System.out.println(s);

        System.out.println("**********");
        String s2 = MyClass.fun4("Hello Wrold");
        System.out.println(s2);


    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        String s = myClass.fun3("Hello Wrold");

    }

}

class MyClass {

    // 泛型方法: 泛型作为返回值，和参数
    public <E> E fun3(E e) {
        System.out.println("泛型方法，泛型作为返回值，参数"+e);
        return e;
    }


    // 泛型方法，无返回值的
    public <E> void fun() {
        System.out.println("泛型方法，无返回值,无参数的");
    }

    // 泛型方法: 泛型作为参数传入
    public <E> void fun2(E e) {
        System.out.println("泛型方法，无返回值，有泛型参数"+e);
    }


    public static <E> E fun4(E e) {
        System.out.println("静态：泛型方法，泛型作为返回值，参数"+e);
        return e;
    }
}
