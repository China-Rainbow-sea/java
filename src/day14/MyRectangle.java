package day14;

public class MyRectangle extends GeometrlicObject{
    private double width;
    private double height;

    public MyRectangle() {
        // 无参构造器
    }

    public MyRectangle(String color, double weight, double width, double height) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    /**
     * 计算矩形的面积
     * @return double
     */
    @Override
    public double findArea() {
        return this.width * this.height;
    }
}
