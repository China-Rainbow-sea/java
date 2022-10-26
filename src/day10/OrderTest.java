package day10;

public class OrderTest {
    public static void main(String[] args){
        Order order = new Order(); // 调用构造器,创建对象
        order.orderDefault = 1;
        order.orderPublic = 2;
        order.methDefault();
        order.methPublic();

//        order.orderPrivate; 'orderPrivate' has private access in 'day10.Order'
    }
}


