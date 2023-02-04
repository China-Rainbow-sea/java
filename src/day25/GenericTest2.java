package day25;

import org.junit.Test;

/**
 * 1. 泛型可能有多个参数，此时应将多个参数一起放在尖括号内，比如：<E1,E2,E3>
 * 2. 泛型类的构造器如下: public GeneicClass(){}
 *           而下面是错误的，public GeneicClass<E>(){}
 *           就是定义的泛型的类的，构造器还是和没有定义泛型一样声明定义。
 * 3. 实例化后，操作原来泛型位置的结构必须与指定泛型类一致
 * 4. 泛型不同的引用不能相互赋值。
 *   > 尽管在编译时 ArrayList<String>和 ArrayList<Integer>是两种类型，但是，在运行时只有一个ArrayList 被加载到JVM中
 * 5. 泛型如果不指定，将被擦除，泛型对应的类型均按照 Object 类来处理，但不等价于 Object,
 *    经验: 泛型要使用就一路用到底，要不就不用，一路都不用。不要中间嵌入。
 * 6. 如果泛型结构时一个接口或抽象类，则不可创建泛型类的对象。
 * 7. Jdk1.7,泛型的简化操作： ArrayList<Fuit> fist = new ArrayList<>()
 * 8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 *
 * 泛型的注意事项:
 *   1.在类/接口上声明的泛型，在本类/接口中即代表某种类型，可以作为非静态属性的类型，非静态方法的参数类型。
 *    ，非静态方法的返回值类型。但在静态方法中不能使用类的泛型。
 *   2. 异常类不能是泛型的。
 *   3. 不能使用 new E[] 。但是可以：E[] extends = (E[]) new Object[capacity]
 *     参考：ArrayList 源码中声明： Object[] elementDate, 而非泛型参数类型数组
 *   4. 父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型。
 *     子类不保留父类的泛型：按需实现
 *      > 没有类型，擦除
 *      > 具体类型
 *    子类保留父类的泛型：泛型子类
 *     > 全部保留
 *     > 部分保留
 *   结论: 子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型。
 */
public class GenericTest2 {
    @Test
    public void test() {
        // 由于子类在继承泛型的父类/实现的接口时，指明了泛型具体是什么类型，所以实例化子类对象时，不再
        // 需要指明泛型了。
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123);
        Integer orderT = subOrder.getOrderT();
        System.out.println(orderT);

        // 但是单独实例化父类时还是要指明泛型具体是什么类型的
        Order2<String> order2 = new Order2<String>();
    }
}


// 继承实现了泛型的类，实现了泛型的结构，
// 可以将父类/接口中的泛型，指定一下，也可以沿用其父类/接口中的泛型，实例化的时候再指明
class SubOrder extends Order2<Integer> { // 这里的SubOrder 不是泛型

}

// 沿用父类/接口中的泛型，实例化的时候指明自身的泛型具体为什么的同时指明了父类中的泛型具体是什么。
class SubOrder2<T> extends Order2<T> { // SubOrder也是泛型，

}


class Order2<T> {
    String orderName;
    int orderId;

    // 类的内部结构也是可以使用类的泛型的
     T orderT;  // 没有使用泛型的话默认是Object 类型

    // static T num; // 注意泛型属性，不支持静态修饰，因为泛型的类型是在实例化的时候确定的类型的
    // 而static 静态是在实例化之前的。

    public Order2() {
        // 泛型不支持创建数组
        // T[] arr = new T[10];
        // T[] arr = (T[]) new Object[10];
    }

    public Order2(String orderName, int orderId,T orderT) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    // 静态方法中不能使用类的泛型，同理，泛型是在实例化的时候确定的具体类型的，
    // 而 static 是在实例化之前操作的。
    /*public static void show(T orderT) {
        System.out.println(orderT);
    }*/

    public T getOrderT() {
        return this.orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order2{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    // 泛型不能作为异常类使用
    public void show() {
       /* try {
            int num = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }*/

         /*try {
            int num = 1/0;
        } catch (T t) {  // 泛型不可以作为异常使用

        }*/
    }


}

/*泛型不能在异常中使用。
class MyException<T> extends Exception {
}*/

class Father<T1,T2> {

}

// 子类不保留父类的泛型，
// 没有类型，擦除
// 子类自己定义了泛型，而父类不保留父类的泛型
class Son<A,B> extends Father{ // 等价于 class extends Father<Object,Object>

}

// 子类自己定义泛型，同时实现了父类的泛型具体类型
class Son2<A,B> extends Father<Integer,String> {

}

// 子类保留父类的泛型<> 意味着子类自己也要定义父类中的泛型的，如果子类自己也想要独自的泛型，就用逗号分隔开
// 再定义泛型
// A,B Son3 自己独特的泛型，T1,T2父类的泛型
class Son3<T1,T2,A,B> extends Father<T1,T2> {

}

// 父类中的泛型部分保留，
class Son4<T2,A,B> extends Father<Integer,T2> {

}
