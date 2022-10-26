package day10;
/*
this 关键字的使用
1. this可以用来修饰，属性，方法，构造器
2. this 修饰属性和方法
 this理解为：当前对象的引用

3. 在类方法中,我们可以使用 “this.属性”/“this.方法”的方式,调用当前对象属性或
方法。但是通常情况下,我们都选择省略“this.” 特殊情况下，如果方法的形参和类的属性
同名时，我们必须显式的使用 “this.变量" 的方式,表明此变量是属性，而非形参
4. 在类的构造器中，我们可以使用 "this.属性"/"this.方法",调用当前正在创建的对象
的属性或方法.
5.

this. 调用构造器
1. 我们在类的构造器中，可以显式的使用 'this(形参列表)方式,调用方式中指定的其他构造器
2. 构造器中不能通过”this(形参列表)" 方法调用自己
3. 如果一个类中有 n 个构造器,则最多有 n -1 构造器中使用了 this(形参),防止调用构造器形成了死递归
4. 规定 this(形参)调用构造器,必须声明在当前构造器的首行(使用逗号表达式不行),导致在构造器中,最多只能声明
一个 this()调用其他的构造器.
 */

public class PersonTest2 {
    public static void main(String[] args){
        Person2 person2 = new Person2("李华",19);
        person2.eat();
        person2.setName("张三");
        person2.eat();
    }
}



class Person2{
    private String name;
    private int age;

    // 无参构造器
    public Person2(){
//        this("2"); 不要形成了死递归,的无限循环
        System.out.print("中国人");
    }

    public Person2(String name){
        this(); // 调用无参构造器
        this.name = name;
    }

    public Person2(int age){
        this();  // 调用无参构造器
        this.age = age;
    }

    public Person2(String name,int age){
        this(name); // 调用有一个参数的构造器
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void eat(){
        System.out.println(this.name+"吃饭");
    }
}
