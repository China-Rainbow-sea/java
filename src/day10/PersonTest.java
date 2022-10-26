package day10;
/*
构造器的作用：
1. 创建对象
2. 初始化对象

构造器的格式：构造器名必须和类名一致,构造器没有返回类型
说明:
1. 一个类中必须含有一个构造器,
2. 如果没有显式的定义类的构造器的话,则系统默认提供一个空参的构造器
3. 一个类中定义的多个构造器,彼此构成重载
4. 一旦我们显式的定义了类的构造器之后,系统就不再提供默认的空参构造器,需要自己手动定义一个空的构造器

 */
public class PersonTest {
    public static void main(String[] args){
        // 创建类的对象: new + 构造器
        Person person = new Person();  // 调用无参构造器,创建对象
        person.setName("李华");
        person.setAge(19);
        System.out.println(person.getName()+":"+person.getAge());

        // 调用含有两个参数的构造器,创建对象
        Person person1 = new Person("张三",36);
        System.out.println(person1.getName()+":"+person1.getAge());

    }


}


class Person{
    private String name;
    private int age;

    // 构造器，无参构造器,
    public Person(){

    }

    // 含有一个参数的构造器
    public Person(String name){
        this.name = name;
    }

    // 含有两个参数的构造器
    public Person(String name ,int age){
        this.name = name;
        this.age = age;
    }


    public void eat(){
        System.out.println("吃东西");
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }


}
