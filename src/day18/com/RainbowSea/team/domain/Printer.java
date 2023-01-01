package day18.com.RainbowSea.team.domain;

/**
 * 打印机的信息
 */
public class Printer implements Equipment {

    private String name;   // 打印机名
    private String type;   // 机器的类型

    public Printer() {

    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return this.name + "(" + this.type + ")";
    }
}
