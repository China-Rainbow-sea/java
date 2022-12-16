package day14;

public class GeometricTest {
    public static void main(String[] args) {
        // 静态方法调用非静态方法: 实例化对象
        GeometricTest geometricTest = new GeometricTest();
        geometricTest.displayGeometricObject(new Circle("white",2.3,1.0));
        System.out.println(geometricTest.equalsArea(new Circle("white", 2.3, 1.0),
                new Circle("white", 2.3, 1.0)));

        geometricTest.displayGeometricObject(new MyRectangle("white",1.0,2.0,3.0));


    }

    /**
     * 求几何面积
     * @param o 几何对象
     */
    public void displayGeometricObject(GeometrlicObject o) {
        System.out.println("面积为: " + o.findArea());
    }

    /**
     * 判断面积是否相等
     * @param o1 几何对象
     * @param o2 几何对象
     * @return boolean 相等返回 true,不相等返回false
     */
    public boolean equalsArea(GeometrlicObject o1,GeometrlicObject o2) {
        return o1.findArea() == o2.findArea();
    }
}
