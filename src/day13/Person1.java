package day13;

public class Person1 {

    String name;
    int age;
    int id = 1001;

    public Person1() {
        // 无参构造器
    }

    public Person1(String name,int age) {
        this.name = name;
        this.age = age;
    }


    public void eat() {
        System.out.println("人，吃饭");
    }


    public void walk() {
        System.out.println("人，走路");
    }


}
