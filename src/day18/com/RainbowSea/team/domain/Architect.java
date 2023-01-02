package day18.com.RainbowSea.team.domain;


/**
 * 架构师类
 */
public class Architect extends Designer {
    private int stock;   // 股票数量

    public Architect() {
        super();   // 调用父类中的无参构造器
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return super.getDetails() + "\t架构师\t" + super.getStatus() + "\t\t" + super.getBonus()
                + "\t\t" + this.stock + "\t\t\t\t\t\t" + super.getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return super.getTeamBaseDetails() + "\t架构师\t" + super.getBonus() +
                "\t" + this.stock;
    }
}
