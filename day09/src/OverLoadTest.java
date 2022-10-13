public class OverLoadTest {
    /*
    方式的重载:(overload) loading
    1. 定义:在同一个类,允许存在一个以上的同名方法,只要它们的参数个数或者参数类型不同即可
    "两同一不同:" 同一个类,相同方法名
       参数列表不同:参数的类型不同,参数的顺序不同,
       与方法的返回类型,权限类型无关
    2. 方法的重载：根据所传递的参数来确定你，所调用的是哪一个方法
     */
    public static void main(String[] args){
        OverLoadTest overLoadTest = new OverLoadTest();  // 实例化对象,静态方法调用非静态方法
        overLoadTest.getSum(9,1);
        overLoadTest.getSum(9,1);
        overLoadTest.getSum("9",1);
        overLoadTest.getSum(9,1);
    }

    // 如下四种方法的重载方式:
    public void getSum(int i ,int j){
        System.out.println(i+j);
    }

    public void getSum(double d1, double d2){
        System.out.println(d1+d2);
    }

    public void getSum(double i,int j){
        System.out.println(i+j);
    }

    public void getSum(int j , double i){
        System.out.println(j+i);
    }


    // 这个不是方法的重载:方法的重载与方法的返回类型无关
  /*  public int getSum(int i,int j){
        System.out.println(i+j);
        return 0;
    }*/

// 这个同样不是方法的重载:方法的重载与方法的权限修饰符无关
 /*   private void getSum(int i,int j){
        System.out.println(i+j);
    }*/


    public void getSum(String s, int j){
        System.out.println(s+""+j);
    }
}
