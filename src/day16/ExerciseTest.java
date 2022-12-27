package day16;

public class ExerciseTest {
    public static void main(String[] args) {
        new C().px();
    }
}


interface A{
   public static final int x = 0;
   public static final int num = 9;
}

class B{
    int x = 1;
    int num2 = 99;
}


class C extends B implements A{
    public void px(){
        // System.out.println(x);  //对应父类，接口中同名的变量为，无法直接使用,存在歧义(编译器无法确定你要调用的是接口中的，还是父类中的变量)
        // 所以对于，父类与 接口同名的变量，需要指明你调用的是哪一个变量
        System.out.println(super.x); // 指明调用的是父类中的 x 变量
        System.out.println(A.x); // 指明调用的是接口中的 x变量(因为接口中的变量省略的是 public static final)


        // 对应父类 与 接口中的不同变量；可以直接通过变量名访问，因为继承，与实现关系的存在
        System.out.println(num);
        System.out.println(num2);
    }


}



interface Playable{
    public abstract void play();
}


interface Bounceable{
    public abstract void play();

}


interface Rollable extends Playable,Bounceable{
    Ball ball = new Ball("Pingpang");
}


class Ball implements Rollable{

    private String name;
    public Ball(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public void play() {
        // ball = new Ball("Football");  // 报错因为对应实现的接口 中定义了该 ball 属性默认是省略了 public static final 是无法修改的
        // 需要主要类，在父类中继承过来的方法和属性，以及接口中实现的类的方法和属性。

    }
}


