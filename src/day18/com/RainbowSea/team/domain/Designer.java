package day18.com.RainbowSea.team.domain;


/**
 * 设计师的类
 */
public class Designer extends Programmer {
    private double bonus;   // 奖金

    public Designer() {
        super();   // 调用父类中的无参构造器
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);   // 调用父类中的构造器
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // 注意了，这里的Designer extends Programmer 继承的不是 Employee 的父类，
    // 所以该方法无法调用到 Employee 中的 toString()方法，没有 super.super.toString()的写法，
    // 因为 在 Employee 和 Programmer 中都有 同名的toString()方法，而Designer 无法调用到同名同参数的父类中父类的方法
    // 但是可以调用到父类中父类的不同名的方法。
    // 所以这里我们，修改 Employee 中的 toString()方法。
    @Override
    public String toString() {
        return super.getDetails() + "\t设计师\t" + super.getStatus() + "\t\t" +
                this.bonus + "\t\t\t\t\t\t\t\t\t" + super.getEquipment().getDescription();
    }

    /*
    Employee: 中的方法
    public String getDetails() {
        return  this.id +"\t" + this.name + "\t" + this.age + "\t" + this.salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }
    // 这样 该 Designer 类就可以调用父类中的父类的不同名方法(但是功能却是一样的)
    解决了 Designer 想要调用父类中的父类的 toString()的方法： 不可写成 super.super.toString()方式

     */

    public String getDetailsForTeam() {
        return super.getTeamBaseDetails() + "\t设计师\t" + this.bonus;
    }

}
