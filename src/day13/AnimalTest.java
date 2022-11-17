package day13;

/*
1. 虚拟方法调用(多态情况下)
子类中定义了与父类同名同参数的方法,在多态情况下,将此时父类的方法称为虚拟方法,父类
根据赋给它的不同子类对象,动态调用属于子类的该方法,这样的方法调用在编译期间是无法确定的,
Person e = new Student();
e.getInfo();  调用Student类的getInfo()方法
2. 编译时类型和运行时类型
编译时 e 为Person 类型,而方法的调用是在运行时确定的,所以调用的是 Student类的getInfo()方法 -- 动态绑定


3. 从编译和运行的角度看:
重载:是指允许在多个同名方法,而这些方法的参数不同,编译器根据方法不同的参数表,对同名方法的名称做修饰,对于编译器而言,
这些同名方法就成了不同的方法,它们的调用地址在编译期就绑定好了(确定好了),Java的重载就是可以包括父类和子类的,即子类可以
重载父类的同名不同参数的方法.所以对于重载而言,在方法调用之前,编译器就已经确定了所要调用的方法,这称为"早绑定"或"静态绑定"
而对于多态,只有等到方法调用的那一刻,编译器才会确定所要调用的具体方法这称为"晚绑定"或"动态绑定"
引用 Bruce Eckel的话 "不要犯傻,如果它不是晚绑定,它就不是多态."

 */
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        test.func(new Dog());
        System.out.println("***********************************");
        test.func(new Cat());

    }


    public void func(Animal animal) {  // 父类的引用指向子类对象
        animal.eat();   // 编译看左边,实际运行结果看右边
        animal.shout();
    }

}
