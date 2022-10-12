package day1;

public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person();  // 实例化对象,new对象,调用构成方法
        // 注意只有当实例化对象,调用了构成方法,才会在内存中开辟空间

        p1.eat();
        p1.sleep();
        p1.talk("汉语");

        Person p2 = new Person(); // 实例化对象
        p2.name = "Tom";

        System.out.println(p2.name);
        System.out.println(p1.name);

        /*
        每个实例化的对象都是相互对立的,不会互相干扰到。
         */


        Person p3 = p2;  // p3 的引用的对象和 p2的是一样的
        System.out.println(p3.name);
        System.out.println(p3);
        System.out.println(p2);
        // p2 和 p3 的指针指向的地址是一样的

    }

    /*
    属性(成员变量) VS 局部变量
    1. 相同点
    1. 定义的变量的方式是一样的， 数据类型 变量名 = 变量值
    2.都是先声明变量后，再使用变量
    3.都有各自对应的作用域，作用范围

    2. 不同点:
    1. 声明的位置不同：
       属性(成员变量)直接声明在类中的{}
       局部变量: 声明在方法内,方法形参,代码块,构造器形参

    2.关于权限修饰符不同
      属性(成员变量) 可以在声明时,指明其权限,使用权限修饰符,
      常用的权限修饰符: public, private, protected,缺省(省略权限修饰符)
      局部变量：不可以使用权限修饰符

      3. 默认初始值的情况不同
      属性(成员变量):会根据其类型,都有默认的初始化值
      整形:byte,short,int long, long long, 0
      浮点型: float,double, 0.0;
      字符型: char：0\ '\u0000'
      布尔型: boolean,false
      引用数据类型: 类,数组,接口：null

      局部变量:没有默认初始值,
      我们必须自己定义局部变量的初始值,不然无法使用
      特别: 形参在调用时,我们赋值即可。

      4. 在内存中加载的位置不同:
      属性(成员变量): 加载到JVM的堆区空间中
      局部变量: 加载到JVM的炸空间中
     */

}
