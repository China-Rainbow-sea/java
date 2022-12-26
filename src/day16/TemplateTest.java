package day16;


/**
 * 模板方法设计模式:
 * 抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类
 * 的基础上进行扩展，改造，但子类总体上会保留抽象类的行为方式。
 *  解决的问题：
 *  > 当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类
 *  去实现，
 *  > 换句话说，在软件开发中实现一个算法时，整体步骤很固定，通用，这些步骤已经在父类中写好了。
 *     但是某些部分易变，易变部分可以抽象出来，供不同子类实现，这就是一种模板模式。
 */
public class TemplateTest {
    public static void main(String[] args) {
        Bank b1 = new DrawMoneys();
        b1.process();  // 多态:动态绑定;调用子类重写的方法transactBusiness()

        System.out.println("**********************");
        Bank b2 = new ManageMoneys();  // 多态
        b2.process();   // 多态调用的是子类重写的方法transactBusiness()
    }
}

abstract class Bank{

    public void drawNumber(){
        System.out.println("取号排队");
    }


    // 抽象方法: 不确定处理怎样的业务需求:让子类继承实现
    abstract public void transactBusiness();

    public void end(){
        System.out.println("最后:业务评价");
    }


    // 重点
    // final 无法被重写,最后将所有操作整合在一起处理,
    public final void process() {
        this.drawNumber();        // 取号
        // 重点,实际调用的是: 子类重写的方法，多态
        this.transactBusiness();  // 对应的业务处理，执行子类中重写的抽象方法
        this.end();               // 最后业务评价
    }
}


// 取钱，操作
class DrawMoneys extends Bank{
    @Override
    // 重写继承的抽象类的抽象方法(无法确定的部分)
    public void transactBusiness(){
        System.out.println("业务处理：取钱");
    }
}


// 存钱操作。
class ManageMoneys extends Bank{
    @Override
    // 重写所继承的抽象类的抽象方法(无法确定的部分)
    public void transactBusiness() {
        System.out.println("业务处理: 存钱");
    }
}
