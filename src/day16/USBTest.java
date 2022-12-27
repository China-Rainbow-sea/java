package day16;


/**
 * 接口的使用:
 *   1. 接口使用上也满足多态性；
 *   2.接口，实际上就是定义了一种规范。
 *   定义Java类的语法格式: 先写 extends 后写 implements
 *   一个类可以实现多个接口，接口也可以继承其他多个接口
 *   实例接口的类中必须提供接口中所有的方法的具体实现内容（重写抽象方法），方可实例化，否则，仍为抽象类
 *   接口的主要用途就是被实现类实现implements
 *   与继承类关系类似，接口与实现类之间存在多态性
 *   接口和类是并列关系，或者可以理解为一种特殊的类，从本质上讲:
 *   接口是一种抽象类，这种抽象类中只包含常量和抽象方法的定义(jdk7.之前: 而没有变量和方法的的实现)
 */
public class USBTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        // 创建非匿名实现类的非匿名对象
        Flash flash = new Flash();
        computer.transferDate(flash);

        // 2.创建了接口的非匿名实现类的匿名对象
        computer.transferDate(new Flash());

        // 创建了接口匿名实现类的非匿名对象
        USB phone = new USB() {

            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机结束工作");
            }
        };

        computer.transferDate(phone);


        // 创建了接口的匿名对象实现类的匿名对象
        computer.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("MP3开始工作");
            }

            @Override
            public void stop() {
                System.out.println("MP3结束工作");
            }
        });




    }
}


interface USB{
    // 常量，定义长，宽，最大最小的传输速度等
    public abstract void start();

    public abstract void stop();
}


class Flash implements USB{
    @Override
    public void start(){
        System.out.println("U盘开启工作");
    }

    @Override
    public void stop(){
        System.out.println("U盘结束工作");
    }

}


class Computer{
    public void transferDate(USB usb) {
        usb.start();
        System.out.println("具体的传输细节");

        usb.stop();
    }
}