package day10;

/*
面向对象:特征之一: 封装性
当我们创建一个类的对象后，我们可以通过 对象.属性的方式,对对象中的属性进行赋值操作,这种情况的赋值操作
是比较的危险的，以及这种操作的属性只是存在数据类型和存储范围上的约束,但是在实际开发中,我们需要给属性赋值加入
额外的限制条件,这个条件就不能在属性的声明时体现出来，我们只能通过方法进行限制条件的添加,同时我们
需要避免用户使用 "对象.属性"的方式直接对我们的对象的属性进行赋值操作，不再我们的控制范围内了,这里我们就需要
将属性私有化
2. 封装的体现:
 我们将类的属性xxx私有化(pvivate),同时,提供公共(public)的方法来获取(getxxx)和设置(setxxx)
 封装的体现: 1. 不对外暴露的私有方法, 2.单例模式
3. 封装的体现，需要权限修饰符来配合
1. java规定的4中权限(从小到大排列) private，缺省, protected，public
2. 4种权限可以用来修饰类及类的内部结构，属性，方法，构造器，内部类
3. 具体的，4种权限都可以用来修饰类的内部结构：属性，方法，构造器，内部类，修饰类的话，只能使用，缺省，public


 */
public class AnimalTest {
    public static void main(String[] args){
        Animal animal = new Animal();  // 调用构造器,创建对象
//        animal.name = "0";  name' has private access in 'day10.Animal'
        animal.setName("大黄");
        animal.setAge(18);
        animal.setLegs(4);
        System.out.println(animal.getName());
        animal.eat();
        animal.setLegs(9);

    }
}


class Animal {
    private String name;
    private int age ;
    private int legs;  // 属性不用初始化

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegs() {
        return this.legs;
    }

    public void setLegs(int legs) {
        if(legs > 0 && legs % 2 == 0){
            this.legs = legs;
        } else {
            System.out.println("错误");
        }
    }



    public void eat(){
        System.out.println("动物进食");
    }
}
