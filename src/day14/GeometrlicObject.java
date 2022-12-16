package day14;


public class GeometrlicObject {
    public String color;
    public double weight;

    public GeometrlicObject() {
        // 无参构造器,提高代码的健壮性
    }

    public GeometrlicObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea() {
        return 0.0;
    }
}



