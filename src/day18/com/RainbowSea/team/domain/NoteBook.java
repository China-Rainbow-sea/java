package day18.com.RainbowSea.team.domain;


/**
 * 笔记本电脑的信息
 */
public class NoteBook implements Equipment{

    private String model;   // 机器型号
    private double price;   // 机器的价格


    public NoteBook() {

    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return this.model;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return this.model + "(" + this.price + ")";
    }
}
