package blogs.blog3;

public class InterviewTest {
    public static void main(String[] args) {
        Students students = new Students();
        students.play();
    }

    public static void main2(String[] args) {
        new C().px();
    }
}




interface People{
    // 接口中的默认方法
    default void func() {
        System.out.println("People 接口中的默认方法 func()");
    }

    // 接口中的静态方法
    public static void method(){
        System.out.println("People接口中的静态方法");
    }
}


class Persons{
    public void func(){
        System.out.println("父类 Persons中的 func()方法");
    }
}



class Students extends Persons implements People{
    @Override
    public void func() {
        System.out.println("本类中重写的 func()方法");
    }


    public void play(){
        this.func();      // 调用执行本类中的 func()重写的方法
        super.func();     // 调用执行父类中的 func()方法
        People.super.func();    // 调用接口中的默认方法 func()
        People.method();    // 调用接口中的静态方法 method();
    }
}



interface Playable{
    public abstract void play();
}


interface Bounceable{
    public abstract void play();

}


interface Rollable extends Playable,Bounceable {
    Ball ball = new Ball("Pingpang");
}


class Ball implements Rollable {

    private String name;
    public Ball(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public void play() {

        // ball = new Ball("Football");
        // ball = new Ball("Football");  // 报错因为对应实现的接口 中定义了该 ball 属性默认是省略了 public static final 是无法修改的
        // 需要主要类，在父类中继承过来的方法和属性，以及接口中实现的类的方法和属性。

    }
}



interface A{
    int x = 0;
}


class B{
    int x = 1;
}


class C extends B implements A{
    public void px(){
        System.out.println(super.x);   // 调用父类中的变量 x
        System.out.println(A.x);       // 调用接口中的变量 x ，因为接口中的变量默认是被public static final修饰的
    }
}



