package day25;

import org.junit.Test;


/**
 * 如果定义了泛型，实例化时却没有使用指明的类的泛型的话，则默认此泛型类型为 Object 类型
 * 所以：如果大家定义了类时带泛型的，建议在实例化时要指明类的泛型。
 */
public class GerericTest {

    @Test
    public void test() {
        // 类中定义了泛型，当时创建对象时没有使用泛型，默认是 Object
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("Tom");
        System.out.println(order.getOrderT());

        Order order2 = new Order("Tom",18,123);

    }

    /*
    建议: 实例化时指明类的泛型。
     */
    @Test
    public void test2() {
        Order<String> order = new Order<String>("Tom",19,"good");
        order.setOrderT("good good good");
        String orderT = order.getOrderT();
        System.out.println(orderT);
    }

}

class Order<T> {
    String orderName;
    int orderId;

    // 类的内部结构也是可以使用类的泛型的
    T orderT;  // 没有使用泛型的话默认是Object 类型

    public Order() {
    }

    public Order(String orderName, int orderId,T orderT) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return this.orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}
