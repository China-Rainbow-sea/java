package day13;

public class Student1 extends Person1 {

    String major;
    int id = 1002;

    public Student1() {
        // 无参构造器
    }

    public Student1(String major) {
        this.major = major;
    }
    public Student1(String name,int age,String major) {
        super(name,age);
        this.major = major;
    }


    @Override
    public void eat() {
        System.out.println("学生，多吃营养的食物");
    }


    @Override
    public void walk() {
        System.out.println("学生，走路");
    }

    public void study() {
        System.out.println("学生，学习知识");
        this.eat();
        super.eat();
        super.walk();
    }


    public void show() {
        System.out.println("name= "+this.name+",age = "+super.age);
        // 这里的this.name 调用的是父类中的name属性,this.先在本类中找,发现本类中没有就会去父类中找
        System.out.println("id= "+id);  // 先在本类中找,其实就是 this.id，只是省略了this.而已
        System.out.println("id= "+super.id);   // 不会在本类中找,直接去父类中找
    }

}
