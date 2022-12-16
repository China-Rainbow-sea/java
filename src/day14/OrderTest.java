package day14;



public class OrderTest {
    public static void main(String[] args) {
        Order order1 = new Order(1001,"AA");
        Order order2 = new Order(1001,"BB");

        System.out.println(order1.equals(order2));  // false;

        Order order3 = new Order(1001,"BB");
        System.out.println(order2.equals(order3));  // true

        String s1 = "BB";
        String s2 = "BB";
        System.out.println( s1 == s2); // true;


    }

}

class Order{
    private int orderId;
    private String orderName;

    public Order() {
        // 无参构造器
    }

    public Order(int orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    @Override
    public boolean equals(Object object) {
        if(this == object) {   // 判断是否指向同一个对象的实例
            return true;
        }

        if(object instanceof Order) {    // instanceof 判断object 是否是 Order的实例/子类
            Order order = (Order)object; // 强制向下转型

           // return order.orderId == this.orderId && this.orderName.equals(order.orderName);
            // 因为字符串常量池的特殊性,可以使用 ==
            return order.orderId == this.orderId && this.orderName == order.orderName;
        } else {
            return false;
        }

    }
}
