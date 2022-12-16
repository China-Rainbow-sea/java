package day14;

public class Person {
    public String name;
    public int age;

    public void eat() {
        System.out.println("父类Person 吃饭");
    }


    public String getInfo() {
        return "Name: "+this.name+ "age:"+this.age;
    }
}


class Student extends Person {
    protected String school = "pku";

    public String getInfo() {
        return "Name: "+super.name+ "age:"+super.age+"school:"+this.school;
    }
}


class Graduate extends Student {
    public String major = "IT";
    public String getInfo() {
        return "Name: "+super.name+"age: "+super.age+"school: "+super.school+"major:"+this.major;
    }
}





