package blogs.blog2;

public class BlockTest {
    public static void main(String[] args) {
        Person person = new Person();
        Person person2 = new Person();
    }
}

class Person{
    String name;
    static String desc;

    public void eat() {
        System.out.println("非静态方法");
    }


    public static void show(){
        System.out.println("静态方法");
    }


    {
        System.out.println("非静态代码块");
    }

    static{
        System.out.println("静态代码块");
        // name = "Tom";  // 静态代码块无法直接调用非静态的
        // eat();
    }
}
