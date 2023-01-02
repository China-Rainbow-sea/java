package day18.com.RainbowSea.team.domain;


/**
 * 员工数据表的信息
 */
public class Employee {
    private int id;         // 员工id
    private String name;    // 员工姓名
    private int age;        // 员工年龄
    private double salary;  // 员工工资


    public Employee() {

    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    // 这里的Designer extends Programmer 继承的不是 Employee 的父类，
    // 用于 Designer无法调用到 Employee 中的 toString()方法，没有 super.super.toString()的写法
    public String getDetails() {
        return  this.id +"\t" + this.name + "\t" + this.age + "\t" + this.salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
