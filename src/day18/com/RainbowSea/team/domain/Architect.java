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


}
