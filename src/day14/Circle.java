package day14;

public class Circle extends GeometrlicObject{
    private double radius;

    public Circle() {
        // 无参构造器
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }


    /**
     * 计算圆的面积
     * @return double
     */
    @Override
    public double findArea() {
        return 3.14 * this.radius * this.radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }




}
