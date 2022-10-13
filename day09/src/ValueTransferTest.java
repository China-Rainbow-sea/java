public class ValueTransferTest {

    /*
    如果变量是基本数据类型,此时赋值的是变量所保存的数据值
    如果变量是引用数据类型,此时赋值的变量所保存的数据的地址值。
     */
    public static void main(String[] args){
        System.out.println("基本数据类型");
        int m = 10;
        int n = m;
        System.out.println("m= "+m+",n="+n);
        n = 20;
        System.out.println("m= "+m+",n="+n);

        System.out.println("引用数据类型");

        Order order = new Order();  // 实例化一个对象
        order.orderId = 1001;
        Order order2 = order;  // 将 order 实例化对象的地址赋值给到 order2中
        // 赋值以后,order 与 order2 的地址值相同,都指向了堆空间中同一个对象实体

        System.out.println("order.orderId="+order.orderId+",order2.orderId="+order2.orderId);
        order2.orderId = 1002;
        System.out.println("order.orderId="+order.orderId+",order2.orderId="+order2.orderId);



    }

}

class Order{
    int orderId;
}
