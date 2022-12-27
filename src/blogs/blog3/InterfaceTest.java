package blogs.blog3;

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);

        // 可以直接通过类名.的方式直接访问，省略的是 public static final;
        System.out.println(Flyable.Min_SPEED);
    }
}


interface Flyable{
    public static final int MAX_SPEED = 7900;
    int Min_SPEED = 1;   // 默认省略了 public static final

    // 抽象方法
    public abstract void fly();

    // 省略了 public abstract
    void stop();
}

class Plane implements Flyable {

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }
}


interface AA{
    // 抽象方法
    public abstract void funAA();
}


interface BB{
    // 抽象方法
    public abstract void funBB();
}



// 接口与接口之间是: 多继承关系
interface DD extends AA,BB{

}


// 一个类实现多个接口
class CC implements AA,BB{

    @Override
    public void funAA() {

    }

    @Override
    public void funBB() {

    }
}