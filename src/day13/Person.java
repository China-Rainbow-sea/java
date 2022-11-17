package day13;

public class Person {

    String name;
    int age;

    public Person() {
        // 空构造器
    }


    public Person(String name , int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("父类吃饭");

    }

    public void walk(int distance) {
        System.out.println("父类走路,走的距离是:"+distance+"公里");
    }

    public void show() {
        System.out.println("父类一个人");
    }

    private void test() {
        System.out.println("父类");
    }

    public String info() {
        return "父类";
    }

    public double info1() {
        return 1.0;
    }


    public static void info3() {

    }


}
