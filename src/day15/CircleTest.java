package day15;



/**
 * 举例: 对于 static 修饰变量/方法的
 * */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle(3.4);

        System.out.println("c1的id: "+c1.getId());
        System.out.println("c2的id: "+c2.getId());
        System.out.println("c3的id: "+c3.getId());


        System.out.println("创建的圆的个数："+c3.getTotal());

    }




}


class Circle {
    private double radius;
    private int id;
    private static int total;         // 记录创建的圆的个数

    public Circle() {
        id = init++;   // 通过构造器: 设置 id
        total++;      // 同时增加圆的个数
    }

    /*public Circle(double radius) {
        this.radius = radius;
        id = init++;
        total ++;
    }*/

    // 优化
    public Circle(double radius) {
        this(); // 调用无参构造器,使用必须在构造器中才可以调用构造器方法，并且必须在第一行
        this.radius = radius;
    }


    // 类的声明结构，与执行的先后顺序无关
    private static int init = 1001;   // static 声明的变量静态属性，被所有对象共享

    /**
     * 计算圆的面积
     *
     * @return double 面积
     */
    public double findArea() {
        return Math.PI * radius * radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

    public static int getInit() {
        return init;
    }


    /**
     * toString() 一般重写不会附加上 static 修饰的属性
     *
     * @return
     */
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", id=" + id +
                '}';
    }
}
