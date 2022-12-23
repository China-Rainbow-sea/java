package day15;


/**
 * 对属性可以赋值的位置
 * // 执行的顺序
 * 1. 默认初始化
 * 2. 显式初始化
 * 3. 在代码块中赋值
 * 4. 构造器中初始化
 * 5. 有了对象以后,可以通过 "对象.属性,或对象.方法"的方式,进行赋值
 */
public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.orderId);
    }
}

class Order{
    {
        orderId = 4;
    }
    int orderId = 3;

    public Order() {
        // this.orderId = 5;
    }

}
