package blogs.blog1;

import java.util.Date;
import java.util.Objects;

public class blog1 {
    public static void main(String[] args) {
        Animal animal = new Animal("Tom",18);
        System.out.println("animal: "+animal);
        System.out.println("animal.toString(): "+animal.toString());

    }






    public static void main13(String[] args) {
        Date date = new Date(32432525324L);
        System.out.println(date);  // 打印date 就是调用重写的toString()方法
        System.out.println(date.toString());
    }


    public static void main12(String[] args) {
        String s1 = "Tom";

        System.out.println(s1);   // s1对象打印调用的就是 重写的toString()方法
        System.out.println(s1.toString());  // 重写了toString()方法不再是Object.toString()中的方法了
    }



    public static void main11(String[] args) {

        Animal animal = new Animal();

        System.out.println("animal: "+animal);
        System.out.println("animal: "+animal.toString());

        System.out.println("animal.getClass(): "+(animal.getClass()));
        System.out.println("animal.getClass().getName(): "+animal.getClass().getName());
        System.out.println("animal.hashCode()："+Integer.toHexString(animal.hashCode()));
        System.out.println("animal.getClass().getSuperclass(): "+animal.getClass().getSuperclass());
    }


    public static void main10(String[] args) {
        Animal animal = new Animal();
        System.out.println("animal: "+animal);
        System.out.println("animal: "+animal.toString());
    }

    public static void main9(String[] args) {
        Animal a1 = new Animal("Tom",18);
        Animal a2 = new Animal("Tom",18);
        Animal a3 = new Animal("Alice",18);
        System.out.println("a1.equals(a2): "+(a1.equals(a2)));
        System.out.println("a1.equals(a3): "+(a1.equals(a3)));


    }
    public static void main8(String[] args) {
        Date d1 = new Date(32432525324L);
        Date d2 = new Date(32432525324L);
        Date d3 = new Date(92432525329L);

        System.out.println("d1.equals(d2): "+(d1.equals(d2)));
        System.out.println("d1.equals(d3): "+(d1.equals(d3)));
    }

    public static void main7(String[] args) {
        String s1 = "Tom";
        String s2 = "Tom";
        String s3 = "Alice";

        String s4 = new String("Tom");
        String s5 = new String("Tom");
        String s6 = new String("Alice");

        System.out.println("s1.equals(s2): "+(s1.equals(s2)));
        System.out.println("s1.equals(s3): "+(s1.equals(s3)));
        System.out.println("s4.equals(s5): "+(s4.equals(s5)));
        System.out.println("s4.equals(s6): "+(s4.equals(s6)));

    }


    public static void main6(String[] args) {
        Animal a1 = new Animal("Tom",18);
        Animal a2 = new Animal("Tom",18);
        Animal a3 = new Animal("Alice",18);
        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a3));

    }


    public static void main5(String[] args) {
        String s1 = "Tom";
        String s2 = "Tom";
        String s3 = "Alice";

        System.out.println("s1 == s2: "+(s1 == s2));
        System.out.println("s2 == s3: "+(s2 == s3));
    }


    public static void main4(String[] args) {
        String s1 = new String("Tom");
        String s2 = new String("Tom");
        String s3 = new String("Alice");

        System.out.println("s1: "+s1);
        System.out.println("s2: "+s2);
        System.out.println("s3: "+s3);

        // String 使用了 new 的方式创建 对象，== 比较的是地址，没有字符串常量池
        System.out.println("s1 == s2: "+(s1 == s2));
        System.out.println("s2 == s3: "+(s2 == s3));
    }


    public static void main3(String[] args) {
        Animal a1 = new Animal("Tom",18);
        Animal a2 = new Animal("Alice",18);
        Animal a3 = new Animal("Tom",18);

        System.out.println("a1: "+a1);
        System.out.println("a2: "+a2);
        System.out.println("a3: "+a3);

        System.out.println("a1 == a2: "+(a1 == a2)); // 引用类型比较的是两个地址是否相等
        System.out.println("a2 == a3: "+(a2 == a3));

    }

    public static void main2(String[] args) {
        int i = 9;
        char c = 9;

        System.out.println("c == i: "+(c == i));

        char A1 = 'A';
        char A2 = 65;

        System.out.println("A1 == A2: "+(A1 == A2));

        char a1 = 'a';
        char a2 = 97;

        System.out.println("a1 == a2: "+(a1 == a2));
    }


    public static void main1(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10.0;

        System.out.println(i == j);  // true
        System.out.println(j == d);  // true
    }
}

class Animal{
    public String name ;
    public int age;

    public Animal() {
        // 无参构造器
    }

    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}



