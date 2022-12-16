package day14;


import java.util.Date;

/*
toString() 方法在Object类中定义，其返回值是String 类型，返回类名和它的引用地址.
在进行String 与其它类型数据的连接操作时,自动调用toString() 方法
Date now = new Date();
System.out.println("now="+now); 相当于
System.out.println("now="+now.toString());
可以根据需要在用户自定义类型中重写 toString()方法
如String类重写了toString()的方法,返回字符串的值,
s1 = "hello"
System.out.println(s1)相当于System.out.println(s1.toString())
基本数据类型转换为 String类型时,调用对应的包装类 toString()方法,
int a = 10;System.out.println("a="+a);
 */
public class ToStringTest {
    /*
    1. Object 类中toString()的使用，
     当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
     2. Object 中的toString()的定义
     public String toString() {
     // getClass()：返回类名的包路径,getName() 返回类名 toHexString(hashCode())返回hash码
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        day14.Customer@27e0e4
    }

    public 方法;
    public void println(Object x) {
        String s = String.valueOf(x);
        synchronized (this) {
            print(s);
            newLine();
        }
    }
    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }
    3. 像String,Date,File ，包装类等都已经重写了Object 类中的toString()方法.
    4. 自定义类也可以重写toString()方法,当调用方法时，返回对象的: "实体内容";
     */
    public static void main(String[] args) {
        Customer02 customer = new Customer02("Tom",21);

        System.out.println(customer.getClass());
        System.out.println(customer.getClass().getName());
        System.out.println(customer.toString()); // day14.Customer@27e0e4
        System.out.println(customer); //  是一样的,day14.Customer@27e0e4

        System.out.println("*********************************");
        String str = new String("MM");
        System.out.println(str);

        Date date = new Date(4534534534543L);
        System.out.println(date.toString());

    }



}

class Customer02{
    private String name;
    private int age;

    public Customer02(){
        // 无参构造器
    }

    public Customer02(String name,int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Customer02{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
