public class OverLoadExer {

    /*
    定义三个重载方法max()
    第一个方法求两个int值的最大值
    第二个方法求两个double值中的最大值
    第三个方法求三个double值中的最大值
    并分别调用三个方法
     */
    public static void main(String[] args){
        OverLoadExer overLoadExer = new OverLoadExer(); // 实例化对象,调用构成方法,静态的调用非静态方法
        System.out.println(overLoadExer.max(99, 1));
        System.out.println(overLoadExer.max(99.0, 99.9));
        System.out.println(overLoadExer.max(99.0, 99.9, 99.99));
    }

    public int max(int x, int y){
        return x > y ? x : y;
    }

    public double max(double x, double y){
        return x > y ? x:y;
    }

    public double max(double x, double y ,double z){
        double temp = x > y ? x : y;
        return z > temp ? z : temp;
    }


}
