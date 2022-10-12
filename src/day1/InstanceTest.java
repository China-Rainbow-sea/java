package day1;

/**
 * 编译完程序以后，生成一个或多个字节码文件，
 * 我们使用JVM中的类的加载器和解释器对生成的字节码文件进行解释运行，
 * 意味着，需要将字节码文件对应的类加载到内存中，涉及到内存解析是在运行的时候。
 */
public class InstanceTest {
    /*
    理解万物皆对象：
    在Java中语言范畴中，我们都将功能，结构等封装到类中，通过类的实例化，来调用具体的功能结构
    > Scanner,String
    > 文件，File
    > 网络资源 URL
     涉及到Java语言月前端Html,后端的数据库交互时,前后端的结构在Java层面交互时，都视为类,对象
     */

    // 匿名对象的使用：
    /*
    1. 我们创建的对象,没有显示的赋给一个变量名，即为 new test 匿名对象
    特征: 匿名对象只能调用一次。
     */
    public static void main(String[] args){
        Phone phone = new Phone();  // 实例化对象,调用构成方法,加载到内存当中,用于静态方法访问非静态方法

        System.out.println(new Phone().name); // new Phone() 实例化对象没有定义对象名,匿名对象
        System.out.println(new Phone().name = "hello");
        System.out.println(new Phone().name); // new Phone() 实例化对象没有定义对象名,匿名对象

        System.out.println("*****************************************");
        // 匿名对象的使用,直接传匿名对象new 查看
        phone.show(new Phone());

    }
}

class Phone{
    int price;
    String name;

    public void show(Phone phone){
        System.out.println(this.name);
        System.out.println(this.price);
    }

}
