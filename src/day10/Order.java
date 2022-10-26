package day10;

public class Order {
    private int orderPrivate;
    int orderDefault;
    public int orderPublic;

    private void methPrivate(){
        System.out.println("private: 私有：本类有效访问");
    }

    void methDefault(){
        System.out.println("缺省: 同包下，同类下有效访问");
    }

    public void methPublic(){
        System.out.println("public 公开的所有都有效访问");
    }

    public int getOrderPrivate() {
        return orderPrivate;
    }

    public void setOrderPrivate(int orderPrivate) {
        this.orderPrivate = orderPrivate;
    }

    public int getOrderDefault() {
        return orderDefault;
    }

    public void setOrderDefault(int orderDefault) {
        this.orderDefault = orderDefault;
    }

    public int getOrderPublic() {
        return orderPublic;
    }

    public void setOrderPublic(int orderPublic) {
        this.orderPublic = orderPublic;
    }
}
