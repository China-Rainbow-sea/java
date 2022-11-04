package day12;

public class Person {
    private String name;
    int age;

    public Person() {
        // 无参构造器,实例化对象
    }


    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }


    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }
}
