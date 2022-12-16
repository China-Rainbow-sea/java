package day14;

import day10.Order;


/*
Object 类的使用
public Object()   构造器
public boolean equals(Object() obj) 对象的比较，“可以重写”
public int hashCode()      取得 Hash码
public String toString()   对象打印的时调用,public
 */

public class ObjectTest {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getClass());  // 打印显示对应的类名
        System.out.println(order.getClass().getSuperclass());   // 打印其父类的类名

        System.out.println(order.hashCode());  // 取得 Hash码
        System.out.println(order);


    }
}
