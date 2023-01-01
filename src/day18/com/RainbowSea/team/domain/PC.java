package day18.com.RainbowSea.team.domain;


/**
 * 电脑信息
 */
public class PC implements Equipment {
    private String model;       // 表示机器的型号
    private String display;     // 表示显示器的名称

    public PC() {
        // 无参构造器
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }


    // 重写接口中的抽象方法
    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }


}
