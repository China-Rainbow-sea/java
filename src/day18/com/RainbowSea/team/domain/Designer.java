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

}
