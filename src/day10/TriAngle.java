package day10;

public class TriAngle {
    private double base;
    private double height;

    // 无参构造器
    public TriAngle(){

    }

    public TriAngle(double base,double height){
        this.base = base;
        this.height = height;
    }

    public void setBase(double base){
        this.base = base;
    }

    public double getBase(){
        return this.base;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }

    public double area(){
        return (this.height+this.base) / 2;
    }
}
