package blogs.blog1;

public class blog1 {
    public static void main(String[] args) {
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



}



